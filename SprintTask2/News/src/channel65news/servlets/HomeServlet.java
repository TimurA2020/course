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

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Article> articles = new ArrayList<>();
        try {
            String id = req.getParameter("id");

            if (id == null) {
                articles = DBConnector.getAllEngArticles();
            }
            else{
                int idToInt = Integer.parseInt(id);
                System.out.println(idToInt);
                articles = DBConnector.getArticlesByLang(idToInt);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            }
        ArrayList<Language> languages = DBConnector.getAllLanguages();
        System.out.println(languages.get(0).getLanguage());
        req.setAttribute("languages", languages);
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
