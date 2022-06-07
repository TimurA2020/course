package channel65news.servlets;

import channel65news.DB.DBConnector;
import channel65news.models.Article;
import channel65news.models.Language;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deletearticle")
public class DeleteArticle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("article_id"));
        Article article = DBConnector.getArticle(id);
        DBConnector.deleteArticle(article);
        resp.sendRedirect("/articles");
    }
}
