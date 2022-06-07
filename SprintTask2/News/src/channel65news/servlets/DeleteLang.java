package channel65news.servlets;

import channel65news.DB.DBConnector;
import channel65news.models.Language;
import channel65news.models.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deletelang")
public class DeleteLang extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("lang_id"));
        Language language = DBConnector.getLanguage(id);
        DBConnector.deleteLanguage(language);
        resp.sendRedirect("/languages");
    }
}
