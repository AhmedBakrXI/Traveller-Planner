
const username = document.getElementById('username');
const password = document.getElementById('password');

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