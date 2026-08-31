<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.smartparking.model.User"%>

<%
if(session.getAttribute("userId")==null){
    response.sendRedirect("login.jsp");
    return;
}

User user=(User)session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>

<link rel="stylesheet" href="css/profile.css">
<!-- 
<style>

body{
    font-family:Arial,Helvetica,sans-serif;
    background:#f2f2f2;
    margin:0;
}

.container{
    width:600px;
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

table td{
    border:1px solid #ccc;
    padding:12px;
}

.label{
    font-weight:bold;
    width:180px;
    background:#f8f9fa;
}

.back{
    margin-top:20px;
    text-align:center;
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

    <div class="profile-header">

        <div class="avatar">👤</div>

        <h2>User Profile</h2>

        <p>Smart Parking System</p>

    </div>

    <table>

        <tr>
            <td class="label">👤 Name</td>
            <td><%=user.getName()%></td>
        </tr>

        <tr>
            <td class="label">📧 Email</td>
            <td><%=user.getEmail()%></td>
        </tr>

        <tr>
            <td class="label">📱 Phone</td>
            <td><%=user.getPhone()%></td>
        </tr>

        <tr>
            <td class="label">📍 Address</td>
            <td><%=user.getAddress()%></td>
        </tr>

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