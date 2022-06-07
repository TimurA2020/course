package channel65news.servlets;

import channel65news.DB.DBConnector;
import channel65news.models.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addlanguage")
public class AddLanguage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("language");
        String code = req.getParameter("code");

        Language language1 = new Language();
        language1.setLanguage(language);
        language1.setCode(code);

        DBConnector.addLanguage(language1);

        resp.sendRedirect("/languages");
    }
}
