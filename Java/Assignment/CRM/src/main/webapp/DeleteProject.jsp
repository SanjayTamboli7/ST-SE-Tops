<%@page import="com.dao.ProjectDao"%>
<jsp:useBean id="p" class="com.model.ProjectModel"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
ProjectDao.deleteProject(p);
response.sendRedirect("ManageProject.jsp");
%>
