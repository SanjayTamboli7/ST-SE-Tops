<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.ProjectModel"%>
<%@page import="com.dao.ProjectDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
	<head>
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
			<input type="text" name="pkprojectid" value="<%=p.getPkprojectid()%>">			
			<div class="mb-3">
				<label for="projectname" class="form-label">Project Name :</label> <input
					type="text" class="form-control" id="projectname"
					name="projectname" value="<%=p.getProjectname()%>">
			</div>
			<div class="mb-3">
				<label for="projectdescription" class="form-label">Project
					Description :</label> <input type="text" class="form-control"
					id="projectdescription" name="projectdescription" value="<%=p.getProjectdescription()%>">
			</div>
			<div class="mb-3">
				<label for="fkcustomerid" class="form-label">Customer ID:</label> <input
					type="number" class="form-control" id="fkcustomerid"
					name="fkcustomerid" value="<%=p.getFkcustomerid()%>">
			</div>
			<div class="mb-3">
				<label for="projectduration" class="form-label">Project
					Duration (days) :</label> <input type="number" class="form-control"
					id="projectduration" name="projectduration" value="<%=p.getProjectduration()%>">
			</div>
			<div class="mb-3">
				<label for="projectstartdate" class="form-label">Project
					Start Date :</label> <input type="date" class="form-control"
					id="projectstartdate" name="projectstartdate" value="<%=p.getProjectstartdate()%>">
			</div>
			<div class="mb-3">
				<label for="projectenddate" class="form-label">Project End
					Date :</label> <input type="date" class="form-control" id="projectenddate"
					name="projectenddate" value="<%=p.getProjectenddate()%>">
			</div>
			<div class="mb-3">
				<label for="projectcost" class="form-label">Project Cost (USD) :</label> <input
					type="number" class="form-control" id="projectcost"
					name="projectcost" value="<%=p.getProjectcost()%>">
			</div>
			<div class="mb-3">
				<label for="projectremarks" class="form-label">Project
					Remarks :</label> <input type="text" class="form-control"
					id="projectremarks" name="projectremarks" value="<%=p.getProjectremarks()%>">
			</div>
			<!-- <div class="form-group"> -->
			<div class="mb-3">
				<label for="projectstatus" class="form-label">Project Status :</label>
				<select class="form-control" id="projectstatus"
					name="projectstatus" value="<%=p.getProjectstatus()%>">
					<option value="Pending">Pending</option>
					<option value="In Progress">In Progress</option>
					<option value="Suspended">Suspended</option>
					<option value="Completed">Completed</option>
				</select>
			</div>
			<%-- <div class="mb-3">
				<label for="fkregid" class="form-label">Created By :</label> <input
					type="number" class="form-control" id="fkregid" name="fkregid" value="<%=p.getFkregid()%>">
			</div> --%>
			
 				<div class="mb-3">
					<label for="fkregid" class="form-label">Created By :</label> 
					<select name="fkregid" value="<%=p.getFkregid()%>">
					<%
						Connection cn=new DBUtil().getConnectionData();
						PreparedStatement st=cn.prepareStatement("select pkRegID, UserName from tblregistration where RegistrationType='B' and ActiveFlag='A'");
						ResultSet rs=st.executeQuery();
						while(rs.next())
						{
					%>
							<option value="<%=rs.getInt(1)%>"><%=rs.getString(2) %></option>
					<% 
						}
						cn.close();
					%>
					</select>
				</div>

			<div class="mb-3">
				<label for="CustomerReview" class="form-label">Customer
					Review :</label> <input type="text" class="form-control"
					id="customerreview" name="customerreview" value="<%=p.getCustomerreview()%>"> 
					<input id="createdbyip" type="hidden" value="100.100.100.100" name="createdbyip" />
					<input id="createddatetime" type="hidden" value="2024-07-18" name="createddatetime" />
			</div>
			<button type="submit" class="btn btn-primary">Edit Project</button>
		</form>
	</div>
</body>
</html>