package com.football.servlets.servlets;

import com.football.servlets.DB.Database;
import com.football.servlets.player.SinglePlayer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addplayer")
public class AddPlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String team = req.getParameter("team");
        int salary = Integer.parseInt(req.getParameter("salary"));
        int transferPrice = Integer.parseInt(req.getParameter("tranferprice"));
        SinglePlayer player = new SinglePlayer();
        player.setName(name);
        player.setSurname(surname);
        player.setClub(team);
        player.setSalary(salary);
        player.setTransferPrice(transferPrice);

        Database.addPlayer(player);

        resp.sendRedirect("/");
    }
}
