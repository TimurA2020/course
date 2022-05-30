package bestbuy.servlets;

import bestbuy.DB.DBItems;
import bestbuy.essence.Brands;
import bestbuy.essence.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/additem")
public class AddItem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long brand_id = Long.valueOf(req.getParameter("brand_id"));
        String name = req.getParameter("item_name");
        String description = req.getParameter("item_description");
        float price = Float.parseFloat(req.getParameter("item_price"));

        Brands brand = DBItems.getBrand(brand_id);

        Items item = new Items();
        item.setName(name);
        item.setDescription(description);
        item.setBrand(brand);
        item.setPrice(price);

        DBItems.addItem(item);

        resp.sendRedirect("/admin");

    }
}
