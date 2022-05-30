<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="model.User" %>
<%@ page import="db.Database" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 30.05.2022
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String email = (String) session.getAttribute("current_user");
    if(email==null){
%>
<form action="/home" method="post">
login: <input type="email" name="user_email">
password: <input type="password" name="user_password">
    <button type="submit">Login</button>
</form>
<%
    }
    if(email!=null){
        User user = Database.getUser(email);
%>
<div style="margin-left:10%;">
<h1>Welcome!</h1>
    <h3>Current user is: <%=email%></h3>
    <h3>Name: <%=user.getName()%></h3>
    <h3>Surname: <%=user.getSurname()%></h3>
<h3>Age: <%=user.getAge()%></h3>
</div>
<%
    }
%>




</body>
</html>
