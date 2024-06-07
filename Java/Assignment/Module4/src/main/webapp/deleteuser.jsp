<%@page import="com.dao.UserDao"%>
<jsp:useBean id="u" class="com.model.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserDao.delete(u);
response.sendRedirect("viewusers.jsp");
%>