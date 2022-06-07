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

@WebServlet(value = "/addpublication")
public class AddPublication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("pub_name");
        String description = req.getParameter("pub_description");
        Double rating = Double.valueOf(req.getParameter("rating"));

        Publication publication = new Publication();
        publication.setName(name);
        publication.setDescription(description);
        publication.setRating(rating);

        DBConnector.addPublication(publication);

        resp.sendRedirect("/publications");
    }
}
