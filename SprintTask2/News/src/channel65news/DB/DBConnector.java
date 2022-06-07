package channel65news.DB;

import channel65news.models.Article;
import channel65news.models.Language;
import channel65news.models.Publication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnector {
    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/news", "postgres", "falcon");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Publication> getAllPublications(){
        ArrayList<Publication> publications = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM publications " +
                    "ORDER by id ASC");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Publication publication = new Publication();
                publication.setId(Integer.parseInt(resultSet.getString("id")));
                publication.setName(resultSet.getString("pub_name"));
                publication.setDescription(resultSet.getString("description"));
                publication.setRating(resultSet.getDouble("rating"));
                publications.add(publication);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return publications;

    }

    public static void deletePublication(Publication publication){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM publications WHERE id = ?");
            statement.setInt(1, publication.getId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteLanguage(Language language){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM languages WHERE id = ?");
            statement.setInt(1, language.getId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteArticle(Article article){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM articles WHERE id = ?");
            statement.setInt(1, article.getId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Article> getAllArticles(){
        ArrayList<Article> articles = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT ar.id, ar.title, ar.short, ar.content, ar.post_date, ar.picture, ar.language_id, p.pub_name, p.description, p.rating " +
                    "FROM articles ar " +
                    "INNER JOIN publications p ON p.id = ar.publication_id " +
                    "ORDER by id ASC");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Article article = new Article();
                article.setId(Integer.parseInt(resultSet.getString("id")));
                article.setTitle(resultSet.getString("title"));
                article.setShortContent(resultSet.getString("short"));
                article.setContent(resultSet.getString("content"));
                article.setDate(resultSet.getTimestamp("post_date"));
                article.setPictureUrl(resultSet.getString("picture"));
                article.setLanguage_id(resultSet.getInt("language_id"));

                Publication publication = new Publication();
                publication.setName(resultSet.getString("pub_name"));
                publication.setDescription(resultSet.getString("description"));
                publication.setRating(resultSet.getDouble("rating"));

                article.setPublication(publication);

                articles.add(article);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return articles;
    }

    public static ArrayList<Article> getAllEngArticles(){
        ArrayList<Article> articles = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                            "SELECT ar.id, ar.title, ar.short, ar.content, ar.post_date, ar.picture, ar.language_id, p.pub_name, p.description, p.rating " +
                                        "FROM articles ar " +
                                        "INNER JOIN publications p ON p.id = ar.publication_id " +
                    "WHERE language_id = 1");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setShortContent(resultSet.getString("short"));
                article.setContent(resultSet.getString("content"));
                article.setDate(resultSet.getTimestamp("post_date"));
                article.setPictureUrl(resultSet.getString("picture"));
                article.setLanguage_id(resultSet.getInt("language_id"));

                Publication publication = new Publication();
                publication.setName(resultSet.getString("pub_name"));
                publication.setDescription(resultSet.getString("description"));
                publication.setRating(resultSet.getDouble("rating"));

                article.setPublication(publication);
                articles.add(article);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return articles;
    }

    public static ArrayList<Article> getArticlesByLang(int id){
        ArrayList<Article> articles = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT ar.id, ar.title, ar.short, ar.content, ar.post_date, ar.picture, ar.language_id, p.pub_name, p.description, p.rating " +
                    "FROM articles ar " +
                    "INNER JOIN publications p ON p.id = ar.publication_id WHERE language_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setShortContent(resultSet.getString("short"));
                article.setContent(resultSet.getString("content"));
                article.setDate(resultSet.getTimestamp("post_date"));
                article.setPictureUrl(resultSet.getString("picture"));
                article.setLanguage_id(resultSet.getInt("language_id"));

                Publication publication = new Publication();
                publication.setName(resultSet.getString("pub_name"));
                publication.setDescription(resultSet.getString("description"));
                publication.setRating(resultSet.getDouble("rating"));

                article.setPublication(publication);
                articles.add(article);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return articles;
    }

    public static ArrayList<Article> getAllRusArticles(){
        ArrayList<Article> articles = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM articles WHERE language_id = 2");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Article article = new Article();
                article.setId(Integer.parseInt(resultSet.getString("id")));
                article.setTitle(resultSet.getString("title"));
                article.setShortContent(resultSet.getString("short"));
                article.setContent(resultSet.getString("content"));
                article.setDate(resultSet.getTimestamp("post_date"));
                article.setPictureUrl(resultSet.getString("picture"));
                article.setLanguage_id(resultSet.getInt("language_id"));
                article.setPublication_id(resultSet.getInt("publication_id"));
                articles.add(article);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return articles;
    }

    public static Article getArticle(int id){
        Article article = new Article();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT ar.id, ar.title, ar.short, ar.content, ar.post_date, ar.picture, ar.language_id, p.pub_name, p.description, p.rating " +
                    "FROM articles ar " +
                    "INNER JOIN publications p ON p.id = ar.publication_id " +
                    "WHERE ar.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                article.setId(id);
                article.setTitle(resultSet.getString("title"));
                article.setShortContent(resultSet.getString("short"));
                article.setContent(resultSet.getString("content"));
                article.setContent(resultSet.getString("content"));
                article.setDate(resultSet.getTimestamp("post_date"));
                article.setPictureUrl(resultSet.getString("picture"));
                article.setLanguage_id(resultSet.getInt("language_id"));

                Publication publication = new Publication();
                publication.setName(resultSet.getString("pub_name"));
                publication.setDescription(resultSet.getString("description"));
                publication.setRating(resultSet.getDouble("rating"));

                article.setPublication(publication);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return article;
    }

    public static ArrayList<Article> getArticlesByPub(int id){
        ArrayList <Article> articles = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM articles WHERE publication_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Article article = new Article();
                article.setTitle(resultSet.getString("title"));
                article.setShortContent(resultSet.getString("short"));
                article.setContent(resultSet.getString("content"));
                article.setContent(resultSet.getString("content"));
                article.setDate(resultSet.getTimestamp("post_date"));
                article.setPictureUrl(resultSet.getString("picture"));
                article.setLanguage_id(resultSet.getInt("language_id"));
                article.setPublication_id(resultSet.getInt("publication_id"));

                articles.add(article);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return articles;
    }

    public static ArrayList<Language> getAllLanguages(){

        ArrayList<Language> languages = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM languages");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Language language = new Language();
                language.setId(Integer.parseInt(resultSet.getString("id")));
                language.setLanguage(resultSet.getString("language"));
                language.setCode(resultSet.getString("code"));
                languages.add(language);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return languages;

    }

    public static Language getLanguage(int language_id){

        Language language = new Language();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM languages WHERE id = ?");
            statement.setInt(1, language_id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                language.setId(Integer.parseInt(resultSet.getString("id")));
                language.setLanguage(resultSet.getString("language"));
                language.setCode(resultSet.getString("code"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return language;

    }

    public static Publication getPublication(int publication_id){

        Publication publication = new Publication();

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM publications WHERE id = ?");
            statement.setInt(1, publication_id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                publication.setId(Integer.parseInt(resultSet.getString("id")));
                publication.setName(resultSet.getString("language"));
                publication.setDescription(resultSet.getString("description"));
                publication.setRating(Double.parseDouble(resultSet.getString("rating")));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return publication;

    }

    public static void editArticle(Article article){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE articles SET title = ?, short = ?, content = ?, picture = ? " +
                    "WHERE id = ?");
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getShortContent());
            statement.setString(3, article.getContent());
            statement.setString(4, article.getPictureUrl());
            statement.setInt(5, article.getId());

            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addLanguage(Language l){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO languages(language, code) " +
                    "VALUES (?, ?)");
            statement.setString(1, l.getLanguage());
            statement.setString(2, l.getCode());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addPublication(Publication p){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO publications(pub_name, description, rating) " +
                    "VALUES (?, ?, ?)");
            statement.setString(1, p.getName());
            statement.setString(2, p.getDescription());
            statement.setDouble(3, p.getRating());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addArticle(Article a){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO articles(title, short, content, post_date, picture, language_id, publication_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, a.getTitle());
            statement.setString(2, a.getShortContent());
            statement.setString(3, a.getContent());
            statement.setTimestamp(4, a.getDate());
            statement.setString(5, a.getPictureUrl());
            statement.setInt(6, a.getLanguage_id());
            statement.setInt(7, a.getPublication_id());
            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
