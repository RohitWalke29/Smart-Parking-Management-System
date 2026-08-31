package com.smartparking.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.smartparking.dao.VehicleDAO;
import com.smartparking.model.Vehicle;



@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {


protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{


HttpSession session=request.getSession();


int userId=(int)session.getAttribute("userId");


String number=request.getParameter("vehicleNumber");
String type=request.getParameter("vehicleType");
String model=request.getParameter("vehicleModel");



Vehicle v=new Vehicle();

v.setUserId(userId);
v.setVehicleNumber(number);
v.setVehicleType(type);
v.setVehicleModel(model);



VehicleDAO dao=new VehicleDAO();


dao.addVehicle(v);



response.sendRedirect("ViewVehicleServlet");


}



}