/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2024-09-04 12:05:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_005fregister_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<html lang=\"en-US\" dir=\"ltr\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <!--  \r\n");
      out.write("    Document Title\r\n");
      out.write("    =============================================\r\n");
      out.write("    -->\r\n");
      out.write("    <title>Titan | Multi purpose HTML5 Template</title>\r\n");
      out.write("    <!--  \r\n");
      out.write("    Favicons\r\n");
      out.write("    =============================================\r\n");
      out.write("    -->\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"assets/images/favicons/apple-icon-57x57.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"60x60\" href=\"assets/images/favicons/apple-icon-60x60.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"assets/images/favicons/apple-icon-72x72.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"assets/images/favicons/apple-icon-76x76.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"assets/images/favicons/apple-icon-114x114.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"assets/images/favicons/apple-icon-120x120.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"assets/images/favicons/apple-icon-144x144.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"assets/images/favicons/apple-icon-152x152.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"assets/images/favicons/apple-icon-180x180.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"192x192\" href=\"assets/images/favicons/android-icon-192x192.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"assets/images/favicons/favicon-32x32.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"assets/images/favicons/favicon-96x96.png\">\r\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"assets/images/favicons/favicon-16x16.png\">\r\n");
      out.write("    <link rel=\"manifest\" href=\"/manifest.json\">\r\n");
      out.write("    <meta name=\"msapplication-TileColor\" content=\"#ffffff\">\r\n");
      out.write("    <meta name=\"msapplication-TileImage\" content=\"assets/images/favicons/ms-icon-144x144.png\">\r\n");
      out.write("    <meta name=\"theme-color\" content=\"#ffffff\">\r\n");
      out.write("    <!--  \r\n");
      out.write("    Stylesheets\r\n");
      out.write("    =============================================\r\n");
      out.write("    \r\n");
      out.write("    -->\r\n");
      out.write("    <!-- Default style sheets-->\r\n");
      out.write("    <link href=\"assets/lib/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Template specific style sheets-->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Volkhov:400i\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/lib/animate.css/animate.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/lib/components-font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/lib/et-line-font/et-line-font.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/lib/flexslider/flexslider.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/lib/owl.carousel/dist/assets/owl.carousel.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/lib/owl.carousel/dist/assets/owl.theme.default.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/lib/magnific-popup/dist/magnific-popup.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"assets/lib/simple-text-rotator/simpletextrotator.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Main style sheet and color file-->\r\n");
      out.write("    <link href=\"assets/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link id=\"color-scheme\" href=\"assets/css/colors/default.css\" rel=\"stylesheet\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body data-spy=\"scroll\" data-target=\".onpage-navigation\" data-offset=\"60\">\r\n");
      out.write("    <main>\r\n");
      out.write("      <div class=\"page-loader\">\r\n");
      out.write("        <div class=\"loader\">Loading...</div>\r\n");
      out.write("      </div>\r\n");
      out.write("\t  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "MenuBar.html", out, false);
      out.write("      \r\n");
      out.write("      <div class=\"main\">\r\n");
      out.write("        <div class=\"col-sm-6 col-sm-offset-3\">\r\n");
      out.write("          <h1 class=\"module-title font-alt mb-0\">Login-Register</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("        <section class=\"module\">\r\n");
      out.write("          <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("              <div class=\"col-sm-5 col-sm-offset-1 mb-sm-40\">\r\n");
      out.write("                <h4 class=\"font-alt\">Login</h4>\r\n");
      out.write("                <hr class=\"divider-w mb-10\">\r\n");
      out.write("                <form class=\"form\" method=\"post\" action=\"LoginController\">\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                  \t<label for=\"username\" class=\"form-label\">User Name :</label>\r\n");
      out.write("                    <input class=\"form-control\" id=\"username\" type=\"text\" name=\"username\" placeholder=\"Username\"/>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                  \t<label for=\"password\" class=\"form-label\">Password :</label>\r\n");
      out.write("                    <input class=\"form-control\" id=\"pwd\" type=\"password\" name=\"pwd\" placeholder=\"Password\"/>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                    <button class=\"btn btn-round btn-b\">Login</button>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\"><a href=\"\">Forgot Password?</a></div>\r\n");
      out.write("                </form>\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"col-sm-5\">\r\n");
      out.write("              \t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                <h4 class=\"font-alt\">Register</h4>\r\n");
      out.write("                <hr class=\"divider-w mb-10\">\r\n");
      out.write("                <form class=\"form\" method=\"post\" action=\"RegistrationController\">\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                  \t<label for=\"emailid\" class=\"form-label\">Email ID :</label>\r\n");
      out.write("                    <input class=\"form-control\" id=\"emailid\" type=\"text\" name=\"emailid\" placeholder=\"Email ID\"/>\r\n");
      out.write("                    <br>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                  \t<label for=\"username\" class=\"form-label\">User Name :</label>\r\n");
      out.write("                    <input class=\"form-control\" id=\"username\" type=\"text\" name=\"username\" placeholder=\"Username\"/>\r\n");
      out.write("                  </div>                  \r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t  \t<label for=\"registrationtype\" class=\"form-label\">Registration Type :</label>\r\n");
      out.write("\t\t\t\t\t<select class=\"form-control\" id=\"registrationtype\" name=\"registrationtype\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"B\">Business Development Executive</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"C\">Customer</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("                    <input id=\"activeflag\" type=\"hidden\" value=\"A\" name=\"activeflag\"/>\r\n");
      out.write("\t\t\t\t  </div>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t  \t<label for=\"password\" class=\"form-label\">Password :</label>\r\n");
      out.write("                    <input class=\"form-control\" id=\"password\" type=\"password\" name=\"password\" placeholder=\"Password\"/>\r\n");
      out.write("                    <input id=\"createddatetime\" type=\"hidden\" value=\"2024-08-26\" name=\"createddatetime\"/>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                  \t<label for=\"re-password\" class=\"form-label\">Confirm Password :</label>\r\n");
      out.write("                    <input class=\"form-control\" id=\"re-password\" type=\"password\" name=\"re-password\" placeholder=\"Re-enter Password\"/>\r\n");
      out.write("                    <input id=\"createdbyip\" type=\"hidden\" value=\"100.100.100.100\" name=\"createdbyip\"/>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <div class=\"form-group\">\r\n");
      out.write("                    <button class=\"btn btn-block btn-round btn-b\">Register</button>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </form>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        \r\n");
      out.write("        <hr class=\"divider-d\">\r\n");
      out.write("        <footer class=\"footer bg-dark\">\r\n");
      out.write("          <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("              <div class=\"col-sm-6\">\r\n");
      out.write("                <p class=\"copyright font-alt\">&copy; 2017&nbsp;<a href=\"index.jsp\">TitaN</a>, All Rights Reserved</p>\r\n");
      out.write("              </div>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t<div class=\"footer-social-links\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-twitter\"></i></a><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-dribbble\"></i></a><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-skype\"></i>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"scroll-up\"><a href=\"#totop\"><i class=\"fa fa-angle-double-up\"></i></a></div>\r\n");
      out.write("    </main>\r\n");
      out.write("    <!--  \r\n");
      out.write("    JavaScripts\r\n");
      out.write("    =============================================\r\n");
      out.write("    -->\r\n");
      out.write("    <script src=\"assets/lib/jquery/dist/jquery.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/bootstrap/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/wow/dist/wow.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/jquery.mb.ytplayer/dist/jquery.mb.YTPlayer.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/isotope/dist/isotope.pkgd.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/imagesloaded/imagesloaded.pkgd.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/flexslider/jquery.flexslider.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/owl.carousel/dist/owl.carousel.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/smoothscroll.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/magnific-popup/dist/jquery.magnific-popup.js\"></script>\r\n");
      out.write("    <script src=\"assets/lib/simple-text-rotator/jquery.simple-text-rotator.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/plugins.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/main.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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