<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${msg }
	<h1>Login Form</h1>
	<form method="post" action="MsgUserLoginController">
		<table>
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="fname" id="fname"></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lname" id="lname"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>
