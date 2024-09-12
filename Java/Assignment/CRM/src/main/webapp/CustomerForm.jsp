<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
		<title>CustomerForm.jsp</title>
</head>
	<body>
		<div class="container mt-5">
			<!--  <form action="AddCustomer.jsp" method="post"> -->			
			<form method="post" action="CustomerController">
				<div class="mb-3">
					<label for="customername" class="form-label">Customer Name :</label>
					<input type="text" class="form-control" id="customername"
						name="customername">
				</div>
				<div class="mb-3">
					<label for="customeremailid" class="form-label">Customer
						Email :</label> <input type="email" class="form-control"
						id="customeremailid" name="customeremailid">
				</div>
				<div class="mb-3">
					<label for="customercontactno" class="form-label">Customer Number:</label> <input
						type="text" class="form-control" id="customercontactno"
						name="customercontactno">
				</div>
				<div class="mb-3">
					<label for="customeraddress" class="form-label">Customer
						Address :</label> <input type="text" class="form-control"
						id="customeraddress" name="customeraddress">
				</div>
				<div class="mb-3">
					<label for="customercity" class="form-label">Customer
						City :</label> <select class="form-control" id="customercity"
						name="customercity">
						<option value="Ahmedabad">Ahmedabad</option>
						<option value="Baroda">Baroda</option>
						<option value="Rajkot">Rajkot</option>
						<option value="Surat">Surat</option>
						<option value="Mumbai">Mumbai</option>
						<option value="Pune">Pune</option>
						<option value="Nagpur">Nagpur</option>
						<option value="Aurangabad">Aurangabad</option>
						<option value="Udaipur">Udaipur</option>
						<option value="Jaipur">Jaipur</option>
						<option value="Bikaner">Bikaner</option>
						<option value="Gangapur">Gangapur</option>
					</select>
				</div>								
				<div class="mb-3">
					<label for="customerstate" class="form-label">Customer
						State :</label> <select class="form-control" id="customerstate" name="customerstate">
						<option value="Gujarat">Gujarat</option>
						<option value="Maharashtra">Maharashtra</option>
						<option value="Rajsthan">Rajsthan</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="customercountry" class="form-label">Customer
						Country :</label> <select class="form-control" id="customercountry"
						name="customercountry">
						<option value="India">India</option>
					</select>
					<input id="createddatetime" type="hidden" value="2024-08-12"
						name="createddatetime" /> 
						<input id="createdbyip" type="hidden" value="100.100.100.100"
						name="createdbyip" />
				</div>
<!-- 				<div class="mb-3">
					<label for="fkregid" class="form-label">Created By :</label> 
					<input type="text" class="form-control" id="fkregid" name="fkregid">
				</div>
 -->				
 				<div class="mb-3">
					<label for="fkregid" class="form-label">Created By :</label> 
					<select name="fkregid">
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
				<button type="submit" class="btn btn-primary">Add Customer</button>
			</form>
		</div>
	</body>
</html>