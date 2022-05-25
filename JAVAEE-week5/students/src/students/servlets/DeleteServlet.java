package students.servlets;

import students.database.DBConnnector;
import students.student.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("modal_id");
        Long studentId = null;
        try{
            studentId = Long.parseLong(id);
        } catch (Exception e){
        }
        Student student = DBConnnector.getStudent(studentId);
        if (student != null) {
            DBConnnector.deleteStudent(student);
            resp.sendRedirect("/");
        }
        else{
                resp.sendRedirect("/");
            }

        }
    }
