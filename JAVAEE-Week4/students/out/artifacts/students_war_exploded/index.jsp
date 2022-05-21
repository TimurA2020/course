<%@ page import="students.student.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 18.05.2022
  Time: 00:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="htmlhead.jsp"%>
<button id="addStudent" class="btn btn-primary btn-sm" style="margin-left: 10%">Add Student</button>
<table class="table table-hover" style="width: 80%; margin: auto">
    <thead>
    <tr>
        <th scope="col" style="width: 10%">ID</th>
        <th scope="col" style="width: 25%">Name</th>
        <th scope="col" style="width: 20%">Surname</th>
        <th scope="col" style="width: 15%">Birthdate?</th>
        <th scope="col" style="width: 15%">City</th>
        <th scope="col" style="width: 15%">Details</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("allstudents");
        if(students != null){
            for(Student student : students){
    %>
    <tr>
        <td><% out.print(student.getId());%></td>
        <td><% out.print(student.getName());%></td>
        <td><% out.print(student.getSurname());%></td>
        <td><% out.print(student.getBirthdate());%></td>
        <td><% out.print(student.getCity());%></td>
        <td><a href='/details?id=<%=student.getId()%>' class = 'btn btn-dark btn-sm'>Details</a></td>
    </tr>
    <%
            }
        }
    %>

    </tbody>
</table>

<div class="popup">
    <div class="popup__container">
        <div class="popup__wrapper">
            <div class="myForm">
                <form role="form" action="/addstudent" autocomplete="off" method="POST">
                    <h1>Add Task</h1>
                    <p>Student's name</p>
                    <input type="text" placeholder="Enter student's name" name="student_name" required><br>
                    <p>Student's surname</p>
                    <input type="Text" placeholder="Enter student's surname" name="student_surname" required><br>
                    <p>Student's birth date</p>
                    <input type="date" name="student_birthdate" required>
                    <p>Student's birth city</p>
                    <input type="Text" placeholder="Enter student's city" name="student_city" required><br>
                    <button type="button" class="btn cancel">Close</button>
                    <button type="submit" class="btn">Add student</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    const button = document.querySelector('#addStudent');
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
