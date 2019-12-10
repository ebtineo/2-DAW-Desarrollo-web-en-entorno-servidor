/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "EcuacionSegundoGrado", urlPatterns = {"/EcuacionSegundoGrado"})
public class EcuacionSegundoGrado extends HttpServlet {

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
        String paramA = request.getParameter("a");
        String paramB = request.getParameter("b");
        String paramC = request.getParameter("c");
        String error = "";
        double a = 0.0, b = 0.0, c = 0.0;
        double x1 = 0.0, x2 = 0.0;
        if (paramA != null && paramB != null && paramC != null ) { // hay valores que procesar
            Scanner scA = new Scanner(paramA).useLocale(Locale.US);
            Scanner scB = new Scanner(paramB).useLocale(Locale.US);
            Scanner scC = new Scanner(paramC).useLocale(Locale.US);
            if (scA.hasNextDouble()) {
                a = scA.nextDouble();
            } else {
                error = error + "El coeficiente a no es un número real válido.\n";
            }
            if (scB.hasNextDouble()) {
                b = scB.nextDouble();
            } else {
                error = error + "El coeficiente b no es un número real válido\n";
            }
            if (scC.hasNextDouble()) {
                c = scC.nextDouble();
            } else {
                error = error + "El coeficiente c no es un número real válido.\n";
            }
            // Empezamos a calcular
            double discriminante = b*b - 4*a*c;
            if (discriminante <0) {
                error = error + "La ecuación no tiene soluciones reales.\n";
            } else {
                x1 = (-b + Math.sqrt(discriminante)) / (2*a);
                x2 = (-b - Math.sqrt(discriminante)) / (2*a);
            }
        } else {
                paramA = "";
                paramB = "";
                paramC = "";
            }
        response.setContentType("text/html;charset=iso-8859-1");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ecuación de 2º grado</title>"); 
            out.println("<link rel='stylesheet' href='estilos/principal.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='index.html'>Index</a>");
            out.println("<h2>Ecuación de 2º grado</h2><br>");
            out.println("<div>");
            out.println("<h3>Introduzca los coeficientes de la ecuación (números reales)</h3>");
            out.println("<br>");
            out.println("<form>");
            out.println("<input type='text' name='a' size='1' style='text-align:right;' value='" + paramA + "'>");
            out.println("x²+");
            out.println("<input type='text' name='b' size='1' style='text-align:right;' value='" + paramB + "'>");
            out.println("x+");
            out.println("<input type='text' name='c' size='1' style='text-align:right;' value='" + paramC + "'>");
            out.println("=0\t");
            out.println("<input type='submit' value='Resolver'>");
            out.println("</form>");
            out.println("</div>");
            out.println("<br><br>");
            if (request.getParameter("a")!=null) {
                if (error.equals("")){
                    out.println("<div>");
                    out.println("x<sub>1</sub>=" + x1);
                    out.println("<br><br>");
                    out.println("x<sub>2</sub>=" + x2);
                    out.println("</div>");
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
        return "Ecuaciones de Segundo Grado";
    }// </editor-fold>

}
