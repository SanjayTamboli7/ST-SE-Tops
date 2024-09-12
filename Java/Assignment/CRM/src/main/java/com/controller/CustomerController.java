package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.model.CustomerModel;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerController() {
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
		
		CustomerModel cmodel=new CustomerModel();		
		cmodel.setCustomername(request.getParameter("customername"));
		cmodel.setCustomeremailid(request.getParameter("customeremailid"));
		cmodel.setCustomercontactno(request.getParameter("customercontactno"));	
		cmodel.setCustomeraddress(request.getParameter("customeraddress"));
		cmodel.setCustomercity(request.getParameter("customercity"));
		cmodel.setCustomerstate(request.getParameter("customerstate"));
		cmodel.setCustomercountry(request.getParameter("customercountry"));
		// cmodel.setFkregid(Integer.parseInt("fkRegID"));
		cmodel.setFkregid(9);	
		cmodel.setCreateddatetime(request.getParameter("createddatetime"));
		cmodel.setCreatedbyip(request.getParameter("createdbyip"));
						
		int x = new CustomerDao().saveCustomer(cmodel);
		if (x > 0) {
			request.setAttribute("msg", "Record inserted.");
		} else {
			request.setAttribute("msg", "Record not inserted.");
		}
		request.getRequestDispatcher("ManageCustomer.jsp").forward(request, response);
	}

}
