/*
 * Generar un número aleatorio
 * comprendido en un rango dado por el usuario
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
public class Ejercicio3 extends HttpServlet {

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
            String error = "";
            int n1=0, n2=0;
            int aleatorio = 0;
            String cadenaN1 = request.getParameter("n1");
            String cadenaN2 = request.getParameter("n2");
            if (cadenaN1!= null) {
                try {
                    n1 = Integer.parseInt(cadenaN1);
                } catch (NumberFormatException e) {
                    error += "El límite inferior no es correcto<br>";
                }
            }
            if (cadenaN2!=null) {
                try {
                    n2 = Integer.parseInt(cadenaN2);
                } catch (NumberFormatException e) {
                    error += "El límite superior no es correcto<br>";
                }
            }
            if (error.equals("") && cadenaN1 != null && cadenaN2 != null) {
                if (n1>n2) {
                    int temp = n1;
                    n1 = n2;
                    n2 = temp;
                }
                Random r = new Random();
                aleatorio = n1 + r.nextInt(n2-n1+1);
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Números aleatorios</h2>");
            out.println("<form method='post'>");
            out.println("<label>Límite inferior</label>");
            out.println("<input type='text' name='n1' value='"+ (cadenaN1==null?"":cadenaN1) + "'>");
            out.println("<br>");
            out.println("<label>Límite superior</label>");
            out.println("<input type='text' name='n2' value='" + (cadenaN2==null?"":cadenaN2) + "'>");
            out.println("<br>");
            out.println("<input type='submit' value='Calcular'>");
            out.println("</form>");
            if (!error.equals("")) {
                out.println("<div style='color:red;' >" + error + "</div");
            } else {
                if (cadenaN1!=null && cadenaN2!=null) {
                    out.println("<h2>" + aleatorio + "</h2>");
                }
            } 
            out.println("<br><br><a href='index.html'>Volver al menú</a>");
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
