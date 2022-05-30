package cookies.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/setcookie")
public class SetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            Cookie cookie = new Cookie("name", name);
            cookie.setMaxAge(3600*24*30);
            resp.addCookie(cookie);
            String surname = req.getParameter("surname");
            Cookie cookie_surname = new Cookie("surname", surname);
            cookie_surname.setMaxAge(3600*24*30);
            resp.addCookie(cookie_surname);
            String age = req.getParameter("age");
            Cookie cookie_age = new Cookie("age", age);
            cookie_age.setMaxAge(3600*24*30);
            resp.addCookie(cookie_age);
            String country = req.getParameter("country");
            Cookie cookie_country = new Cookie("country", country);
            cookie_country.setMaxAge(3600*24*30);
            resp.addCookie(cookie_country);
            String gender = req.getParameter("gender");
            Cookie cookie_gender = new Cookie("gender", gender);
            cookie_gender.setMaxAge(3600*24*30);
            resp.addCookie(cookie_gender);
            String card = req.getParameter("card");
            Cookie cookie_card = new Cookie("card", card);
            cookie_card.setMaxAge(3600*24*30);
            resp.addCookie(cookie_card);

        resp.sendRedirect("/home");
    }
}
