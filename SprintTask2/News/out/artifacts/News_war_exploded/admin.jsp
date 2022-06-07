<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 03.06.2022
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Admin panel</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<%@include file="styleadmin.jsp"%>
<%@include file="navbaradmin.jsp"%>

<div class="sidenav">
    <a href="/admin.jsp">Admin Panel</a>
    <a href="/articles">Articles</a>
    <a href="/languages">Languages</a>
    <a href="/publications">Publications</a>
</div>
<div class="right-menu">
    <div class="container"><h1>Welcome to the admin panel</h1>
        <h3>Here you can add, edit or remove certain elements, i.e languages, articles and publications</h3>
    </div>
    </div>

</div>

</body>
</html>
