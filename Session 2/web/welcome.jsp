<%@ page import="bestbuy.essence.Users" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 21.05.2022
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<%@include file="CSS.jsp"%>
<%@include file="navbar.jsp"%>

<%
    Users user = (Users) request.getAttribute("welcome");
    if (user!=null){
%>

<h1>Welcome <%=user.getFullname()%>!</h1>

<%
    }
%>

</body>
</html>
