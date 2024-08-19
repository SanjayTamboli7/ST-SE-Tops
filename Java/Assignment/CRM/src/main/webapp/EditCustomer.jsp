<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.CustomerModel"%>
<%@page import="com.dao.CustomerDao"%>
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
		<form action="EditCustomer1.jsp" method="post">
		<!-- <form method="post" action="CustomerController"> -->
				<div class="mb-3">
					<label for="CustomerName" class="form-label">Customer Name :</label>
					<input type="text" class="form-control" id="CustomerName"
						name="CustomerName" value="<%=p.getCustomerName()%>">
				</div>
				<div class="mb-3">
					<label for="CustomerEmailID" class="form-label">Customer
						Email :</label> <input type="email" class="form-control"
						id="CustomerEmailID" name="CustomerEmailID" value="<%=p.getCustomerEmailID()%>">
				</div>
				<div class="mb-3">
					<label for="CustomerContactNo" class="form-label">Customer Contact Number:</label> <input
						type="text" class="form-control" id="CustomerContactNo"
						name="CustomerContactNo" value="<%=p.getCustomerContactNo()%>">
				</div>
				<div class="mb-3">
					<label for="CustomerAddress" class="form-label">Customer
						Address :</label> <input type="text" class="form-control"
						id="CustomerAddress" name="CustomerAddress" value="<%=p.getCustomerAddress()%>">
				</div>				
				<div class="mb-3">
					<label for="CustomerCity" class="form-label">Customer
						City :</label> <select class="form-control" id="CustomerCity"
						name="CustomerCity" value="<%=p.getCustomerCity()%>">
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
					<label for="CustomerState" class="form-label">Customer
						State :</label> <select class="form-control" id="CustomerState" name="CustomerState" value="<%=p.getCustomerCity()%>">
						<option value="Gujarat">Gujarat</option>
						<option value="Maharashtra">Maharashtra</option>
						<option value="Rajsthan">Rajsthan</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="CustomerCountry" class="form-label">Customer
						Country :</label> <select class="form-control" id="CustomerCountry"
						name="CustomerCountry" value="<%=p.getCustomerCountry()%>">
						<option value="India">India</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="fkRegID" class="form-label">Created By :</label> <input type="text" class="form-control"
						id="fkRegID" name="fkRegID" value="<%=p.getFkRegID()%>">
						<input id="CreatedDateTime" type="hidden" value="2024-08-12"
						name="CreatedDateTime" /> 
						<input id="CreatedByIP" type="hidden" value="100.100.100.100"
						name="CreatedByIP" />						
				</div>
			<button type="submit" class="btn btn-primary">Edit Customer</button>
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