<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 01.06.2022
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    body{
        font-family: "Helvetica Neue", Arial, sans-serif;
        margin-left: 10%;
        margin-right: 10%;
    }

    #first-navbar{
        height: 40px;
    }

    #search{
        height: 25px;
        margin-right: 3px;
        width: 100px
    }

    .button_secondary {
        background-color: #e98724;
    }

    .search-form{
        margin-top: 15px;
    }


    .content {
        margin: 64px auto;
        width: 94%;
        max-width: 640px;
        text-align: center;
    }

    .button {
        height: 25px;
        width: 70px;
        display: inline-block;
        margin: 0;
        padding: 3px 3px 7px 3px;
        border: 0;
        border-radius: 3px;
        background-color: #aaa;
        color: #fff;
        text-decoration: none;
        font-weight: 700;
        font-size: 15px;
        line-height: 1.5;
        cursor: pointer;
        -webkit-appearance: none;
        -webkit-font-smoothing: antialiased;
    }

    .button:hover {
        opacity: 0.85;
    }

    .button:active {
        box-shadow: inset 0 3px 4px hsla(0, 0%, 0%, 0.2);
    }

    .button:focus {
        outline: thin dotted #444;
        outline: 5px auto -webkit-focus-ring-color;
        outline-offset: -2px;
    }

    .navbar-brand, .navbar-nav, .navbar-nav>li {
        float:none !important;
    }

    ul{
        width: 80%;
    }
    .it{
        margin-left: 30px;
        margin-right: 30px;
    }
    .list{
        margin-left: 8%;
    }

    .welcome-container{
        margin-top: 20px;
        background-color: #63e1ff;
        padding: 20px;
    }

    h1{
        text-align: center;
        color: #333333;
    }
    .cardcontainer{
        width: 350px;
        height: 500px;
        background-color: white;
        margin-left: auto;
        margin-right: auto;
        transition: 0.3s;
    }
    .cardcontainer:hover{
        box-shadow: 0 0 45px gray;
    }
    .photo{
        height: 300px;
        width: 100%;
    }
    .photo img{
        height: 100%;
        width: 100%;
    }
    .txt1{
        margin: auto;
        text-align: center;
        font-size: 17px;
    }
    .content{
        width: 80%;
        height: 100px;
        margin-left: auto;
        margin-right: auto;
        position: relative;
        top: -33px;
    }
    .photos{
        width: 90px;
        height: 30px;
        background-color: #E74C3C;
        color: white;
        position: relative;
        top: -30px;
        padding-left: 10px;
        font-size: 20px;
    }
    .txt4{
        font-size:27px;
        position: relative;
        top: 33px;
    }
    .txt5{
        position: relative;
        top: 18px;
        color: #E74C3C;
        font-size: 23px;
    }
    .txt2{
        position: relative;
        top: 10px;
    }
    .cardcontainer:hover > .photo{
        height: 200px;
        animation: move1 0.5s ease both;
    }
    @keyframes move1{
        0%{height: 300px}
        100%{height: 200px}
    }
    .cardcontainer:hover > .content{
        height: 200px;
    }
    .footer{
        width: 80%;
        height: 100px;
        margin-left: auto;
        margin-right: auto;
        background-color: white;
        position: relative;
        top: -15px;
    }
    .btn{
        position: relative;
        top: 20px;
    }
    #heart{
        cursor: pointer;
    }
    .like{
        float: right;
        font-size: 22px;
        position: relative;
        top: 20px;
        color: #333333;
    }
    .fa-gratipay{
        margin-right: 10px;
        transition: 0.5s;
    }
    .fa-gratipay:hover{
        color: #E74C3C;
    }
    .txt3{
        color: gray;
        position: relative;
        top: 18px;
        font-size: 14px;
    }
    .comments{
        float: right;
        cursor: pointer;
    }
    .fa-clock, .fa-comments{
        margin-right: 7px;
    }

    .single-article{
        margin-left: 10%;
        margin-right: 0;
    }

    .articles{
        display: flex;
        width: 100%;
    }

    .page{
        display: flex;
        flex-direction: row;
        margin-top: 10px;
    }

    .left-page{
        width: 70%;
    }

    .right-page{
        width: 30%;
        height: 20%;
        background-color: #63e1ff;
        border: 1px outset;
        border-radius: 1px;
    }
</style>
