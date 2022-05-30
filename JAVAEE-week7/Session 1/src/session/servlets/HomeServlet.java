package session.servlets;

import com.sun.net.httpserver.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        session.setAttribute("name", name);
        session.setAttribute("surname", surname);
        session.setAttribute("age", age);
        String city = req.getParameter("city");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        session.setAttribute("city", city);
        session.setAttribute("address", address);
        session.setAttribute("phone", phone);
        String uni = req.getParameter("uni");
        String major = req.getParameter("major");
        String group = req.getParameter("group");
        session.setAttribute("uni", uni);
        session.setAttribute("major", major);
        session.setAttribute("group", group);

        resp.sendRedirect("home");
    }
}
