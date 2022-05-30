package cookies.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Cookie cookies[] = req.getCookies();
            String myCookie = null;
            String surname = null;
            String age = null;
            String country = null;
            String gender = null;
            String card = null;
            String language = null;
            String myCookie_ru = null;
            String surname_ru = null;
            String age_ru = null;
            String country_ru = null;
            String gender_ru = null;
            String card_ru = null;

        try {

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("name")) {
                        myCookie = cookie.getValue();
                    }
                }
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("surname")) {
                        surname = cookie.getValue();
                    }
                }
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("age")) {
                        age = cookie.getValue();
                    }
                }
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("country")) {
                        country = cookie.getValue();
                    }
                }
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("gender")) {
                        gender = cookie.getValue();
                    }
                }

                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("card")) {
                        card = cookie.getValue();
                    }
                }
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("language")) {
                        language = cookie.getValue();
                    }
                }
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("name_ru")) {
                        myCookie_ru = cookie.getValue();
                    }
                }

                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("surname_ru")) {
                        surname_ru = cookie.getValue();
                    }
                }
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("age_ru")) {
                        age_ru = cookie.getValue();
                    }
                }
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("country_ru")) {
                        country_ru = cookie.getValue();
                    }
                }
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("gender_ru")) {
                        gender_ru = cookie.getValue();
                    }
                }

                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("card_ru")) {
                        card_ru = cookie.getValue();
                    }
                }


            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        req.setAttribute("name", myCookie);
        req.setAttribute("surname", surname);
        req.setAttribute("age", age);
        req.setAttribute("card", card);
        req.setAttribute("gender", gender);
        req.setAttribute("country", country);
        req.setAttribute("language", language);

        req.setAttribute("name_ru", myCookie_ru);
        req.setAttribute("surname_ru", surname_ru);
        req.setAttribute("age_ru", age_ru);
        req.setAttribute("card_ru", card_ru);
        req.setAttribute("gender_ru", gender_ru);
        req.setAttribute("country_ru", country_ru);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
