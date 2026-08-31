<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.smartparking.model.Vehicle"%>

<%
if(session.getAttribute("userId")==null){
    response.sendRedirect("login.jsp");
    return;
}

List<Vehicle> vehicleList=(List<Vehicle>)request.getAttribute("vehicleList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Vehicles</title>

<link rel="stylesheet" href="css/viewvehicle.css">
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

table th,table td{
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
    color:#0d6efd;
    font-weight:bold;
}

.back{
    margin-top:20px;
    text-align:center;
}

</style>   -->

</head>

<body>

<div class="container">

<h2>My Vehicles</h2>

<table>

<tr>
<th>ID</th>
<th>Vehicle Number</th>
<th>Type</th>
<th>Model</th>
<th>Action</th>
</tr>

<%
if(vehicleList!=null){

for(Vehicle v:vehicleList){
%>

<tr>

<td><%=v.getVehicleId()%></td>

<td><%=v.getVehicleNumber()%></td>

<td><%=v.getVehicleType()%></td>

<td><%=v.getVehicleModel()%></td>
<!-- 
<td>

<a href="EditVehicleServlet?id=<%=v.getVehicleId()%>">Edit</a>

|

<a href="DeleteVehicleServlet?id=<%=v.getVehicleId()%>"
onclick="return confirm('Delete Vehicle?')">
Delete
</a>

</td>   -->

<td class="action-buttons">

<a class="edit-btn"
href="EditVehicleServlet?id=<%=v.getVehicleId()%>">
✏ Edit
</a>

<a class="delete-btn"
href="DeleteVehicleServlet?id=<%=v.getVehicleId()%>"
onclick="return confirm('Delete Vehicle?')">
🗑 Delete
</a>

</td>

</tr>

<%
}
}
%>

</table>

<div class="back">

<a class="back-btn" href="dashboard.jsp">
⬅ Back to Dashboard
</a>

</div>

</div>

</body>
</html>