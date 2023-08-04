package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author havie
 */
public class OrderItemsDAO extends MyDAO {

    public List<OrderItems> getOdDetailByOdId(int odId) {
        List<OrderItems> List = new ArrayList<>();
        xSql = "select oi.*, p.Name, p.Price from OrderItems oi join Products p\n"
                + "on oi.ProductID = p.ID where oi.OrderID = ?";
        try {
            int productId, quantity, price;
            String name;
            OrderItems detail;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, odId);
            rs = ps.executeQuery();
            while (rs.next()) {
                productId = rs.getInt("ProductID");
                name = rs.getString("Name");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                detail = new OrderItems(odId, productId, name, quantity, price);
                List.add(detail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return List;
    }

    public void insert(int ProductID, int Quantity) {

        try {
            xSql = "INSERT INTO OrderItems (OrderID, ProductID, Quantity)\n"
                    + "SELECT MAX(id), ?, ?\n"
                    + "FROM Orders;";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, ProductID);
            ps.setInt(2, Quantity);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
