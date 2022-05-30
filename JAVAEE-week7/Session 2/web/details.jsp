<%@ page import="bestbuy.essence.Items" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 25.05.2022
  Time: 15:37
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
    Items item = (Items) request.getAttribute("item");
    if (item!=null){

%>
<div class="container mt-5">
    <h2>Item name: <%=item.getName()%></h2>
    <h3>Item brand: <%=item.getBrand().getName() + " / " + item.getBrand().getCountry()%></h3>
    <p>Item Description: <%=item.getDescription()%></p>
    <p>Price: $<%=item.getPrice()%></p>
    <a class="btn btn-primary" href="admin">Back</a>
</div>

<%
    }
%>

</body>
</html>
