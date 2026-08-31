<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.smartparking.model.ParkingSlot"%>


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

<title>Book Parking Slot</title>


<style>


body{

    font-family: Arial;
    background:#f4f6f9;
    margin:0;
    padding:20px;

}


.header{

    background:#007bff;
    color:white;
    padding:15px;
    border-radius:10px;

}



.container{

    margin-top:30px;

}



.slot-grid{

    display:flex;
    gap:25px;
    flex-wrap:wrap;

}



.slot-card{

    background:white;
    width:230px;
    padding:20px;
    border-radius:15px;

    box-shadow:0px 4px 10px #ccc;

    text-align:center;

}



.slot-card h2{

    color:#333;

}



.available{

    color:green;
    font-weight:bold;

}



.occupied{

    color:red;
    font-weight:bold;

}



.book-btn{

    background:#28a745;
    color:white;

    border:none;

    padding:12px 25px;

    border-radius:8px;

    cursor:pointer;

}



.book-btn:hover{

    background:#218838;

}



.back-btn{

    display:inline-block;

    margin-top:30px;

    background:#007bff;

    color:white;

    padding:10px 20px;

    text-decoration:none;

    border-radius:8px;

}


</style>


</head>



<body>


<div class="header">

<h1>
Smart Parking - Book Slot
</h1>

</div>



<div class="container">


<h2>
Available Parking Slots
</h2>



<div class="slot-grid">


<%


List<ParkingSlot> slotList =
(List<ParkingSlot>)request.getAttribute("slotList");



if(slotList != null && !slotList.isEmpty()){



    for(ParkingSlot slot : slotList){


%>



<div class="slot-card">


<h2>

<%=slot.getSlotNumber()%>

</h2>



<p>

<b>Type :</b>

<%=slot.getSlotType()%>

</p>




<p>

<b>Status :</b>

<%


if("Available".equalsIgnoreCase(slot.getStatus())){


%>


<span class="available">

Available

</span>


<%

}else{


%>


<span class="occupied">

Occupied

</span>


<%

}

%>


</p>





<%

if("Available".equalsIgnoreCase(slot.getStatus())){


%>


<form action="BookSlotServlet" method="post">


<input type="hidden"
name="slotId"
value="<%=slot.getSlotId()%>">



<button type="submit" class="book-btn">

Confirm Booking

</button>



</form>



<%

}


%>


</div>




<%

    }


}
else{


%>


<h2>

No Parking Slots Available

</h2>


<%

}


%>



</div>



<br>


<a href="dashboard.jsp" class="back-btn">

Back To Dashboard

</a>



</div>



</body>

</html>