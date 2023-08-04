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
@WebServlet(name = "DeleteCateServlet", urlPatterns = {"/deletecate"})
public class DeleteCateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        
        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        request.getRequestDispatcher("delete_cate.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        
        CategoriesDAO cd = new CategoriesDAO();
        cd.deleteCategory(cateID);
        
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);
        
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP = pd.getAllProducts();
        request.setAttribute("listP", listP);


        

       request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}
