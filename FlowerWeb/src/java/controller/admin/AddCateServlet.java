package controller.admin;

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "AddCateServlet", urlPatterns = {"/addcate"})
public class AddCateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // thêm moi 1 cate
        String categoryName = request.getParameter("name");
        CategoriesDAO cd = new CategoriesDAO();
        cd.addCategory(categoryName);
        
        // lay ra list cate de hien thi
        List<Categories> listC = cd.getCategories();
        request.setAttribute("listC", listC);

        // lay ra list san pham de hien thi
        ProductsDAO pd = new ProductsDAO();
        List<Products> listP = pd.getAllProducts();
        request.setAttribute("listP", listP);

        // chuyen toi trang home.jsp
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }
}
