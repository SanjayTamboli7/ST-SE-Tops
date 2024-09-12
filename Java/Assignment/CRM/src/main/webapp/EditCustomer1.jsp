<%@page import="com.dao.CustomerDao"%>
<jsp:useBean id="v" class="com.model.CustomerModel"></jsp:useBean>
<jsp:setProperty property="*" name="v"/>

<%

  String s= request.getParameter("customername");

   System.out.print(s);
int i=CustomerDao.updateCustomer(v);

System.out.print(i);
response.sendRedirect("ManageCustomer.jsp");
%>
