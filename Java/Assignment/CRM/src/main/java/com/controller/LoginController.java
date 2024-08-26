package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.model.RegistrationModel;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
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
		RegistrationModel lmodel=new RegistrationModel();
		lmodel.setUsername(request.getParameter("username"));
		lmodel.setPwd(request.getParameter("password"));
		
		RegistrationModel model=new LoginDao().userLogin(lmodel);
		if (model != null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("model", model);
			response.sendRedirect("HomeController.do?action=index&username="+model.getUsername()); 
		}
		// write a code to insert a record into tblLogin
		else {
			
		}
	}

}
