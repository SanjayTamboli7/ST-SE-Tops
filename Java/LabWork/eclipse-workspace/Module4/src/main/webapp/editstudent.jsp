<%@page import="com.dao.StudentDao"%>
<jsp:useBean id="u" class="com.model.Student"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=StudentDao.update(u);
response.sendRedirect("viewstudents.jsp");
%>
