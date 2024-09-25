<%@page import="crud.dao.QryDao"%>
<%@page import="crud.model.QueryModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>  
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Registrations</title>
	</head>
<body>
	<jsp:include page="HeaderQuery.html"></jsp:include>
	<div class="px-4 py-5 my-5">
		<div class="col-lg-6 mx-auto">
			<h4 class="display-5 fw-bold text-body-emphasis">All Registrations</h4>
			<%
			List<QueryModel> list = QryDao.getAllQueries();
			request.setAttribute("list", list);
			%>
			<table class="table table-bordered border-dark table-striped">
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>Suggestion</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<%
				for (QueryModel qm : list) {
				%>
				<tr>
					<td><%=qm.getPkqueryid()%></td>
					<td><%=qm.getDescription()%></td>
					<td><%=qm.getSuggestion()%></td>
					<%-- <td><a class="btn btn-success"
						href="EditRegistration.jsp?id=<%=rm.getPkregid()%>">Edit</a></td>
					<td><a class="btn btn-danger"
						href="DeleteRegistration.jsp?id=<%=rm.getPkregid()%>">Delete</a></td> --%>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>

</body>
</html>
