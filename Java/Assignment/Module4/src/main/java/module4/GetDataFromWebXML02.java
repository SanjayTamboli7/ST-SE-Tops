package module4;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 02 Write a Java program to fetch data from web.xml to Servlet using ServletCotext.  

public class GetDataFromWebXML02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetDataFromWebXML02() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		PrintWriter pw=response.getWriter();
		response.setContentType("html/text");
		
		ServletContext context=getServletContext();
		String userName=context.getInitParameter("userName");
		request.setAttribute("msg", "Username is "+userName);
		pw.println("Username is "+userName);
		pw.close();
		
		// doGet(request, response);
	}

}
