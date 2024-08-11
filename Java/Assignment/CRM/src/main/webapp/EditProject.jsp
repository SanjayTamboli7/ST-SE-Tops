<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.ProjectModel"%>
<%@page import="com.dao.ProjectDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Project</title>
</head>
<body>
	<%
	String Projectid = request.getParameter("id");
	System.out.println("Project id = " + Projectid);
	ProjectModel p = ProjectDao.getProjectByID(Integer.parseInt(Projectid));
	%>
	<jsp:include page="HeaderProject.html"></jsp:include>
	<div class="container mt-5">
		<form action="EditProject1.jsp" method="post">
		<!-- <form method="post" action="ProjectController"> -->
			<div class="mb-3">
				<label for="ProjectName" class="form-label">Project Name :</label> <input
					type="text" class="form-control" id="ProjectName"
					name="ProjectName">
			</div>
			<div class="mb-3">
				<label for="ProjectDescription" class="form-label">Project
					Description :</label> <input type="text" class="form-control"
					id="ProjectDescription" name="ProjectDescription">
			</div>
			<div class="mb-3">
				<label for="fkCustomerID" class="form-label">Customer ID:</label> <input
					type="number" class="form-control" id="fkCustomerID"
					name="fkCustomerID">
			</div>
			<div class="mb-3">
				<label for="ProjectDuration" class="form-label">Project
					Duration (days) :</label> <input type="number" class="form-control"
					id="ProjectDuration" name="ProjectDuration">
			</div>
			<div class="mb-3">
				<label for="ProjectStartDate" class="form-label">Project
					Start Date :</label> <input type="date" class="form-control"
					id="ProjectStartDate" name="ProjectStartDate">
			</div>
			<div class="mb-3">
				<label for="ProjectEndDate" class="form-label">Project End
					Date :</label> <input type="date" class="form-control" id="ProjectEndDate"
					name="ProjectEndDate">
			</div>
			<div class="mb-3">
				<label for="ProjectCost" class="form-label">Project Cost (USD) :</label> <input
					type="number" class="form-control" id="ProjectCost"
					name="ProjectCost">
			</div>
			<div class="mb-3">
				<label for="ProjectRemarks" class="form-label">Project
					Remarks :</label> <input type="text" class="form-control"
					id="ProjectRemarks" name="ProjectRemarks">
			</div>
			<!-- <div class="form-group"> -->
			<div class="mb-3">
				<label for="ProjectStatus" class="form-label">Project Status :</label>
				<select class="form-control" id="ProjectStatus"
					name="ProjectStatus">
					<option value="Pending">Pending</option>
					<option value="In Progress">In Progress</option>
					<option value="Suspended">Suspended</option>
					<option value="Completed">Completed</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="fkregid" class="form-label">Created By :</label> <input
					type="number" class="form-control" id="fkregid" name="fkregid">
				<input id="createddatetime" type="hidden" value="2024-07-12"
					name="createddatetime" /> <input id="createddatetime"
					type="hidden" value="2024-07-18" name="createddatetime" />
			</div>
			<div class="mb-3">
				<label for="CustomerReview" class="form-label">Customer
					Review :</label> <input type="text" class="form-control"
					id="CustomerReview" name="CustomerReview"> <input
					id="CreatedByIP" type="hidden" value="100.100.100.100"
					name="CreatedByIP" />
			</div>
			<button type="submit" class="btn btn-primary">Edit Project</button>
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