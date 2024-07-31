<%@page import="com.dao.FeedbackDao"%>
<jsp:useBean id="u" class="com.model.FeedbackModel"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
FeedbackDao.deleteFeedback(u);
response.sendRedirect("ManageFeedback.jsp");
%>