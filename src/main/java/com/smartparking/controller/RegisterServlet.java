package com.smartparking.controller;

import java.io.IOException;

import com.smartparking.dao.UserDAO;
import com.smartparking.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get form data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		// Create User Object
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setAddress(address);

		// Save User
		UserDAO userDAO = new UserDAO();
		boolean status = userDAO.addUser(user);

		// Response
		response.setContentType("text/html");

		if (status) {

		    response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");

		} else {

		    response.sendRedirect(request.getContextPath() + "/registerFailed.jsp");

		}
	}
}