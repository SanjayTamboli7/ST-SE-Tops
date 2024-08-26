<%@page import="com.dao.QueryDao"%>
<%@page import="com.model.QueryModel"%>
<jsp:useBean id="u" class="com.model.QueryModel"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
String QueryID = request.getParameter("id");
System.out.println("In Query id = " + QueryID);
QueryModel rm = QueryDao.getQueryByID(Integer.parseInt(QueryID));
int i=QueryDao.deleteQuery(rm);
response.sendRedirect("ManageQuery.jsp");
%>
