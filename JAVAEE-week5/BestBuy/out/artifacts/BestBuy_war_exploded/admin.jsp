<%@ page import="java.util.ArrayList" %>
<%@ page import="bestbuy.essence.Items" %>
<%@ page import="bestbuy.essence.Brands" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 25.05.2022
  Time: 11:03
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
<h1>Admin Panel</h1>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Add product
</button> <a class="btn btn-danger" href="/brands">See Brands</a>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action ="/additem" method="post">
            <div class="modal-body form">
                <h4>Please choose item's brand, add a name and a description</h4>


                <p>Choose the brand name</p>
                <select name="brand_id" style="margin-bottom: 7px;">
                    <%
                        ArrayList<Brands> allBrands = (ArrayList<Brands>) request.getAttribute("allbrands");
                        if(allBrands!=null){
                            for(Brands brand : allBrands){

                    %>
                    <option value="<%=brand.getId()%>"><%=brand.getName() + " / " + brand.getCountry()%></option>
                    <%
                            }
                        }
                    %>
                </select>
                <p>Name</p>
                <input type="text" placeholder="Enter product's name" name ="item_name"><br>
                <p>Description</p>
                <input type="text" placeholder="Enter product's description" name ="item_description"><br>
                <p>Price</p>
                <input type="number" step ="0.01" placeholder="Enter product's price" name = "item_price"><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Add a product</button>
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
        <th scope="col">Name</th>
        <th scope="col">Brand</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
        <th scope="col">Details</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("allitems");
        if(items!=null){
            for (Items item : items){
    %>
    <tr>
        <th scope="row"><%=item.getId()%></th>
        <td><%=item.getName()%></td>
        <td><%=item.getBrand().getName() + " / " + item.getBrand().getCountry()%></td>
        <td><%=item.getDescription()%></td>
        <td>$<%=item.getPrice()%></td>
        <td><a class="btn btn-dark" href="/details?id=<%=item.getId()%>">Details</a></td>
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
