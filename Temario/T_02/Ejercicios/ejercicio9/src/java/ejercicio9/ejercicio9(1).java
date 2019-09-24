package ejercicio9;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ejercicio9"})
public class ejercicio9 extends HttpServlet {

    Map<String, String> diccionario = new HashMap<>();

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

        diccionario.put("Perro", "Significado perro");
        diccionario.put("Gato", "Significado gato");
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
            buscapalabra(request, out);
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void buscapalabra(HttpServletRequest request, PrintWriter out) {
        String palabra = request.getParameter("palabra");

        if (palabra == null || !diccionario.containsKey(palabra)) {
            System.out.println("No se encontró la palabra");
        } else {
            
            out.println(diccionario.get(palabra));
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
