package todolist.servlet;

import todolist.db.TaskDatabase;
import todolist.task.Task;

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
        Long taskId = null;
        try{
            taskId = Long.parseLong(id);
        } catch (Exception e){
        }

        Task task = TaskDatabase.getTask(taskId);
        if(task!=null){
            req.setAttribute("todo", task);
            req.getRequestDispatcher("details.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }
    }
}
