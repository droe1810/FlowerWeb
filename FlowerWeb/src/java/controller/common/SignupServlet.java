package controller.common;

import dao.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.*;

@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})

public class SignupServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pass, cfpass, fullname, email;

        // lay ra thong tin nguoi dung input o form signup
        fullname = request.getParameter("fullname");
        email = request.getParameter("email");
        pass = request.getParameter("pass");
        cfpass = request.getParameter("cfpass");

        // lay ra tat ca nhung tai khoan da ton tai trong he thong
        UsersDAO ud = new UsersDAO();
        List<Users> listU = ud.getAllUser();

        for (Users u : listU) {
            // kiem tra email da ton tai chua
            if (u.getEmail().equals(email)) {
                request.setAttribute("mess", "email registered an account!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
        
        // kiem tra mat khau va nhap lai mat khau co khop nhau hay khong
        if (!pass.equals(cfpass)) {
            request.setAttribute("mess", "Password not match!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            // neu khong co van de gì -> dang ky tai khoan thành công
            ud.SignUp(fullname, email, pass);
            request.getRequestDispatcher("home").forward(request, response);

        }

    }

}
