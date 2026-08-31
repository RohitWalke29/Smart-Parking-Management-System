<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.smartparking.model.ParkingSlot" %>


<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Manage Parking Slots</title>

<link rel="stylesheet" href="css/manageslots.css">
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
    background:#2563eb;
    color:white;
    padding:10px 20px;
    text-decoration:none;
    border-radius:5px;

}


</style>   -->


</head>


<body>


<div class="container">

    <div class="header">

        <h2>🅿 Manage Parking Slots</h2>

        <p>View All Available Parking Slots</p>

    </div>

    <div class="table-container">

        <table>

            <tr>

                <th>Slot ID</th>
                <th>Slot Number</th>
                <th>Slot Type</th>
                <th>Status</th>

            </tr>

            <%

            List<ParkingSlot> slotList =
            (List<ParkingSlot>)request.getAttribute("slotList");

            if(slotList!=null && !slotList.isEmpty()){

                for(ParkingSlot slot : slotList){

            %>

            <tr>

                <td><%=slot.getSlotId()%></td>

                <td><%=slot.getSlotNumber()%></td>

                <td><%=slot.getSlotType()%></td>

                <td>

                    <span class="<%= slot.getStatus().equalsIgnoreCase("Available") ? "available" : "occupied" %>">

                        <%=slot.getStatus()%>

                    </span>

                </td>

            </tr>

            <%

                }

            }

            else{

            %>

            <tr>

                <td colspan="4" class="no-data">

                    No Parking Slots Available

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