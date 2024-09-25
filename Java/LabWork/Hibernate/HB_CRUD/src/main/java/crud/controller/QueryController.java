package crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.dao.QryDao;
import crud.model.QueryModel;

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
		
		QueryModel rmodel=new QueryModel();
		
		rmodel.setCustomeremailid(request.getParameter("customeremailid"));
		rmodel.setDescription(request.getParameter("description"));
		rmodel.setSuggestion(request.getParameter("suggestion"));
		
		String msg=new QryDao().queryRegistration(rmodel);
		if (msg.equals("Ok"))
		{
			request.setAttribute("msg", msg);
			/* request.getRequestDispatcher("CRUDQuery.jsp").forward(request, response); */
		} else {
			request.setAttribute("msg", "Query is not added.");
			/* request.getRequestDispatcher("CRUDQuery.jsp").forward(request, response); */
		}
		request.getRequestDispatcher("CRUDQuery.jsp").forward(request, response);
	}

}
