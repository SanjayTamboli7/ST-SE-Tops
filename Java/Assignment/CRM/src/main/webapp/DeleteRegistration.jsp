<%@page import="com.dao.RegistrationDao"%>
<jsp:useBean id="p" class="com.model.RegistrationModel"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
RegistrationDao.deleteRegistration(p);
response.sendRedirect("ManageRegistration.jsp");
%>
