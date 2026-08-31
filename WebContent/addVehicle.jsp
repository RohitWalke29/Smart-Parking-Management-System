<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
if(session.getAttribute("userId")==null){
response.sendRedirect("login.jsp");
return;
}
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Add Vehicle</title>

<link rel="stylesheet" href="css/vehicle.css">
<!-- 
<style>

body{

font-family:Arial,Helvetica,sans-serif;
background:#f2f2f2;
margin:0;

}

.container{

width:500px;
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

}

td{

padding:10px;

}

input[type=text],
select{

width:100%;
padding:8px;
border:1px solid #999;

}

input[type=submit]{

padding:10px 20px;
background:#0d6efd;
color:white;
border:none;
cursor:pointer;

}

input[type=submit]:hover{

background:#0b5ed7;

}

.back{

margin-top:20px;
text-align:center;

}

.back a{

text-decoration:none;
color:#0d6efd;

}

</style>   -->

</head>

<body>
<!-- 
<div class="container">

<h2>Add Vehicle</h2>

<form action="AddVehicleServlet" method="post">

<table>

<tr>

<td>Vehicle Number</td>

<td>

<input type="text"
name="vehicleNumber"
required>

</td>

</tr>

<tr>

<td>Vehicle Type</td>

<td>

<select name="vehicleType">

<option value="Car">Car</option>

<option value="Bike">Bike</option>

<option value="SUV">SUV</option>

<option value="Other">Other</option>

</select>

</td>

</tr>

<tr>

<td>Vehicle Model</td>

<td>

<input type="text"
name="vehicleModel">

</td>

</tr>

<tr>

<td colspan="2" align="center">

<input type="submit"
value="Add Vehicle">

</td>

</tr>

</table>

</form>

<div class="back">

<a href="dashboard.jsp">Back to Dashboard</a>

</div>  -->

<div class="container">

    <h2>🚗 Add Vehicle</h2>

    <form action="AddVehicleServlet" method="post">

        <div class="form-group">
            <label>Vehicle Number</label>
            <input type="text" name="vehicleNumber" required>
        </div>

        <div class="form-group">
            <label>Vehicle Type</label>

            <select name="vehicleType">

                <option value="Car">Car</option>
                <option value="Bike">Bike</option>
                <option value="SUV">SUV</option>
                <option value="Other">Other</option>

            </select>

        </div>

        <div class="form-group">
            <label>Vehicle Model</label>
            <input type="text" name="vehicleModel">
        </div>

        <input type="submit" value="Add Vehicle">

    </form>

    <div class="back">

        <a href="dashboard.jsp">⬅ Back to Dashboard</a>

    </div>

</div>

</div>

</body>
</html>