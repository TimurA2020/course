package channel65news.servlets;

import channel65news.DB.DBConnector;
import channel65news.models.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/publications")
public class PublicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Publication> publications = DBConnector.getAllPublications();
        req.setAttribute("publications", publications);
        req.getRequestDispatcher("/publication.jsp").forward(req, resp);
    }
}
