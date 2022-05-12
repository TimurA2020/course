package com.tinder.servlets;

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
        PrintWriter in = resp.getWriter();
        in.print("<!DOCTYPE html><html lang='en'><head> <meta charset='UTF-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Document</title> <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head><body> <style></style> <form class='m-5' action='/register' method='post'> <div class='row mb-3'> <label for='inputEmail3' class='col-sm-2 col-form-label'>Full Name: </label> <div class='col-sm-10'> <input type='text' class='form-control' id='inputName' name='clientName'> </div></div><div class='row mb-3'> <label for='inputPassword3' class='col-sm-2 col-form-label'>Age: </label> <div class='col-sm-10'> <input type='number' class='form-control' id='inputSurname' name='clientAge'> </div></div><div class=\"form-check form-check-inline\"> <input class=\"form-check-input\" type=\"radio\" name=\"inlineRadioOptions\" id=\"inlineRadio1\" value=\"Mister\"> <label class=\"form-check-label\" for=\"inlineRadio1\">Male</label> </div><div class=\"form-check form-check-inline\"> <input class=\"form-check-input\" type=\"radio\" name=\"inlineRadioOptions\" id=\"inlineRadio2\" value=\"Miss\"> <label class=\"form-check-label\" for=\"inlineRadio2\">Female</label> </div></div><button type='submit' class='btn btn-primary'>Register</button> </form></body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
