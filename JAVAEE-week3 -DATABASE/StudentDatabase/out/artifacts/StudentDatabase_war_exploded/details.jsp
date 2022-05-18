<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 18.05.2022
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>

<div class="container">
    <%
        Student student = (Student) request.getAttribute("student");
        if (student!=null){
    %>
        <h1>Add Task</h1>
        <p>Student's name</p>
        <input type="text" placeholder="" name="student_name" value = "<%=student.getName()%>" readonly><br>
        <input type = "text" class="hidden-id" name="student_id" value="<%=student.getId()%>" readonly>
        <p>Surname</p>
        <input type="Text" placeholder="Enter task description" name="student_surname" value ="<%=student.getSurname()%>" readonly><br>
        <p>Birth Date</p>
        <input type="date" name="student_date" value ="<%=student.getBirthdate()%>" readonly>
        <p>City</p>
        <input type="Text" placeholder="Enter task description" name="student_city" value ="<%=student.getCity()%>" readonly><br>
        <a href = "/" class = "btn btn-dark">Close</a>
    <%
        }
    %>
</div>
</body>
</html>

</body>
</html>
