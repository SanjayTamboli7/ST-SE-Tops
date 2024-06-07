
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

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
			<td><a href="HomeController.do?action=edituser&userid=${model.userid }">Edit
					User</a></td>
			<td><a
				href="HomeController.do?action=deleteuser&userid=${model.userid }">Delete
					User</a></td>
		</tr>
	</table>
	<br>
	<br>

	
		<form method="post" action="HomeController.do">
			<table>
				<tr>
					<td>FirstName :</td>
					<td><input type="text" name="firstname"
						value="${hmodel.firstname }"></td>
				</tr>
				<tr>
					<td>LastName :</td>
					<td><input type="text" name="lastname"
						value="${hmodel.lastname }"></td>
				</tr>
				<tr>
					<td>UserName :</td>
					<td><input type="text" name="username"
						value="${hmodel.username }"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="text" name="password"
						value="${hmodel.password }"> <input type="hidden"
						name="userid" value="${hmodel.userid }"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	
	
</body>
</html>