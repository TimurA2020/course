<%@ page import="channel65news.models.Publication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="channel65news.models.Article" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 01.06.2022
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
    <title>Title Page</title>
</head>
<body>
<%@include file="style.jsp"%>
<nav class="navbar navbar-expand-lg bg-light" id="first-navbar">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%
                    ArrayList<Language> languages = (ArrayList<Language>) request.getAttribute("languages");
                    if (languages!=null){
                        for (Language l : languages){
                %>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/home?id=<%=l.getId()%>"><%=l.getCode()%></a>
                </li>
                <%
                    }
                    }
                %>
            </ul>
            <a class="navbar-brand" href="#" style="margin-right: 33.5%;">Channel 65 News</a>
            <a class="navbar-brand" href="/admin.jsp">Admin Panel</a>
            <%--            <form class="d-flex search-form" role="search">--%>
            <%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" id="search">--%>
            <%--                    <button type="submit" href="#!" class="button button_secondary">Search</button>--%>
            <%--            </form>--%>
        </div>
    </div>
</nav>
<%@include file="navbar.jsp"%>

<div class="welcome-container">
    <h1 style="text-align: center">News from all around the world!</h1>
    <h3 style="text-align: center">You can read news from many different languages</h3>
</div>
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
            <p class="txt4"><%=a.getPublication().getName()%></p>
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



<%@include file="footer.jsp"%>
</body>
</html>
