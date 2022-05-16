package todolist.servlet;

import todolist.db.TaskDatabase;
import todolist.task.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(value = "/addtask")
public class addTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskName = req.getParameter("task_name");
        String taskDescription = req.getParameter("task_description");
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        String parameter = req.getParameter("task_date");
        try {
            Date date  = in.parse(parameter);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Task taskToAdd = new Task();
        taskToAdd.setName(taskName);
        taskToAdd.setDescription(taskDescription);
        taskToAdd.setDeadlineDate(parameter);

        TaskDatabase.addTask(taskToAdd);

        resp.sendRedirect("/");
    }
}
