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

import com.smartparking.dao.UserDAO;
import com.smartparking.dao.ParkingSlotDAO;
import com.smartparking.dao.BookingDAO;
import com.smartparking.model.ParkingSlot;
import com.smartparking.model.Booking;
import com.smartparking.model.User;


@WebServlet("/ReportsServlet")
public class ReportsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public ReportsServlet() {
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



        // Get Users Count

        UserDAO userDAO = new UserDAO();

        List<User> userList = userDAO.getAllUsers();



        // Get Slots Count

        ParkingSlotDAO slotDAO = new ParkingSlotDAO();

        List<ParkingSlot> slotList = slotDAO.getAllSlots();



        // Get Bookings Count

        BookingDAO bookingDAO = new BookingDAO();

        List<Booking> bookingList = bookingDAO.getAllBookings();



        int totalUsers = userList.size();

        int totalSlots = slotList.size();

        int totalBookings = bookingList.size();


        int availableSlots = 0;

        int occupiedSlots = 0;



        for(ParkingSlot slot : slotList) {


            if(slot.getStatus().equalsIgnoreCase("Available")) {

                availableSlots++;

            }
            else if(slot.getStatus().equalsIgnoreCase("Occupied")) {

                occupiedSlots++;

            }

        }



        // Send Data To JSP


        request.setAttribute("totalUsers", totalUsers);

        request.setAttribute("totalSlots", totalSlots);

        request.setAttribute("totalBookings", totalBookings);

        request.setAttribute("availableSlots", availableSlots);

        request.setAttribute("occupiedSlots", occupiedSlots);



        RequestDispatcher rd =
                request.getRequestDispatcher("reports.jsp");


        rd.forward(request, response);


    }

}