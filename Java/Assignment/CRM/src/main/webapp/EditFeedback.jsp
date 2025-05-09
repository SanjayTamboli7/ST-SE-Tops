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
		<form action="EditFeedback1.jsp">
		<!-- <form method="post" action="FeedbackController"> -->
		<input type="text" name="pkfeedbackid" value="<%=u.getPkfeedbackid()%>">

			<div class="mb-3">
				<label for="customeremailid" class="form-label">Customer
					Email ID:</label> <input type="email" class="form-control"
					id="customeremailid" name="customeremailid" value="<%=u.getCustomeremailid()%>">
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">Description :</label> <input
					type="text" class="form-control" id="description"
					name="description" value="<%=u.getDescription()%>">
                    <input id="createddatetime" type="hidden" value="2024-07-18" name="createddatetime"/>
			</div>
			<div class="mb-3">
				<label for="suggestion" class="form-label">Suggestion:</label> <input
					type="text" class="form-control" id="suggestion" name="suggestion" value="<%=u.getSuggestion()%>">
                    <input id="createdbyip" type="hidden" value="100.100.100.100" name="createdbyip"/>
			</div>
			<button type="submit" class="btn btn-primary">Edit Feedback</button>
		</form>
	</div>
</body>
</html>