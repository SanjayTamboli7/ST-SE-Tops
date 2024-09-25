package crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.dao.HBDao;
import crud.model.UserModel;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
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
		UserModel lmodel=new UserModel();
		lmodel.setUsername(request.getParameter("username"));
		lmodel.setPassword(request.getParameter("password"));
		
		UserModel model=new HBDao().userLogin(lmodel);
		if (model!=null) {
			HttpSession sess=request.getSession(true);
			sess.setAttribute("model", model);
			response.sendRedirect("HomeController?action=showuser&userid="+model.getUserid());
			
		} else {
			request.setAttribute("msg", "Invalid username or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
