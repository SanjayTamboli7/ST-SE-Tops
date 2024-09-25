package crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import crud.model.Person;

@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyServlet1() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");
		String first_name, last_name, age, profession;
		first_name = request.getParameter("first_name");
		last_name = request.getParameter("last_name");
		age = request.getParameter("age");
		profession = request.getParameter("profession");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		org.hibernate.Transaction tx = null;
		try
		{
			tx = s.beginTransaction();
			Person a = new Person(first_name, last_name, age, profession);
			s.save(a);
			tx.commit();
		} catch (Exception e)
		{
			if (tx != null)
				tx.rollback();
		}
		finally
		{
			if (s != null)
			{
				s.close();
			}
		}
		try (PrintWriter out = response.getWriter())
		{
			out.println("<!DOCTYPE=html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Welcome</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet at  my request at " + first_name + "</h1>");
			out.println("</body>");
			out.println("<html>");
		}
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		String first_name, last_name, age, profession;
		first_name = request.getParameter("first_name");
		last_name = request.getParameter("last_name");
		age = request.getParameter("age");
		profession = request.getParameter("profession");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		org.hibernate.Transaction tx = null;
		try
		{
			tx = s.beginTransaction();
			Person a = new Person(first_name, last_name, age, profession);
			s.save(a);
			tx.commit();
		} catch (Exception e)
		{
			if (tx != null)
				tx.rollback();
		}
		finally
		{
			if (s != null)
			{
				s.close();
			}
		}
		try (PrintWriter out = response.getWriter())
		{
			out.println("<!DOCTYPE=html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Welcome</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet at  my request at " + first_name + "</h1>");
			out.println("</body>");
			out.println("<html>");
		}
	}
}
