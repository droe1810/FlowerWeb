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

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // them 
        int productId = Integer.parseInt(request.getParameter("productID"));
        ProductsDAO pd = new ProductsDAO();
        Products p = pd.getProductByID(productId);

        // lay ra gio hang
        List<Products> cart = (List<Products>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Calculate the total price of items in the cart
        int total = 0;
        boolean productExists = false;

        //them san pham vao gio hang, neu san pham da ton tai trong gio hang, cap nhat quantity += 1, tính thành tien cua gio hàng
        for (Products cartProduct : cart) {
            if (cartProduct.getID() == p.getID()) {
                cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                productExists = true;
            }
            total += cartProduct.getPrice() * cartProduct.getQuantity();
        }

        //them san pham vao gio hang, neu san pham chua ton tai trong gio hang, cap nhat quantity = 1, cap nhat thành tièn cua gio hàng
        if (!productExists) {
            p.setQuantity(1);
            cart.add(p);
            total += p.getPrice();
        }

        session.setAttribute("total", total);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("home").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lay ra gio hàng
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

        // xóa 1 san pham khoi gio hàng neu nhu cap nhat quatity cua san phâm dó vê 0
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
