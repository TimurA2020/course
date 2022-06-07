package channel65news.servlets;

import channel65news.DB.DBConnector;
import channel65news.models.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deletepub")
public class DeletePub extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("pub_id"));
        Publication publication = DBConnector.getPublication(id);
        DBConnector.deletePublication(publication);
        resp.sendRedirect("/publications");
    }
}
