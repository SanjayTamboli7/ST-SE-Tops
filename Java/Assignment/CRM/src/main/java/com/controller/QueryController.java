package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.QueryDao;
import com.model.QueryModel;

@WebServlet("/QueryController")
public class QueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryController() {
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
		QueryModel fmodel = new QueryModel();
		
		fmodel.setCustomeremailid(request.getParameter("customeremailid"));
		fmodel.setDescription(request.getParameter("description"));
		fmodel.setSuggestion(request.getParameter("suggestion"));
		fmodel.setResponse(request.getParameter("response"));
		fmodel.setFkresponseid(Integer.parseInt(request.getParameter("fkresponseid")));
		// fmodel.setFkregid(Integer.parseInt("fkRegID"));
		fmodel.setFkregid(7);	
		fmodel.setResponsedate(request.getParameter("ResponseDate"));
		fmodel.setCreateddatetime(request.getParameter("CreatedDateTime"));
		fmodel.setCreatedbyip(request.getParameter("CreatedByIP"));
		
		int x = new QueryDao().saveQuery(fmodel);
		if (x > 0) {
			request.setAttribute("msg", "Record inserted.");
		} else {
			request.setAttribute("msg", "Record not inserted.");
		}
		request.getRequestDispatcher("ManageQuery.jsp").forward(request, response);
	}

}
