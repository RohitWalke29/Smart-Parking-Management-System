package com.smartparking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartparking.dao.BookingDAO;
import com.smartparking.model.Booking;


@WebServlet("/ViewAllBookingsServlet")
public class ViewAllBookingsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public ViewAllBookingsServlet() {
        super();
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // Admin Session Check

        HttpSession session = request.getSession(false);


        if(session == null || session.getAttribute("admin") == null) {


            response.sendRedirect("adminLogin.jsp");

            return;

        }



        // Get All Bookings

        BookingDAO bookingDAO = new BookingDAO();


        List<Booking> bookingList =
                bookingDAO.getAllBookings();



        // Send Data To JSP

        request.setAttribute("bookingList", bookingList);



        RequestDispatcher rd =
                request.getRequestDispatcher("viewAllBookings.jsp");


        rd.forward(request, response);



    }


}