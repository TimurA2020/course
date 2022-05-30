<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 28.05.2022
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>

<%
    String name = (String) session.getAttribute("name");
    String surname = (String) session.getAttribute("surname");
    String age = (String) session.getAttribute("age");

    if(name==null || surname == null || age == null){
%>

<h1 class="text-center">Step 1</h1>
<div class="container">
<form action ="/home" method="post">
<div class="mb-3 row">
    <label for="staticEmail" class="col-sm-2 col-form-label">Name: </label>
    <div class="col-sm-10">
        <input type="text"  class="form-control" id="staticEmail" name="name">
    </div>
</div>
<div class="mb-3 row">
    <label for="surname" class="col-sm-2 col-form-label">Surname: </label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="surname" name = "surname">
    </div>
</div>
<div class="mb-3 row">
    <label for="age" class="col-sm-2 col-form-label">Age: </label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="age" name="age">
    </div>
</div>
    <button class="btn btn-success" type="submit">Next</button>
</form>
</div>

<%
    }

    String city = (String) session.getAttribute("city");
    String address = (String) session.getAttribute("address");
    String phone = (String) session.getAttribute("phone");

    if(name!=null & surname!=null && city ==null){

%>



<h1 class="text-center">Step 2</h1>
<div class="container">
    <form action ="/home" method="post">
        <div class="mb-3 row">
            <label for="city" class="col-sm-2 col-form-label">City: </label>
            <div class="col-sm-10">
                <input type="text"  class="form-control" id="city" name="city">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="address" class="col-sm-2 col-form-label">Address: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="address" name = "address">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="phone" class="col-sm-2 col-form-label">Phone: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="phone" name="phone">
            </div>
        </div>
        <input type="hidden" value="<%=name%>" name="name">
        <input type="hidden" value="<%=surname%>" name="surname">
        <input type="hidden" value="<%=age%>" name="age">
        <button class="btn btn-success" type="submit">Next</button>
    </form>
</div>
</body>

<%
    }
    %>

<%
    String uni = (String) session.getAttribute("uni");
    String major = (String) session.getAttribute("major");
    String group = (String) session.getAttribute("group");

    if(name !=null && city != null && uni == null){
%>
<h1 class="text-center">Step 3</h1>
<div class="container">
    <form action ="/home" method="post">
        <div class="mb-3 row">
            <label for="Uni" class="col-sm-2 col-form-label">Uni: </label>
            <div class="col-sm-10">
                <input type="text"  class="form-control" id="Uni" name="uni">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="major" class="col-sm-2 col-form-label">major: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="major" name = "major">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="group" class="col-sm-2 col-form-label">Group: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="group" name="group">
            </div>
        </div>
        <input type="hidden" value="<%=name%>" name="name">
        <input type="hidden" value="<%=surname%>" name="surname">
        <input type="hidden" value="<%=age%>" name="age">
        <input type="hidden" value="<%=city%>" name="city">
        <input type="hidden" value="<%=address%>" name="address">
        <input type="hidden" value="<%=phone%>" name="phone">
        <button class="btn btn-success" type="submit">Next</button>
    </form>
</div>
<%
    }
    if(name !=null && city !=null && uni !=null){

%>
<div class="container">
    Name: <%=name%><br>
    Surname: <%=surname%><br>
    Age: <%=age%><br>
    City: <%=city%><br>
    Phone: <%=phone%><br>
    Address: <%=address%><br>
    Uni: <%=uni%><br>
    Major: <%=major%><br>
    Group: <%=group%>
</div>
<%
    }
%>
<%@include file="footer.jsp"%>

