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
@WebServlet(name = "BuyByCartServlet", urlPatterns = {"/buybycart"})
public class BuyByCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        //gọi ra dữ liệu của phiên người dùng hiện tại
        Users u = (Users) session.getAttribute("user");

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        List<Products> cart = (List<Products>) session.getAttribute("cart");
        int total = 0;

        // Update the quantity of the product in the cart
        for (Products cartProduct : cart) {

            // Calculate the total price of items in the cart
            total += cartProduct.getPrice() * cartProduct.getQuantity();
        }

        LocalDate date = LocalDate.now();

        // Tạo đơn hàng
        OrdersDAO od = new OrdersDAO();
        Orders order = new Orders(u.getID(), name, phone, address, date, total);
        od.createOrder(order);

        // Tạo các mặt hàng trong đơn hàng (OrderItems)
        OrderItemsDAO oid = new OrderItemsDAO();
        for (Products p : cart) {
            oid.insert(p.getID(), p.getQuantity());
        }

        session.removeAttribute("cart");
        session.removeAttribute("total");

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
