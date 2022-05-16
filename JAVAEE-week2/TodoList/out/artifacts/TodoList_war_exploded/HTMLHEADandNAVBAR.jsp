<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 15.05.2022
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<style>
    .myForm {
        display: none;
        animation-duration: 1.5s;
        animation-fill-mode: both;
        animation-name: fadeIn;
    }

    .open {
        display: block;
    }

    .popup {
        position: fixed;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        background: rgba(17, 17, 17, 0.5);
        transition: all 0.5s ease;
        display: none;
    }

    .popup_open {
        display: block;
    }

    .popup__container {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background: #fff;
        border-radius: 10px;
        max-width: 588px;
        width: 100%;
    }

    .popup__wrapper {
        padding: 40px;
    }

    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    .hidden-id{
        display: none;
    }
</style>
<nav class="navbar navbar-expand-lg navbar-light bg-primary mb-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">NEWS.com</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Task Manager</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">All Tasks</a>
            </ul>
        </div>
    </div>
</nav>
