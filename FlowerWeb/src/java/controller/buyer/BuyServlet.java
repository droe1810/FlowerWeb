package controller.buyer;

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
import java.time.LocalDate;

/**
 *
 * @author havie
 */
@WebServlet(name = "BuyServlet", urlPatterns = {"/buy"})
public class BuyServlet extends HttpServlet {

    Products p;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        //gọi ra dữ liệu của phiên người dùng hiện tại
        Users u = (Users) session.getAttribute("user");
        request.setAttribute("u", u);

        int productID = Integer.parseInt(request.getParameter("productID"));
        ProductsDAO pd = new ProductsDAO();
        p = pd.getProductByID(productID);
        request.setAttribute("p", p);

        request.getRequestDispatcher("buy.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        //gọi ra dữ liệu của phiên người dùng hiện tại
        Users u = (Users) session.getAttribute("user");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        int productID = Integer.parseInt(request.getParameter("productID"));

        int totalAmount = p.getPrice();

        LocalDate date = LocalDate.now();

        OrdersDAO od = new OrdersDAO();
        Orders order = new Orders(u.getID(), name, phone, address, date, totalAmount);
        od.createOrder(order);
        
        OrderItemsDAO oid = new OrderItemsDAO();
        oid.insert(productID, 1);

        CategoriesDAO cad = new CategoriesDAO();
        List<Categories> listC = cad.getCategories();
        request.setAttribute("listC", listC);

        ProductsDAO pd = new ProductsDAO();
        List<Products> listP = pd.getAllProducts();
        request.setAttribute("listP", listP);

        List<Orders> listO = od.getMyOrders(u.getID());

        request.setAttribute("listO", listO);
        request.getRequestDispatcher("my_order.jsp").forward(request, response);
    }
}
