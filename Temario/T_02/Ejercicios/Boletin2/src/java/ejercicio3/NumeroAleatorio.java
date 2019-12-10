/*
 * Servlet NumeroAleatorio
 * Genera un número aleatorio comprendido entre los valores 
 * seleccionados por el usuario
 */
package ejercicio3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "NumeroAleatorio", urlPatterns = {"/NumeroAleatorio"})
public class NumeroAleatorio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Obtener datos, validar y convertir
            int limiteInferior = 0, limiteSuperior = 0;
            String limiteInferiorStr, limiteSuperiorStr;
            String error = "";
            boolean valoresRecibidos = request.getParameter("limiteInferior") != null;
            
            
            limiteInferiorStr = request.getParameter("limiteInferior");
            limiteSuperiorStr = request.getParameter("limiteSuperior");
            if (limiteInferiorStr != null) {
                try {
                    limiteInferior = Integer.parseInt(limiteInferiorStr);
                } catch (NumberFormatException e) {
                    error += "El límite inferior debe ser un número<br>";
                }
            }
            if (limiteSuperiorStr != null) {
                try {
                    limiteSuperior = Integer.parseInt(limiteSuperiorStr);
                } catch (NumberFormatException e) {
                    error += "El límite superior debe ser un número<br>";
                }
            }
            
            // Lógica de negocio
            int numeroAleatorio = 0;
            if (valoresRecibidos && error.equals("")) {
                if (limiteInferior > limiteSuperior){
                    error += "El límite inferior es mayor que el superior<br>";
                }
                numeroAleatorio = limiteInferior + (int)(Math.random() * (1 + limiteSuperior - limiteInferior));
            }
            
            // Vista
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Numero Aleatorio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Numero Aleatorio</h2>");
            out.println("<form>");
            out.println("<label>Límite Inferior</label>");
            out.println("<input type='number' name='limiteInferior' value ='" +
                    (valoresRecibidos?limiteInferiorStr:"") + "'>");
            out.println("<label>Límite Superior</label>");
            out.println("<input type='number' name='limiteSuperior' value='" 
                    + (valoresRecibidos?limiteSuperiorStr:"") + "'>");
            out.println("<input type='submit' value='Aceptar'>");
            out.println("</form>");
            out.println("<hr>");
            if (valoresRecibidos) {
                if (error.equals("")) {
                    out.println("<h3>" + numeroAleatorio + "</h3>");
                } else {
                    out.println("<div style='color:red;'>" + error + "</div>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
