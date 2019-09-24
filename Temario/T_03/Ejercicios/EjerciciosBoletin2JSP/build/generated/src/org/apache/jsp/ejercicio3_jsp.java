package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Random;

public final class ejercicio3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
    String error = "";
    int n1=0, n2=0;
    int aleatorio=0;
    String cadenaN1 = request.getParameter("campo1");
    String cadenaN2 = request.getParameter("campo2");
    if (cadenaN1 != null) {
        try {
            n1 = Integer.parseInt(cadenaN1);
        } catch (NumberFormatException e) {
            error += "El limite inferior no es correcto";
        }
    }
    if (cadenaN2 != null) {
        try {
            n2 = Integer.parseInt(cadenaN2);
        } catch (NumberFormatException e) {
            error += "El limite superior no es correcto";
        }
    }
    if (error.equals("") && cadenaN1!=null && cadenaN2!=null) {
        if (n1 > n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        Random r = new Random();
        aleatorio = n1 + r.nextInt(n2-n1);
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
      out.write("        <h1>Generador de numeros aleatorios</h1>\n");
      out.write("        <form method=\"post\">\n");
      out.write("        Introduzca el primer numero: <input type=\"text\" name=\"campo1\" ");
      out.print( "value='"+n1+"'");
      out.write("> <br>\n");
      out.write("        Introduzca el segundo numero: <input type=\"text\" name=\"campo2\" ");
      out.print( "value='"+n2+"'");
      out.write("> <br>\n");
      out.write("        <input type=\"submit\" value=\"Generar numero\">\n");
      out.write("        </form>\n");
      out.write("        ");

            if (!error.equals("")) {
                out.println("<div style='color:red;'>" + error + "</div>");
            } else {
                if (cadenaN1!=null && cadenaN2!=null) {
                    out.println("<h2>" + aleatorio + "</h2>");
                }
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
