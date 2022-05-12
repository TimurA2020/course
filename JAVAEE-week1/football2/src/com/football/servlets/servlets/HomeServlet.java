package com.football.servlets.servlets;

import com.football.servlets.player.SinglePlayer;
import com.football.servlets.DB.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<SinglePlayer> allPlayers = Database.getAllPlayers();
        PrintWriter in = resp.getWriter();
        in.print("<!DOCTYPE html><html lang='en'><head> <meta charset='UTF-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Document</title> <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'></head><body>");
        in.print("<style>h1{color:green;}h2{color:red}.blue{color:blue;}.margin{margin-top:10px;margin-bottom:10px;}</style>");
        in.print("<form class='m-5' action = '/addplayer' method='post'> <div class='row mb-3'> <label for='inputEmail3' class='col-sm-2 col-form-label'>Name: </label> <div class='col-sm-10'> <input type='text' class='form-control' id='inputName' name='name'> </div></div><div class='row mb-3'> <label for='inputPassword3' class='col-sm-2 col-form-label'>Surname: </label> <div class='col-sm-10'> <input type='text' class='form-control' id='inputSurname' name='surname'> </div></div><div class='row mb-3'> <label for='inputPassword3' class='col-sm-2 col-form-label'>Team: </label> <div class='col-sm-10'> <select class='custom-select' id='inputGroupSelect04' name='team'> <option selected>Choose...</option> <option value='Real Madrid'>Real Madrid</option> <option value='Barcelona'>Barcelona</option> <option value='Bavaria'>Bavaria</option> </select> </div><div class='row mb-3'> <label for='inputPassword3' class='col-sm-2 col-form-label'>Salary: </label> <div class='col-sm-10'> <input type='number' class='form-control' id='inputSurname' name='salary'> </div></div><div class='row mb-3'> <label for='inputPassword3' class='col-sm-2 col-form-label'>Transfer Price: </label> <div class='col-sm-10'> <input type='number' class='form-control' id='inputSurname' name='tranferprice'> </div></div></div><button type='submit' class='btn btn-primary'>Add Player</button> </form>");

        for (SinglePlayer pl : allPlayers){
            in.print("<div class='container margin'>");
            in.print("<h1>" + pl.getName() + " " + pl.getSurname() + "</h1>");
            in.print("<h2 class='blue'>Club: " + pl.getClub() + "</h2>");
            in.print("<h2>Salary: " + pl.getSalary() + " EUR</h2>");
            in.print("<h2>Transfer price: " + pl.getTransferPrice() + " EUR</h2>");
            in.print("</div>");
        }
        in.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
