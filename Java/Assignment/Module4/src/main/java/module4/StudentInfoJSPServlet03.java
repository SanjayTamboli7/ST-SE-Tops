package module4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Write a Java program to submit student information (fname, lname, email, mobile, gender, password) 
// using jsp form to servlet. Fetch data at servlet and print all the data in console.

public class StudentInfoJSPServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentInfoJSPServlet03() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		PrintWriter pw=response.getWriter();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String gender=request.getParameter("gender");
		String password=request.getParameter("password");
		
		pw.println("First name is " + firstname);
		pw.println("Last name is " + lastname);
		pw.println("Email is " + email);
		pw.println("Mobile is " + mobile);
		pw.println("Gender is " + gender);
		pw.println("Password is " + password);
		
	}

}
