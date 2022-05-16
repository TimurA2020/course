<%@ page import="todolist.task.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="todolist.db.TaskDatabase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="HTMLHEADandNAVBAR.jsp"%>
<button id="addTask" class="btn btn-primary btn-sm" style="margin-left: 10%">Add Task</button>
<table class="table table-hover" style="width: 80%; margin: auto">
    <thead>
    <tr>
        <th scope="col" style="width: 10%">ID</th>
        <th scope="col" style="width: 40%">To Do</th>
        <th scope="col" style="width: 20%">Deadline</th>
        <th scope="col" style="width: 15%">Completed?</th>
        <th scope="col" style="width: 15%">Details</th>
    </tr>
    </thead>
    <tbody>
    <% ArrayList<Task> allTasks = TaskDatabase.getAllTasks();
        for (Task tk : allTasks){
    out.print("<tr>");
        out.print("<th scope='row'>" + tk.getId() + "</th>");
        out.print("<td>" + tk.getName() + "</td>");
        out.print("<td>" + tk.getDeadlineDate() + "</td>");
        out.print("<td>Нет</td>");
        out.print("<td><a href='/details?id=" + tk.getId() + "' class = 'btn btn-primary btn-sm'>Details</a></td>");
        out.print("</tr>");
}

    %>
    </tbody>
</table>

<div class="popup">
    <div class="popup__container">
        <div class="popup__wrapper">
            <div class="myForm">
                <form role="form" action="/addtask" autocomplete="off" method="POST">
                    <h1>Add Task</h1>
                    <p>Task name</p>
                    <input type="text" placeholder="Enter task name" name="task_name" required><br>
                    <p>Description</p>
                    <input type="Text" placeholder="Enter task description" name="task_description" required><br>
                    <p>Deadline</p>
                    <input type="date" name="task_date" required>
                    <button type="button" class="btn cancel">Close</button>
                    <button type="submit" class="btn">Add task</button>
                </form>
            </div>
        </div>
    </div>
</div>


<script>
    const button = document.querySelector('#addTask');
    const form = document.querySelector('.myForm');
    const popup = document.querySelector('.popup');
    const cancel = document.querySelector('.cancel')

    button.addEventListener('click', () => {
        form.classList.add('open');
        popup.classList.add('popup_open');
    });

    cancel.addEventListener('click', () =>{
        form.classList.remove('open');
        popup.classList.remove('popup_open');
    });

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
