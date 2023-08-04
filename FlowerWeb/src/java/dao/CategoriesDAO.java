/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.*;
import model.*;

/**
 *
 * @author havie
 */
public class CategoriesDAO extends MyDAO {

    public List<Categories> getCategories() {
        List<Categories> categoriesList = new ArrayList<>();
        xSql = "SELECT * FROM Categories";
        try {
            String xName;
            int xId;
            Categories x;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("ID");
                xName = rs.getString("Name");
                x = new Categories(xId, xName);
                categoriesList.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoriesList;
    }

    public void addCategory(String categoryName) {
        xSql = "INSERT INTO Categories (Name) VALUES (?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, categoryName);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(int cateID, String newName) {
        xSql = "UPDATE Categories SET Name = ? WHERE ID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, newName);
            ps.setInt(2, cateID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(int cateID) {
        try {
            // Set foreign key references to null in other tables
            xSql = "UPDATE Products SET CategoryID = NULL WHERE CategoryID = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cateID);
            ps.executeUpdate();

            // Delete the category from Categories table
            xSql = "DELETE FROM Categories WHERE ID = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, cateID);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CategoriesDAO cd = new CategoriesDAO();
        System.out.println(cd.getCategories());
    }
}
