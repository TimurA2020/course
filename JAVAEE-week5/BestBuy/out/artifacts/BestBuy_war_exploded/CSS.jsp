<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 20.05.2022
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    body{
        font-family: Verdana;
    }
   .navbar-brand{
       margin-left: 20%;
   }

   .right-items{
       margin-right: 20%;
       float:right;
       justify-content: end;
   }

   .welcome{
       text-align: center;
       margin-top: 2%;
       margin-left: auto;
       margin-right: auto;
   }

   .product-list{
       display: flex;
       width: 70%;
       justify-content: center;
   }

   .products{
       margin-left: 20%;
       margin-right: 20%;
       justify-content: center;
       width: 70%;
   }

    .login-container{
        margin: 20px auto;
        padding: 10px;
        width: 300px;
        height: 300px;
        background-color: #fff;
        border-radius: 5px;
    }
    h1{
        width: 70%;
        color: #777;
        font-size: 32px;
        margin: 28px auto;
        margin-bottom: 20px;
        text-align: center;
        /*padding-top: 40px;*/
    }
    form{
        /*padding: 15px;*/
        text-align: left;
    }
    input{
        padding: 12px 0;
        margin-bottom: 10px;
        border-radius: 3px;
        border: 2px solid transparent;
        text-align: center;
        width: 90%;
        font-size: 16px;
        transition: border .2s, background-color .2s;
    }
    form .field{
        background-color: #ECF0F1;
    }
    form .field:focus {
        border: 2px solid #3498DB;
    }
    form .login-btn{
        background-color: #18c76c;
        color: #fff;
        line-height: 25px;
        cursor: pointer;
    }
    form .login-btn:hover,
    form .login-btn:active {
        background-color: #1F78B4;
        border: 2px solid #1F78B4;
    }
    .pass-link{
        text-align: center;
    }
    .pass-link a:link,
    .pass-link a:visited{
        font-size: 12px;
        color: #777;
    }

    input{
        margin-bottom: 10px;
        text-align: left;
        border: lightgray 1px outset;
        padding: 3px;
    }

    button{
        margin: 7px;
    }

    input{
        margin-bottom: 15px;
    }
    p{
        margin: 3px;
    }
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
