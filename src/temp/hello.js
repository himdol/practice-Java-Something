const loginForm = document.getElementById("login-form");
const loginInput = loginForm.querySelector("input");

function onLoginSubmit(event) {
  event.preventDefault();
  // const username = loginInput.value;
  console.log(loginInput.value);
}

loginForm.addEventListener("submit", onLoginSubmit);

