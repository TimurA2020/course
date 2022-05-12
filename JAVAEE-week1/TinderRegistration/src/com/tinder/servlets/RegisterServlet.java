package com.tinder.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("clientName");
        int age = Integer.parseInt(req.getParameter("clientAge"));
        String genderMister = req.getParameter("inlineRadioOptions");

        if (age > 18){
            System.out.println("Welcome Dear " + genderMister + " " + fullName);
        }
        else{
            System.out.println("Welcome lil' " + genderMister + " " + fullName + " Unfortunately you are too young for this site");
        }
        resp.sendRedirect("/home");
    }
}
