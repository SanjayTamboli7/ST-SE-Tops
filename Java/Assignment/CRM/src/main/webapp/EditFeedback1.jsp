<%@page import="com.dao.FeedbackDao,com.model.FeedbackModel"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 --%>
 <jsp:useBean id="u" class="com.model.FeedbackModel"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=FeedbackDao.updateFeedback(u);
response.sendRedirect("ManageFeedback.jsp");
%>
