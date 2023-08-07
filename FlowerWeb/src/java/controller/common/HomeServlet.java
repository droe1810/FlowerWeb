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

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // lay ra list category
        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        // lay ra categoryID mà nguoi dùng muon xem
        String stringCateID = request.getParameter("CateID");
        
        // danh sach san pham
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP;
        //neu khong chon category cu the, tra ve danh sach tat ca san pham
        if (stringCateID == null) {
            listP = pd.getAllProducts();
        // neu chon 1 category, lay ra danh sach san pham thuoc ve category do
        } else {
            int cateID = Integer.parseInt(stringCateID);
            listP = pd.getProductsByCategoryID(cateID);
        }
        request.setAttribute("listP", listP);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    

    }


}
