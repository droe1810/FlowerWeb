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
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "OrderDetailServlet", urlPatterns = {"/orderdetail"})
public class OrderDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        
        int odid = Integer.parseInt(request.getParameter("odid"));
        OrderItemsDAO oid = new OrderItemsDAO();
        List<OrderItems> detail = oid.getOdDetailByOdId(odid);
     
        
        request.setAttribute("detail", detail);
        request.getRequestDispatcher("orderdetail.jsp").forward(request, response);


    }

}
