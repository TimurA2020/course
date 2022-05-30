package login;

import db.Database;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");

        ArrayList<User> users = Database.getUsers();

        HttpSession session = req.getSession();
        for (User user : users){
            if(user.getUser().equals(email) && user.getPassword().equals(password)){
                System.out.println("hello " + user.getUser());
                session.setAttribute("current_user", email);
                resp.sendRedirect("/index.jsp");
            }
        }
    }
}
