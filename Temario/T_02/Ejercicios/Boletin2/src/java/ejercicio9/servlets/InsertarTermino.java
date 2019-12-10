/*
 * Servlet InsertarTermino
 * Inserta un término y su definición en el diccionario
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author jose
 */
@WebServlet(name = "InsertarTermino", urlPatterns = {"/InsertarTermino"})
public class InsertarTermino extends HttpServlet {

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
        response.setContentType("text/html;charset=ISO-8859-1");
        try (PrintWriter out = response.getWriter()) {
            // Controlador
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("usuario") == null) {
                response.sendRedirect("Login");
                return;
            }
            String mensaje = "";
            String termino = request.getParameter("termino");
            String definicion = request.getParameter("definicion");
            if (termino != null && definicion !=null) {
                termino = termino.trim();
                if (!termino.equals("")) {
                    Diccionario d = new Diccionario();
                    if (d.insertar(termino.toLowerCase(), definicion)) {
                        mensaje = "Se ha introducido el término " + termino;
                    } else {
                        mensaje = "Error al introducir " + termino;
                    }
                }
            }
            
            // Vista        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Diccionario - Introducir Término</title>");
            if (!mensaje.equals("")) {
                out.println("<script>alert('" + mensaje + "')</script>");
            }
            out.println("</head>");
            out.println("<body>");
            out.println("<div style='background-color:lightblue;width:100%;'><br>" 
                    + sesion.getAttribute("usuario") +
                    "<br><span style='text-align:right;'><a href='CerrarSesion'>Cerrar Sesión</a>" +
                            "</span><br> "+ 
                            getServletContext().getAttribute("cuentaUsuarios") + " usuarios conectados</div>");
            out.println("<h2>Insertar Término</h2>");
            out.println("<br>");
            out.println("<form method='post'>");
            out.println("<label for='termino'>Término</label>");
            out.println("<input type='text' name='termino' id='termino' required>");
            out.println("<br>");
            out.println("<label for='definicion'>Definición</label>");
            out.println("<textarea name='definicion' id='definicion' required></textarea>");
            out.println("<br>");
            out.println("<input type='submit' value='Insertar'>");
            out.println("</form>");
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
