package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Orders;

public class OrdersDAO extends MyDAO {

    public List<Orders> getMyOrders(int userID) {
        List<Orders> orderList = new ArrayList<>();
        xSql = "SELECT "
                + "ID, UserID, Name, PhoneNumber, Address, OrderDate, TotalAmount "
                + "FROM Orders "
                + "WHERE UserID = ?;";
        try {
            int id, totalAmount;
            String name, phoneNumber, address;
            LocalDate orderDate;
            Orders order;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                phoneNumber = rs.getString("PhoneNumber");
                address = rs.getString("Address");
                orderDate = rs.getDate("OrderDate").toLocalDate();
                totalAmount = rs.getInt("TotalAmount");
                order = new Orders(id, userID, name, phoneNumber, address, orderDate, totalAmount);
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }
    
     public List<Orders> getAllOrders() {
        List<Orders> orderList = new ArrayList<>();
        xSql = "SELECT "
                + "ID, UserID, Name, PhoneNumber, Address, OrderDate, TotalAmount "
                + "FROM Orders ";

        try {
            int userID,id, totalAmount;
            String name, phoneNumber, address;
            LocalDate orderDate;
            Orders order;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                userID = rs.getInt("UserID");
                name = rs.getString("Name");
                phoneNumber = rs.getString("PhoneNumber");
                address = rs.getString("Address");
                orderDate = rs.getDate("OrderDate").toLocalDate();
                totalAmount = rs.getInt("TotalAmount");
                order = new Orders(id, userID, name, phoneNumber, address, orderDate, totalAmount);
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }

    public void createOrder(Orders order) {
        // Tính toán TotalAmount bằng cách lấy Giá từ bảng Products và nhân với Số lượng từ bảng OrderItems

        // Thiết lập giá trị TotalAmount trong đối tượng Orders
        // Thêm đơn hàng vào bảng Orders
        try {
            xSql = "INSERT INTO Orders (UserID, Name, PhoneNumber, Address, OrderDate, TotalAmount) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, order.getUserID());
            ps.setString(2, order.getName());
            ps.setString(3, order.getPhone());
            ps.setString(4, order.getAddress());
            ps.setDate(5, Date.valueOf(order.getOrderDate()));
            ps.setInt(6, order.getTotalAmount());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertToOrderItems(int productID, int quantity) {
        int orderID = 0;

        // Lấy ID lớn nhất từ bảng Orders
        String getMaxOrderIDSql = "SELECT MAX(ID) AS MaxOrderID FROM Orders;";
        try {
            PreparedStatement psMaxOrderID = con.prepareStatement(getMaxOrderIDSql);
            ResultSet rsMaxOrderID = psMaxOrderID.executeQuery();
            if (rsMaxOrderID.next()) {
                orderID = rsMaxOrderID.getInt("MaxOrderID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Thêm dữ liệu vào bảng OrderItems
        String insertSql = "INSERT INTO OrderItems (OrderID, ProductID, Quantity) VALUES (?, ?, ?);";
        try {
            PreparedStatement psInsert = con.prepareStatement(insertSql);
            psInsert.setInt(1, orderID);
            psInsert.setInt(2, productID);
            psInsert.setInt(3, quantity);
            psInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(Orders order) {
        int orderID = order.getID();

        // Tính toán TotalAmount bằng cách lấy Giá từ bảng Products và nhân với Số lượng từ bảng OrderItems
        int totalAmount = calculateTotalAmount(order);

        // Cập nhật giá trị TotalAmount trong bảng Orders
        try {
            String updateSql = "UPDATE Orders SET TotalAmount = ? WHERE ID = ?;";
            PreparedStatement psUpdate = con.prepareStatement(updateSql);
            psUpdate.setInt(1, totalAmount);
            psUpdate.setInt(2, orderID);
            psUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int calculateTotalAmount(Orders order) {
        int totalAmount = 0;

        xSql = "SELECT SUM(p.Price * oi.Quantity) AS TotalAmount "
                + "FROM OrderItems oi "
                + "INNER JOIN Products p ON oi.ProductID = p.ID "
                + "WHERE oi.OrderID = ?;";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, order.getID());
            rs = ps.executeQuery();
            if (rs.next()) {
                totalAmount = rs.getInt("TotalAmount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalAmount;
    }

}
