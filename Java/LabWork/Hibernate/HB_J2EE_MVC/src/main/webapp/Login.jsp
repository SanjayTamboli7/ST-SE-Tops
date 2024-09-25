<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-jsp</title>
</head>
<body>
	${msg }
	<form method="post" action="LoginController">
		<table>
			<tr>
				<td>UserName :</td>
				<td><input type="text" name="username"></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login"></td>
		</table>
	</form>
</body>
</html>