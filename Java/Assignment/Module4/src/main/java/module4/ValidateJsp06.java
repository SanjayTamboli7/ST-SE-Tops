package module4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ValidateJsp06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValidateJsp06() {
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
		if (firstname.length() <= 5) {
			/* pw.println("Firstname contains Number..."); */
			request.setAttribute("msg", "FirstName contains Numbers...");
		}
		pw.println("Last name is " + lastname);
		if (lastname.length() <= 7 ) {
			pw.println("Lastname must be atleast 7 character long...");
		}
		pw.println("Email is " + email);
		pw.println("Mobile is " + mobile);
		if (mobile.length() != 10 ) {
			pw.println("Mobile number should have 10 digits...");
		}
		pw.println("Gender is " + gender);
		if (gender != "Male" || gender != "Female") {
			pw.println("Gender should be either Male or Female");
		}
		pw.println("Password is " + password);
		if (password.length() <= 7 ) {
			pw.println("Password must be atleast 8 character long...");
		}
		request.getRequestDispatcher("Validatejsp06.jsp").forward(request, response);
	}

}
