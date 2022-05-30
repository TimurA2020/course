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
            String name_ru = req.getParameter("name_ru");
            Cookie cookie_ru = new Cookie("name_ru", name_ru);
            cookie.setMaxAge(3600*24*30);
            resp.addCookie(cookie_ru);
            String surname = req.getParameter("surname");
            Cookie cookie_surname = new Cookie("surname", surname);
            cookie_surname.setMaxAge(3600*24*30);
            resp.addCookie(cookie_surname);
            String surname_ru = req.getParameter("surname_ru");
            Cookie cookie_surname_ru = new Cookie("surname_ru", surname_ru);
            cookie_surname.setMaxAge(3600*24*30);
            resp.addCookie(cookie_surname_ru);

            String age = req.getParameter("age");
            Cookie cookie_age = new Cookie("age", age);
            cookie_age.setMaxAge(3600*24*30);
            resp.addCookie(cookie_age);
            String age_ru = req.getParameter("age_ru");
            Cookie cookie_age_ru = new Cookie("age_ru", age_ru);
            cookie_age.setMaxAge(3600*24*30);
            resp.addCookie(cookie_age_ru);

            String country = req.getParameter("country");
            Cookie cookie_country = new Cookie("country", country);
            cookie_country.setMaxAge(3600*24*30);
            resp.addCookie(cookie_country);
            String country_ru = req.getParameter("country_ru");
            Cookie cookie_country_ru = new Cookie("country_ru", country_ru);
            cookie_country.setMaxAge(3600*24*30);
            resp.addCookie(cookie_country_ru);

            String gender = req.getParameter("gender");
            Cookie cookie_gender = new Cookie("gender", gender);
            cookie_gender.setMaxAge(3600*24*30);
            resp.addCookie(cookie_gender);
            String gender_ru = req.getParameter("gender_ru");
            Cookie cookie_gender_ru = new Cookie("gender_ru", gender_ru);
            cookie_gender.setMaxAge(3600*24*30);
            resp.addCookie(cookie_gender_ru);

            String card = req.getParameter("card");
            Cookie cookie_card = new Cookie("card", card);
            cookie_card.setMaxAge(3600*24*30);
            resp.addCookie(cookie_card);
            String card_ru = req.getParameter("card_ru");
            Cookie cookie_card_ru = new Cookie("card_ru", card_ru);
            cookie_card.setMaxAge(3600*24*30);
            resp.addCookie(cookie_card_ru);

        resp.sendRedirect("/home");
    }
}
