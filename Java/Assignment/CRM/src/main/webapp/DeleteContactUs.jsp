<%@page import="com.dao.ContactUsDao"%>
<%@page import="com.model.ContactUsModel"%>
<jsp:useBean id="p" class="com.model.ContactUsModel"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
String ContactUsID = request.getParameter("id");
System.out.println("In Delete Reg id = " + ContactUsID);
ContactUsModel cm = ContactUsDao.getContactUsByID(Integer.parseInt(ContactUsID));
int i=ContactUsDao.deleteContactUs(cm);
response.sendRedirect("ManageContactUs.jsp");
%>
