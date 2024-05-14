/**
 * Retrieves references to HTML elements and checks for error or logout messages in the URL.
 * Displays corresponding messages if present.
 */
const username = document.getElementById('username');
const password = document.getElementById('password');
const url = new URL(window.location.href);
const errorMessage = url.searchParams.has('error');
const logoutMessage = url.searchParams.has('logout');
const logHead = document.getElementById('log-head');

// Display error message if present
if (errorMessage) {
    const html =
        '<div class="input-box" style="align-items: center; color: #e12729;"><h2>Invalid login</h2></div>';
    logHead.insertAdjacentHTML("afterend", html);
}

// Display logout message if present
if (logoutMessage) {
    const html =
        '<div class="input-box" style="align-items: center; color: #007f4e"><h2>Successful Log out</h2></div>';
    logHead.insertAdjacentHTML("afterend", html);
}

/**
 * Displays a browser notification with the provided message.
 * This function checks if the browser supports notifications and requests permission if necessary.
 *
 * @param {string} msg The message to display in the notification
 */
function notify(msg) {

    if ("Notification" in window) {
        // Request permission to display notifications
        Notification.requestPermission().then(function (permission) {
            if (permission === "granted") {
                new Notification(msg);
            }
        });
    } else {
        console.log("This browser does not support notifications.");
    }
}

/**
 * Redirects to the login page.
 */
function requestLogin() {
    window.location.href = "../Home/home.html";
}
