<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04 Student Info Getting JSP</title>
</head>
<body>
	<%String firstname = request.getParameter("firstname");%>
	<%String lastname = request.getParameter("lastname");%>
	<%String email = request.getParameter("email");%>
	<%String mobile = request.getParameter("mobile");%>
	<%String gender = request.getParameter("gender");%>
	<%String password = request.getParameter("password");%>

		<table>
			<tr>
				<td>FirstName :</td>
				<td><%= firstname %></td>
			</tr>
			<tr>
				<td>LastName :</td>
				<td><%= lastname %></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><%= email %></td>
			</tr>
			<tr>
				<td>Mobile :</td>
				<td><%= mobile %></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><%= gender %></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><%= password %></td>
			</tr>
<!-- 			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
 -->		</table>

</body>
</html>
