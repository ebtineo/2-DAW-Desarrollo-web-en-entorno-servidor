package ejX1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WorKeLid
 */
public class ejX1_controlador extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ejX1_controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ejX1_controlador at " + request.getContextPath() + "</h1>");
            out.println("<br>");
            
            out.println("<form action='/bol2/ejX1_controlador' method='get'>");
                out.println("<input type='text' name='busqueda'>");
                out.println("<input type='submit' value='Buscar'><br>");
            out.println("</form>");
            
            out.println("<form action='/bol2/ejX1_controlador' method='get'>");
                out.println("Termino:<input type='text' name='termino'>");
                out.println("Definicion:<input type='text' name='definicion'>");
                out.println("<input type='submit' value='Insertar'><br>");
            out.println("</form>");
            
            if (request.getParameterNames().hasMoreElements()) {
                Diccionario dc = new Diccionario();
                out.println("<p>");
                
                if (request.getParameter("busqueda") != null) {
                    out.println("Busqueda: " + dc.buscar(request.getParameter("busqueda")));
                } else {
                    request.getParameterMap().forEach((clave, valor) ->
                        out.println("Clave: " + clave + ", Valor: " + Arrays.deepToString(valor) + "<br />"));
                        dc.insertar(clave, Arrays.deepToString(valor));
                }
                
                out.println("</p>");
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
