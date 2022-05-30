<%@ page import="bestbuy.essence.Brands" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 25.05.2022
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BestBuy</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<body>
<%@include file="CSS.jsp"%>
<%@include file="navbar.jsp"%>
<%
    Brands item = (Brands) request.getAttribute("brand");
    if (item!=null){

%>
<div class="container mt-5">
    <h2>Brand name: <%=item.getName()%></h2>
    <h3>Brand country: <%=item.getCountry()%></h3>
    <a class="btn btn-primary" href="/brands">Back</a>
</div>

<%
    }
%>

</body>
</html>
