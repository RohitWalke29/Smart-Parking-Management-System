package com.smartparking.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.smartparking.dao.VehicleDAO;
import com.smartparking.model.Vehicle;



@WebServlet("/ViewVehicleServlet")
public class ViewVehicleServlet extends HttpServlet {



protected void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{


HttpSession session=request.getSession();


int userId=(int)session.getAttribute("userId");



VehicleDAO dao=new VehicleDAO();


List<Vehicle> list =
dao.getVehiclesByUserId(userId);



request.setAttribute("vehicleList", list);



request.getRequestDispatcher("viewVehicles.jsp").forward(request, response);



}


}