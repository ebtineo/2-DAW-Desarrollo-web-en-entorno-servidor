/*
 * Servlet VerImagem
 * Intercepta las peticiones a /imagenes/*, comprueba el
 * usuario conectado y reenvía la petición a la imagen correspondiente
 */
package ejercicio12;

import ejercicio10.modelo.Usuario;
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
@WebServlet(name = "VerImagen", urlPatterns = {"/imagenes/*"})
public class VerImagen extends HttpServlet {

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
        Usuario u = (Usuario)sesion.getAttribute("usuario");
        // Si el usuario no se ha registrado
        if (u == null) {
            response.sendRedirect("../Login");
            return;
        }
        response.addHeader("Cache-Control", "no-cache");
        String usuario = u.getNombreCompleto();
        /*
        String imagen = request.getRequestURI().substring(
                getServletContext().getContextPath().length() + 9 );
        */
        String imagen = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
        getServletContext().getRequestDispatcher(
                "/WEB-INF/imagenes/" + usuario + imagen).forward(request, response);
        //System.out.println("/WEB-INF/imagenes/" + usuario + imagen);
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
