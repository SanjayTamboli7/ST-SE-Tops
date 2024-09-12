<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>QueryForm.jsp</title>
	</head>
	<body>
		<div class="container mt-5">
			<!--  <form action="AddQuery.jsp" method="post"> -->
			<form method="post" action="QueryController">
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
					<input id="createddatetime" type="hidden" value="2024-07-18"
						name="createddatetime" />	
				</div>
				<!-- <div class="mb-3">
					<label for="fkresponseid" class="form-label">Response From:</label>
					<input type="number" class="form-control" id="fkresponseid"
						name="fkresponseid">
				</div> -->
				<div class="mb-3">
					<label for="fkresponseid" class="form-label">Response From:</label>
					<select name="fkresponseid">
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
					<label for="responsedate" class="form-label">Response On:</label> <input
						type="date" class="form-control" id="responsedate"
						name="responsedate"> <input id="createdbyip" type="hidden"
						value="100.100.100.100" name="createdbyip" />
				</div>
				<button type="submit" class="btn btn-primary">Add Query</button>
			</form>
		</div>
	</body>
</html>