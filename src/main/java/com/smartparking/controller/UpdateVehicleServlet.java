package com.smartparking.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.smartparking.dao.VehicleDAO;
import com.smartparking.model.Vehicle;



@WebServlet("/UpdateVehicleServlet")
public class UpdateVehicleServlet extends HttpServlet {



protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{


int id = Integer.parseInt(
request.getParameter("vehicleId")
);


String number =
request.getParameter("vehicleNumber");


String type =
request.getParameter("vehicleType");


String model =
request.getParameter("vehicleModel");



Vehicle v = new Vehicle();


v.setVehicleId(id);
v.setVehicleNumber(number);
v.setVehicleType(type);
v.setVehicleModel(model);



VehicleDAO dao = new VehicleDAO();


dao.updateVehicle(v);



response.sendRedirect("ViewVehicleServlet");



}


}