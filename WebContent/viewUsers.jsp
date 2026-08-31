<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.smartparking.model.User" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>View Users</title>

<link rel="stylesheet" href="css/viewusers.css">
<!-- 
<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}

.container{

    width:90%;
    margin:40px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;

}

h2{

    text-align:center;
    color:#1e3a8a;

}


table{

    width:100%;
    border-collapse:collapse;
    margin-top:20px;

}


th{

    background:#2563eb;
    color:white;
    padding:12px;

}


td{

    padding:10px;
    text-align:center;
    border:1px solid #ddd;

}


.back{

    display:inline-block;
    margin-top:20px;
    padding:10px 20px;
    background:#2563eb;
    color:white;
    text-decoration:none;
    border-radius:5px;

}


</style>   -->


</head>


<body>


<div class="container">

    <div class="header">

        <h2>👥 All Registered Users</h2>

        <p>Manage and View Registered Users</p>

    </div>

    <div class="table-container">

        <table>

            <tr>

                <th>User ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Created At</th>

            </tr>

            <%

            List<User> userList =
            (List<User>)request.getAttribute("userList");

            if(userList!=null && !userList.isEmpty()){

                for(User user:userList){

            %>

            <tr>

                <td><%=user.getUserId()%></td>

                <td><%=user.getName()%></td>

                <td><%=user.getEmail()%></td>

                <td><%=user.getPhone()%></td>

                <td><%=user.getAddress()%></td>

                <td><%=user.getCreatedAt()%></td>

            </tr>

            <%

                }

            }

            else{

            %>

            <tr>

                <td colspan="6" class="no-data">

                    No Users Available

                </td>

            </tr>

            <%

            }

            %>

        </table>

    </div>

    <div class="btn-area">

        <a href="adminDashboard.jsp" class="back">

            ⬅ Back To Dashboard

        </a>

    </div>

</div>


</body>

</html>