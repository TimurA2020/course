<%@ page import="bestbuy.servlets.Cart" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 30.05.2022
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<body>
<%@include file="CSS.jsp"%>
<%@include file="navbar.jsp"%>


<div class="products">
    <div class="container">

        <div class="row">
                <%
                List<Cart> cart = (List<Cart>) session.getAttribute("cart");
                if (cart!=null){
                    for (Cart c : cart) {
            %>
            <div class="col-4 mt-4 mb-4">
                    <div class="card-body">
                        <h2><%=c.getName()%></h2>
                        <h5 class="card-title">$<%=c.getPrice()%></h5>
                    </div>
            </div>
            <%
                }
                }
            %>
        </div>
    </div>
</div>

</body>
</html>
