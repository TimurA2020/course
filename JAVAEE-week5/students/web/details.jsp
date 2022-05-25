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
        <h1>Student</h1>
        <p>Student's name</p>
        <input type="text" placeholder="" name="student_name" value = "<%=student.getName()%>" readonly><br>
        <input type = "text" class="hidden-id" name="student_id" value="<%=student.getId()%>" readonly>
        <p>Surname</p>
        <input type="Text" placeholder="Enter task description" name="student_surname" value ="<%=student.getSurname()%>" readonly><br>
        <p>Birth Date</p>
        <input type="date" name="student_date" value ="<%=student.getBirthdate()%>" readonly>
        <p>City</p>
    <input type = "text" name = "student_city" value = "<%=student.getCity().getName()%>" readonly><br>
        <a href = "/" class = "btn btn-dark">Close</a>
        <a href = "/edit?id=<%=student.getId()%>" class="btn btn-primary">Edit</a>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
        DELETE
    </button>

    <!-- Modal -->
    <form role = "form" action = "/delete" autocomplete="off" method="post">
        <input type="hidden" name="modal_id" value="<%=student.getId()%>">
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete <%=student.getName()%>'s records?</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ARE YOU SURE?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="Submit" class="btn btn-Danger">Delete</button>
                </div>
            </div>
        </div>
    </div>
    </form>
    <%
        }
    %>
</div>
</body>
</html>
