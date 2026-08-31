<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.smartparking.model.ParkingSlot"%>

<%
if(session.getAttribute("userId")==null){
response.sendRedirect("login.jsp");
return;
}

List<ParkingSlot> slotList=
(List<ParkingSlot>)request.getAttribute("slotList");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Available Parking Slots</title>

<link rel="stylesheet" href="css/viewslots.css">
<!-- 
<style>

body{
font-family:Arial,Helvetica,sans-serif;
background:#f2f2f2;
margin:0;
}

.container{
width:900px;
margin:40px auto;
background:white;
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

input[type=submit]{

padding:6px 15px;
background:#198754;
color:white;
border:none;
cursor:pointer;

}

input[type=submit]:hover{

background:#157347;

}

.back{

text-align:center;
margin-top:20px;

}

.back a{

text-decoration:none;
color:#0d6efd;
font-weight:bold;

}

</style>   -->

</head>

<body>

<div class="container">

<h2>Available Parking Slots</h2>

<table>

<tr>

<th>Slot Number</th>

<th>Type</th>

<th>Status</th>

<th>Action</th>

</tr>

<%
if(slotList!=null){

for(ParkingSlot slot:slotList){

%>

<tr>

<td><%=slot.getSlotNumber()%></td>

<td><%=slot.getSlotType()%></td>

<td>

<%
if(slot.getStatus().equalsIgnoreCase("Available")){
%>

<span class="status available">
    🟢 Available
</span>

<%
}else{
%>

<span class="status booked">
    🔴 Booked
</span>

<%
}
%>

</td>

<td>

<%

if(slot.getStatus().equalsIgnoreCase("Available")){

%>

<form action="BookSlotServlet" method="post">

<input type="hidden"
name="slotId"
value="<%=slot.getSlotId()%>">

<input type="submit"
class="book-btn"
value="🚗 Book Now">

</form>

<%

}else{

out.print("Booked");

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