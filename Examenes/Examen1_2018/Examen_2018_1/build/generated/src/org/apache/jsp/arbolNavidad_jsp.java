package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Bola;

public final class arbolNavidad_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      modelo.Arbol arbol = null;
      synchronized (session) {
        arbol = (modelo.Arbol) _jspx_page_context.getAttribute("arbol", PageContext.SESSION_SCOPE);
        if (arbol == null){
          arbol = new modelo.Arbol();
          _jspx_page_context.setAttribute("arbol", arbol, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      modelo.Posicion posicion = null;
      synchronized (_jspx_page_context) {
        posicion = (modelo.Posicion) _jspx_page_context.getAttribute("posicion", PageContext.PAGE_SCOPE);
        if (posicion == null){
          posicion = new modelo.Posicion();
          _jspx_page_context.setAttribute("posicion", posicion, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("posicion"), request);
      out.write('\n');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${arbol.cambiar(posicion.fila, posicion.columna)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('\n');
      out.write('\n');

    if (arbol.coloresConsecutivos() == 0) {
        response.sendRedirect("felicitación.jsp");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Coloca las bolas del árbol</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/principal.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"div_imagen\">\n");
      out.write("            <div class=\"fila\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"fila\">\n");
      out.write("            </div>\n");
      out.write("            ");

                for (int fila = 0; fila < arbol.getProfundidad(); fila++) {
            
      out.write("\n");
      out.write("            <div class=\"fila\">\n");
      out.write("                ");

                    Bola[] filaBolas = arbol.getFila(fila);
                    for (int columna = 0; columna < filaBolas.length; columna++) {
                
      out.write("\n");
      out.write("                <form>\n");
      out.write("                    <div clas=\"bola\">\n");
      out.write("                    <input type=\"image\" src=\"");
      out.print( filaBolas[columna].getImagen() );
      out.write("\" name=\"bola1\">\n");
      out.write("                    <input type=\"hidden\" name=\"fila\" value=\"");
      out.print( fila);
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"columna\" value=\"");
      out.print( columna);
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"panel\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            Número de Intentos: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${arbol.intentos}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            Número de bolas consecutivas \n");
      out.write("            <br>\n");
      out.write("            del mismo color:\n");
      out.write("            <br>\n");
      out.write("            <div class=\"puntuacion\">\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${arbol.coloresConsecutivos()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
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
