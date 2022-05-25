<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 19.05.2022
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>

<div class="container">
    <%
        Student student = (Student) request.getAttribute("student");
        if (student!=null){
    %>
    <div>
        <form role="form" action="/edit" autocomplete="off" method="POST">
            <input type ="hidden" name ="student_id" value = "<%=student.getId()%>">
            <h1>Add Task</h1>
            <p>Student's name</p>
            <input type="text" placeholder="Enter student's name" name="student_name" value = "<%=student.getName()%>"><br>
            <p>Student's surname</p>
            <input type="Text" placeholder="Enter student's surname" name="student_surname" value = "<%=student.getSurname()%>"><br>
            <p>Student's birth date</p>
            <input type="date" name="student_birthdate" value = "<%=student.getBirthdate()%>">
            <p>Student's birth city</p>
            <select name="city">
                <%
                    ArrayList<City> allCities = (ArrayList<City>) request.getAttribute("cities");
                    if (allCities!=null){
                        for (City city : allCities){
                %>
                <option value = "<%=city.getId()%>"><%=city.getName() + " / " + city.getCode() %></option>
                <%
                        }
                    }
                %></select>
            <a class="btn cancel btn-dark" href="/">Close</a>
            <button type="submit" class="btn btn-success">Edit data</button>
        </form>
    </div>
    <%
        }
    %>
</div>
</body>
</html>


