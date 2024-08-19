package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ContactUsDao;
import com.model.ContactUsModel;

@WebServlet("/ContactUsController")
public class ContactUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactUsController() {
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

		ContactUsModel cumodel=new ContactUsModel();		
		
		cumodel.setYourName(request.getParameter("YourName"));
		cumodel.setYourEmailID(request.getParameter("YourEmailID"));
		cumodel.setYourMessage(request.getParameter("YourMessage"));				
		cumodel.setCreatedDateTime(request.getParameter("CreatedDateTime"));
		cumodel.setCreatedByIP(request.getParameter("CreatedByIP"));
						
		int x = new ContactUsDao().saveContactUs(cumodel);
		if (x > 0) {
			request.setAttribute("msg", "Record inserted.");
		} else {
			request.setAttribute("msg", "Record not inserted.");
		}
		// request.getRequestDispatcher("ManageContactUs.jsp").forward(request, response);
		
	}

}
