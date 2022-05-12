package kz.burgerking.main.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html><html lang='en'><head>    <meta charset='UTF-8'>    <meta http-equiv='X-UA-Compatible' content='IE=edge'>    <meta name='viewport' content='width=device-width, initial-scale=1.0'>    <title>Document</title>    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head><body>    <style>            </style>    <form class='m-5' action = '/addorder' method = 'post'>        <div class='row mb-3'>          <label for='inputEmail3' class='col-sm-2 col-form-label'>Name: </label>          <div class='col-sm-10'>            <input type='text' class='form-control' id='inputName' name = 'clientName'>          </div>        </div>        <div class='row mb-3'>          <label for='inputPassword3' class='col-sm-2 col-form-label'>Surname: </label>          <div class='col-sm-10'>            <input type='text' class='form-control' id='inputSurname' name = 'clientSurname'>          </div>        </div>        <div class='row mb-3'>            <label for='inputPassword3' class='col-sm-2 col-form-label'>Item: </label>            <div class='col-sm-10'>                <select class='custom-select' id='inputGroupSelect04' name = 'option'>                    <option selected>Choose...</option>                    <option value='Crispy Chicken - 1500 KZT'>Crispy Chicken - 1500 KZT</option>                    <option value='Chicken Nuggets - 1000 KZT'>Chicken Nuggets - 1000 KZT</option>                    <option value='Double Wopper - 2500 KZT'>Double Wopper - 2500 KZT</option>                  </select>            </div>          </div>               <button type='submit' class='btn btn-primary'>Order</button>      </form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
