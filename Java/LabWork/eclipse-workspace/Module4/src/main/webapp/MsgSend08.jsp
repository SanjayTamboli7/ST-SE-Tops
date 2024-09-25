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
	<h1>Send Message Form</h1>
	<form method="post" action="MsgSendController">
		<table>
			<tr>
				<td>From :</td>
				<td><input type="text" name="FromUser"></td>
			</tr>
			<tr>
				<td>To :</td>
				<td><input type="text" name="ToUser"></td>
			</tr>
			<tr>
				<td>Message :</td>
				<td><input type="text" name="MsgDetail"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Send Message"></td>
			</tr>
		</table>
	</form>
</body>
</html>
