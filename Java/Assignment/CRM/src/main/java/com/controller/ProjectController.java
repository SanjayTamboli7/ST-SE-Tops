package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProjectDao;
import com.model.ProjectModel;

@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectController() {
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
		
		ProjectModel pmodel=new ProjectModel();
		pmodel.setProjectname(request.getParameter("projectname"));
		pmodel.setProjectdescription(request.getParameter("projectdescription"));
		pmodel.setFkcustomerid(Integer.parseInt(request.getParameter("fkcustomerid")));
		pmodel.setProjectduration(Integer.parseInt(request.getParameter("projectduration")));
		pmodel.setProjectstartdate(request.getParameter("projectstartdate"));
		pmodel.setProjectenddate(request.getParameter("projectenddate"));
		pmodel.setProjectcost(Integer.parseInt(request.getParameter("projectcost")));
		pmodel.setProjectremarks(request.getParameter("projectremarks"));
		pmodel.setProjectstatus(request.getParameter("projectstatus"));
		// pmodel.setFkRegID(Integer.parseInt("fkRegID"));
		pmodel.setFkregid(9);	
		pmodel.setCustomerreview(request.getParameter("customerreview"));
		pmodel.setCreateddatetime(request.getParameter("createddatetime"));
		pmodel.setCreatedbyip(request.getParameter("createdbyip"));
				
		int x = new ProjectDao().saveProject(pmodel);
		if (x > 0) {
			request.setAttribute("msg", "Record inserted.");
		} else {
			request.setAttribute("msg", "Record not inserted.");
		}
		request.getRequestDispatcher("ManageProject.jsp").forward(request, response);
	}

}
