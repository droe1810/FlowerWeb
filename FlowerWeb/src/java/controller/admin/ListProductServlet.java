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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author havie
 */
@WebServlet(name = "ListProductServlet", urlPatterns = {"/listproduct"})
public class ListProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ProductsDAO pd = new ProductsDAO();
        List<Products> listP;

        listP = pd.getAllProducts();

        request.setAttribute("listP", listP);

        request.getRequestDispatcher("list_product.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String txt = request.getParameter("txt");

        ProductsDAO pd = new ProductsDAO();
        List<Products> listP;
        listP = pd.searchProductByName(txt);

        request.setAttribute("listP", listP);

        request.getRequestDispatcher("list_product.jsp").forward(request, response);

    }
}
