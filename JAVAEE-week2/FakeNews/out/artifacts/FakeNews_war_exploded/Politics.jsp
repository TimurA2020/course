<%@ page import="com.fakenews.News.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fakenews.db.NewsDatabase" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 13.05.2022
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="htmlhead.jsp"%>
<%@include file="navbar.jsp"%>
<%
    ArrayList<News> allNews = NewsDatabase.getAllNews();
    for (News news : allNews){
        if(news.getCategory() == "Politics") {
            out.print("<div class = 'container news'>");
            out.print("<h1>" + news.getTitle() + "</h1>");
            out.print("<p>" + news.getContent() + "</p>");
            out.print("<p class='author'>Author: " + news.getAuthor() + "</p></div>");
        }
    }
%>

</body>
</html>
