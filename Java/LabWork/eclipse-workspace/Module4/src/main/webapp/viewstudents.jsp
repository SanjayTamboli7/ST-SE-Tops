<%@page import="com.dao.StudentDao"%>
<%@page import="com.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students</title>
</head>
<body>


	<jsp:include page="Student08.html"></jsp:include>

	<div class="px-4 py-5 my-5">
		<div class="col-lg-6 mx-auto">
			<h4 class="display-5 fw-bold text-body-emphasis">All Students</h4>


			<%
			List<Student> list = StudentDao.getAllRecords();
			request.setAttribute("list", list);
			%>

			<table class="table table-bordered border-dark table-striped">
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Gender</th>
					<th>Password</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<%
				for (Student u : list) {
				%>
				<tr>
					<td><%=u.getId()%></td>
					<td><%=u.getFname()%></td>
					<td><%=u.getLname()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getMobile()%></td>
					<td><%=u.getGender()%></td>
					<td><%=u.getPassword()%></td>
					<td><a class="btn btn-success"
						href="editformstudent.jsp?id=<%= u.getId()%>">Edit</a></td>
					<td><a class="btn btn-danger"
						href="deletestudent.jsp?id=<%= u.getId()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>

</body>
</html>
