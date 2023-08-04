package controller.admin;

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author havie
 */
@WebServlet(name = "AddCateServlet", urlPatterns = {"/addcate"})
public class AddCateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String categoryName = request.getParameter("name");

        CategoriesDAO cd = new CategoriesDAO();
        cd.addCategory(categoryName);
        
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        ProductsDAO pd = new ProductsDAO();
        List<Products> listP = pd.getAllProducts();

        request.setAttribute("listP", listP);

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


    }
}
