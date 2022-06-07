<%@ page import="java.util.ArrayList" %>
<%@ page import="channel65news.models.Language" %>
<%@ page import="channel65news.models.Article" %>
<%@ page import="channel65news.models.Publication" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 03.06.2022
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
<title>Admin panel</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<%@include file="styleadmin.jsp"%>
<%@include file="navbaradmin.jsp"%>

    <div class="sidenav">
        <a href="/admin.jsp">Admin Panel</a>
        <a href="/articles">Articles</a>
        <a href="/languages">Languages</a>
        <a href="/publications">Publications</a>
    </div>
    <div class="right-menu">
        <div class="header-t" style="display: flex">
            <div style="width: 85%"><h2 style="margin-top: 0px">Articles</h2></div>
            <div style="width: 14%">
                <button type="button" class="btn btn-success btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Add an article</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form action ="/addarticle" method="post">
                            <div class="modal-body form">
                                <h4>Please add an article</h4>
                                <p>Enter the title of the article</p>
                                <input type="text" placeholder="Enter the title" name = "title" style="margin-bottom: 10px"><br>
                                <p>Enter the short content</p>
                                <textarea class="content-area" type="text" placeholder="Enter the short content" name = "short_content" style="margin-bottom: 10px"></textarea><br>
                                <p>Enter the main content</p>
                                <textarea type="text" class="main-content" placeholder="Enter the main content" name = "main_content" style="margin-bottom: 10px"></textarea><br>
                                <p>Add the picture's URL</p>
                                <input type="text" placeholder="URL of the picture" name = "url" style="margin-bottom: 10px"><br>
                                <p>Select the language of the article</p>
                                <select name="language">
                                    <%
                                        ArrayList<Language> languages = (ArrayList<Language>) request.getAttribute("languages");
                                        if(languages!=null){
                                            for (Language language : languages){

                                    %>
                                    <option value="<%=language.getId()%>"><%=language.getLanguage() + " / " + language.getCode()%></option>
                                    <%
                                        }
                                        }
                                    %>
                                </select><br>
                                <p>Select the outlet that published the article</p>
                                <select name="publication">
                                    <%
                                        ArrayList<Publication> publications = (ArrayList<Publication>) request.getAttribute("publications");
                                        if (publications!=null){
                                            for (Publication publication : publications){

                                    %>
                                    <option value = "<%=publication.getId()%>"><%=publication.getName()%></option>
                                    <%
                                        }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Add an article</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Title</th>
                <th scope="col">Language</th>
                <th scope="col">Added Date</th>
                <th scope="col">Publication</th>
                <th scope="col">Details</th>
                <th scope="col">Edit</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
                if (articles != null){
                    for(Article a : articles){

            %>
            <tr>
                <th scope="row"><%=a.getId()%></th>
                <td><%=a.getTitle()%></td>
                <td><%=a.getLanguage_id()%></td>
                <td><%=a.getDate()%></td>
                <td><%=a.getPublication().getName()%></td>
                <td><a class="btn btn-sm btn-primary" href="/details?id=<%=a.getId()%>">Details</a></td>
                <td><a href="/editarticle?id=<%=a.getId()%>" class="btn btn-primary btn-sm" style="margin-right: 10px">Edit</a><form action="/deletearticle" method="post"><input type="hidden" value="<%=a.getId()%>" name="article_id"> <button type="submit" class="btn btn-danger btn-sm">Delete</button></form></td>
            </tr>

            <%
                }
                }
            %>
            </tbody>
        </table>
    </div>
<%@include file="footer.jsp"%>
</body>
</html>
