<%@page import="com.dao.QueryDao"%>
<%@page import="com.model.QueryModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
  <!-- 
  pkQueryID 		(Add mode -> Auto generated. Edit mode -> No change. Access to customer.)
  CustomerEmailID	(Add mode -> The customer who adds the query. Edit mode -> Let the customer change it if query is not responded by the BDE. Customer email id can be worked out from the login user.)
  Description		(Add mode -> Let the customer add this description. Edit mode -> Let the customer change it if query is not responded by the BDE.)
  Suggestion		(Add mode -> Let the customer add this suggestion. Edit mode -> Let the customer change it if query is not responded by the BDE.)
  Response			(Add mode -> It should be blank. Edit mode -> Let BDE edit this field.)
  fkResponseID		(Add mode -> It should be blank. Edit mode -> Work out the pkRegID from tblRegistration using login email id.)
  fkRegID			(Add mode -> Work out the pkRegID from tblRegistration using login email id. Edit mode -> No change in this field.)
  ResponseDate		(Add mode -> It should be blank. Edit mode -> It should be system date.)
  CreatedDateTime	(Add / Edit mode -> It should be system date & time.) 
  CreatedByIP		(Add / Edit mode -> It should be client system's IP address.)
  
  Allow customer to delete it if query is not responded by the BDE.
  -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Queries</title>
</head>
	<body>
		<jsp:include page="HeaderQuery.html"></jsp:include>
		<div class="px-4 py-5 my-5">
			<div class="col-lg-6 mx-auto">
				<h4 class="display-5 fw-bold text-body-emphasis">All Queries</h4>
				<%
				List<QueryModel> list = QueryDao.getAllQueries();
				request.setAttribute("list", list);
				%>
				<table class="table table-bordered border-dark table-striped">
					<tr>
						<th>Id</th>
						<th>Customer Email</th>
						<th>Description</th>
						<th>Suggestion</th>
						<th>Response</th>
						<th>Response From</th>
						<th>Query From</th>
						<th>Response On</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
					<%
					for (QueryModel q : list) {
					%>
					<tr>
						<td><%=q.getPkQueryID()%></td>
						<td><%=q.getCustomerEmailID()%></td>
						<td><%=q.getDescription()%></td>
						<td><%=q.getSuggestion()%></td>
						<td><%=q.getResponse()%></td>
						<td><%=q.getFkResponseID()%></td>
						<td><%=q.getFkRegID()%></td>
						<td><%=q.getResponseDate()%></td>
						<td><a class="btn btn-success"
							href="EditQuery.jsp?id=<%=q.getPkQueryID()%>">Edit</a></td>
						<td><a class="btn btn-danger"
							href="DeleteQuery.jsp?id=<%=q.getPkQueryID()%>">Delete</a></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</div>
	
	</body>
</html>