/*
 * Servlet Buscar
 * Permite buscar un termino en el diccionario
 */
package ejercicio9.servlets;

import ejercicio9.modelo.Diccionario;
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
@WebServlet(name = "Buscar", urlPatterns = {"/Buscar"})
public class Buscar extends HttpServlet {

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
            String termino = request.getParameter("termino");
            String definicion = "";
            if (termino != null) {
                Diccionario d = new Diccionario();
                definicion = d.buscar(termino);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Buscar en el Diccionario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Diccionario</h2>");
            out.println("<br>");
            out.println("<form method='post'>");
            out.println("Término a buscar");
            out.println("<input type='text' name='termino' required>");
            out.println("<input type='submit' value='Buscar'>");
            out.println("</form>");
            if (termino != null && !termino.equals("")) {
                if (definicion.substring(0, 2).equals("E:")) {
                    out.println("<div style='color:red;'>");
                    out.println(definicion.substring(2));
                } else {
                    out.println("<div style='color:blue;'>");
                    out.println(definicion);
                }
                out.println("</div>");
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
