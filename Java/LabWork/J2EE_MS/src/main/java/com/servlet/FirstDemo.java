package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet("/FirstDemo")*/
public class FirstDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FirstDemo() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html"); // encoding
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello, How are you?</h1>");
		String name=request.getParameter("name");
		out.print("<br>Your name is.. "+name);
		//doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html"); // encoding
		PrintWriter out = response.getWriter();
		int a= Integer.parseInt(request.getParameter("no1"));
		int b= Integer.parseInt(request.getParameter("no2"));
		out.println("Sum is.. "+(a+b));
	}

}
