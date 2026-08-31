<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Admin Login</title>

<link rel="stylesheet" href="css/adminlogin.css">
<!-- 
<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}

.container{
    width:350px;
    margin:80px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;
}

h2{
    text-align:center;
    color:#1e3a8a;
}

input{
    width:100%;
    padding:10px;
    margin:10px 0;
    box-sizing:border-box;
}

button{
    width:100%;
    padding:10px;
    background:#2563eb;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;
}

button:hover{
    background:#1d4ed8;
}

.back{
    display:block;
    margin-top:15px;
    text-align:center;
    text-decoration:none;
}

</style>   -->

</head>

<div class="container">

    <div class="admin-icon">
        👨‍💼
    </div>

    <h2>Admin Login</h2>

    <p class="subtitle">
        Smart Parking Management System
    </p>

    <form action="AdminLoginServlet" method="post">

        <input type="text"
        name="username"
        placeholder="Enter Username"
        required>

        <input type="password"
        name="password"
        placeholder="Enter Password"
        required>

        <button type="submit">

            🔐 Login

        </button>

    </form>

    <a href="login.jsp" class="back">

        ⬅ Back to User Login

    </a>

</div>

</html>