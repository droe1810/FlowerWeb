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


@WebServlet(name = "EditCateServlet", urlPatterns = {"/editcate"})
public class EditCateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lay ra danh sách category
        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        request.getRequestDispatcher("edit_cate.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // cap nhat category
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        String newName = request.getParameter("name");  
        CategoriesDAO cd = new CategoriesDAO();
        cd.updateCategory(cateID, newName);
        
        // lay ra danh sach category moi
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);
        
        // lay ra danh sach san pham
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP = pd.getAllProducts();
        request.setAttribute("listP", listP);

       request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}
