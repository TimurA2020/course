<%@ page import="com.sun.net.httpserver.Request" %><%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 26.05.2022
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Generic Site
    </title>
</head>
<body>
<style>
    input{
        margin: 5px;
    }
</style>
<%String language = (String) request.getAttribute("language");%>
<form action = "/language" method="post">
Choose your language: <select name="language"><option value="Ru">Ru</option><option value="Eng"
        <%if(language.equals("Eng")){%> selected="selected"<%}%>>Eng</option></select>
    <button type="submit">OK</button>
</form>
<%
    if (language != null && language.equals("Eng")) {
%>
<form action="/setcookie" method="post">
    <%
        String name_eng = (String) request.getAttribute("name");
        String surname = (String) request.getAttribute("surname");
        String age = (String) request.getAttribute("age");
        String country = (String) request.getAttribute("country");
        String gender = (String) request.getAttribute("gender");
        String card = (String) request.getAttribute("card");
    %>
    Name: <input type="text" placeholder="<%if (name_eng==null || name_eng.equals("")){%>enter something<%}else{out.print(name_eng);}%>" name="name"><br>
    Surname: <input type="text" placeholder="<%if (surname==null || surname.equals("")){%>enter something<%}else{out.print(surname);}%>" name="surname"><br>
    Age: <input type="text" placeholder="<%if (age==null || age.equals("")){%>enter something<%}else{out.print(age);}%>" name="age"><br>
    Country: <input type="text" placeholder="<%if (country==null || country.equals("")){%>enter something<%}else{out.print(country);}%>" name="country"><br>
    Gender: Male<input type="radio" placeholder="enter something" name="gender" value="Male" <%if (gender==null || gender.equals("Male") || gender.equals("")){%>checked="checked">
    Female<input type="radio" placeholder="enter something" name="gender" value="Female" <% }else{%>checked="checked"<%}%>><br>
    Credit Card: <input type="number" placeholder="<%if (card==null || card.equals("")){%>enter something<%}else{out.print(card);}%>" name="card"><br>
    <button type="submit">Set Cookie</button>
</form>
<%
}
    else{
%>
<form action="/setcookie" method="post">
    <%
        String name_ru = (String) request.getAttribute("name_ru");
        String surname = (String) request.getAttribute("surname_ru");
        String age = (String) request.getAttribute("age_ru");
        String country = (String) request.getAttribute("country_ru");
        String gender = (String) request.getAttribute("gender_ru");
        String card = (String) request.getAttribute("card_ru");
    %>
    Имя: <input type="text" placeholder="<%if (name_ru==null || name_ru.equals("")){%>Введите данные<%}else{out.print(name_ru);}%>" name="name_ru"><br>
    Фамилия: <input type="text" placeholder="<%if (surname==null || surname.equals("")){%>Введите данные<%}else{out.print(surname);}%>" name="surname_ru"><br>
    Возраст: <input type="text" placeholder="<%if (age==null || age.equals("")){%>Введите данные<%}else{out.print(age);}%>" name="age_ru"><br>
    Страна: <input type="text" placeholder="<%if (country==null || country.equals("")){%>Введите данные<%}else{out.print(country);}%>" name="country_ru"><br>
    Пол: Мужской<input type="radio" placeholder="Введите данные" name="gender_ru" value="Male" <%if (gender==null || gender.equals("Male") || gender.equals("")){%>checked="checked">
    Женский<input type="radio" placeholder="Введите данные" name="gender_ru" value="Female" <% }else{%>checked="checked"<%}%>><br>
    Карта: <input type="number" placeholder="<%if (card==null || card.equals("")){%>Введите данные<%}else{out.print(card);}%>" name="card_ru"><br>
    <button type="submit">Отправить</button>
</form>

<%
    }
%>


</body>
</html>
