package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedList;
import java.util.List;
import modelo.Receta;
import modelo.Usuario;

public final class mostrarRecetas_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      modelo.ModeloRecetas todasLasRecetas = null;
      synchronized (application) {
        todasLasRecetas = (modelo.ModeloRecetas) _jspx_page_context.getAttribute("todasLasRecetas", PageContext.APPLICATION_SCOPE);
        if (todasLasRecetas == null){
          todasLasRecetas = new modelo.ModeloRecetas();
          _jspx_page_context.setAttribute("todasLasRecetas", todasLasRecetas, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write('\n');
      modelo.Usuario usuario = null;
      synchronized (session) {
        usuario = (modelo.Usuario) _jspx_page_context.getAttribute("usuario", PageContext.SESSION_SCOPE);
        if (usuario == null){
          usuario = new modelo.Usuario();
          _jspx_page_context.setAttribute("usuario", usuario, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
      modelo.Receta recetaNueva = null;
      synchronized (_jspx_page_context) {
        recetaNueva = (modelo.Receta) _jspx_page_context.getAttribute("recetaNueva", PageContext.PAGE_SCOPE);
        if (recetaNueva == null){
          recetaNueva = new modelo.Receta();
          _jspx_page_context.setAttribute("recetaNueva", recetaNueva, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("recetaNueva"), "nombre", request.getParameter("nuevaReceta"), request, "nuevaReceta", false);
      out.write('\n');

    //Usuario usuario = (Usuario)session.getAttribute("usuario");
    // Buscamos la receta entre la lista global
    //String nuevaReceta = request.getParameter("nuevaReceta");
    if (recetaNueva.getNombre()!=null) {
        usuario.nuevaRecetaFavorita(
                todasLasRecetas.buscarReceta(recetaNueva.getNombre()));                
    }
    pageContext.setAttribute("mensaje", session.getAttribute("mensaje"));
    session.removeAttribute("mensaje");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Mis Recetas Favoritas</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/principal.css\">\n");
      out.write("        <script src=\"js/miScript.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"mostrar('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("')\">\n");
      out.write("        <br>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "cabeceraUsuario.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"titulo\">\n");
      out.write("            <h2>Mis Recetas Favoritas</h2>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"centrado\">\n");
      out.write("            ");
      out.print( usuario.getRecetasFavoritas().isEmpty()?"<h3>No hay ninguna receta favorita</h3>":"" );
      out.write("\n");
      out.write("\n");
      out.write("            <table>\n");
      out.write("                ");

                    for (Receta receta : usuario.getRecetasFavoritas()) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td><b>");
      out.print(receta.getNombre() );
      out.write("</b></td>\n");
      out.write("                    <td> de ");
      out.print(receta.getAutor().getNombre() );
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"detalleReceta.jsp\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"receta\" value=\"");
      out.print(receta.getNombre() );
      out.write("\">\n");
      out.write("                            <input type=\"submit\" name=\"receta\" value=\"Ver Detalles\">\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"formulario centrado\">\n");
      out.write("            <label>Añadir una receta a mis favoritas </label>\n");
      out.write("            <form method=\"post\">\n");
      out.write("                <select name=\"nuevaReceta\">\n");
      out.write("                    ");

                        for (Receta receta : todasLasRecetas.getTodasLasRecetas()) {
                            if (!usuario.getRecetasFavoritas().contains(receta)) {
                    
      out.write("   \n");
      out.write("                    <option value=\"");
      out.print(receta.getNombre() );
      out.write("\"><b>");
      out.print(receta.getNombre());
      out.write("</b> de ");
      out.print(receta.getAutor().getNombre());
      out.write(" </option>\n");
      out.write("                    ");

                            }
                        }
                    
      out.write("\n");
      out.write("                </select>\n");
      out.write("                <input type=\"submit\" value=\"Añadir\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"centrado\" style=\"text-align: center;\">\n");
      out.write("            <a href=\"crearReceta.jsp\"><button>Crear una nueva receta</button></a>\n");
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
