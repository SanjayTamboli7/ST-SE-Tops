<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="">
	<tr>
		<th>UserId</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>UserName</th>
		<th>Password</th>
	</tr>
	<tr>
		<td>${model.userid }</td>
		<td>${model.firstname }</td>
		<td>${model.lastname }</td>
		<td>${model.username }</td>
		<td>${model.password }</td>
	</tr>
	
</table>
</body>
</html>