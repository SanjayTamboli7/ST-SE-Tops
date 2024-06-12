package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.MsgUserLoginDao;
import com.model.MsgUserModel;

public class MsgUserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MsgUserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		MsgUserModel lmodel=new MsgUserModel();
		lmodel.setFname(request.getParameter("fname"));
		lmodel.setLname(request.getParameter("lname"));
		
		MsgUserModel model=new MsgUserLoginDao().MsgUserLogin(lmodel);
		if (model == null) {
			HttpSession session=request.getSession(false);
			session.setAttribute("model", null);
			response.sendRedirect("HomeController.do?action=MsgPassLogi08");			
		}
		else {
			HttpSession session=request.getSession(true);
			session.setAttribute("model", model);
			// response.sendRedirect("HomeController.do?action=showuser&userid="+model.getUserid());
			response.sendRedirect("HomeController.do?action=MsgPassList08&username="+model.getEmail());
		}
		
		
	}

}
