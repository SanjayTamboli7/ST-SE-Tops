package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.LoginDao;
import com.model.UserModel;

public class LoginController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel lmodel=new UserModel();
		lmodel.setUsername(request.getParameter("username"));
		lmodel.setPassword(request.getParameter("password"));
		
		UserModel model = new LoginDao().userLogin(lmodel);
		if (model != null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("model", model);
			response.sendRedirect("HomeController.do?action=showuser&userid="+model.getUserid());
		}
	}

}
