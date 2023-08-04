package controller.common;

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
@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/deleteproduct"})
public class DeleteProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int productID = Integer.parseInt(request.getParameter("ID"));
        
        ProductsDAO pd = new ProductsDAO();
        pd.deleteProduct(productID);
        
        
        List<Products> listP;

        listP = pd.getAllProducts();

        request.setAttribute("listP", listP);
        request.getRequestDispatcher("list_product.jsp").forward(request, response);

    }


}
