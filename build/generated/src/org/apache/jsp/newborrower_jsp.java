package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newborrower_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<title>Daily UI - Day 1 Sign In</title>\n");
      out.write("\n");
      out.write("\t<!-- Google Fonts -->\n");
      out.write("\t<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>\n");
      out.write("\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/animate.css\">\n");
      out.write("\t<!-- Custom Stylesheet -->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <form action =\"Borrower_Serv\" name=\"myform\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"top\">\n");
      out.write("\t\t\t<h1 id=\"title\" class=\"hidden\" align = center>New Borrower Details:</h1>\n");
      out.write("                        <h2 id=\"title\" class=\"hidden\" align = center><span id=\"logo\"><i><b>Fill all the details to successfully add the new borrower!</b></i></span></h2>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"login-box animated fadeInUp\">\n");
      out.write("\t\t\t<div class=\"box-header\">\n");
      out.write("\t\t\t\t<h2>New Borrower Details</h2>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<label for=\"firstname\">First Name: </label>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" name=\"first_name\" placeholder=\"First Name\" required>\n");
      out.write("\t\t\t<br/>\n");
      out.write("                        <label for=\"lastname\">Last Name: </label>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" name=\"last_name\" placeholder=\"Last Name\" required>\n");
      out.write("\t\t\t<br/>\n");
      out.write("                        <label for=\"ssn\">SSN: </label>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" name=\"ssn\" placeholder=\"Social Security Number\" required>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<label for=\"address\">Address: </label>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" name=\"address\" placeholder=\"Address\" required=\"true\">\n");
      out.write("\t\t\t<br/>\n");
      out.write("                        <label for=\"city\">City: </label>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" name=\"city\" placeholder=\"City\" required>\n");
      out.write("\t\t\t<br/>\n");
      out.write("                        <label for=\"state\">State: </label>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" name=\"state\" placeholder=\"State\" required>\n");
      out.write("\t\t\t<br/>\n");
      out.write("                        <label for=\"phone\">Phone: </label>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" name=\"phone_number\" placeholder=\"Phone Number\" required>\n");
      out.write("\t\t\t<br/>\n");
      out.write("\t\t\t<button type=\"submit\" style=\"width:195px\">Add</button>\n");
      out.write("\t\t\t<br/>\n");
      out.write("                        <br/>\n");
      out.write("                        <a href=\"./webpages/index.html\" align = center><u>Back</u></a>\n");
      out.write("<!--\t\t\t<a href=\"#\"><p class=\"small\">Forgot your password?</p></a>-->\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\t$(document).ready(function () {\n");
      out.write("    \t$('#logo').addClass('animated fadeInDown');\n");
      out.write("    \t$(\"input:text:visible:first\").focus();\n");
      out.write("\t});\n");
      out.write("\t$('#username').focus(function() {\n");
      out.write("\t\t$('label[for=\"username\"]').addClass('selected');\n");
      out.write("\t});\n");
      out.write("\t$('#username').blur(function() {\n");
      out.write("\t\t$('label[for=\"username\"]').removeClass('selected');\n");
      out.write("\t});\n");
      out.write("\t$('#password').focus(function() {\n");
      out.write("\t\t$('label[for=\"password\"]').addClass('selected');\n");
      out.write("\t});\n");
      out.write("\t$('#password').blur(function() {\n");
      out.write("\t\t$('label[for=\"password\"]').removeClass('selected');\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
