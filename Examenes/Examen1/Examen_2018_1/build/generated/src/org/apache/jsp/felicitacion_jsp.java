package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class felicitacion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      modelo.Arbol arbol = null;
      synchronized (session) {
        arbol = (modelo.Arbol) _jspx_page_context.getAttribute("arbol", PageContext.SESSION_SCOPE);
        if (arbol == null){
          arbol = new modelo.Arbol();
          _jspx_page_context.setAttribute("arbol", arbol, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
      out.write("        <title>Feliz Navidad</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/principal.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            if (arbol.getIntentos()<5) {
        
      out.write("\n");
      out.write("        <h2>Lo has hecho muy bien</h2>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <div id=\"div_felicitacion\">\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        ");

            if (session.getAttribute("nombre")!=null) {
        
      out.write("\n");
      out.write("        <h2>Felicidades, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <form action=\"arbolNavidad.jsp\">\n");
      out.write("            <input type=\"submit\" value=\"Empezar de nuevo\"\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");

    session.invalidate();

      out.write('\n');
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
