<%@page import="com.dao.StudentDao"%>
<jsp:useBean id="u" class="com.model.Student"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
StudentDao.delete(u);
response.sendRedirect("viewusers.jsp");
%>