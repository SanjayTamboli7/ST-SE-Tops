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
				<label for="pkQueryID" class="form-label">Query ID:</label>
				<input id="pkQueryID" type=number name="pkQueryID" value="<%=u.getPkQueryID()%>"/>
			</div>
			<div class="mb-3">
				<label for="CustomerEmailID" class="form-label">Customer
					Email ID:</label> <input type="email" class="form-control"
					id="CustomerEmailID" name="CustomerEmailID" value="<%=u.getCustomerEmailID()%>">
			</div>
			<div class="mb-3">
				<label for="Description" class="form-label">Description :</label> <input
					type="text" class="form-control" id="Description"
					name="Description" value="<%=u.getDescription()%>">
			</div>
			<div class="mb-3">
				<label for="Suggestion" class="form-label">Suggestion:</label> <input
					type="text" class="form-control" id="Suggestion" name="Suggestion" value="<%=u.getSuggestion()%>">
			</div>
			<div class="mb-3">
				<label for="Response" class="form-label">Response:</label> <input
					type="text" class="form-control" id="Response" name="Response" value="<%=u.getResponse()%>">
			</div>
			<div class="mb-3">
				<label for="fkResponseID" class="form-label">Response From:</label>
				<input type="number" class="form-control" id="fkResponseID"
					name="fkResponseID" value="<%=u.getFkResponseID()%>">
			</div>
			<div class="mb-3">
				<label for="fkRegID" class="form-label">Query From:</label> <input
					type="number" class="form-control" id="fkRegID" name="fkRegID" value="<%=u.getFkRegID()%>">
				<input id="CreatedDateTime" type="hidden" value="2024-07-18"
					name="CreatedDateTime" />
			</div>
			<div class="mb-3">
				<label for="ResponseDate" class="form-label">Response On:</label> <input
					type="date" class="form-control" id="ResponseDate"
					name="ResponseDate" value="<%=u.getResponseDate()%>"> <input id="CreatedByIP" type="hidden"
					value="100.100.100.100" name="CreatedByIP" />
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