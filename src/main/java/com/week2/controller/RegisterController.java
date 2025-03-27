package com.week2.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/stdRegister", "/" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/pages/stdRegister.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
	    System.out.println("Action received: " + action);  // Debugging

	    if ("already-registered".equals(action)) {
	        response.sendRedirect("login");
	        return;
	    }

	    System.out.println("Nothing happens");
		
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		String username = request.getParameter("username");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phone-number");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("re-password");
		
		Pattern alphabetValidate = Pattern.compile("^[a-zA-Z]+$");
		
		
		
		
	    if (firstName.length() < 5) {
	        request.setAttribute("error", "First-name should be more than 5 letters.");
	        request.getRequestDispatcher("WEB-INF/pages/stdRegister.jsp").forward(request, response);
	        return;
	    }

	    if (!alphabetValidate.matcher(firstName).matches() || !alphabetValidate.matcher(lastName).matches()) {
	        request.setAttribute("error", "First & Last name should contain only alphabets.");
	        request.getRequestDispatcher("WEB-INF/pages/stdRegister.jsp").forward(request, response);
	        return;
	    }

	    if (!password.equals(confirmPassword)) {
	        request.setAttribute("error", "The password does not match.");
	        request.getRequestDispatcher("WEB-INF/pages/stdRegister.jsp").forward(request, response);
	        return;
	    }
	    request.getSession().setAttribute("registeredUsername", username);
	    request.getSession().setAttribute("registeredPassword", password);
		response.sendRedirect("login");
		
	}

}
