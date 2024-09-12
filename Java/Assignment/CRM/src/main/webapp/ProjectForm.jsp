<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>ProjectForm.jsp</title>
	</head>
	<body>
		<div class="container mt-5">
			<!--  <form action="AddProject.jsp" method="post"> -->
			<form method="post" action="ProjectController">
				<div class="mb-3">
					<label for="projectname" class="form-label">Project Name :</label> <input
						type="text" class="form-control" id="projectname"
						name="projectname">
				</div>
				<div class="mb-3">
					<label for="projectdescription" class="form-label">Project
						Description :</label> <input type="text" class="form-control"
						id="projectdescription" name="projectdescription">
				</div>
				
				<!-- <div class="mb-3">
					<label for="fkcustomerid" class="form-label">Customer ID:</label> <input
						type="number" class="form-control" id="fkcustomerid"
						name="fkcustomerid">
				</div> -->

 				<div class="mb-3">
					<label for="fkcustomerid" class="form-label">Customer ID:</label>
					<select name="fkcustomerid">
					<%
						Connection cn=new DBUtil().getConnectionData();
						PreparedStatement st=cn.prepareStatement("select pkCustomerID, CustomerName from tblcustomer");
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
					<label for="projectduration" class="form-label">Project
						Duration (days) :</label> <input type="number" class="form-control"
						id="projectduration" name="projectduration">
				</div>
				<div class="mb-3">
					<label for="projectstartdate" class="form-label">Project
						Start Date :</label> <input type="date" class="form-control"
						id="projectstartdate" name="projectstartdate">
				</div>
				<div class="mb-3">
					<label for="projectenddate" class="form-label">Project End
						Date :</label> <input type="date" class="form-control" id="projectenddate"
						name="projectenddate">
				</div>
				<div class="mb-3">
					<label for="projectcost" class="form-label">Project Cost (USD) :</label> <input
						type="number" class="form-control" id="projectcost"
						name="projectcost">
				</div>
				<div class="mb-3">
					<label for="projectremarks" class="form-label">Project
						Remarks :</label> <input type="text" class="form-control"
						id="projectremarks" name="projectremarks">
				</div>
				<div class="mb-3">
					<label for="projectstatus" class="form-label">Project Status :</label>
					<select class="form-control" id="projectstatus"
						name="projectstatus">
						<option value="Pending">Pending</option>
						<option value="In Progress">In Progress</option>
						<option value="Suspended">Suspended</option>
						<option value="Completed">Completed</option>
					</select>
				</div>
				<!-- <div class="mb-3">
					<label for="fkregid" class="form-label">Created By :</label> <input
						type="number" class="form-control" id="fkregid" name="fkregid">
					
				</div> -->
				<div class="mb-3">
					<label for="fkregid" class="form-label">Created By :</label> 
					<select name="fkregid">
					<%
						Connection cnf=new DBUtil().getConnectionData();
						PreparedStatement stf=cnf.prepareStatement("select pkRegID, UserName from tblregistration where RegistrationType='C' and ActiveFlag='A'");
						ResultSet rsf=stf.executeQuery();
						while(rsf.next())
						{
					%>
							<option value="<%=rsf.getInt(1)%>"><%=rsf.getString(2) %></option>
					<% 
						}
						cn.close();
					%>
					</select>
				</div>				
				<div class="mb-3">
					<label for="customerreview" class="form-label">Customer
						Review :</label> <input type="text" class="form-control"
						id="customerreview" name="customerreview"> 
						<input id="createddatetime" type="hidden" value="2024-07-12"
						name="createddatetime" /> 
						<input id="createdbyip" type="hidden" value="100.100.100.100"
						name="createdbyip" />
				</div>
				<button type="submit" class="btn btn-primary">Add Project</button>
			</form>
		</div>
	</body>
</html>