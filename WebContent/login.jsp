<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<link rel="stylesheet" href="css/login.css">

</head>

<body>

<div class="container">

<h2>User Login</h2>

<%
String error=request.getParameter("error");
if(error!=null){
%>

<p class="error"><%=error%></p>

<%
}
%>

<form action="LoginServlet" method="post">

<table>

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
<td>
<input type="submit" value="Login">
</td>
</tr>

</table>

</form>

<div class="register">

<a href="register.jsp">New User? Register Here</a>

</div>

</div>

</body>
</html>