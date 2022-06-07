package channel65news.servlets;

import channel65news.DB.DBConnector;
import channel65news.models.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/readmore")
public class ReadMore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Article article = DBConnector.getArticle(id);
        System.out.println("s");
        req.setAttribute("article", article);
        req.getRequestDispatcher("/readmore.jsp").forward(req, resp);
    }
}
