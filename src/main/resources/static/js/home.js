/**
 * Adds an event listener to the window scroll event.
 * Changes the opacity of the header element based on the scroll position.
 */
window.addEventListener("scroll", function () {
   // Get the header element by its ID
   let header = document.getElementById("mainnav");
   // Get the vertical scroll position of the window
   let scrollTop = window.pageYOffset || document.documentElement.scrollTop;
   // Calculate the opacity based on the scroll position
   // Opacity decreases as the scroll position increases
   header.style.opacity = 1 - scrollTop / 500;
});
