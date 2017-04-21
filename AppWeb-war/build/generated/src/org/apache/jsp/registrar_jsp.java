package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registrar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <link href='style.css' rel='stylesheet' type='text/css'>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JobsNow</title>\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://use.fontawesome.com/40f6f1cf0c.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"middlePage\" style=\"margin-top:  0;\">\n");
      out.write("            <div class=\"page-header\">\n");
      out.write("                <h1 class=\"logo\">JobsNow <small>Welcome to our place!</small></h1>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"panel panel-info\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h3 class=\"panel-title\">Registrate</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-7\" style=\"border-left:1px solid #ccc;height:660px\">\n");
      out.write("                            <form class=\"form-horizontal\" action=\"ServletLogin\" method=\"post\">\n");
      out.write("                                <fieldset>\n");
      out.write("                                    <div class=\"spacing\"><small>Nombre</small></div>\n");
      out.write("                                    <input id=\"nombre\" name=\"nombre\" type=\"text\" placeholder=\"Nombre\" class=\"form-control input-md\" required=\"true\">\n");
      out.write("                                    <div class=\"spacing\"><small>Apellidos</small></div>\n");
      out.write("                                    <input id=\"apellidos\" name=\"apellidos\" type=\"text\" placeholder=\"Apellidos\" class=\"form-control input-md\" required=\"true\">\n");
      out.write("                                    <div class=\"spacing\"><small>Email</small></div>\n");
      out.write("                                    <input id=\"email\" name=\"email\" type=\"text\" placeholder=\"Email\" class=\"form-control input-md\" required=\"true\">\n");
      out.write("                                    <div class=\"spacing\"><small>Contraseña</small></div>\n");
      out.write("                                    <input id=\"password\" name=\"password\" type=\"password\" placeholder=\"Password\" class=\"form-control input-md\" required=\"true\">\n");
      out.write("                                    <div class=\"spacing\"><small>Repetir Contraseña</small></div>\n");
      out.write("                                    <input id=\"password2\" name=\"password2\" type=\"password\" placeholder=\"Password\" class=\"form-control input-md\" required=\"true\">\n");
      out.write("                                    <div class=\"spacing\"><small>Twitter</small></div>\n");
      out.write("                                    <input id=\"twitter\" name=\"twitter\" type=\"text\" placeholder=\"@NombreUsuario\" class=\"form-control input-md\">\n");
      out.write("                                    <div class=\"spacing\"><small>Instagram</small></div>\n");
      out.write("                                    <input id=\"instagram\" name=\"instagram\" type=\"text\" placeholder=\"@NombreUsuario\" class=\"form-control input-md\">\n");
      out.write("                                    <div class=\"spacing\"><small>Página Web</small></div>\n");
      out.write("                                    <input id=\"paginaweb\" name=\"paginaweb\" type=\"text\" placeholder=\"www.tuweb.com\" class=\"form-control input-md\">\n");
      out.write("                                    <div class=\"spacing\"><small>Foto</small></div>\n");
      out.write("                                    <input id=\"imagen\" name=\"nombre\" type=\"file\" placeholder=\"Foto\" class=\"form-control input-md\" required=\"true\">\n");
      out.write("                                    <div class=\"spacing\"></div>\n");
      out.write("                                    <button id=\"singlebutton\" name=\"singlebutton\" class=\"btn btn-info btn-sm pull-right\">Registrarse</button>\n");
      out.write("                                </fieldset>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
