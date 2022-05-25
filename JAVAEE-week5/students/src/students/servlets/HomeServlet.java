package students.servlets;

import students.database.DBConnnector;
import students.student.City;
import students.student.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> allStudents = DBConnnector.getAllStudents();
        req.setAttribute("allstudents", allStudents);
        ArrayList<City> cities = DBConnnector.getAllCities();
        System.out.println(cities.get(0).getName());
        req.setAttribute("cities", cities);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }


}
