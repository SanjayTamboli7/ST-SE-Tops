/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2024-08-30 11:13:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dao.ProjectDao;
import com.model.ProjectModel;
import java.util.List;

public final class ManageProject_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.dao.ProjectDao");
    _jspx_imports_classes.add("com.model.ProjectModel");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("  <!-- \r\n");
      out.write("  \r\n");
      out.write("  pkProjectID  \t\t\t(Add mode -> Auto generated. Edit mode -> No change. Access to customer.)\r\n");
      out.write("  ProjectName  \t\t\t(Add mode -> Let BDE add project name. Edit mode -> Let BDE edit project name.) \r\n");
      out.write("  ProjectDescription   \t(Add mode -> Let BDE add project description. Edit mode -> Let BDE edit project description.)\r\n");
      out.write("  fkCustomerID \t\t\t(Add mode -> Let BDE select the customer and set the customer Id from customer master. Edit mode -> Let BDE select the customer and set the customer Id from customer master.)\r\n");
      out.write("  ProjectDuration \t\t(Add mode -> Let BDE add project duration. Edit mode -> Let BDE edit project duration.)\r\n");
      out.write("  ProjectStartDate \t\t(Add mode -> Let BDE add project start date. Edit mode -> Let BDE edit project start date.)\r\n");
      out.write("  ProjectEndDate \t\t(Add mode -> Let BDE add project end date. Edit mode -> Let BDE edit project end date.)\r\n");
      out.write("  ProjectCost\t\t\t(Add mode -> Let BDE add project cost. Edit mode -> Let BDE edit project cost.)\r\n");
      out.write("  ProjectRemarks \t\t(Add mode -> Let BDE add project remarks. Edit mode -> Let BDE edit project remarks.)\r\n");
      out.write("  ProjectStatus \t\t(Add mode -> Let BDE add project remarks. Edit mode -> Let BDE edit project remarks. it should be drop down list.)\r\n");
      out.write("  fkRegID \t\t\t\t(Add mode -> Work out the pkRegID from tblRegistration using login email id. Edit mode -> No change in this field.)\r\n");
      out.write("  CustomerReview \t\t(Add mode -> Let customer add review. Edit mode -> Let customer edit review.) \r\n");
      out.write("  CreatedDateTime\t\t(Add / Edit mode -> It should be system date & time.) \r\n");
      out.write("  CreatedByIP\t\t\t(Add / Edit mode -> It should be client system's IP address.)\r\n");
      out.write("    \r\n");
      out.write("  Allow BDE to delete it if Project is not reviewed by the customer and status is not \"Completed\".\r\n");
      out.write("  -->\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>View Projects</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "HeaderProject.html", out, false);
      out.write("\r\n");
      out.write("\t<div class=\"px-4 py-5 my-5\">\r\n");
      out.write("\t\t<div class=\"col-lg-6 mx-auto\">\r\n");
      out.write("\t\t\t<h4 class=\"display-5 fw-bold text-body-emphasis\">All Projects</h4>\r\n");
      out.write("\t\t\t");

			List<ProjectModel> list = ProjectDao.getAllProjects();
			request.setAttribute("list", list);
			
      out.write("\r\n");
      out.write("\t\t\t<table class=\"table table-bordered border-dark table-striped\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>Id</th>\r\n");
      out.write("\t\t\t\t\t<th>Name</th>\r\n");
      out.write("\t\t\t\t\t<th>Description</th>\r\n");
      out.write("\t\t\t\t\t<th>Customer</th>\r\n");
      out.write("\t\t\t\t\t<th>Days</th>\r\n");
      out.write("\t\t\t\t\t<th>Start Date</th>\r\n");
      out.write("\t\t\t\t\t<th>End Date</th>\r\n");
      out.write("\t\t\t\t\t<th>Cost</th>\r\n");
      out.write("\t\t\t\t\t<th>Remarks</th>\r\n");
      out.write("\t\t\t\t\t<th>BDE</th>\r\n");
      out.write("\t\t\t\t\t<th>Review</th>\r\n");
      out.write("\t\t\t\t\t<th>Edit</th>\r\n");
      out.write("\t\t\t\t\t<th>Delete</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				for (ProjectModel p : list) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getPkprojectid());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getProjectname());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getProjectdescription());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getFkcustomerid());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getProjectduration());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getProjectstartdate());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getProjectenddate());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getProjectcost());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getProjectremarks());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getFkregid());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(p.getCustomerreview());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td><a class=\"btn btn-success\"\r\n");
      out.write("\t\t\t\t\t\thref=\"EditProject.jsp?id=");
      out.print(p.getPkprojectid());
      out.write("\">Edit</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a class=\"btn btn-danger\"\r\n");
      out.write("\t\t\t\t\t\thref=\"DeleteProject.jsp?id=");
      out.print(p.getPkprojectid());
      out.write("\">Delete</a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
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