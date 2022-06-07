package channel65news.servlets;

import channel65news.DB.DBConnector;
import channel65news.models.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/outlet")
public class OutletServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        ArrayList<Article> articles = DBConnector.getArticlesByPub(id);
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/outlet.jsp").forward(req, resp);
    }
}
