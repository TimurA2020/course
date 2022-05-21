<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 21.05.2022
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<body>
<%@include file="CSS.jsp"%>
<%@include file="navbar.jsp"%>

<div class="login-container">
    <h1>Login</h1>
    <form action="/login" method="POST">
        <input type="text" placeholder="username" class="field" name = "login">
        <input type="password" placeholder="password" class="field" name = "password">
        <input type="submit" value="login" class="login-btn">
    </form>
    <div class="pass-link">
        <a href="#" >Lost your password?</a>
    </div>
</div>

</body>
</html>
