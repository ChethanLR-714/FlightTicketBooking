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

@WebServlet("/saveReg")
public class NewRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewRegController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_reg.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession(false);

			if (session.getAttribute("user") != null) {

				String name = request.getParameter("name");
				String city = request.getParameter("city");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");

				DAOService service = new DAOServiceImpl();
				service.connectDB();

				service.saveRegistration(name, city, email, mobile);

				request.setAttribute("msg", "record is saved");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_reg.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

}
