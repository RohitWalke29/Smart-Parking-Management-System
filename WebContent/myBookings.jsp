<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.smartparking.model.Booking"%>

<%
if(session.getAttribute("userId")==null){
    response.sendRedirect("login.jsp");
    return;
}

List<Booking> bookingList=(List<Booking>)request.getAttribute("bookingList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Bookings</title>

<link rel="stylesheet" href="css/mybookings.css">
<!-- 
<style>

body{
    font-family:Arial,Helvetica,sans-serif;
    background:#f2f2f2;
    margin:0;
}

.container{
    width:1000px;
    margin:40px auto;
    background:#fff;
    padding:25px;
    border:1px solid #ccc;
}

h2{
    text-align:center;
    color:#0d6efd;
}

table{
    width:100%;
    border-collapse:collapse;
}

table th,
table td{
    border:1px solid #ccc;
    padding:10px;
    text-align:center;
}

table th{
    background:#0d6efd;
    color:white;
}

a{
    text-decoration:none;
    color:#dc3545;
    font-weight:bold;
}

.back{
    margin-top:20px;
    text-align:center;
}

.back a{
    color:#0d6efd;
}

</style>   -->

</head>

<body>

<div class="container">

<h2>My Bookings</h2>

<table>

<tr>
<th>Booking ID</th>
<th>Slot ID</th>
<th>Vehicle ID</th>
<th>Booking Date</th>
<th>Start Time</th>
<th>End Time</th>
<th>Status</th>
<th>Action</th>
</tr>

<%
if(bookingList!=null){

for(Booking booking:bookingList){
%>

<tr>

<td><%=booking.getBookingId()%></td>

<td><%=booking.getSlotId()%></td>

<td><%=booking.getVehicleId()%></td>

<td><%=booking.getBookingDate()%></td>

<td><%=booking.getStartTime()%></td>

<td><%=booking.getEndTime()%></td>

<td>

<%
if(booking.getStatus().equalsIgnoreCase("Cancelled")){
%>

<span class="status cancelled">
🔴 Cancelled
</span>

<%
}else{
%>

<span class="status active">
🟢 Active
</span>

<%
}
%>

</td>

<td>

<%
if(!booking.getStatus().equalsIgnoreCase("Cancelled")){
%>

<a class="cancel-btn"
href="CancelBookingServlet?bookingId=<%= booking.getBookingId() %>&slotId=<%= booking.getSlotId() %>"
onclick="return confirm('Are you sure you want to cancel this booking?')">

🗑 Cancel

</a>

<%
}else{
%>

<span class="already-cancelled">

✔ Already Cancelled

</span>

<%
}
%>

</td>

</tr>

<%
}
}
%>

</table>

<div class="back">

<a class="back-btn"
href="dashboard.jsp">

⬅ Back to Dashboard

</a>

</div>

</div>

</body>
</html>