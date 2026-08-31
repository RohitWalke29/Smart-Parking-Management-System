package com.smartparking.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.smartparking.dao.PaymentDAO;
import com.smartparking.model.Payment;



@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;



    public PaymentServlet() {

        super();

    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        // Check User Session

        HttpSession session = request.getSession(false);



        if(session == null || session.getAttribute("user") == null) {


            response.sendRedirect("login.jsp");

            return;

        }




        // Get Payment Details


        int bookingId =
        Integer.parseInt(request.getParameter("bookingId"));



        double amount =
        Double.parseDouble(request.getParameter("amount"));



        String paymentMethod =
        request.getParameter("paymentMethod");





        // Create Payment Object


        Payment payment = new Payment();



        payment.setBookingId(bookingId);

        payment.setAmount(amount);

        payment.setPaymentMethod(paymentMethod);

        payment.setPaymentStatus("PAID");





        // Insert Payment


        PaymentDAO paymentDAO = new PaymentDAO();



        boolean status =
        paymentDAO.addPayment(payment);





        if(status) {



            response.getWriter().println("<script>");

            response.getWriter().println(
            "alert('Payment Successful');"
            );

            response.getWriter().println(
            "location='MyBookingsServlet';"
            );

            response.getWriter().println("</script>");



        }
        else {



            response.getWriter().println("<script>");

            response.getWriter().println(
            "alert('Payment Failed');"
            );

            response.getWriter().println(
            "location='MyBookingsServlet';"
            );


            response.getWriter().println("</script>");



        }




    }



}