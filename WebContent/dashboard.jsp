<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("userId")==null){
        response.sendRedirect("login.jsp");
        return;
    }

    String name=(String)session.getAttribute("userName");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smart Parking Dashboard</title>

<link rel="stylesheet" href="css/dashboard.css">

</head>

<body>

<div class="container">

    <div class="dashboard-header">

        <div class="dashboard-left">

            <h1>🚗 Smart Parking Dashboard</h1>

            <h3>Welcome, <%=name%></h3>

        </div>

        <div class="dashboard-right">

            <div id="currentDate"></div>

            <div id="currentTime"></div>

        </div>

    </div>

    <div class="menu">

        <a href="addVehicle.jsp" class="card">
            <span class="icon">🚘</span>
            <span>Add Vehicle</span>
        </a>

        <a href="ViewVehicleServlet" class="card">
            <span class="icon">🚙</span>
            <span>View Vehicles</span>
        </a>

        <a href="ViewSlotsServlet" class="card">
            <span class="icon">🅿️</span>
            <span>View Parking Slots</span>
        </a>

        <a href="MyBookingsServlet" class="card">
            <span class="icon">📖</span>
            <span>My Bookings</span>
        </a>

        <a href="profile.jsp" class="card">
            <span class="icon">👤</span>
            <span>Profile</span>
        </a>

        <a href="LogoutServlet" class="card logout">
            <span class="icon">🚪</span>
            <span>Logout</span>
        </a>

    </div>

</div>
<footer class="footer">

    <p>🚗 Smart Parking Management System</p>
    
    <p class="developer">Developed by Rohit Walke</p>

    <p>Park Smart • Park Safe • Park Easy</p>

    <p>© 2026 All Rights Reserved</p>

</footer>
<script>

function updateDateTime(){

    const now = new Date();

    const options = {
        weekday:'long',
        day:'numeric',
        month:'long',
        year:'numeric'
    };

    document.getElementById("currentDate").innerHTML =
        "📅 " + now.toLocaleDateString("en-IN", options);

    document.getElementById("currentTime").innerHTML =
        "🕒 " + now.toLocaleTimeString("en-IN");

}

updateDateTime();

setInterval(updateDateTime,1000);

</script>

</body>
</html>