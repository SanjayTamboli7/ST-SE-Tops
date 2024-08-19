<%@page import="com.dao.CustomerDao"%>
<jsp:useBean id="p" class="com.model.CustomerModel"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
CustomerDao.deleteCustomer(p);
response.sendRedirect("ManageCustomer.jsp");
%>
