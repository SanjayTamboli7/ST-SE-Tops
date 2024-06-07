<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Form</title>
</head>
<body>
	<%@page import="com.dao.StudentDao,com.model.Student"%>

	<%
	String id = request.getParameter("id");
	Student u = StudentDao.getRecordById(Integer.parseInt(id));
	%>
	<jsp:include page="Header.html"></jsp:include>
	<div class="col-lg-6 mx-auto">
		<h4 class="display-5 fw-bold text-body-emphasis">Edit User</h4>
		<form action="editstudent.jsp" method="post">
			<input type="hidden" name="id" value="<%=u.getId()%>" />
			<div class="mb-3">
				<label for="fname" class="form-label">First Name:</label> <input
					type="text" class="form-control" id="fname" name="fname"
					value="<%=u.getFname()%>">
			</div>
			<div class="mb-3">
				<label for="lname" class="form-label">Last Name:</label> <input
					type="text" class="form-control" id="lname" name="lname"
					value="<%=u.getLname()%>">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email:</label> <input
					type="email" class="form-control" id="email" name="email"
					value="<%=u.getEmail()%>">
			</div>
			<div class="mb-3">
				<label for="mobile" class="form-label">Mobile:</label> <input
					type="number" class="form-control" id="mobile" name="mobile"
					value="<%=u.getMobile()%>">
			</div>
			<div class="mb-3">
				<label for="gender" class="form-label">Gender:</label> <select
					class="form-select" id="gender" name="gender">
					<option value="Male">Male</option>
					<option value="Female">Female</option>
					<option value="Other">Other</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password:</label> <input
					type="password" class="form-control" id="password" name="password"
					value="<%=u.getPassword()%>">
			</div>
			<button type="submit" class="btn btn-primary">Edit Student</button>
		</form>
	</div>
</body>
</html>