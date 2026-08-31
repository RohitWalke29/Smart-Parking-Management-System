package com.smartparking.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.smartparking.dao.VehicleDAO;
import com.smartparking.model.Vehicle;



@WebServlet("/EditVehicleServlet")
public class EditVehicleServlet extends HttpServlet {


protected void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{


int id = Integer.parseInt(request.getParameter("id"));



VehicleDAO dao = new VehicleDAO();


Vehicle vehicle = dao.getVehicleById(id);



request.setAttribute("vehicle", vehicle);



request.getRequestDispatcher("editVehicle.jsp")
.forward(request,response);



}


}