package com.smartparking.controller;

import java.io.IOException;
import java.util.List;

import com.smartparking.dao.ParkingSlotDAO;
import com.smartparking.model.ParkingSlot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewSlotsServlet")
public class ViewSlotsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ViewSlotsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ParkingSlotDAO dao = new ParkingSlotDAO();

        List<ParkingSlot> slotList = dao.getAvailableSlots();

        request.setAttribute("slotList", slotList);

        request.getRequestDispatcher("viewSlots.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}