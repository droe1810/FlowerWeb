package controller.common;

import dao.*;
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

        // lay ra ky tu ma nguoi dung search
        String txt = request.getParameter("txt");
        
        // lay ra list category
        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);
        
        //lay ra nhung san pham co tên chua ký tu mà nguoi dùng muon search
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP = pd.searchProductByName(txt);
        request.setAttribute("listP", listP);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
        
    }

}
