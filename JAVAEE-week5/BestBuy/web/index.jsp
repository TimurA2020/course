<%@ page import="java.util.ArrayList" %>
<%@ page import="bestbuy.essence.Items" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 20.05.2022
  Time: 12:55
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
<div class="container welcome">
    <h1>Welcome to BestBuy</h1>
    <h4>High tech electronics for the best price!</h4>
</div>
<div class="products">
    <div class="container">

        <div class="row">
            <%
                ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("allitems");
                if (items!=null){
                    for (Items item : items){
            %>
            <div class="col-4 mt-4 mb-4">
                <div class="card-body">
                    <h2><%=item.getName()%></h2>
                    <h5 class="card-title">$<%=item.getPrice()%></h5>
                    <p class="card-text"><%=item.getDescription()%></p>
                    <a href="/buy?id=<%=item.getId()%>" class="btn btn-success">BUY NOW</a>
            </div>
        </div>
            <%
                }
                }
            %>
    </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
</body>
</html>
