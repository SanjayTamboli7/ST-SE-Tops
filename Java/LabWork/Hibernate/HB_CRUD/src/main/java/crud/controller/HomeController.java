package crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.dao.HBDao;
import crud.model.UserModel;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
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

		String action=request.getParameter("action");
		if (action.equals("showuser"))
		{
			int userid=Integer.parseInt(request.getParameter("userid"));
			UserModel hmodel=new HBDao().verifyuserLogin(userid);
			request.setAttribute("hmodel", hmodel);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if(action.equals("edituser")) {
			int userid=Integer.parseInt(request.getParameter("userid"));
			UserModel homemodel=new HBDao().verifyuserLogin(userid);
			request.setAttribute("homemodel", homemodel);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if(action.equals("deleteuser")) {
			int userid=Integer.parseInt(request.getParameter("userid"));
			int x=new HBDao().deleteUser(userid);
			request.setAttribute("msg", "Record deleted");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
	}

}
