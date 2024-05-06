<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <jsp:forward page="index5.jsp">
	<jsp:param value="123" name="sid"/>
	<jsp:param value="Rahul" name="sname"/>
</jsp:forward>
 --%>
 
<jsp:include page="index5.jsp">
	<jsp:param value="123" name="sid"/>
	<jsp:param value="Rahul" name="sname"/>
</jsp:include>
 
<h1>Sanjay Tamboli</h1>
</body>
</html>