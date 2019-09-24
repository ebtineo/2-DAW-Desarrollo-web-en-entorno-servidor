package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class convertirTemperaturas_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      beans.Temperatura temperatura = null;
      synchronized (session) {
        temperatura = (beans.Temperatura) _jspx_page_context.getAttribute("temperatura", PageContext.SESSION_SCOPE);
        if (temperatura == null){
          temperatura = new beans.Temperatura();
          _jspx_page_context.setAttribute("temperatura", temperatura, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("<c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${! empty param.convertirAF}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("temperatura"), "gradoC", request.getParameter("gradoC"), request, "gradoC", false);
      out.write("\n");
      out.write("</c:if>\n");

    if (request.getParameter("convertirAC")!=null) {

      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("temperatura"), "gradoF", request.getParameter("gradoF"), request, "gradoF", false);
      out.write('\n');

    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Conversor de Temperaturas</h1>\n");
      out.write("        <br>\n");
      out.write("        <form>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label>Temperatura en ºC</label></td>\n");
      out.write("                    <td><input type=\"text\" name=\"gradoC\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${temperatura.gradoC}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\n");
      out.write("                    <td><input type=\"submit\" name=\"convertirAF\" value=\"Convertir a ºF\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><label>Temperatura en ºF</label></td>\n");
      out.write("                    <td><input type=\"text\" name=\"gradoF\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${temperatura.gradoF}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\n");
      out.write("                    <td><input type=\"submit\" name=\"convertirAC\" value=\"Convertir a ºC\"></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
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
