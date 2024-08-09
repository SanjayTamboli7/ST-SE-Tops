<%@page import="com.dao.ProjectDao"%>
<%@page import="com.model.ProjectModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
  <!-- 
  
  pkProjectID  			(Add mode -> Auto generated. Edit mode -> No change. Access to customer.)
  ProjectName  			(Add mode -> Let BDE add project name. Edit mode -> Let BDE edit project name.) 
  ProjectDescription   	(Add mode -> Let BDE add project description. Edit mode -> Let BDE edit project description.)
  fkCustomerID 			(Add mode -> Let BDE select the customer and set the customer Id from customer master. Edit mode -> Let BDE select the customer and set the customer Id from customer master.)
  ProjectDuration 		(Add mode -> Let BDE add project duration. Edit mode -> Let BDE edit project duration.)
  ProjectStartDate 		(Add mode -> Let BDE add project start date. Edit mode -> Let BDE edit project start date.)
  ProjectEndDate 		(Add mode -> Let BDE add project end date. Edit mode -> Let BDE edit project end date.)
  ProjectCost			(Add mode -> Let BDE add project cost. Edit mode -> Let BDE edit project cost.)
  ProjectRemarks 		(Add mode -> Let BDE add project remarks. Edit mode -> Let BDE edit project remarks.)
  ProjectStatus 		(Add mode -> Let BDE add project remarks. Edit mode -> Let BDE edit project remarks. it should be drop down list.)
  fkRegID 				(Add mode -> Work out the pkRegID from tblRegistration using login email id. Edit mode -> No change in this field.)
  CustomerReview 		(Add mode -> Let customer add review. Edit mode -> Let customer edit review.) 
  CreatedDateTime		(Add / Edit mode -> It should be system date & time.) 
  CreatedByIP			(Add / Edit mode -> It should be client system's IP address.)
    
  Allow BDE to delete it if Project is not reviewed by the customer and status is not "Completed".
  -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Queries</title>
</head>
<body>
	<jsp:include page="HeaderProject.html"></jsp:include>
	<div class="px-4 py-5 my-5">
		<div class="col-lg-6 mx-auto">
			<h4 class="display-5 fw-bold text-body-emphasis">All Queries</h4>
			<%
			List<ProjectModel> list = ProjectDao.getAllQueries();
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
					<th>Project From</th>
					<th>Response On</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<%
				for (ProjectModel p : list) {
				%>
				<tr>
					<td><%=p.getPkProjectID()%></td>
					<td><%=p.getCustomerEmailID()%></td>
					<td><%=p.getDescription()%></td>
					<td><%=p.getSuggestion()%></td>
					<td><%=p.getResponse()%></td>
					<td><%=p.getFkResponseID()%></td>
					<td><%=p.getFkRegID()%></td>
					<td><%=p.getResponseDate()%></td>
					<td><a class="btn btn-success"
						href="EditProject.jsp?id=<%=p.getPkProjectID()%>">Edit</a></td>
					<td><a class="btn btn-danger"
						href="DeleteProject.jsp?id=<%=p.getPkProjectID()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>

</body>
</html>