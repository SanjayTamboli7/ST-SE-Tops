<%@page import="com.dao.CustomerDao"%>
<%@page import="com.model.CustomerModel"%>
<jsp:useBean id="p" class="com.model.CustomerModel"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
String CustomerID = request.getParameter("id");
System.out.println("In Delete Reg id = " + CustomerID);
CustomerModel cm = CustomerDao.getCustomerByID(Integer.parseInt(CustomerID));
int i=CustomerDao.deleteCustomer(cm);
response.sendRedirect("ManageCustomer.jsp");
%>
