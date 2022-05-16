<%@ page import="todolist.task.Task" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 16.05.2022
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="HTMLHEADandNAVBAR.jsp"%>

<div class="container">
    <%
        Task task = (Task) request.getAttribute("todo");
        if (task!=null){
    %>
    <form role="form" action="/deletetask" autocomplete="off" method="POST">
        <h1>Add Task</h1>
        <p>Task name</p>
        <input type="text" placeholder="Enter task name" name="task_name" value = "<%=task.getName()%>"><br>
        <input type = "text" class="hidden-id" name="task_id" value="<%=task.getId()%>">
        <p>Description</p>
        <input type="Text" placeholder="Enter task description" name="task_description" value ="<%=task.getDescription()%>"><br>
        <p>Deadline</p>
        <input type="date" name="task_date" value ="<%=task.getDeadlineDate()%>">
        <button type="button" class="btn cancel">Close</button>
        <button type="submit" class="btn">Delete Task</button>
    </form>
    <%
        }
    %>
</div>
</body>
</html>
