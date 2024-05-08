package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.RegistrationDao;
import com.model.UserModel;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel rmodel = new UserModel();
		rmodel.setFirstname(request.getParameter("firstname"));
		rmodel.setLastname(request.getParameter("lastname"));
		rmodel.setUsername(request.getParameter("username"));
		rmodel.setPassword(request.getParameter("password"));
		
		int x=new RegistrationDao().userRegistration(rmodel);
		
		if (x>0) {
			request.setAttribute("msg", "Record inserted");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Record not inserted");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
			
		}
		
	}

}
