package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FeedbackDao;
import com.model.FeedbackModel;

@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FeedbackController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

		FeedbackModel fmodel = new FeedbackModel();
		
		fmodel.setCustomeremailid(request.getParameter("customeremailid"));
		fmodel.setDescription(request.getParameter("description"));
		fmodel.setSuggestion(request.getParameter("suggestion"));
		// fmodel.setFkregid(Integer.parseInt("fkregid"));
		fmodel.setFkregid(7);		
		fmodel.setCreateddatetime(request.getParameter("createddatetime"));
		// fmodel.setCreateddatetime("21-07-2024 00:00");
		fmodel.setCreatedbyip(request.getParameter("createdbyip"));
		// fmodel.setCreatedbyip("102.102.102.102");
		
		int x = new FeedbackDao().saveFeedback(fmodel);
		if (x > 0) {
			request.setAttribute("msg", "Record inserted.");
		} else {
			request.setAttribute("msg", "Record not inserted.");
		}
		// request.getRequestDispatcher("index.jsp").forward(request, response);

	}
}
