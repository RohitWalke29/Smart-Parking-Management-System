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
import com.smartparking.model.User;


@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public ViewUsersServlet() {
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



        // Get All Users

        UserDAO userDAO = new UserDAO();

        List<User> userList = userDAO.getAllUsers();



        // Send Data To JSP

        request.setAttribute("userList", userList);



        RequestDispatcher rd =
                request.getRequestDispatcher("viewUsers.jsp");


        rd.forward(request, response);



    }

}