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
		pmodel.setProjectName(request.getParameter("ProjectName"));
		pmodel.setProjectDescription(request.getParameter("ProjectDescription"));
		pmodel.setFkCustomerID(Integer.parseInt(request.getParameter("fkCustomerID")));
		pmodel.setProjectDuration(Integer.parseInt(request.getParameter("ProjectDuration")));
		pmodel.setProjectStartDate(request.getParameter("ProjectStartDate"));
		pmodel.setProjectEndDate(request.getParameter("ProjectEndDate"));
		pmodel.setProjectCost(Integer.parseInt(request.getParameter("ProjectCost")));
		pmodel.setProjectRemarks(request.getParameter("ProjectRemarks"));
		pmodel.setProjectStatus(request.getParameter("ProjectStatus"));
		// pmodel.setFkRegID(Integer.parseInt("fkRegID"));
		pmodel.setFkRegID(9);	
		pmodel.setCustomerReview(request.getParameter("CustomerReview"));
		pmodel.setCreatedDateTime(request.getParameter("CreatedDateTime"));
		pmodel.setCreatedByIP(request.getParameter("CreatedByIP"));
				
		int x = new ProjectDao().saveProject(pmodel);
		if (x > 0) {
			request.setAttribute("msg", "Record inserted.");
		} else {
			request.setAttribute("msg", "Record not inserted.");
		}
		request.getRequestDispatcher("ManageProject.jsp").forward(request, response);
	}

}
