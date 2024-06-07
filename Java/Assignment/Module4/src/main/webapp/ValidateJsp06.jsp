<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06 Validate JSP On Server Side</title>
</head>
<body>
	<!-- 
		03 Write a Java program to submit student information (fname, lname, email, mobile, gender, password) 
 		using jsp form to servlet. Fetch data at servlet and print all the data in console.
 		Run this file to see the execution.
	-->
	<h1>03 Student Info from JSP to Servlet</h1>
	<form method="post" action="ValidateJsp06">
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