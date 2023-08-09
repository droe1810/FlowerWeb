package dao;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class UsersDAO extends MyDAO {

    // hàm dang nhâp
    public Users Login(String email, String pass) {
        xSql = "select * from Users where email = ? and password = ?";
        String xName, xPass, xEmail;
        int xId, xRole;
        Users x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("ID");
                xName = rs.getString("Name");
                xEmail = rs.getString("email");
                xPass = rs.getString("password");
                xRole = rs.getInt("role");

                x = new Users(xId, xName, xEmail, xPass, xRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    // hàm tra vê danh sách tat ca nguoi dung
    public List<Users> getAllUser() {
        List<Users> list = new ArrayList<>();
        xSql = "select * from users";
        String xPass, xName, xEmail;
        int xId, xRole;
        Users x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("ID");
                xName = rs.getString("Name");
                xEmail = rs.getString("email");
                xPass = rs.getString("password");
                xRole = rs.getInt("role");

                x = new Users(xId, xName, xEmail, xPass, xRole);
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // hàm dang kí
    public void SignUp(String name, String email, String pass) {
        xSql = "INSERT INTO Users (Name, Email, Password, Role) VALUES ( ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setInt(4, 3);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
