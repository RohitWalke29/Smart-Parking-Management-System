package com.smartparking.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.smartparking.dao.VehicleDAO;



@WebServlet("/DeleteVehicleServlet")
public class DeleteVehicleServlet extends HttpServlet {



protected void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{


int id =
Integer.parseInt(request.getParameter("id"));



VehicleDAO dao = new VehicleDAO();



dao.deleteVehicle(id);



response.sendRedirect("ViewVehicleServlet");



}


}