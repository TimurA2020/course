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
import java.util.ArrayList;

@WebServlet(value = "/articles")
public class ArticlesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Article> articles = DBConnector.getAllArticles();
        ArrayList<Language> languages = DBConnector.getAllLanguages();
        ArrayList<Publication> publications = DBConnector.getAllPublications();
        req.setAttribute("languages", languages);
        req.setAttribute("publications", publications);
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/articles.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
