package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HBDao;
import com.model.UserModel;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action=request.getParameter("action");
	if (action.equals("showuser"))
	{
		int userid=Integer.parseInt(request.getParameter("userid"));
		UserModel hmodel=new HBDao().verifyuserLogin(userid);
		request.setAttribute("hmodel", hmodel);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	} else if(action.equals("edituser")) {
		int userid=Integer.parseInt(request.getParameter("userid"));
		UserModel homemodel=new HBDao().verifyuserLogin(userid);
		request.setAttribute("homemodel", homemodel);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	} else if(action.equals("deleteuser")) {
		int userid=Integer.parseInt(request.getParameter("userid"));
		int x=new HBDao().deleteUser(userid);
		request.setAttribute("msg", "Record deleted");
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel hmodel=new UserModel();
		hmodel.setUserid(Integer.parseInt(request.getParameter("userid")));
		hmodel.setFirstname(request.getParameter("firstname"));
		hmodel.setLastname(request.getParameter("lastname"));
		hmodel.setUsername(request.getParameter("username"));
		hmodel.setPassword(request.getParameter("password"));
		int x=new HBDao().updateUser(hmodel);
		if (x>0) {
			request.setAttribute("msg", "Record updated");
			response.sendRedirect("HomeController?action=showuser&userid="+hmodel.getUserid());
		}
	}

}
