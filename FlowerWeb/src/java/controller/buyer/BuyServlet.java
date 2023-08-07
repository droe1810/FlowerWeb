package controller.buyer;

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
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

        //gọi ra dữ liệu của phiên người dùng hiện tại
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");
        request.setAttribute("u", u);

        // lay ra san pham ma buyer mua
        int productID = Integer.parseInt(request.getParameter("productID"));
        ProductsDAO pd = new ProductsDAO();
        p = pd.getProductByID(productID);
        request.setAttribute("p", p);

        request.getRequestDispatcher("buy.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //gọi ra dữ liệu của phiên người dùng hiện tại
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");

        // lay thong tin nguoi mua
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        int productID = Integer.parseInt(request.getParameter("productID"));

        // lay ra thanh tien
        int totalAmount = p.getPrice();

        // ngay mua hang
        LocalDate date = LocalDate.now();

        // Tạo đơn hàng
        OrdersDAO od = new OrdersDAO();
        Orders order = new Orders(u.getID(), name, phone, address, date, totalAmount);
        od.createOrder(order);

        // Tạo  mặt hàng trong đơn hàng (OrderItems)
        OrderItemsDAO oid = new OrderItemsDAO();
        oid.insert(productID, 1);
        
        // lay ra danh sach don hang cua buyer
        List<Orders> listO = od.getMyOrders(u.getID());
        request.setAttribute("listO", listO);
        
        request.getRequestDispatcher("my_order.jsp").forward(request, response);
    }
}
