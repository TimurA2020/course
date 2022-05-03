var users = [];

var email = document.getElementById("email");
var password = document.getElementById("password");
var firstname = document.getElementById("name");

document.getElementById("submit-button").addEventListener("click", function(){
    if(email.value.length < 1){
        document.getElementById("p2").innerText = "Please enter your email";
    }
    if(firstname.value.length < 1){
        document.getElementById("p1").innerText = "Please enter your name";
    }
    if(password.value.length < 1){
        document.getElementById("p3").innerText = "Please enter your password";
    }
    for (var i = 0; i < users.length; i++){
        if (users[i].email == email.value){
            document.getElementById("p2").innerText = "User with this email already exists";
        }
    }
    var singleUser = {};
    singleUser.email = email.value;
    singleUser.password = password.value;
    users.push(singleUser);
    updateStorage();
})

email.addEventListener("mouseover", function(){
    document.getElementById("p2").innerText = "";
})

password.addEventListener("mouseover", function(){
    document.getElementById("p3").innerText = "";
})

firstname.addEventListener("mouseover", function(){
    document.getElementById("p1").innerText = "";
})

function updateStorage(){
    localStorage.users = JSON.stringify(users);
  }
