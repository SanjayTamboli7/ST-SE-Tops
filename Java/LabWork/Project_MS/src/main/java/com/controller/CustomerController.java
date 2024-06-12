package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDao;
import com.model.CustomerModel;
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("register"))
		{
			CustomerModel rmodel=new CustomerModel();
			rmodel.setFirstname(request.getParameter("firstname"));
			rmodel.setLastname(request.getParameter("lastname"));
			rmodel.setMobno(request.getParameter("mobno"));
			rmodel.setAddress(request.getParameter("address"));
			rmodel.setCity(request.getParameter("city"));
			rmodel.setEmail(request.getParameter("email"));
			rmodel.setPassword(request.getParameter("password"));
			rmodel.setStatus("Active");
		
			int x=new CustomerDao().customerRegistration(rmodel);
			if(x>0)
			{
				response.sendRedirect("login.jsp");
			}
			else
			{
				response.sendRedirect("registration.jsp");
			}
		}
		else if(action.equalsIgnoreCase("login"))
		{
			CustomerModel lmodel=new CustomerModel();
			lmodel.setEmail(request.getParameter("email"));
			lmodel.setPassword(request.getParameter("password"));
			
			CustomerModel model=new CustomerDao().customerLogin(lmodel);
			if(model != null)
			{
				HttpSession session=request.getSession(true);
				session.setAttribute("cmodel", model);
				session.setAttribute("firstname", model.getFirstname());
				session.setAttribute("lastname", model.getLastname());
				session.setAttribute("customerid", model.getCustomerid());
				response.sendRedirect("cust-home.jsp");
			}
			else
			{
				request.setAttribute("msg", "Invalid Username or Password...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("Submit"))
		{
			
		}
	}
}
