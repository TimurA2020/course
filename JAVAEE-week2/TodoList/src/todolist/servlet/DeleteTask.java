package todolist.servlet;

import todolist.db.TaskDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deletetask")
public class DeleteTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("task_id");
        String name = req.getParameter("task_name");
        System.out.println(id);
        Long taskId = null;
        try {
            taskId = Long.parseLong(id);
        } catch (Exception e) {
        }
        TaskDatabase.deleteTask(taskId);
        resp.sendRedirect("/");
    }
}
