package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Datos;

/**
 *
 * @author WorKeLid
 */
public class Grafica extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession sesion = request.getSession();
            Datos datos = null;
            if (sesion.getAttribute("datos") != null) {
                datos = (Datos) sesion.getAttribute("datos");
            } else {
                response.sendRedirect("ListaValores");
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<script>");
                out.println("var datos = " + datos.toString());
                out.println("var etiquetas = " + datos.getEtiquetas());
                out.println("</script>");
                out.println("<script src='grafica.js'></script>");
                out.println("<title>Temperaturas</title>");            
            out.println("</head>");
            
            out.println("<body onload='dibujar_grafica()'>");
            out.println("<h3>Temperaturas</h3>");
            out.println("<canvas id=\'grafica\' height=\'400\' width=\'800\' style=\'background-color: lightgrey;\' ></canvas>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}