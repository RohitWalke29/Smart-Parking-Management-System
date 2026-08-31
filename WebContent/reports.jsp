<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Reports</title>

<link rel="stylesheet" href="css/reports.css">
<!-- 
<style>

body{

    font-family:Arial;
    background:#f2f2f2;

}


.container{

    width:80%;
    margin:50px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;

}


h2{

    text-align:center;
    color:#1e3a8a;

}



.cards{

    display:flex;
    justify-content:center;
    flex-wrap:wrap;
    gap:20px;
    margin-top:30px;

}



.card{

    width:200px;
    padding:25px;
    background:#2563eb;
    color:white;
    text-align:center;
    border-radius:10px;

}



.number{

    font-size:35px;
    font-weight:bold;

}



.back{

    display:block;
    width:200px;
    text-align:center;
    margin:30px auto;
    padding:12px;
    background:#dc2626;
    color:white;
    text-decoration:none;
    border-radius:5px;

}


</style>  -->


</head>


<body>


<div class="container">

    <div class="header">

        <h2>📊 Smart Parking Reports</h2>

        <p>Overall System Statistics</p>

    </div>

    <div class="cards">

        <div class="card">

            <div class="icon">👥</div>

            <h3>Total Users</h3>

            <div class="number">
                <%=request.getAttribute("totalUsers")%>
            </div>

        </div>

        <div class="card">

            <div class="icon">🅿</div>

            <h3>Total Slots</h3>

            <div class="number">
                <%=request.getAttribute("totalSlots")%>
            </div>

        </div>

        <div class="card">

            <div class="icon">✅</div>

            <h3>Available Slots</h3>

            <div class="number">
                <%=request.getAttribute("availableSlots")%>
            </div>

        </div>

        <div class="card">

            <div class="icon">🚫</div>

            <h3>Occupied Slots</h3>

            <div class="number">
                <%=request.getAttribute("occupiedSlots")%>
            </div>

        </div>

        <div class="card">

            <div class="icon">📖</div>

            <h3>Total Bookings</h3>

            <div class="number">
                <%=request.getAttribute("totalBookings")%>
            </div>

        </div>

    </div>

    <div class="btn-area">

        <a href="adminDashboard.jsp" class="back">

            ⬅ Back To Dashboard

        </a>

    </div>

</div>


</body>

</html>