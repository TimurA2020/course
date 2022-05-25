<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 24.05.2022
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
