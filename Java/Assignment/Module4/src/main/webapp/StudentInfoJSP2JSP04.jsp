<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04 Student Info from JSP to JSP</title>
</head>
<body>
	<!-- 
		04 Write a Java program to submit student information (fname, lname, email, mobile, gender, password) 
 		using jsp form. Display these data in another jsp.
 		Run this file to see the execution.
	-->
	<h1>04 Student Info from JSP to JSP</h1>
	<form method="GET" action="StudentInfoJSPGet04.jsp">
		<table>
			<tr>
				<td>FirstName :</td>
				<td><input type="text" name="firstname"></td>
			</tr>
			<tr>
				<td>LastName :</td>
				<td><input type="text" name="lastname"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Mobile :</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><input type="text" name="gender"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>


</body>
</html>