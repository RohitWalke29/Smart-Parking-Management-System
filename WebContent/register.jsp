<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<link rel="stylesheet" href="css/register.css">
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
}

td{
    padding:10px;
}

input[type=text],
input[type=email],
input[type=password],
textarea{
    width:100%;
    padding:8px;
    border:1px solid #999;
}

input[type=submit]{
    width:100%;
    padding:10px;
    background:#198754;
    color:white;
    border:none;
    cursor:pointer;
}

input[type=submit]:hover{
    background:#157347;
}

.login{
    text-align:center;
    margin-top:15px;
}

.login a{
    text-decoration:none;
    color:#0d6efd;
}

</style>   -->

</head>

<body>

<div class="container">

<h2>User Registration</h2>

<form action="RegisterServlet" method="post">

<table>

<tr>
<td>Name</td>
</tr>

<tr>
<td><input type="text" name="name" required></td>
</tr>

<tr>
<td>Email</td>
</tr>

<tr>
<td><input type="email" name="email" required></td>
</tr>

<tr>
<td>Password</td>
</tr>

<tr>
<td><input type="password" name="password" required></td>
</tr>

<tr>
<td>Phone</td>
</tr>

<tr>
<td><input type="text" name="phone" required></td>
</tr>

<tr>
<td>Address</td>
</tr>

<tr>
<td>
<textarea name="address" rows="4"></textarea>
</td>
</tr>

<tr>
<td>
<input type="submit" value="Register">
</td>
</tr>

</table>

</form>

<div class="login">

<a href="login.jsp">Already have an account? Login</a>

</div>

</div>

</body>
</html>