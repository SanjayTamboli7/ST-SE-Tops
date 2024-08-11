<%@page import="com.dao.ProjectDao,com.model.ProjectModel"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 --%>
 <jsp:useBean id="p" class="com.model.ProjectModel"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
int i=ProjectDao.updateProject(p);
response.sendRedirect("ManageProject.jsp");
%>
