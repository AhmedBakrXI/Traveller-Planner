



window.addEventListener("scroll", function () {
   let header = document.getElementById("mainnav");
   let scrollTop = window.pageYOffset || document.documentElement.scrollTop;
   header.style.opacity = 1 - scrollTop / 500;
});

