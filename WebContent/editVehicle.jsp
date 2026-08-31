<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<%@ page import="com.smartparking.model.Vehicle"%>


<%

Vehicle v =
(Vehicle)request.getAttribute("vehicle");

%>



<!DOCTYPE html>

<html>


<head>


<meta charset="UTF-8">

<title>Edit Vehicle</title>

<link rel="stylesheet" href="css/editvehicle.css">

<!-- 
<style>


body{

font-family:Arial;
background:#f4f7fb;

}



.container{

width:400px;
margin:50px auto;
background:white;
padding:30px;
border-radius:15px;
box-shadow:0 5px 15px #ccc;

}



input{

width:100%;
padding:12px;
margin:10px 0;

}



button{

width:100%;
padding:12px;
background:#0d6efd;
color:white;
border:none;
border-radius:5px;

}


</style>   -->


</head>


<body>



<div class="container">


<div class="header">

<h2>🚗 Edit Vehicle</h2>

<p>Update Your Vehicle Details</p>

</div>



<form action="UpdateVehicleServlet" method="post">


<input type="hidden"
name="vehicleId"
value="<%=v.getVehicleId()%>">



<label>Vehicle Number</label>

<input type="text"
name="vehicleNumber"
value="<%=v.getVehicleNumber()%>">



<label>Vehicle Type</label>

<input type="text"
name="vehicleType"
value="<%=v.getVehicleType()%>">



<label>Vehicle Model</label>

<input type="text"
name="vehicleModel"
value="<%=v.getVehicleModel()%>">



<button type="submit">

Update Vehicle

</button>


</form>



<a href="ViewVehicleServlet" class="back">

⬅ Back To Vehicles

</a>


</div>


</body>


</html>