package controller.common;

import dao.ProductsDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

@WebServlet(name = "ProductDetailServlet", urlPatterns = {"/productdetail"})

public class ProductDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int id = Integer.parseInt(request.getParameter("ID"));
        
        ProductsDAO pd = new ProductsDAO();
        
        Products p = pd.getProductByID(id);
               
        request.setAttribute("p", p);
        request.getRequestDispatcher("product_detail.jsp").forward(request, response);

    }

}
