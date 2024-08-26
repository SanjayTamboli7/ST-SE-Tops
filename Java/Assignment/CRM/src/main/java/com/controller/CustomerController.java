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
		cmodel.setCustomerName(request.getParameter("CustomerName"));
		cmodel.setCustomerEmailID(request.getParameter("CustomerEmailID"));
		cmodel.setCustomerContactNo(request.getParameter("CustomerContactNo"));	
		cmodel.setCustomerAddress(request.getParameter("CustomerAddress"));
		cmodel.setCustomerCity(request.getParameter("CustomerCity"));
		cmodel.setCustomerState(request.getParameter("CustomerState"));
		cmodel.setCustomerCountry(request.getParameter("CustomerCountry"));
		// cmodel.setFkRegID(Integer.parseInt("fkRegID"));
		cmodel.setFkRegID(9);	
		cmodel.setCreatedDateTime(request.getParameter("CreatedDateTime"));
		cmodel.setCreatedByIP(request.getParameter("CreatedByIP"));
						
		int x = new CustomerDao().saveCustomer(cmodel);
		if (x > 0) {
			request.setAttribute("msg", "Record inserted.");
		} else {
			request.setAttribute("msg", "Record not inserted.");
		}
		request.getRequestDispatcher("ManageCustomer.jsp").forward(request, response);
	}

}
