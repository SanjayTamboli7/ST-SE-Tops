<%@page import="com.dao.MsgListDao"%>
<%@page import="com.model.MsgList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>08 Show Messages List on JSP</title>
</head>
<body>
	<jsp:include page="HeaderEmp.html"></jsp:include>
	<div align="center">
		<div class="px-4 py-5 my-5">
			<div class="col-lg-6 mx-auto">
				<h4 class="display-5 fw-bold text-body-emphasis">All Messages</h4>
				<%
				List<MsgList> list = MsgListDao.getAllRecords();
				request.setAttribute("list", list);
				%>
				<table class="table table-bordered border-dark table-striped">
					<tr>
						<th>ID</th>
						<th>From User</th>
						<th>To User</th>
						<th>Message</th>
					</tr>
					<%
					for (MsgList u : list) {
					%>
					<tr>
						<td><%=u.getMsgId()%></td>
						<td><%=u.getFromUser()%></td>
						<td><%=u.getToUser()%></td>
						<td><%=u.getMsgDetail()%></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
