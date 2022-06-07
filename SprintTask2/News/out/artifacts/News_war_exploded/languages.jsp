<%@ page import="java.util.ArrayList" %>
<%@ page import="channel65news.models.Language" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 03.06.2022
  Time: 15:05
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
<%@include file="navbaradmin.jsp"%>

    <div class="sidenav">
        <a href="/admin.jsp">Admin Panel</a>
        <a href="/articles">Articles</a>
        <a href="/languages">Languages</a>
        <a href="/publications">Publications</a>
    </div>
    <div class="right-menu">
        <div class="header-t" style="display: flex">
            <div style="width: 85%"><h2 style="margin-top: 0px">Languages</h2></div>
            <div style="width: 14%">
                <button type="button" class="btn btn-success btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Add a language</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form action ="/addlanguage" method="post">
                            <div class="modal-body form">
                                <h4>Please add a language</h4>
                                <p>Choose the brand name</p>
                                <p>Language name</p>
                                <input type="text" placeholder="Enter the language" name = "language" style="margin-bottom: 10px"><br>
                                <p>Language code</p>
                                <input type="text" placeholder="Enter language's code" name = "code" style="margin-bottom: 10px"><br>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Add a language</button>
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
                <th scope="col">Language</th>
                <th scope="col">Code</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Language> languages = (ArrayList<Language>) request.getAttribute("languages");
                if (languages != null){
                    for(Language l : languages){

            %>
            <tr>
                <th scope="row"><%=l.getId()%></th>
                <td><%=l.getLanguage()%></td>
                <td><%=l.getCode()%></td>
                <td><form action="/deletelang" method="post"><input type="hidden" value="<%=l.getId()%>" name="lang_id"> <button type="submit" class="btn btn-danger btn-sm">Delete</button></form></td>
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
