<%@page import="com.dao.RegistrationDao,com.model.RegistrationModel"%>
<jsp:useBean id="rm" class="com.model.RegistrationModel"></jsp:useBean>
<jsp:setProperty property="*" name="rm"/>

<%
int i=RegistrationDao.updateRegistration(rm);
response.sendRedirect("ManageRegistration.jsp");
%>
