package bestbuy.servlets;


import bestbuy.DB.DBItems;
import bestbuy.essence.Brands;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addbrand")
public class AddBrand extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("brand_name");
        String country = req.getParameter("brand_country");
        Brands brand = new Brands();
        brand.setName(name);
        brand.setCountry(country);
        DBItems.addBrand(brand);

        resp.sendRedirect("/brands");
    }
}
