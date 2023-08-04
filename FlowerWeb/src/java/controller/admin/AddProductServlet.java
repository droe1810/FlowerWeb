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
@WebServlet(name = "AddProductServlet", urlPatterns = {"/addproduct"})
public class AddProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("add_product.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String image = "img/product/" + request.getParameter("image");
        int price = Integer.parseInt(request.getParameter("price"));
        String des = request.getParameter("des");

        int category = Integer.parseInt(request.getParameter("category"));

        ProductsDAO pd = new ProductsDAO();

        pd.addProduct(new Products(name, des, price, image, category));

        List<Products> listP;

        listP = pd.getAllProducts();

        request.setAttribute("listP", listP);
        
        request.getRequestDispatcher("list_product.jsp").forward(request, response);

    }
}
