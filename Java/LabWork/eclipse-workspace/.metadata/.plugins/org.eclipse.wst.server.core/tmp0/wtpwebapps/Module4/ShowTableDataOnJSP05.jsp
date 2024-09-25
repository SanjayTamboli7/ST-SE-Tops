<%@page import="com.dao.EmpDao"%>
<%@page import="com.model.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>05 Show SQL table data on JSP</title>
</head>
<body>
	<jsp:include page="HeaderEmp.html"></jsp:include>
	<div align="center">
		<div class="px-4 py-5 my-5">
			<div class="col-lg-6 mx-auto">
				<h4 class="display-5 fw-bold text-body-emphasis">All Employees</h4>
				<%
				List<Emp> list = EmpDao.getAllRecords();
				request.setAttribute("list", list);
				%>
				<table class="table table-bordered border-dark table-striped">
					<tr>
						<th>No</th>
						<th>Name</th>
						<th>Job</th>
						<th>Manager</th>
						<th>Joined On</th>
						<th>Salary</th>
						<th>Commission</th>
						<th>Department</th>
					</tr>
					<%
					for (Emp u : list) {
					%>
					<tr>
						<td><%=u.getEmpno()%></td>
						<td><%=u.getEname()%></td>
						<td><%=u.getJob()%></td>
						<td><%=u.getMgr()%></td>
						<td><%=u.getHiredate()%></td>
						<td><%=u.getSal()%></td>
						<td><%=u.getComm()%></td>
						<td><%=u.getDeptno()%></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
