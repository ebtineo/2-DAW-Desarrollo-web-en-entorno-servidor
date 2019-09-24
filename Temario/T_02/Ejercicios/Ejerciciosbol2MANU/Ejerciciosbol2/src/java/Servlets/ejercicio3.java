/*
 *3. Realizar una aplicación web que pida dos números enteros al usuario y muestre un número
aleatorio que esté dentro del rango comprendido por esos dos números. El resultado se
mostrará junto al formulario, de forma que el usuario pueda volver a pedir otro número sin
cambiar de página.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
public class ejercicio3 extends HttpServlet {

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
            String cadenaN1 = request.getParameter("n1");
            String cadenaN2 = request.getParameter("n2");
            int n1 = 0, n2 = 0;
            int aleatorio = 0;

            //Comprobamos que el límite INFERIOR esté correctamente definido
            if (cadenaN1 != null) {
                try {
                    n1 = Integer.parseInt(cadenaN1);
                } catch (NumberFormatException ex) {
                    error += "El límite inferior no es correcto.<br>";
                }
            }
            //Comprobamos que el límite SUPERIOR esté correctamente definido
            if (cadenaN2 != null) {
                try {
                    n2 = Integer.parseInt(cadenaN2);
                } catch (NumberFormatException ex) {
                    error += "El límite superior no es correcto.<br>";
                }
            }

            if (error.equals("") && cadenaN1 != null && cadenaN2 != null) {
                if (n1 > n2) {
                    int temp = n1;
                    n1 = n2;
                    n2 = temp;
                }

                Random r = new Random();
                aleatorio = n1 + r.nextInt(n2 - n1 + 1);
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ejercicio3</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Números aleatorios (en un rango)</h3>");
            out.println("<form method='post'>");
            out.println("<label>Límit INFERIOR</label>");
            out.println("<input type='text' name='n1' value='" + (cadenaN1==null?"":cadenaN1) + "'>");
            out.println("<br>");
            out.println("<label>Límit SUPERIOR</label>");
            out.println("<input type='text' name='n2' value='"+ (cadenaN2==null?"":cadenaN2) +"'>");
            out.println("<br>");
            out.println("<input type='submit' value='Generar'>");
            out.println("</form>");

            if(!error.equals("")){
                out.println("<p style='color:red;'>" + error + "</p>");
            }else{
                if(cadenaN1 !=null && cadenaN2!=null){
                    out.println("<h2>" + aleatorio + "</h2>");
                }
            }
            out.println("<a href=''>Volver al formulario</a>");
            out.println("<br>");
            out.println("<a href='index.html'>Volver al índice</a>");
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
