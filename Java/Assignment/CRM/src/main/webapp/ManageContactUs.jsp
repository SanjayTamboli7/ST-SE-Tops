<%@page import="com.dao.ContactUsDao"%>
<%@page import="com.model.ContactUsModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
  <!--     
  pkContactUsID		(Add mode -> Auto generated. Edit mode -> No change. Access to site visitor.)
  YourName	  		(Add mode -> Let site visitor add it.)
  YourEmailID		(Add mode -> Let site visitor add it.)
  YourMessage		(Add mode -> Let site visitor add it.)
  CreatedDateTime	(Add / Edit mode -> It should be system date & time.)	
  CreatedByIP		(Add / Edit mode -> It should be client system's IP address.)
      
  Allow Admin to delete it if customer is not associated with any project.
  -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View ContactUs</title>
</head>
<body>
	<jsp:include page="HeaderContactUs.html"></jsp:include>
	<div class="px-4 py-5 my-5">
		<div class="col-lg-6 mx-auto">
			<h4 class="display-5 fw-bold text-body-emphasis">All ContactUs</h4>
			<%
			List<ContactUsModel> list = ContactUsDao.getAllContactUss();
			request.setAttribute("list", list);
			%>
			<table class="table table-bordered border-dark table-striped">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email ID</th>
					<th>Message</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<%
				for (ContactUsModel cu : list) {
				%>
				<tr>
					<td><%=cu.getPkContactUsID()%></td>
					<td><%=cu.getYourName()%></td>
					<td><%=cu.getYourEmailID()%></td>
					<td><%=cu.getYourMessage()%></td>
					<td><a class="btn btn-success"
						href="ViewContactUs.jsp?id=<%=cu.getPkContactUsID()%>">View</a></td>
					<td><a class="btn btn-danger"
						href="DeleteContactUs.jsp?id=<%=cu.getPkContactUsID()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>

</body>
</html>
