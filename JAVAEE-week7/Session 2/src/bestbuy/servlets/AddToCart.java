package bestbuy.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/addtocart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("item_name");
        double price = Double.parseDouble(req.getParameter("item_price"));

        HttpSession session = req.getSession();
        List <Cart> cart = (List<Cart>) session.getAttribute("cart");
        if(cart==null){
            cart = new ArrayList<>();
        }
        cart.add(new Cart(name, price));

        session.setAttribute("cart", cart);

        resp.sendRedirect("/");
    }
}
