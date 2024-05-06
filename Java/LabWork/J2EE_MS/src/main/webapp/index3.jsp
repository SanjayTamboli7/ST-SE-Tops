<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int a= 10, b=20; %>
<%
int z=0;
z=a+b;
out.println("Sum = " + z);
%>
<%= "Sum is expression" + z %> <br>
<%= 5+6+7+8+9+10 %>
</body>
</html>