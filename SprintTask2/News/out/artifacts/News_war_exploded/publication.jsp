<%@ page import="java.util.ArrayList" %>
<%@ page import="channel65news.models.Language" %>
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
                    <a class="nav-link" style="color: floralwhite;" href="/home">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

    <div class="sidenav">
        <a href="/admin.jsp">Admin Panel</a>
        <a href="/articles">Articles</a>
        <a href="/languages">Languages</a>
        <a href="/publications">Publications</a>
    </div>
    <div class="right-menu">
        <div class="header-t" style="display: flex">
            <div style="width: 85%"><h2 style="margin-top: 0px">Publications</h2></div>
            <div style="width: 14%">
                <button type="button" class="btn btn-success btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Add a publication</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Publication</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form action ="/addpublication" method="post">
                            <div class="modal-body form">
                                <h4>Please add a publication</h4>
                                <p>Name</p>
                                <input type="text" placeholder="Enter the name of the publication" name = "pub_name" style="margin-bottom: 10px"><br>
                                <p>Description</p>
                                <input type="text" placeholder="Enter their description" name = "pub_description" style="margin-bottom: 10px"><br>
                                <p>Rating</p>
                                <input type="number" placeholder="Enter their rating" name = "rating" style="margin-bottom: 10px"><br>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Add a publication</button>
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
                <th scope="col">Publication</th>
                <th scope="col">Description</th>
                <th scope="col">Rating</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Publication> publications = (ArrayList<Publication>) request.getAttribute("publications");
                if (publications != null){
                    for(Publication p : publications){

            %>
            <tr>
                <th scope="row"><%=p.getId()%></th>
                <td><%=p.getName()%></td>
                <td><%=p.getDescription()%></td>
                <td><%=p.getRating()%></td>
                <td><form action="/deletepub" method="post"><input type="hidden" value="<%=p.getId()%>" name="pub_id"> <button type="submit" class="btn btn-danger btn-sm">Delete</button></form></td>
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
