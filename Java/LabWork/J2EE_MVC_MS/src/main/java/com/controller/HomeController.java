package com.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.HomeDao;
import com.model.UserModel;

import java.io.IOException;

public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if (action.equals("showuser")) 
		{
			int userid = Integer.parseInt(request.getParameter("userid"));
			UserModel model=new HomeDao().userVerifyLogin(userid);
			request.setAttribute("model", model);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else if (action.equals("edituser")) {
			int userid = Integer.parseInt(request.getParameter("userid"));
			UserModel model=new HomeDao().userVerifyLogin(userid);
			request.setAttribute("hmodel", model);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else if (action.equals("deleteuser")) {
			int userid = Integer.parseInt(request.getParameter("userid"));
			int x=new HomeDao().deleteUser(userid);
			if (x>0) {
				request.setAttribute("msg", "Record deleted...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		UserModel hmodel = new UserModel();
		hmodel.setUserid(Integer.parseInt(request.getParameter("userid")));
		hmodel.setFirstname(request.getParameter("firstname"));
		hmodel.setLastname(request.getParameter("lastname"));
		hmodel.setUsername(request.getParameter("username"));
		hmodel.setPassword(request.getParameter("password"));
		
		int x=new HomeDao().updateUser(hmodel);
		if (x>0) {
			response.sendRedirect("HomeController.do?action=showuser&userid="+hmodel.getUserid());
		}
		
	}

}
