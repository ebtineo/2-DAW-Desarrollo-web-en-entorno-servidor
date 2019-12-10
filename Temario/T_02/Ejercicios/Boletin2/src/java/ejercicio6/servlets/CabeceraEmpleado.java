/*
 * Servlet CabeceraEmpleado
 * Cabecera para las páginas de gestión de Empleados
 */
package ejercicio6.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jose
 */
@WebServlet(name = "CabeceraEmpleado", urlPatterns = {"/CabeceraEmpleado"})
public class CabeceraEmpleado extends HttpServlet {

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

        HttpSession sesion = request.getSession();
/*
        if (sesion.getAttribute("usuario") == null) {
            request.getRequestDispatcher("/LoginEmpleado").forward(request, response);
        }
*/
        String nombreUsuario = sesion.getAttribute("usuario").toString();
        try {
            PrintWriter out = response.getWriter();
            out.println("<meta http-eqiv='refresh' content='0;url=LoginEmpleado'>");
            out.println("<div style='background-color: lightblue;text-align: center'><br>");
            out.println("<h2>" + request.getAttribute("titulo") + "</h2>");
            out.println(nombreUsuario);
            out.println("<img src='imagenes/perfil.jpeg' alt=''>");
            out.println("<br><br></div>");
        } catch (Exception e) {
            System.err.println(e.getMessage());
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
