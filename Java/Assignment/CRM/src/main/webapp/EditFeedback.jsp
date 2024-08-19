<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.FeedbackModel"%>
<%@page import="com.dao.FeedbackDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Feedback</title>
</head>
<body>
	<%
	String Feedbackid = request.getParameter("id");
	System.out.println("Feedback id = "+Feedbackid);
	FeedbackModel u = FeedbackDao.getFeedbackByID(Integer.parseInt(Feedbackid));
	%>
	<jsp:include page="HeaderFeedback.html"></jsp:include>
	<div class="container mt-5">
		<form action="EditFeedback1.jsp" method="post">
		<!-- <form method="post" action="FeedbackController"> -->
		<input type="hidden" name="pkFeedbackID" value=Integer.parseInt(Feedbackid)/>

			<div class="mb-3">
				<label for="customeremailid" class="form-label">Customer
					Email ID:</label> <input type="email" class="form-control"
					id="customeremailid" name="customeremailid" value="<%=u.getCustomeremailid()%>">
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">Description :</label> <input
					type="text" class="form-control" id="description"
					name="description" value="<%=u.getDescription()%>">
			</div>
			<div class="mb-3">
				<label for="suggestion" class="form-label">Suggestion:</label> <input
					type="text" class="form-control" id="suggestion" name="suggestion" value="<%=u.getSuggestion()%>">
			</div>
			<button type="submit" class="btn btn-primary">Edit Feedback</button>
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