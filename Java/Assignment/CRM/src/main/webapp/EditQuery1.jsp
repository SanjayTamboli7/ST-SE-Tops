<%@page import="com.dao.QueryDao,com.model.QueryModel"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 --%>
 <jsp:useBean id="u" class="com.model.QueryModel"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=QueryDao.updateQuery(u);
response.sendRedirect("ManageQuery.jsp");
%>
