<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.QueryModel"%>
<%@page import="com.dao.QueryDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Query</title>
</head>
<body>
	<%
	String Queryid = request.getParameter("id");
	System.out.println("Query id = " + Queryid);
	QueryModel u = QueryDao.getQueryByID(Integer.parseInt(Queryid));
	%>
	<jsp:include page="HeaderQuery.html"></jsp:include>
	<div class="container mt-5">
		<form action="EditQuery1.jsp" method="post">
		<!-- <form method="post" action="QueryController"> -->
			<div class="mb-3">
				<label for="customeremailid" class="form-label">Customer
					Email ID:</label> <input type="email" class="form-control"
					id="customeremailid" name="customeremailid">
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">Description :</label> <input
					type="text" class="form-control" id="description"
					name="description">
			</div>
			<div class="mb-3">
				<label for="suggestion" class="form-label">Suggestion:</label> <input
					type="text" class="form-control" id="suggestion" name="suggestion">
			</div>
			<div class="mb-3">
				<label for="response" class="form-label">Response:</label> <input
					type="text" class="form-control" id="response" name="response">
			</div>
			<div class="mb-3">
				<label for="fkresponseid" class="form-label">Response From:</label>
				<input type="number" class="form-control" id="fkresponseid"
					name="fkresponseid">
			</div>
			<div class="mb-3">
				<label for="fkregid" class="form-label">Query From:</label> <input
					type="number" class="form-control" id="fkregid" name="fkregid">
				<input id="createddatetime" type="hidden" value="2024-07-18"
					name="createddatetime" />
			</div>
			<div class="mb-3">
				<label for="responsedate" class="form-label">Response On:</label> <input
					type="date" class="form-control" id="responsedate"
					name="responsedate"> <input id="createdbyip" type="hidden"
					value="100.100.100.100" name="createdbyip" />
			</div>
			<button type="submit" class="btn btn-primary">Edit Query</button>
		</form>
	</div>

	<%-- 	
	<div class="col-lg-6 mx-auto">
		<h4 class="display-5 fw-bold text-body-emphasis">Edit User</h4>
		<form action="edituser.jsp" method="post">
			<input type="hidden" name="id" value="<%=u.getId()%>" />
			<div class="mb-3">
				<label for="name" class="form-label">Name:</label> <input
					type="text" class="form-control" id="name" name="name"
					value="<%=u.getClass()%>">
			</div>
			<button type="submit" class="btn btn-primary">Edit User</button>
		</form>
	</div>
 --%>

</body>
</html>