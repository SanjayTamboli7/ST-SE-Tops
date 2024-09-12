<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.CustomerModel"%>
<%@page import="com.dao.CustomerDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer</title>
</head>
<body>
	<%
	String Customerid = request.getParameter("id");
	System.out.println("Customer id = " + Customerid);
	CustomerModel p = CustomerDao.getCustomerByID(Integer.parseInt(Customerid));
	%>
	<jsp:include page="HeaderCustomer.html"></jsp:include>
	<div class="container mt-5">
		<form action="EditCustomer1.jsp">
			<!-- <form method="post" action="CustomerController"> -->
			<input type="text" name="pkcustomerid"
				value="<%=p.getPkcustomerid()%>">
			<div class="mb-3">
				<label for="customername" class="form-label">Customer Name :</label>
				<input type="text" class="form-control" name="customername"
					value="<%=p.getCustomername()%>">
			</div>
			<div class="mb-3">
				<label for="customeremailid" class="form-label">Customer
					Email :</label> <input type="email" class="form-control"
					name="customeremailid" value="<%=p.getCustomeremailid()%>">
			</div>
			<div class="mb-3">
				<label for="customercontactno" class="form-label">Customer
					Number:</label> <input type="text" class="form-control"
					name="customercontactno" value="<%=p.getCustomercontactno()%>">
			</div>
			<div class="mb-3">
				<label for="customeraddress" class="form-label">Customer
					Address :</label> <input type="text" class="form-control"
					name="customeraddress" value="<%=p.getCustomeraddress()%>">
			</div>
			<div class="mb-3">
				<label for="customercity" class="form-label">Customer City :</label>
				<select class="form-control" name="customercity"
					value="<%=p.getCustomercity()%>">
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
				<label for="customerstate" class="form-label">Customer State
					:</label> <select class="form-control" name="customerstate"
					value="<%=p.getCustomerstate()%>">
					<option value="Gujarat">Gujarat</option>
					<option value="Maharashtra">Maharashtra</option>
					<option value="Rajsthan">Rajsthan</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="customercountry" class="form-label">Customer
					Country :</label> <input type="text" class="form-control"
					name="customercountry" value="<%=p.getCustomercountry()%>">
					<input name="createddatetime" type="hidden" value="2024-08-12" /> 
					<input name="createdbyip" type="hidden" value="100.100.100.100" />
			</div>
			<%-- <div class="mb-3">
				<label for="fkregid" class="form-label">Created By :</label> <input
					type="text" class="form-control" id="fkregid" name="fkregid"
					value="<%=p.getFkregid()%>"> 
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
			<button type="submit" class="btn btn-primary">Edit Customer
			</button>
		</form>
	</div>

</body>
</html>

