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

@WebServlet(value = "/editarticle")
public class EditArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Article article = DBConnector.getArticle(id);
        req.setAttribute("article", article);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article1 = DBConnector.getArticle(Integer.parseInt(req.getParameter("article_id")));
        article1.setTitle(req.getParameter("title"));
        article1.setShortContent(req.getParameter("short_content"));
        article1.setContent(req.getParameter("main_content"));
        article1.setPictureUrl(req.getParameter("url"));
        DBConnector.editArticle(article1);

        resp.sendRedirect("/articles");
    }
}
