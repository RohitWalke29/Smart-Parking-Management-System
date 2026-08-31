<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="javax.servlet.http.HttpSession"%>

<%
HttpSession session1 = request.getSession(false);

if(session1 == null || session1.getAttribute("admin")==null){
    response.sendRedirect("adminLogin.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Admin Dashboard</title>

<link rel="stylesheet" href="css/admindashboard.css?v=1">

</head>

<body>

<div class="container">

    <!-- ===========================
             HEADER
    ============================ -->

    <div class="dashboard-header">

        <div class="dashboard-left">

            <h2>🚗 Smart Parking Admin Dashboard</h2>

            <p>Welcome, Administrator</p>

        </div>

        <div class="dashboard-right">

            <div class="top-right">

                <div class="notification">

                    <span class="bell" onclick="toggleNotification()">

                        🔔

                        <span class="badge">3</span>

                    </span>

                    <div id="notificationBox" class="notification-box">

                        <h4>Notifications</h4>

                        <hr>

                        <p>👤 New User Registered</p>

                        <p>🚗 New Booking Created</p>

                        <p>🅿 2 Parking Slots Available</p>

                    </div>

                </div>

            </div>

            <div id="currentDate"></div>

            <div id="currentTime"></div>

        </div>

    </div>

    <!-- ===========================
              MENU
    ============================ -->

    <div class="menu">

        <a href="ViewUsersServlet" class="card">

            👥

            <span>View Users</span>

        </a>

        <a href="ManageSlotsServlet" class="card">

            🅿️

            <span>Manage Slots</span>

        </a>

        <a href="ViewAllBookingsServlet" class="card">

            📖

            <span>View Bookings</span>

        </a>

        <a href="ReportsServlet" class="card">

            📊

            <span>Reports</span>

        </a>

        <a href="AdminLogoutServlet" class="card logout">

            🚪

            <span>Logout</span>

        </a>

    </div>

</div>

<script>

/* ===========================
      DATE & TIME
=========================== */

function updateDateTime(){

    const now = new Date();

    const options = {

        weekday:"long",

        day:"numeric",

        month:"long",

        year:"numeric"

    };

    document.getElementById("currentDate").innerHTML =
    "📅 " + now.toLocaleDateString("en-IN", options);

    document.getElementById("currentTime").innerHTML =
    "🕒 " + now.toLocaleTimeString("en-IN");

}

updateDateTime();

setInterval(updateDateTime,1000);


/* ===========================
   NOTIFICATION BELL
=========================== */

function toggleNotification(){

    var box = document.getElementById("notificationBox");

    if(box.style.display==="block"){

        box.style.display="none";

    }
    else{

        box.style.display="block";

    }

}

window.onclick=function(event){

    if(!event.target.closest(".notification")){

        document.getElementById("notificationBox").style.display="none";

    }

}

</script>

</body>

</html>