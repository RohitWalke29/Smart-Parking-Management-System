package com.smartparking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartparking.dao.AdminDAO;
import com.smartparking.model.Admin;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdminLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h2>Admin Servlet Working</h2>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDAO adminDAO = new AdminDAO();
        Admin admin = adminDAO.loginAdmin(username, password);

        if (admin != null) {

            HttpSession session = request.getSession();

            session.setAttribute("admin", admin);
            session.setAttribute("adminId", admin.getAdminId());
            session.setAttribute("adminUsername", admin.getUsername());

            response.sendRedirect("adminDashboard.jsp");

        } else {

            response.getWriter().println("<script>");
            response.getWriter().println("alert('Invalid Username or Password');");
            response.getWriter().println("location='adminLogin.jsp';");
            response.getWriter().println("</script>");

        }
    }
}