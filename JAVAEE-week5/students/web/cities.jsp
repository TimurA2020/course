<%@ page import="students.student.City" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 24.05.2022
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="htmlhead.jsp"%>
<button id="addStudent" class="btn btn-primary btn-sm" style="margin-left: 10%">Add City</button>
<table class="table table-hover" style="width: 80%; margin: auto">
    <thead>
    <tr>
        <th scope="col" style="width: 10%">ID</th>
        <th scope="col" style="width: 25%">City</th>
        <th scope="col" style="width: 15%">Code</th>
        <th scope="col" style="width: 15%">Details</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<City> cities = (ArrayList<City>) request.getAttribute("cities");
        if(cities != null){
            for(City city : cities){
    %>
    <tr>
        <td><% out.print(city.getId());%></td>
        <td><% out.print(city.getName());%></td>
        <td><% out.print(city.getCode());%></td>
        <td><a href='/details?id=<%=city.getId()%>' class = 'btn btn-dark btn-sm'>Details</a></td>
    </tr>
    <%
            }
        }
    %>

    </tbody>
</table>

<div class="popup">
    <div class="popup__container">
        <div class="popup__wrapper">
            <div class="myForm">
                <form role="form" action="/addcity" autocomplete="off" method="POST">
                    <h1>Add City</h1>
                    <p>City's name</p>
                    <input type="text" placeholder="Enter city's name" name="city_name" required><br>
                    <p>City's code</p>
                    <input type="Text" placeholder="Enter city's code" name="city_code" required><br>
                    <button type="button" class="btn cancel">Close</button>
                    <button type="submit" class="btn">Add city</button>
                </form>
            </div>
        </div>
    </div>
</div>


<%@include file="script.jsp"%>

</body>
</html>
