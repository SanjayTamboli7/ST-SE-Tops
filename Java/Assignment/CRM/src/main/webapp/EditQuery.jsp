<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.QueryModel"%>
<%@page import="com.dao.QueryDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Query</title>
</head>
<body>
	<%
	String Queryid = request.getParameter("id");
	System.out.println("Query id = " + Queryid);
	QueryModel u = QueryDao.getQueryByID(Integer.parseInt(Queryid));
	%>
	<jsp:include page="HeaderQuery.html"></jsp:include>
	<div class="container mt-5">
		<form action="EditQuery1.jsp" method="post">
		<!-- <form method="post" action="QueryController"> -->
			<div class="mb-3">
				<label for="pkqueryid" class="form-label">Query ID:</label>
				<input id="pkqueryid" type=number name="pkqueryid" value="<%=u.getPkqueryid()%>"/>
			</div>
			<div class="mb-3">
				<label for="customeremailid" class="form-label">Customer
					Email ID:</label> <input type="email" class="form-control"
					id="customeremailid" name="customeremailid" value="<%=u.getCustomeremailid()%>">
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">Description :</label> <input
					type="text" class="form-control" id="description"
					name="description" value="<%=u.getDescription()%>">
			</div>
			<div class="mb-3">
				<label for="suggestion" class="form-label">Suggestion:</label> <input
					type="text" class="form-control" id="suggestion" name="suggestion" value="<%=u.getSuggestion()%>">
			</div>
			<div class="mb-3">
				<label for="response" class="form-label">Response:</label> <input
					type="text" class="form-control" id="response" name="response" value="<%=u.getResponse()%>">
			</div>
			
				<div class="mb-3">
					<label for="fkresponseid" class="form-label">Response From:</label>
					<select name="fkresponseid" value="<%=u.getFkresponseid()%>">
					<%
						Connection cn=new DBUtil().getConnectionData();
						PreparedStatement st=cn.prepareStatement("select pkRegID, UserName from tblregistration where RegistrationType='B' and ActiveFlag='A'");
						ResultSet rs=st.executeQuery();
						while(rs.next())
						{
					%>
							<option value="<%=rs.getInt(1)%>"><%=rs.getString(2) %></option>
					<% 
						}
						cn.close();
					%>
					</select>
				</div>
			<%-- <div class="mb-3">
				<label for="fkregid" class="form-label">Query From:</label> <input
					type="number" class="form-control" id="fkregid" name="fkregid" value="<%=u.getFkregid()%>">
			</div> --%>
			<div class="mb-3">
					<label for="fkregid" class="form-label">Created By :</label> 
					<select name="fkregid" value="<%=u.getFkregid()%>">
					<%
						Connection cnf=new DBUtil().getConnectionData();
						PreparedStatement stf=cnf.prepareStatement("select pkRegID, UserName from tblregistration where RegistrationType='C' and ActiveFlag='A'");
						ResultSet rsf=stf.executeQuery();
						while(rsf.next())
						{
					%>
							<option value="<%=rsf.getInt(1)%>"><%=rsf.getString(2) %></option>
					<% 
						}
						cn.close();
					%>
					</select>
				</div>
			<div class="mb-3">
				<label for="responsedate" class="form-label">Response On:</label> <input
					type="date" class="form-control" id="responsedate"
					name="responsedate" value="<%=u.getResponsedate()%>"> <input id="createdbyip" type="hidden"
					value="100.100.100.100" name="createdbyip" />
				<input id="createddatetime" type="hidden" value="2024-07-18"
					name="createddatetime" />
			</div>
			<button type="submit" class="btn btn-primary">Edit Query</button>
		</form>
	</div>
</body>
</html>
