package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import com.dao.AdminDao;
import com.model.ServicesModel;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, // 512 MB)
maxFileSize = 1024 * 1024 * 512, // 512 MB
maxRequestSize  = 1024 * 1024 * 512) // 512 MB

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String extractfilename(Part file) {
    	String cd=file.getHeader("content-disposition");
    	System.out.println(cd);
    	String [] items=cd.split(";");
    	for (String string : items) {
    		if (string.trim().startsWith("filename")) {
    			return string.substring(string.indexOf("=")+2, string.length()-1);
    		}
    	}
		return "";
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if (action.equals("login")) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if (username.equals("admin") && password.equals("admin")) {
				response.sendRedirect("admin/dashboard.jsp");
			}
		}
		else if(action.equals("addmainservices")) {
			ServicesModel sm=new ServicesModel();
			sm.setServicename(request.getParameter("servicename"));
			String savePath = "E:\\Tops-Tech\\ST-SE-Tops\\Java\\LabWork\\Project_MS\\src\\main\\webapp\\images";
			File fileSaveDir=new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();				
			}
			Part file=request.getPart("image");
			String fileName=extractfilename(file);
			file.write(savePath+File.separator+fileName);
			
			sm.setImage(fileName);
			
			int x=new AdminDao().addMainServices(sm);
			if (x>0) {
				response.sendRedirect("admin/dashboard.jsp");
			} 
			else {
				response.sendRedirect("admin/addmainservices.jsp");

			}
			
		}
	}

}
