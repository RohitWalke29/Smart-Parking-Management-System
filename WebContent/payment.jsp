<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Payment</title>


<style>

body{

    font-family:Arial;
    background:#f2f2f2;

}


.container{

    width:400px;
    margin:50px auto;
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 0 10px gray;

}


h2{

    text-align:center;
    color:#1e3a8a;

}


input,select{

    width:100%;
    padding:10px;
    margin:10px 0;

}



button{

    width:100%;
    padding:12px;
    background:#2563eb;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;

}



button:hover{

    background:#1d4ed8;

}



</style>


</head>


<body>


<div class="container">


<h2>Payment</h2>



<form action="PaymentServlet" method="post">



<label>Booking ID</label>

<input type="number" name="bookingId"
value="<%=request.getParameter("bookingId")%>"
readonly>



<label>Amount</label>

<input type="number" name="amount"
value="100"
readonly>



<label>Payment Method</label>


<select name="paymentMethod">


<option value="UPI">
UPI
</option>


<option value="CARD">
Card
</option>


<option value="CASH">
Cash
</option>


</select>




<button type="submit">
Pay Now
</button>



</form>



</div>


</body>


</html>