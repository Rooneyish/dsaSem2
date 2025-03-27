package com.week2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LogInController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println("Action received: " + action);

		if ("not-registered".equals(action)) {
			response.sendRedirect("register");
			return;
		}

		String registeredUsername = (String) request.getSession().getAttribute("registeredUsername");
		String registeredPassword = (String) request.getSession().getAttribute("registeredPassword");

	    String username = request.getParameter("username").trim();
	    String password = request.getParameter("password").trim();
		
		if (registeredUsername == null || registeredPassword == null || !username.equals(registeredUsername)
				|| !password.equals(registeredPassword)) {
			request.setAttribute("error", "Invalid username or password. Please try again.");
			request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
			return;
		}

		request.getSession().setAttribute("username", username);
		response.sendRedirect("home");
	}

}
