<%@ page import="com.sun.net.httpserver.Request" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 26.05.2022
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Generic Site
    </title>
</head>
<body>
<style>
    input{
        margin: 5px;
    }
</style>
<form action="/setcookie" method="post">
    <%
        String name = (String) request.getAttribute("name");
        String surname = (String) request.getAttribute("surname");
        String age = (String) request.getAttribute("age");
        String country = (String) request.getAttribute("country");
        String gender = (String) request.getAttribute("gender");
        String card = (String) request.getAttribute("card");
    %>
    Name: <input type="text" placeholder="<%if (name==null){%>enter something<%}else{out.print(name);}%>" name="name"><br>
    Surname: <input type="text" placeholder="<%if (surname==null){%>enter something<%}else{out.print(surname);}%>" name="surname"><br>
    Age: <input type="text" placeholder="<%if (age==null){%>enter something<%}else{out.print(age);}%>" name="age"><br>
    Country: <input type="text" placeholder="<%if (country==null){%>enter something<%}else{out.print(country);}%>" name="country"><br>
    Gender: Male<input type="radio" placeholder="enter something" name="gender" value="Male" <%if (gender==null || gender.equals("Male")){%>checked="checked">
    Female<input type="radio" placeholder="enter something" name="gender" value="Female" <% }else{%>checked="checked"<%}%>><br>
    Credit Card: <input type="number" placeholder="<%if (card==null){%>enter something<%}else{out.print(card);}%>" name="card"><br>
    <button type="submit">Set Cookie</button>
</form>

</body>
</html>
