<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 13.05.2022
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-primary mb-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">NEWS.com</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">All News</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/entertainment">Entertainment</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/sports">Sports</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/politics">Politics</a>
                </li>
            </ul>
            <form class="d-flex m-auto">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
