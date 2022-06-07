<%@ page import="channel65news.models.Article" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 02.06.2022
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<title>Read More</title>
</head>
<body>
<%@include file="style.jsp"%>
<%@include file="navbar.jsp"%>
<div class="articles">
    <div class="row">
        <%
            ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
            if (articles!=null){
                for (Article a : articles){

        %>
        <div class="col-4 mt-4 mb-4 single-article">
            <h5><%=a.getTitle()%></h5>
            <div class="cardcontainer">
                <div class="photo">
                    <img src="<%=a.getPictureUrl()%>">
                    <div class="photos">Photos</div>
                </div>
                <div class="content">
                    <p class="txt4"><%=a.getPublication_id()%></p>
                    <p class="txt5"><%=a.getDate()%></p>
                    <p class="txt2"><%=a.getShortContent()%></p>
                    <a href="readmore?id=<%=a.getId()%>">Read more</a>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>


    </div>
</div>

</body>
</html>
