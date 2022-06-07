package channel65news.models;

import java.sql.Timestamp;

public class Article {
    int id;
    String title;
    String shortContent;
    String content;
    Timestamp date;
    String pictureUrl;
    int language_id;
    int publication_id;
    Publication publication;
    Language language;


    public Article() {
    }

    public Article(int id, String title, String shortContent, String content, Timestamp date, String pictureUrl, int language_id, int publication_id) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
        this.date = date;
        this.pictureUrl = pictureUrl;
        this.language_id = language_id;
        this.publication_id = publication_id;
    }

    public Article(int id, String title, String shortContent, String content, Timestamp date, String pictureUrl, int language_id, int publication_id, Publication publication) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
        this.date = date;
        this.pictureUrl = pictureUrl;
        this.language_id = language_id;
        this.publication_id = publication_id;
        this.publication = publication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(int publication_id) {
        this.publication_id = publication_id;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Article(int id, String title, String shortContent, String content, Timestamp date, String pictureUrl, int language_id, int publication_id, Publication publication, Language language) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
        this.date = date;
        this.pictureUrl = pictureUrl;
        this.language_id = language_id;
        this.publication_id = publication_id;
        this.publication = publication;
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
