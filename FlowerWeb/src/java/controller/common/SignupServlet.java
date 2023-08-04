package controller.common;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import model.*;

@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})

public class SignupServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String pass, cfpass, fullname, email;

        fullname = request.getParameter("fullname");
        email = request.getParameter("email");
        pass = request.getParameter("pass");
        cfpass = request.getParameter("cfpass");

        UsersDAO ud = new UsersDAO();
        List<Users> listU = ud.getAllUser();

        for (Users u : listU) {
            if (u.getEmail().equals(email)) {
                request.setAttribute("mess", "email registered an account!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }

        if (!pass.equals(cfpass)) {
            request.setAttribute("mess", "Password not match!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            ud.SignUp(fullname, email, pass);
            request.getRequestDispatcher("home").forward(request, response);

        }

    }

}
