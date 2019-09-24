/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo
 */
public class Ej4 extends HttpServlet {

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
            double numA = 0, numB = 0, numC = 0;
            double raiz;
            double result1 = 0, result2 = 0;
            String cadenaA = request.getParameter("numA");
            String cadenaB = request.getParameter("numB");
            String cadenaC = request.getParameter("numC");
            if (cadenaA != null) {
                try {
                    numA = Integer.parseInt(cadenaA);
                } catch (NumberFormatException e) {
                    error += "El parametro A no es un numero entero<br>";
                }
            }
            if (cadenaB != null) {
                try {
                    numB = Integer.parseInt(cadenaB);
                } catch (NumberFormatException e) {
                    error += "El parametro B no es un numero entero<br>";
                }
            }
            if (cadenaC != null) {
                try {
                    numC = Integer.parseInt(cadenaC);
                } catch (NumberFormatException e) {
                    error += "El parametro C no es un numero entero<br>";
                }
            }
            if (error.equals("") && cadenaA!=null && cadenaB!=null && cadenaC!=null) {
                raiz = ((numB*numB) - (4*numA*numC));
                if (raiz < 0) {
                    error += "No existe solucion real para esta ecuacion<br>";
                } else {
                    if (numA == 0) {
                        error += "La ecuación no es de segundo grado<br>";
                    } else {
                        result1 = ((-numB + Math.sqrt(raiz)) / (2*numA));
                        result2 = ((-numB - Math.sqrt(raiz)) / (2*numA));
                    }
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ej4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Realizar ecuaciones de segundo grado</h1>");
            out.println("<div>");
            out.println("<h3>Introduzca los coeficientes de la ecuacion (numeros reales)</h3><br>");
            out.println("<form method='post'>");
            out.println("<input type='text' name='numA'>x<sup>2</sup>+<input type='text' name='numB'>x+<input type='text' name='numC'>=0");
            out.println("<br><input type='submit' value='Resolver'><br><br>");
            out.println("</form>");
            if (!error.equals("")) {
                out.println("<div style='color:red;'>" + error + "</div>");
            } else {
                out.println("x<sub>1</sub>=&nbsp" + result1 + "<br>");
                out.println("x<sub>2</sub>=&nbsp" + result2);
            }
            out.println("</div>");
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
