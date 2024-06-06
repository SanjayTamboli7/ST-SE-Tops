package com.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.random.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.ForgotDao;
import com.model.CustomerModel;

public class ForgotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ForgotController() {
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
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("submit")) {
			String email = request.getParameter("email");
			CustomerModel f = new CustomerModel();
			ForgotDao dao = new ForgotDao();
			f = dao.checkEmail(email);
			if (f == null) {
				request.setAttribute("invalidemail", "Invalid email address");
				request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
			} else {
				String emailid = f.getEmail();
				String username = f.getFirstname() + " " + f.getLastname();
				final String senderid = "contactsrtz@gmail.com";
				final String password = "degdtazqlwellaoe";
				Properties props = new Properties();
				String host = "smtp.gmail.com";

				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.socketFactory.fallback", "true");
				props.put("mail.smtp.ssl.protocols", "TLSv1.2");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.debug", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "465");
				props.put("mail.smtp.user", senderid);
				props.put("mail.smtp.password", password);

				Session session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderid, password);
					}
				});
				try {
					Random rand=new Random();
					int otp=rand.nextInt(900000)+100000;
					Message message=new MimeMessage(session);
					message.setFrom(new InternetAddress(senderid));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailid));
					message.setSubject("OTP Request");
					String msg1 = "<!DOCTYPE html><html><head></head><body><center><div style='background-color:#f8f8f8; width:500px; height:200px'><div style='background-color:#00e58b; width:500px; height:50px'><h3 style='color:white; padding-top:10px;'>EmailDemo.com </h3></div><p style='color:gray; margin-left:-300px;'>Dear "
							+ username + ",</p><br><p style='color:gray; margin-top:-10px;'>" + otp
							+ "  is your One Time Password.Do NOT share this code with anyone for security reasons.this is valid for 10 minutes.</p><div></center></body></html>";
					message.setContent(msg1,"text/html; charset=utf-8");
					Transport.send(message);
					HttpSession otpsession=request.getSession();
					otpsession.setAttribute("otp", otp);
					otpsession.setMaxInactiveInterval(10 * 60);
					otpsession.setAttribute("UserData", f);
					request.getRequestDispatcher("forgot");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
