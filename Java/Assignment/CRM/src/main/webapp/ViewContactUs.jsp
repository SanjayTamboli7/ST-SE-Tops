<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.ContactUsModel"%>
<%@page import="com.dao.ContactUsDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View ContactUs</title>
</head>
<body>
	<%
	String ContactUsid = request.getParameter("id");
	System.out.println("ContactUs id = " + ContactUsid);
	ContactUsModel p = ContactUsDao.getContactUsByID(Integer.parseInt(ContactUsid));
	%>
	<jsp:include page="HeaderContactUs.html"></jsp:include>
	<div class="container mt-5">
		<form action="ManageContactUs.jsp" method="post">
		<!-- <form method="post" action="ContactUsController"> -->
				<input type="text" name="pkContactUsID" value="<%=p.getPkContactUsID()%>">	
				<div class="mb-3">
					<label for="YourName" class="form-label">Your Name :</label>
					<input type="text" class="form-control" id="YourName"
						name="YourName" value="<%=p.getYourName()%>" disabled>
				</div>
				<div class="mb-3">
					<label for="YourEmailID" class="form-label">Your
						Email :</label> <input type="email" class="form-control"
						id="YourEmailID" name="YourEmailID" value="<%=p.getYourEmailID()%>" disabled>
				</div>
				<div class="mb-3">
					<label for="YourMessage" class="form-label">Your Message :</label> <input
						type="text" class="form-control" id="YourMessage"
						name="YourMessage" value="<%=p.getYourMessage()%>" disabled>
				</div>
			<button type="submit" class="btn btn-primary">View All</button>
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