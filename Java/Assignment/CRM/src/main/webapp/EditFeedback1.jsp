<%@page import="com.dao.FeedbackDao"%>
<%@page import="com.model.FeedbackModel"%>
<jsp:useBean id="u" class="com.model.FeedbackModel"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i=FeedbackDao.updateFeedback(u);
response.sendRedirect("ManageFeedback.jsp");
%>
