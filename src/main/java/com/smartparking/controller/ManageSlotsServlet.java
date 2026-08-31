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

import com.smartparking.dao.ParkingSlotDAO;
import com.smartparking.model.ParkingSlot;


@WebServlet("/ManageSlotsServlet")
public class ManageSlotsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public ManageSlotsServlet() {
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



        // Get All Parking Slots

        ParkingSlotDAO slotDAO = new ParkingSlotDAO();


        List<ParkingSlot> slotList = slotDAO.getAllSlots();



        // Send Data To JSP

        request.setAttribute("slotList", slotList);



        RequestDispatcher rd =
                request.getRequestDispatcher("manageSlots.jsp");


        rd.forward(request, response);


    }

}