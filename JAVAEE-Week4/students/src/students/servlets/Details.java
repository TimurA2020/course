package students.servlets;

import students.database.DBConnnector;
import students.student.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/details")
public class Details extends HttpServlet {
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
            req.getRequestDispatcher("details.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }
    }
    }
