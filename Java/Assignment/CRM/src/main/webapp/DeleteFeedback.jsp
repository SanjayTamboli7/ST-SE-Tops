<%@page import="com.dao.FeedbackDao"%>
<%@page import="com.model.FeedbackModel"%>
<jsp:useBean id="u" class="com.model.FeedbackModel"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
String FeedbackID = request.getParameter("id");
System.out.println("In Delete FeedbackID id = " + FeedbackID);
FeedbackModel rm = FeedbackDao.getFeedbackByID(Integer.parseInt(FeedbackID));
int i=FeedbackDao.deleteFeedback(rm);
response.sendRedirect("ManageFeedback.jsp");
%>
