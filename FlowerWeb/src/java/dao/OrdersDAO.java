package dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Orders;

public class OrdersDAO extends MyDAO {

    // lay ra nhung don hang cua 1 khach hang
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
    
    // lay ra tat ca nhung don hang
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

     // tao 1 don hàng
    public void createOrder(Orders order) {
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
}
