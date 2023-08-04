package controller.common;

import dao.CategoriesDAO;
import dao.ProductsDAO;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

@WebServlet(name = "SearchProductServlet", urlPatterns = {"/searchproduct"})

public class SearchProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String txt = request.getParameter("txt");
        
        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);
        
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP = pd.searchProductByName(txt);
        request.setAttribute("listP", listP);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
        
    }

}
