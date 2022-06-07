<%@ page import="channel65news.models.Article" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 07.06.2022
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<%@include file="styleadmin.jsp"%>
<nav class="navbar navbar-expand-lg bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#" style="color: floralwhite;">Admin Panel</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav" style="float: right;">
            <ul class="navbar-nav" style="float: right;">
                <li class="nav-item" style="float: right; display: inline">
                    <a class="nav-link disabled" style="color: floralwhite;" href="/home">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="sidenav">
    <a href="/admin.jsp">Admin Panel</a>
    <a href="/languages">Languages</a>
    <a href="/articles">Articles</a>
    <a href="/publications">Publications</a>
</div>
<div class="right-menu">
        <div>
            <%
                Article article = (Article) request.getAttribute("article");
                if(article!=null){
            %>
            <h4>Please edit the article</h4>
            <p>Enter the title of the article</p>
            <textarea type="text" placeholder="<%=article.getTitle()%>" name = "title" style="margin-bottom: 10px" disabled><%=article.getTitle()%></textarea>
            <p>Enter the short content</p>
            <textarea type="text" class="content-area" name = "short_content" style="margin-bottom: 10px" value="<%=article.getShortContent()%>" disabled><%=article.getShortContent()%></textarea><br>
            <p>Enter the main content</p>
            <textarea type="text" class="main-content" name = "main_content" style="margin-bottom: 10px" value="<%=article.getContent()%>" disabled><%=article.getContent()%></textarea>
            <p>Add the picture's URL</p>
            <input type="text" placeholder="URL of the picture" name = "url" style="margin-bottom: 10px" value="<%=article.getPictureUrl()%>" disabled><br>
            <input type="number" name = "article_id" value="<%=article.getId()%>">
            <a class="btn btn-secondary" href="/articles">Close</a>
        </div>


        <%
            }
        %>
