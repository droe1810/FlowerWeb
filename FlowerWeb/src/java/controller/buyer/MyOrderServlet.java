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


@WebServlet(name = "MyOrderServlet", urlPatterns = {"/myorder"})
public class MyOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        //gọi ra dữ liệu của phiên người dùng hiện tại
        Users u = (Users) session.getAttribute("user");
        OrdersDAO od = new OrdersDAO();
        List<Orders> listO = od.getMyOrders(u.getID());
        
        request.setAttribute("listO", listO);
        request.getRequestDispatcher("my_order.jsp").forward(request, response);


    }

}
