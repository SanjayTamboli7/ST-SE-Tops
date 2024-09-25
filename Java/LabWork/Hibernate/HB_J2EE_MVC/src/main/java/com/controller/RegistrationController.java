package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HBDao;
import com.model.UserModel;

import java.io.IOException;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel rmodel=new UserModel();
		rmodel.setFirstname(request.getParameter("firstname"));
		rmodel.setLastname(request.getParameter("lastname"));
		rmodel.setUsername(request.getParameter("username"));
		rmodel.setPassword(request.getParameter("password"));
		
		String msg=new HBDao().userRegistration(rmodel);
		if (!msg.equals("error"))
		{
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Registration failed.");
			request.getRequestDispatcher("Registration.jsp").forward(request, response);
		}
		
	}

}
