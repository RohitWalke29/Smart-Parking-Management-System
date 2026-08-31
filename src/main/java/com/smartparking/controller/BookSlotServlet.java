package com.smartparking.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.smartparking.dao.BookingDAO;
import com.smartparking.dao.VehicleDAO;
import com.smartparking.model.Booking;
import com.smartparking.model.Vehicle;

@WebServlet("/BookSlotServlet")
public class BookSlotServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        int userId = Integer.parseInt(session.getAttribute("userId").toString());

        int slotId = Integer.parseInt(request.getParameter("slotId"));

        // Get User Vehicle

        VehicleDAO vehicleDAO = new VehicleDAO();

        List<Vehicle> vehicles = vehicleDAO.getVehiclesByUserId(userId);

        if (vehicles == null || vehicles.isEmpty()) {

            response.sendRedirect("addVehicle.jsp");
            return;
        }

        int vehicleId = vehicles.get(0).getVehicleId();

        Booking booking = new Booking();

        booking.setUserId(userId);
        booking.setVehicleId(vehicleId);
        booking.setSlotId(slotId);
        booking.setBookingDate(new Date(System.currentTimeMillis()));
        booking.setStartTime(new Timestamp(System.currentTimeMillis()));
        booking.setEndTime(new Timestamp(System.currentTimeMillis() + 3600000));
        booking.setStatus("BOOKED");

        BookingDAO dao = new BookingDAO();

        int bookingId = dao.bookSlot(booking);

        if (bookingId > 0) {

            response.sendRedirect("payment.jsp?bookingId=" + bookingId);

        } else {

            response.sendRedirect("ViewSlotsServlet");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("ViewSlotsServlet");

    }

}