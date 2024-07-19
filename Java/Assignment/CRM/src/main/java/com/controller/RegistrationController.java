package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegistrationDao;
import com.model.RegistrationModel;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegistrationModel rmodel=new RegistrationModel();
		rmodel.setUsername(request.getParameter("username"));
		rmodel.setEmailid(request.getParameter("emailid"));
		rmodel.setPwd(request.getParameter("password"));
		rmodel.setRegistrationtype(request.getParameter("registrationtype"));
		rmodel.setActiveflag(request.getParameter("activeflag"));
		rmodel.setCreateddatetime(request.getParameter("Tobeset"));
		rmodel.setCreatedbyip(request.getParameter("createdbyip"));		
		
		int x=new RegistrationDao().userRegistration(rmodel);
		if (x>0) {
			request.setAttribute("msg", "Record inserted.");
		} else {
			request.setAttribute("msg", "Record not inserted.");
		}
		request.getRequestDispatcher("login_register.jsp").forward(request, response);
	}
}
