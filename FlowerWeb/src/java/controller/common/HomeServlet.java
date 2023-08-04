package controller.common;

import dao.*;
import model.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;

/**
 *
 * @author havie
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        String stringCateID = request.getParameter("CateID");
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP;
        if (stringCateID == null) {
            listP = pd.getAllProducts();
        } else {
            int cateID = Integer.parseInt(stringCateID);
            listP = pd.getProductsByCategoryID(cateID);
        }
        request.setAttribute("listP", listP);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    

    }


}
