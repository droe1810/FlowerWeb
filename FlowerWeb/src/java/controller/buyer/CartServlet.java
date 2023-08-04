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
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");
        request.setAttribute("u", u);

        int productId = Integer.parseInt(request.getParameter("productID"));
        ProductsDAO pd = new ProductsDAO();
        Products p = pd.getProductByID(productId);

        List<Products> cart = (List<Products>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Calculate the total price of items in the cart
        int total = 0;
        boolean productExists = false;

        for (Products cartProduct : cart) {
            if (cartProduct.getID() == p.getID()) {
                cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                productExists = true;
            }
            total += cartProduct.getPrice() * cartProduct.getQuantity();
        }

        // If the product doesn't exist in the cart, add it with quantity 1
        if (!productExists) {
            p.setQuantity(1);
            cart.add(p);
            total += p.getPrice();
        }

        // Set the total price as an attribute in the session
        session.setAttribute("total", total);

        session.setAttribute("cart", cart);
        request.getRequestDispatcher("home").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession session = request.getSession();
    List<Products> cart = (List<Products>) session.getAttribute("cart");
    int productId = Integer.parseInt(request.getParameter("productID"));
    int quantity = Integer.parseInt(request.getParameter("quantity"));

    int total = 0;

    // Update the quantity of the product in the cart
    for (Products cartProduct : cart) {
        if (cartProduct.getID() == productId) {
            cartProduct.setQuantity(quantity);
        }
        // Calculate the total price of items in the cart
        total += cartProduct.getPrice() * cartProduct.getQuantity();
    }

    // Remove the product from the cart if its quantity is zero
    Iterator<Products> iterator = cart.iterator();
    while (iterator.hasNext()) {
        Products cartProduct = iterator.next();
        if (cartProduct.getQuantity() == 0) {
            iterator.remove();
        }
    }

    // Set the total price as an attribute in the session
    session.setAttribute("total", total);

    // Save the updated cart and redirect back to the cart.jsp
    session.setAttribute("cart", cart);
    response.sendRedirect("cart.jsp");
    }

}
