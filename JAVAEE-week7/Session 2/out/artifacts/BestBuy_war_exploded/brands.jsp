<%@ page import="bestbuy.essence.Brands" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 25.05.2022
  Time: 13:45
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
<h1>Admin Panel - Brands Section
    <a href="/admin" class="btn btn-primary">Back</a></h1>
<button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Add brand
</button>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action ="/addbrand" method="post">
                <div class="modal-body form">
                    <h4>Add a brand and it's country</h4>
                    <p>Brand name</p>
                    <input type="text" placeholder="Enter a brand name" name ="brand_name"><br>
                    <p>Country</p>
                    <input type="text" placeholder="Enter the origin country" name ="brand_country"><br>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Add brand</button>
                </div>
            </form>
        </div>
    </div>
</div>
</form>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Brand</th>
        <th scope="col">Country</th>
        <th scope="col">Details</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Brands> items = (ArrayList<Brands>) request.getAttribute("allbrands");
        if(items!=null){
            for (Brands item : items){
    %>
    <tr>
        <th scope="row"><%=item.getId()%></th>
        <td><%=item.getName()%></td>
        <td><%=item.getCountry()%></td>
        <td><a class="btn btn-dark" href="/branddetails?id=<%=item.getId()%>">Details</a></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
</body>
</html>
