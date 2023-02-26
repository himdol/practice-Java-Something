const h1 = document.querySelector("div.hello:first-child h1");

function handleClick() {
  const clickedClass = "clicked";
  h1.classList.toggle(clickedClass);
}

h1.addEventListener("click", handleClick);


