package students.servlets;

import students.database.DBConnnector;
import students.student.City;
import students.student.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/addstudent")
public class addStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("student_name");
        String surname = req.getParameter("student_surname");
        String birthdate = req.getParameter("student_birthdate");
        String id = req.getParameter("city");
        Long city_id = null;
        try{
            city_id= Long.parseLong(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        City city = DBConnnector.getCity(city_id);

        if (city!=null) {

            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setBirthdate(birthdate);
            student.setCity(city);

            DBConnnector.addStudent(student);
        }

        resp.sendRedirect("/");
    }
}
