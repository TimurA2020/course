package students.servlets;

import students.database.DBConnnector;
import students.student.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/addcity")
public class AddCity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<City> cities = DBConnnector.getAllCities();
        req.setAttribute("cities", cities);
        req.getRequestDispatcher("/details.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city_name = req.getParameter("city_name");
        String code = req.getParameter("city_code");

        City city = new City();
        city.setName(city_name);
        city.setCode(code);

        DBConnnector.addCity(city);

        resp.sendRedirect("/cities");
    }

}
