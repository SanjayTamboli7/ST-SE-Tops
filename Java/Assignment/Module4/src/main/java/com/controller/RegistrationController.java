package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.dao.MsgPassRegDao;
import com.model.MsgUserModel;

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
		// doGet(request, response);
		MsgUserModel rmodel = new MsgUserModel();
		rmodel.setFname(request.getParameter("fname"));
		rmodel.setLname(request.getParameter("lname"));
		rmodel.setEmail(request.getParameter("email"));
		rmodel.setMobile(request.getParameter("mobile"));

		int x = new MsgPassRegDao().userRegistration(rmodel);
		if (x>0) {
			request.setAttribute("msg", "Record inserted");
			request.getRequestDispatcher("MsgPassLogin08.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Record not inserted");
			request.getRequestDispatcher("MsgPassReg08.jsp").forward(request, response);
			
		}
	}

}
