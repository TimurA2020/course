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


@WebServlet(value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long studentId = null;
        try{
            studentId = Long.parseLong(id);
        } catch (Exception e){
        }

        Student student = DBConnnector.getStudent(studentId);
        System.out.println(student.getCity());
        if(student!=null){
            req.setAttribute("student", student);
            ArrayList<City> cities = DBConnnector.getAllCities();
            req.setAttribute("cities", cities);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("student_id"));
        String name = req.getParameter("student_name");
        String surname = req.getParameter("student_surname");
        String birthdate = req.getParameter("student_birthdate");
        Long city_id = Long.parseLong(req.getParameter("city"));
        City city = DBConnnector.getCity(city_id);
        Student student = DBConnnector.getStudent(id);

        if (student!=null){
            student.setName(name);
            student.setSurname(surname);
            student.setBirthdate(birthdate);
            student.setCity(city);

            DBConnnector.saveStudent(student);

            resp.sendRedirect("/");
        }else{
            resp.sendRedirect("/");
        }
    }
}
