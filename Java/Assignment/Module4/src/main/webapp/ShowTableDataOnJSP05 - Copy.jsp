<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
<!-- <meta charset="UTF-8"> -->
<title>05 Show SQL table data on JSP</title>
</head>
<body>

	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/module4" user="root" password="" />

	<sql:query var="listUsers" dataSource="${myDS}">
        SELECT * FROM EMP;
    </sql:query>

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>List of employees</caption>
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
			<c:forEach var="user" items="${listUsers.rows}">
				<tr>
					<td><c:out value="${user.empno}" /></td>
					<td><c:out value="${user.ename}" /></td>
					<td><c:out value="${user.job}" /></td>
					<td><c:out value="${user.mgr}" /></td>
					<td><c:out value="${user.hiredate}" /></td>
					<td><c:out value="${user.sal}" /></td>
					<td><c:out value="${user.commission}" /></td>
					<td><c:out value="${user.department}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
