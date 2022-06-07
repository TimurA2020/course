<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 03.06.2022
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    nav{
        background-color: #111;
    }

    .content-area{
        width: 400px;
        height: 150px;
    }

    .main-content{
        width: 400px;
        height: 600px;
    }
    p{
        margin-bottom: 2px
    }
    .main-body{
        display: flex;
    }

    .right-menu{
        margin-left: 250px;
        padding-left: 50px;
        padding-top: 25px;
    }
    body {
        font-family: "Lato", sans-serif;
    }

    .sidenav {
        margin-top: 55px;
        height: 100%;
        width: 250px;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
        background-color: #111;
        overflow-x: hidden;
        padding-top: 20px;
    }

    .sidenav a {
        padding: 6px 6px 6px 32px;
        text-decoration: none;
        font-size: 25px;
        color: #818181;
        display: block;
    }

    .sidenav a:hover {
        color: #f1f1f1;
    }

    @media screen and (max-height: 450px) {
        .sidenav {padding-top: 15px;}
        .sidenav a {font-size: 18px;}
    }
</style>
