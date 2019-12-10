package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Dato;
import modelo.Datos;

/**
 *
 * @author WorKeLid
 */
public class ListaValores extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* Evaluacion de sesion */
        HttpSession session = request.getSession();
        Datos datos;
        if (session.getAttribute("datos") == null) {
            datos = new Datos();
            session.setAttribute("datos", datos);
        } else {
            datos = (Datos) session.getAttribute("datos");
        }/* FIN evaluacion de sesion */
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet introducirDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Valores de Temperatura</h1>");
            
            if (datos.size() <= 0) { // La tabla esta vacia
            } else {
                out.println("<label>Periodo :</label><label> Valor</label><br>");
                for (Dato d : datos) {
                    out.println("<label>" + d.getEtiqueta() + ": </label>");
                    out.println(" <label>" + d.getValor() + "</label><br>");
                }
            }
            
            out.println("<form action='Controlador' method='get'>");
                out.println("<input type='text' name='etiqueta'>");
                out.println("<input type='number' name='valor'><br>");
                out.println("<input type='submit' name='add' value='add'><br>");
                out.println("<input type='submit' name='print' value='print'>");
            out.println("</form>");
            
            
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
}