/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2024-09-01 11:28:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.util.DBUtil;
import java.sql.Connection;

public final class AddCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/CustomerForm.jsp", Long.valueOf(1725190060318L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("com.util.DBUtil");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Add Customer Form</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write('\r');
      out.write('\n');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "HeaderCustomer.html", out, false);
      out.write("\r\n");
      out.write("\t<div class=\"px-4 py-5 my-5\">\r\n");
      out.write("\t\t<div class=\"col-lg-6 mx-auto\">\r\n");
      out.write("\t\t\t<h4 class=\"display-5 fw-bold text-body-emphasis\">Add New\r\n");
      out.write("\t\t\t\tCustomer</h4>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<!-- <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> -->\r\n");
      out.write("\t\t<title>CustomerForm.jsp</title>\r\n");
      out.write("</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"container mt-5\">\r\n");
      out.write("\t\t\t<!--  <form action=\"AddCustomer.jsp\" method=\"post\"> -->\t\t\t\r\n");
      out.write("\t\t\t<form method=\"post\" action=\"CustomerController\">\r\n");
      out.write("\t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t<label for=\"customername\" class=\"form-label\">Customer Name :</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"customername\"\r\n");
      out.write("\t\t\t\t\t\tname=\"customername\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t<label for=\"customeremailid\" class=\"form-label\">Customer\r\n");
      out.write("\t\t\t\t\t\tEmail :</label> <input type=\"email\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customeremailid\" name=\"customeremailid\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t<label for=\"customercontactno\" class=\"form-label\">Customer Number:</label> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"text\" class=\"form-control\" id=\"customercontactno\"\r\n");
      out.write("\t\t\t\t\t\tname=\"customercontactno\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t<label for=\"customeraddress\" class=\"form-label\">Customer\r\n");
      out.write("\t\t\t\t\t\tAddress :</label> <input type=\"text\" class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\tid=\"customeraddress\" name=\"customeraddress\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t<label for=\"customercity\" class=\"form-label\">Customer\r\n");
      out.write("\t\t\t\t\t\tCity :</label> <select class=\"form-control\" id=\"customercity\"\r\n");
      out.write("\t\t\t\t\t\tname=\"customercity\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Ahmedabad\">Ahmedabad</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Baroda\">Baroda</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Rajkot\">Rajkot</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Surat\">Surat</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Mumbai\">Mumbai</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Pune\">Pune</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Nagpur\">Nagpur</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Aurangabad\">Aurangabad</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Udaipur\">Udaipur</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Jaipur\">Jaipur</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Bikaner\">Bikaner</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Gangapur\">Gangapur</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t<label for=\"customerstate\" class=\"form-label\">Customer\r\n");
      out.write("\t\t\t\t\t\tState :</label> <select class=\"form-control\" id=\"customerstate\" name=\"customerstate\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Gujarat\">Gujarat</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Maharashtra\">Maharashtra</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"Rajsthan\">Rajsthan</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t<label for=\"customercountry\" class=\"form-label\">Customer\r\n");
      out.write("\t\t\t\t\t\tCountry :</label> <select class=\"form-control\" id=\"customercountry\"\r\n");
      out.write("\t\t\t\t\t\tname=\"customercountry\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"India\">India</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t<input id=\"createddatetime\" type=\"hidden\" value=\"2024-08-12\"\r\n");
      out.write("\t\t\t\t\t\tname=\"createddatetime\" /> \r\n");
      out.write("\t\t\t\t\t\t<input id=\"createdbyip\" type=\"hidden\" value=\"100.100.100.100\"\r\n");
      out.write("\t\t\t\t\t\tname=\"createdbyip\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("<!-- \t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t<label for=\"fkregid\" class=\"form-label\">Created By :</label> \r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"fkregid\" name=\"fkregid\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write(" -->\t\t\t\t\r\n");
      out.write(" \t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t<label for=\"fkregid\" class=\"form-label\">Created By :</label> \r\n");
      out.write("\t\t\t\t\t<select name=\"fkregid\">\r\n");
      out.write("\t\t\t\t\t");

						Connection cn=new DBUtil().getConnectionData();
						PreparedStatement st=cn.prepareStatement("select pkRegID, UserName from tblregistration where RegistrationType='B' and ActiveFlag='A'");
						ResultSet rs=st.executeQuery();
						while(rs.next())
						{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"");
      out.print(rs.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t");
 
						}
						cn.close();
					
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">Add Customer</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}