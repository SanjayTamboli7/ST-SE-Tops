package module4;

import java.io.IOException;
import java.io.*;  
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 01 Write a Java program to fetch data from web.xml to Servlet using ServletConfig.  
// To test this program, run this servlet direclty.

public class GetDataFromWebXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetDataFromWebXML() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		String userName = config.getInitParameter("userName");
		out.print("User name is "+userName);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
