<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.RegistrationModel"%>
<%@page import="com.dao.RegistrationDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Registration</title>
</head>
<body>
	<%
	String RegID = request.getParameter("id");
	System.out.println("Registration id = " + RegID);
	RegistrationModel p = RegistrationDao.getRegistrationByID(Integer.parseInt(RegID));
	%>
	<jsp:include page="HeaderRegistration.html"></jsp:include>
	<div class="container mt-5">
		<form action="EditRegistration1.jsp" method="post">
		<!-- <form method="post" action="RegistrationController"> -->
				 <input type="text" name="pkregid" value="<%=p.getPkregid()%>">	
                  <div class="form-group">
                  	<label for="emailid" class="form-label">Email ID :</label>
                    <input class="form-control" id="emailid" type="text" name="emailid" placeholder="Email Id" value="<%=p.getEmailid()%>"/>
                    <%-- value="<%=p.getEmailid()%>" --%>
                    <br>
                  </div>
                  <div class="form-group">
                  	<label for="username" class="form-label">User Name :</label>
                    <input class="form-control" id="username" type="text" name="username" placeholder="Username" value="<%=p.getUsername()%>"/>
                    <br>
                  </div>                  
				  <div class="form-group">
				  	<label for="registrationtype" class="form-label">Registration Type :</label>
					<select class="form-control" id="registrationtype" name="registrationtype" value="<%=p.getRegistrationtype()%>">
						<option value="B">Business Development Executive</option>
						<option value="C">Customer</option>
					</select>
                    <input id="activeflag" type="hidden" value="A" name="activeflag"/>
                    <br>
				  </div>								
				  <div class="form-group">
				  	<label for="pwd" class="form-label">Password :</label>
                    <input class="form-control" id="pwd" type="password" name="pwd" placeholder="Password" value="<%=p.getPwd()%>"/>
                    <input id="createddatetime" type="hidden" value="2024-08-17 15:15" name="createddatetime"/>
                    <br>
                  </div>
                  <div class="form-group">
                  	<label for="re-password" class="form-label">Confirm Password :</label>
                    <input class="form-control" id="re-password" type="password" name="re-password" placeholder="Re-enter Password" value="<%=p.getPwd()%>"/>
                    <input id="createdbyip" type="hidden" value="100.100.100.100" name="createdbyip"/>
                    <br>
                  </div>				
			<button type="submit" class="btn btn-primary">Edit Registration</button>
		</form>
	</div>
</body>
</html>
