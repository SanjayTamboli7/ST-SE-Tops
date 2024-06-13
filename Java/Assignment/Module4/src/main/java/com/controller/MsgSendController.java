package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.dao.MsgPassRegDao;
import com.dao.MsgSendRegDao;
import com.model.MsgSendModel;
import com.model.MsgUserModel;

public class MsgSendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MsgSendController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MsgSendModel rmodel = new MsgSendModel();
		rmodel.setFromUser(request.getParameter("FromUser"));
		rmodel.setToUser(request.getParameter("ToUser"));
		rmodel.setMsgDetail(request.getParameter("MsgDetail"));

		int x = new MsgSendRegDao().msgRegistration(rmodel);
		if (x > 0) {
			request.setAttribute("msg", "Record inserted");
			// request.getRequestDispatcher("MsgPassLogin08.jsp").forward(request,
			// response);
		} else {
			request.setAttribute("msg", "Record not inserted");
			// request.getRequestDispatcher("MsgPassReg08.jsp").forward(request, response);
		}
		request.getRequestDispatcher("MsgSend08.jsp").forward(request, response);
	}

}
