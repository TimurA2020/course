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
        try {

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("name")) {
                        myCookie = cookie.getValue();
                    }
                }
            }

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("surname")) {
                        surname = cookie.getValue();
                    }
                }
            }
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("age")) {
                        age = cookie.getValue();
                    }
                }
            }
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("country")) {
                        country = cookie.getValue();
                    }
                }
            }
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("gender")) {
                        gender = cookie.getValue();
                    }
                }
            }
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("card")) {
                        card = cookie.getValue();
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
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
