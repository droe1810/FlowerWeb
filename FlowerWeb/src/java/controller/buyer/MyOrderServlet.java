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

@WebServlet(name = "MyOrderServlet", urlPatterns = {"/myorder"})
public class MyOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //gọi ra dữ liệu của phiên người dùng hiện tại
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");
        
        // lay ra danh sách order cua buyer
        OrdersDAO od = new OrdersDAO();
        List<Orders> listO = od.getMyOrders(u.getID());

        request.setAttribute("listO", listO);
        request.getRequestDispatcher("my_order.jsp").forward(request, response);

    }

}
