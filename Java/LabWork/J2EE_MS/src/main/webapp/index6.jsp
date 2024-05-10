<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="s1" class="com.model.Student"></jsp:useBean>
	<jsp:setProperty property="sid" value="4321" name="s1" />
	<jsp:setProperty property="sname" value="Rahul" name="s1" />
	<jsp:setProperty property="city" value="S.Nagar" name="s1" />

	<jsp:useBean id="s2" class="com.model.Student"></jsp:useBean>
	<jsp:setProperty property="sid" value="3210" name="s2" />
	<jsp:setProperty property="sname" value="Rocky" name="s2" />
	<jsp:setProperty property="city" value="G.Nagar" name="s2" />

	<table>
		<tr>
			<th>SID</th>
			<th>SName</th>
			<th>City</th>
		</tr>
		<tr>
			<td><%=s1.getSid()%></td>
			<td><%=s1.getSname()%></td>
			<td><%=s1.getCity()%></td>
		</tr>
		<tr>
			<td><jsp:getProperty property="sid" name="s2"/></td>
			<td><jsp:getProperty property="sname" name="s2"/></td>
			<td><jsp:getProperty property="city" name="s2"/></td>
		</tr>
	</table>
</body>
</html>