<%@page import="com.dao.QueryDao"%>
<jsp:useBean id="q" class="com.model.QueryModel"></jsp:useBean>
<jsp:setProperty property="*" name="q"/>

<%
int i=QueryDao.updateQuery(q);
response.sendRedirect("ManageQuery.jsp");
%>
