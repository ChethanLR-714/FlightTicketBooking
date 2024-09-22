package com.regapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.regapp.model.DAOService;
import com.regapp.model.DAOServiceImpl;

@WebServlet("/verifyLogin")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logincontroller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");

			DAOService service = new DAOServiceImpl();
			service.connectDB();

			boolean status = service.verifyCredentials(user, pass);

			if (status == true) {
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(10);
				session.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_reg.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("error", "invalid/password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			}

		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		}
		
	}

}
