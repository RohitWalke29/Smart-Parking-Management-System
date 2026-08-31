package com.smartparking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartparking.dao.UserDAO;
import com.smartparking.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get Login Data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Check User
        UserDAO userDAO = new UserDAO();
        User user = userDAO.loginUser(email, password);

        if (user != null) {

            // Create Session
            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getName());

            System.out.println("Login Successful!");

            // Redirect to Dashboard
            response.sendRedirect("dashboard.jsp");
        } else {

            response.sendRedirect("login.jsp?error=Invalid Email or Password");

        }
    }
}