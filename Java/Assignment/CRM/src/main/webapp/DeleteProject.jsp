<%@page import="com.dao.ProjectDao"%>
<%@page import="com.model.ProjectModel"%>
<jsp:useBean id="p" class="com.model.ProjectModel"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
String ProjectID = request.getParameter("id");
System.out.println("In Project id = " + ProjectID);
ProjectModel pm = ProjectDao.getProjectByID(Integer.parseInt(ProjectID));
int i=ProjectDao.deleteProject(pm);
response.sendRedirect("ManageProject.jsp");
%>
