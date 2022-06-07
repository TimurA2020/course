<%@ page import="channel65news.models.Article" %>
<%@ page import="channel65news.models.Publication" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 02.06.2022
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<title>Read More</title>
</head>
<body>
<%@include file="style.jsp"%>
<%@include file="navbar.jsp"%>
<div class ="page">
<%
    Article article = (Article) request.getAttribute("article");
    if (article != null){
%>
<div class="container left-page">
    <h1><%=article.getTitle()%></h1>
    <p style="fon-size: 13px; color:red;"><%=article.getDate()%></p>
    <img src="<%=article.getPictureUrl()%>" style="width: 50%"><br>
    <p><%=article.getContent()%></p>
</div>
    <div class="container right-page">
        <h1><%=article.getPublication().getName()%></h1>
        <p><%=article.getPublication().getDescription()%></p>
        <h5>Rating: <%=article.getPublication().getRating()%></h5>
    </div>

    <%
        }
    %>



</div>





<%@include file="footer.jsp"%>
</body>
</html>
