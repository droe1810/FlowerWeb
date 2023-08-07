package controller.seller;

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "ViewOrderServlet", urlPatterns = {"/vieworder"})
public class ViewOrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // lay ra thong tin order
        OrdersDAO od = new OrdersDAO();
        List<Orders> listO = od.getAllOrders();
        
        request.setAttribute("listO", listO);
        request.getRequestDispatcher("allorder.jsp").forward(request, response);


    }

}
