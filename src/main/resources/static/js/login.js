
const username = document.getElementById('username');
const password = document.getElementById('password');
const url = new URL(window.location.href);
const errorMessage = url.searchParams.has('error');
const logoutMessage = url.searchParams.has('logout');
const logHead = document.getElementById('log-head');

if (errorMessage) {
    const html =
        '<div class="input-box" style="align-items: center; color: #e12729;"><h2>Invalid login</h2></div>';
    logHead.insertAdjacentHTML("afterend", html);
}

if (logoutMessage) {
    const html =
        '<div class="input-box" style="align-items: center; color: #007f4e"><h2>Successful Log out</h2></div>';
    logHead.insertAdjacentHTML("afterend", html);
}

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

function requestLogin() {
    window.location.href = "../Home/home.html";
}