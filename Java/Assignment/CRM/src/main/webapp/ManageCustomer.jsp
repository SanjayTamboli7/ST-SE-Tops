<%@page import="com.dao.CustomerDao"%>
<%@page import="com.model.CustomerModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
  <!-- 
  
  pkCustomerID      (Add mode -> Auto generated. Edit mode -> No change. Access to BDE.)
  CustomerName      (Add / Edit mode -> Let BDE add / edit customer name.)
  CustomerEmailID   (Add / Edit mode -> Let BDE add / edit customer email ID.)
  CustomerContactNo (Add / Edit mode -> Let BDE add / edit customer contact number.)
  CustomerAddress   (Add / Edit mode -> Let BDE add / edit customer address.)
  CustomerCity      (Add / Edit mode -> Let BDE add / edit customer city.)
  CustomerState     (Add / Edit mode -> Let BDE add / edit customer state.)
  CustomerCountry   (Add / Edit mode -> Let BDE add / edit customer country.)
  fkRegID           (Add / Edit mode -> Work out the pkRegID from tblRegistration using login email id.)
  CreatedDateTime	(Add / Edit mode -> It should be system date & time.) 
  CreatedByIP		(Add / Edit mode -> It should be client system's IP address.)
      
  Allow BDE to delete it if customer is not associated with any project.
  -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customers</title>
</head>
<body>
	<jsp:include page="HeaderCustomer.html"></jsp:include>
	<div class="px-4 py-5 my-5">
		<div class="col-lg-6 mx-auto">
			<h4 class="display-5 fw-bold text-body-emphasis">All Customers</h4>
			<%
			List<CustomerModel> list = CustomerDao.getAllCustomers();
			request.setAttribute("list", list);
			%>
			<table class="table table-bordered border-dark table-striped">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email ID</th>
					<th>Contact No</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
					<th>Country</th>
					<th>Customer of</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<%
				for (CustomerModel c : list) {
				%>
				<tr>
					<td><%=c.getPkCustomerID()%></td>
					<td><%=c.getCustomerName()%></td>
					<td><%=c.getCustomerEmailID()%></td>
					<td><%=c.getCustomerContactNo()%></td>
					<td><%=c.getCustomerAddress()%></td>
					<td><%=c.getCustomerCity()%></td>
					<td><%=c.getCustomerState()%></td>
					<td><%=c.getCustomerCountry() %></td>
					<td><%=c.getFkRegID()%></td>
					<td><a class="btn btn-success"
						href="EditCustomer.jsp?id=<%=c.getPkCustomerID()%>">Edit</a></td>
					<td><a class="btn btn-danger"
						href="DeleteCustomer.jsp?id=<%=c.getPkCustomerID()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>

</body>
</html>
