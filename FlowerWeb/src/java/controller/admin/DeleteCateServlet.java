package controller.admin;

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "DeleteCateServlet", urlPatterns = {"/deletecate"})
public class DeleteCateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lay ra list category
        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        request.getRequestDispatcher("delete_cate.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // xóa 1 category
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        CategoriesDAO cd = new CategoriesDAO();
        cd.deleteCategory(cateID);
        
        // lay danh sách category moi
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);
        
        // lay danh sách san pham
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP = pd.getAllProducts();
        request.setAttribute("listP", listP);

       request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}
