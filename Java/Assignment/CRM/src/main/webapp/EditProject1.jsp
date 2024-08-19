<%@page import="com.dao.ProjectDao,com.model.ProjectModel"%>
<jsp:useBean id="p" class="com.model.ProjectModel"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
int i=ProjectDao.updateProject(p);
response.sendRedirect("ManageProject.jsp");
%>
