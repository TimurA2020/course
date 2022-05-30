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
    <title><%
        String defaultCookie = (String) request.getAttribute("cookie1");
        if (defaultCookie=="-"){
    %>Default Site Name<%
        }
        else{
            out.print(defaultCookie);
    }
    %>
    </title>
</head>
<body>
<form action="/setcookie" method="post">
    <input type="text" placeholder="enter something" name="cookie_text">
    <button type="submit">Set Cookie</button>
</form>

</body>
</html>
