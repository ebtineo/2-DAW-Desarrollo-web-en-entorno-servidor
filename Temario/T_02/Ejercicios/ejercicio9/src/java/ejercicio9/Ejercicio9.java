package ejercicio9;

import datos.Diccionario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ejercicio9"})
public class Ejercicio9 extends HttpServlet {


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
        Diccionario d = null;
        try {
            d= new Diccionario();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio9</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='ejercicio9' method='GET'>");
            out.println("<input type='text' name='palabra' placeholder='Palabra a buscar...'><br>");
            out.println("<input type='submit' value='Comprobar'>");
            buscapalabra(request, out, d);
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void buscapalabra(HttpServletRequest request, PrintWriter out, Diccionario d) {
        String palabra = request.getParameter("palabra");
        String definicion = d.buscar(palabra);
        if (palabra != null) {
            if (definicion == null) {
                out.println("No se encontró la palabra");
            } else {
                out.println(definicion);
            }
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
