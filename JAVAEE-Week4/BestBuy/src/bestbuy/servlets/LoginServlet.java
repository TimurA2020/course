package bestbuy.servlets;

import bestbuy.DB.DBUsers;
import bestbuy.essence.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Users> allUsers = DBUsers.getAllUsers();
        req.setAttribute("allusers", allUsers);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Users> allUsers = DBUsers.getAllUsers();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int count = 0;
        System.out.println(login + " " + password);
        System.out.println(allUsers.get(0).getEmail() +  " " + allUsers.get(0).getPassword());
        if (allUsers!=null){
            for (int i = 0; i < allUsers.size(); i++) {

                if (login.equals(allUsers.get(i).getEmail()) && password.equals(allUsers.get(i).getPassword())) {
                    req.setAttribute("welcome", allUsers.get(i));
                    req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
                    count++;
                }
            }
            System.out.println(count);
            if (count == 0){
                resp.sendRedirect("/wronguser.jsp");
            }
            }


    }
}
