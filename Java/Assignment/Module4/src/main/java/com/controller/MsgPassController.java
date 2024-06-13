package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.MsgHomeDao;
import com.model.MsgUserModel;

public class MsgPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MsgPassController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if (action.equals("MsgPassList08")) {
			// int userid = Integer.parseInt(request.getParameter("userid"));
			String useremail = request.getParameter("useremail");
			MsgUserModel model = new MsgHomeDao().userVerifyLogin(useremail);
			request.setAttribute("model", model);
			request.getRequestDispatcher("MsgPassList08.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
