package com.smartparking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.smartparking.dao.BookingDAO;

@WebServlet("/CancelBookingServlet")
public class CancelBookingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String id = request.getParameter("bookingId");
            String slot = request.getParameter("slotId");


            if(id == null || slot == null || id.trim().isEmpty() || slot.trim().isEmpty()) {

                response.sendRedirect("MyBookingsServlet");
                return;
            }


            int bookingId = Integer.parseInt(id);
            int slotId = Integer.parseInt(slot);


            BookingDAO dao = new BookingDAO();


            boolean result = dao.cancelBooking(bookingId, slotId);


            response.sendRedirect("MyBookingsServlet");


        } catch(Exception e) {

            e.printStackTrace();

            response.sendRedirect("MyBookingsServlet");
        }
    }
}