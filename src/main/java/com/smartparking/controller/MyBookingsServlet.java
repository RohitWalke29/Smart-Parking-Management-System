package com.smartparking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.smartparking.dao.BookingDAO;
import com.smartparking.model.Booking;


@WebServlet("/MyBookingsServlet")
public class MyBookingsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession(false);



        if(session == null || session.getAttribute("userId") == null)
        {
            response.sendRedirect("login.jsp");
            return;
        }



        int userId = Integer.parseInt(
                session.getAttribute("userId").toString()
        );



        BookingDAO bookingDAO = new BookingDAO();



        List<Booking> bookingList =
                bookingDAO.getBookingsByUserId(userId);



        System.out.println("USER ID : " + userId);

        System.out.println("TOTAL BOOKINGS : " + bookingList.size());



        request.setAttribute(
                "bookingList",
                bookingList
        );



        request.getRequestDispatcher("myBookings.jsp")
                .forward(request, response);

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request,response);

    }

}