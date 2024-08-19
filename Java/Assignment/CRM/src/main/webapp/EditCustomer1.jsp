<%@page import="com.dao.CustomerDao,com.model.CustomerModel"%>
 <jsp:useBean id="c" class="com.model.CustomerModel"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>

<%
int i=CustomerDao.updateCustomer(c);
response.sendRedirect("ManageCustomer.jsp");
%>
