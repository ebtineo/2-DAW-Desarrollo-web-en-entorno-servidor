package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Usuario;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String error="";
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    if (login != null && password != null) {
        if (!login.equals("") && password.equals(login.toLowerCase())) {
            Usuario u = new Usuario();
            u.setLogin(login);
            u.setNombre(login.toUpperCase());
            session.setAttribute("usuario", u);
            response.sendRedirect("mostrarRecetas.jsp");
            return;
        } else {
            error = "Usuario o contraseña incorrectos";
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Recetas</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/principal.css\" >\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"titulo\">\n");
      out.write("            <h2>Inicio de Sesión</h2>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"centrado formulario\">\n");
      out.write("            <form method=\"post\">\n");
      out.write("                <table class=\"centrado\">\n");
      out.write("                    <tr><td><label>Usuario </label></td><td><input type=\"text\" name=\"login\"></td></tr>\n");
      out.write("                    <tr><td><label>Contraseña </label></td><td><input type=\"password\" name=\"password\"></td></tr>\n");
      out.write("                    <tr><td></td><td><input type=\"submit\" value=\"Iniciar Sesión\"></td></tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        ");

            if (!error.equals("")) {
        
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        <div class=\"error\">\n");
      out.write("            <h1>");
      out.print(error);
      out.write("</h1>\n");
      out.write("        </div>\n");
      out.write("        ");

            }
        
      out.write("\n");
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
