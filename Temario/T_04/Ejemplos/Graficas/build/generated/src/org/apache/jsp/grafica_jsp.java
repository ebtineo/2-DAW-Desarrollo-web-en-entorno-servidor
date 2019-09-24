package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class grafica_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      beans.Datos datos = null;
      synchronized (_jspx_page_context) {
        datos = (beans.Datos) _jspx_page_context.getAttribute("datos", PageContext.PAGE_SCOPE);
        if (datos == null){
          datos = new beans.Datos();
          _jspx_page_context.setAttribute("datos", datos, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script>\n");
      out.write("            function dibujar_grafica() {\n");
      out.write("                var datos = [\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ];\n");
      out.write("                var canvas = document.getElementById('grafica');\n");
      out.write("                var gr = canvas.getContext('2d');\n");
      out.write("                gr.font='15px Arial';\n");
      out.write("                gr.beginPath();\n");
      out.write("                // obtenemos las dimensiones del canvas\n");
      out.write("                ancho = canvas.clientWidth;\n");
      out.write("                alto = canvas.clientHeight;\n");
      out.write("                // Dibujamos dejando un margen del 10%\n");
      out.write("                x_derecha = ancho * 0.1;\n");
      out.write("                y_abajo = alto * 0.9;\n");
      out.write("                // Buscamos el maximo de las temperaturas\n");
      out.write("                min =  100000;\n");
      out.write("                max = -100000;\n");
      out.write("                for (i=0;i<datos.length;i++) {\n");
      out.write("                    if (datos[i]>max) {\n");
      out.write("                        max = datos[i];\n");
      out.write("                    }\n");
      out.write("                    if (datos[i]<min) {\n");
      out.write("                        min = datos[i];\n");
      out.write("                    }    \n");
      out.write("                }\n");
      out.write("                // Calculamos la escala vertical y el paso horizontal\n");
      out.write("                escala_y = alto*0.8/(max-min);\n");
      out.write("                paso_x = ancho*0.8/datos.length;\n");
      out.write("                gr.fillStyle='#F02000';\n");
      out.write("                // Nos posicionamos en el primer punto de la grafica\n");
      out.write("                gr.moveTo(x_derecha, y_abajo-(datos[0]-min)*escala_y);\n");
      out.write("                x = x_derecha;\n");
      out.write("                // Recorremos el resto de los datos dibujando segmentos de linea\n");
      out.write("                for(i=1;i<datos.length;i++) {\n");
      out.write("                    x+=paso_x;\n");
      out.write("                    gr.lineTo(x,y_abajo-(datos[i]-min)*escala_y);\n");
      out.write("                    // Cada 6 puntos mostramos el valor\n");
      out.write("                    if(i%6==0) {\n");
      out.write("                        gr.fillText(datos[i]+'º',x+10,y_abajo-(datos[i]-min)*escala_y);\n");
      out.write("                    }    \n");
      out.write("                }\n");
      out.write("                gr.strokeStyle='#0020F0';\n");
      out.write("                gr.lineWidth = 4;\n");
      out.write("                // Terminamos la grafica\n");
      out.write("                gr.stroke();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Temperaturas</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"dibujar_grafica()\">\n");
      out.write("        <h3>Temperaturas</h3>\n");
      out.write("        \n");
      out.write("        <canvas id=\"grafica\" height=\"400\" width=\"800\" style=\"background-color: lightgrey\" ></canvas>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${datos.datos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("dato");
    _jspx_th_c_forEach_0.setVarStatus("status");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dato.temperatura}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                                ");
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!status.last}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    ,\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
