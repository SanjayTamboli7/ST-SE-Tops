<%@page import="com.dao.FeedbackDao"%>
<%@page import="com.model.FeedbackModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>

<title>View Feedbacks</title>
</head>
<body>
	<jsp:include page="HeaderFeedback.html"></jsp:include>
	<div class="px-4 py-5 my-5">
		<div class="col-lg-6 mx-auto">
			<h4 class="display-5 fw-bold text-body-emphasis">All Feedbacks</h4>
			<%
			List<FeedbackModel> list = FeedbackDao.getAllFeedbacks();
			request.setAttribute("list", list);
			%>
			<table class="table table-bordered border-dark table-striped">
				<tr>
					<th>Feedback ID</th>
					<th>Customer Email</th>
					<th>Description</th>
					<th>Suggestion</th>
					<th>From</th>
					<th>Create date</th>
					<th>On IP</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<%
				for (FeedbackModel u : list) {
				%>
				<tr>
					<td><%=u.getPkfeedbackid()%></td>
					<td><%=u.getCustomeremailid()%></td>
					<td><%=u.getDescription()%></td>
					<td><%=u.getSuggestion()%></td>
					<td><%=u.getFkregid()%></td>
					<td><%=u.getCreateddatetime()%></td>
					<td><%=u.getCreatedbyip()%></td>
					<td><a class="btn btn-success"
						href="EditFeedback.jsp?id=<%=u.getPkfeedbackid()%>">Edit</a></td>
					<td><a class="btn btn-danger"
						href="deleteuser.jsp?id=<%=u.getPkfeedbackid()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>