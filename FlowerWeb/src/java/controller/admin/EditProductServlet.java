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
@WebServlet(name = "EditProductServlet", urlPatterns = {"/editproduct"})
public class EditProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("ID"));
        ProductsDAO pd = new ProductsDAO();
        Products p = pd.getProductByID(id);
        request.setAttribute("detail", p);

        CategoriesDAO cd = new CategoriesDAO();
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        request.getRequestDispatcher("edit_product.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int productID = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = "img/product/" + request.getParameter("image");
        int Price = Integer.parseInt(request.getParameter("price"));
        int cateID = Integer.parseInt(request.getParameter("category"));
        String des = request.getParameter("des");

        Products productUpdate = new Products(name, des, Price, image, cateID);
        ProductsDAO pd = new ProductsDAO();
        pd.editProduct(productID, productUpdate);

        List<Products> listP;

        listP = pd.getAllProducts();

        request.setAttribute("listP", listP);
        

       request.getRequestDispatcher("list_product.jsp").forward(request, response);

    }
}
