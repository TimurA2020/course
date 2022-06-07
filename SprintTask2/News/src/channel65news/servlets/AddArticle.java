package channel65news.servlets;

import channel65news.DB.DBConnector;
import channel65news.models.Article;
import channel65news.models.Language;
import channel65news.models.Publication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet(value = "/addarticle")
public class AddArticle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String short_content = req.getParameter("short_content");
        String content = req.getParameter("main_content");
        String url = req.getParameter("url");
        int language_id = Integer.parseInt(req.getParameter("language"));
        int publication_id = Integer.parseInt(req.getParameter("publication"));
        Language language = DBConnector.getLanguage(language_id);
        Publication publication = DBConnector.getPublication(publication_id);
        Timestamp timeStamp = Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));


        Article article = new Article();
        article.setTitle(title);
        article.setShortContent(short_content);
        article.setContent((content));
        article.setDate(timeStamp);
        article.setPictureUrl(url);
        article.setPublication_id(publication_id);
        article.setLanguage_id(language_id);
        article.setPublication(publication);

        DBConnector.addArticle(article);

        resp.sendRedirect("/articles");
    }
}
