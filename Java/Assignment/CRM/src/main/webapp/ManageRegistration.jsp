<%@page import="com	.dao.RegistrationDao"%>
<%@page import="com.model.RegistrationModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
  <!--     
  pkRegID 			(Add mode -> Auto generated. Edit mode -> No change. Access to site visitor.)
  UserName 			(Add mode -> Let site visitor add it.)
  EmailId 			(Add mode -> Let site visitor add it.)
  pwd 				(Add mode -> Let site visitor add it.)
  RegistrationType 	(Add mode -> Let site visitor add it.)
  ActiveFlag 		(Add mode -> By default "A". Edit mode -> Admin can deactivate it.)
  CreatedDateTime	(Add / Edit mode -> It should be system date & time.)	
  CreatedByIP		(Add / Edit mode -> It should be client system's IP address.)      
  -->
  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Registrations</title>
</head>
<body>
	<jsp:include page="HeaderRegistration.html"></jsp:include>
	<div class="px-4 py-5 my-5">
		<div class="col-lg-6 mx-auto">
			<h4 class="display-5 fw-bold text-body-emphasis">All Registrations</h4>
			<%
			List<RegistrationModel> list = RegistrationDao.getAllRegistrations();
			request.setAttribute("list", list);
			%>
			<table class="table table-bordered border-dark table-striped">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email ID</th>
					<th>Type</th>
					<th>Active</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<%
				for (RegistrationModel rm : list) {
				%>
				<tr>
					<td><%=rm.getPkregid()%></td>
					<td><%=rm.getUsername()%></td>
					<td><%=rm.getEmailid()%></td>
					<td><%=rm.getRegistrationtype()%></td>
					<td><%=rm.getActiveflag()%></td>
					<td><a class="btn btn-success"
						href="EditRegistration.jsp?id=<%=rm.getPkregid()%>">Edit</a></td>
					<td><a class="btn btn-danger"
						href="DeleteRegistration.jsp?id=<%=rm.getPkregid()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>

</body>
</html>
