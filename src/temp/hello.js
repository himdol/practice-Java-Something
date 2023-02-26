const loginForm = document.getElementById("login-form");
const loginInput = loginForm.querySelector("input");
const loginButton = loginForm.querySelector("button");

function onLoginBtnClick() {
  const username = loginInput.value;
  if (username === "") {
    alert("please write your name");
  } else if (username.length > 15) {
    alert("Your name is too long.");
  }
}

loginButton.addEventListener("click", onLoginBtnClick);