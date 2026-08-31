<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.smartparking.model.Booking" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>All Bookings</title>

<link rel="stylesheet" href="css/viewbookings.css">
<!-- 
<style>

body{
    font-family:Arial;
    background:#f2f2f2;
}


.container{

    width:95%;
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

</style>  -->


</head>


<body>


<div class="container">

    <div class="header">

        <h2>📖 All Parking Bookings</h2>

        <p>View and Monitor All Booking Records</p>

    </div>

    <div class="table-container">

        <table>

            <tr>

                <th>Booking ID</th>
                <th>User ID</th>
                <th>Vehicle ID</th>
                <th>Slot ID</th>
                <th>Booking Date</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Status</th>

            </tr>

            <%

            List<Booking> bookingList =
            (List<Booking>)request.getAttribute("bookingList");

            if(bookingList!=null && !bookingList.isEmpty()){

                for(Booking booking : bookingList){

            %>

            <tr>

                <td><%=booking.getBookingId()%></td>

                <td><%=booking.getUserId()%></td>

                <td><%=booking.getVehicleId()%></td>

                <td><%=booking.getSlotId()%></td>

                <td><%=booking.getBookingDate()%></td>

                <td><%=booking.getStartTime()%></td>

                <td><%=booking.getEndTime()%></td>

                <td>

                    <%
                    String status = booking.getStatus();
                    String cssClass = "booked";

                    if(status.equalsIgnoreCase("Cancelled")){
                        cssClass = "cancelled";
                    }
                    else if(status.equalsIgnoreCase("Completed")){
                        cssClass = "completed";
                    }
                    %>

                    <span class="<%=cssClass%>">

                        <%=status%>

                    </span>

                </td>

            </tr>

            <%

                }

            }

            else{

            %>

            <tr>

                <td colspan="8" class="no-data">

                    No Bookings Available

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