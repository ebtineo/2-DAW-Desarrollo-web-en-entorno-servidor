/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alberto
 */
@WebServlet(name = "E04EcuSegundoGrado", urlPatterns = {"/E04EcuSegundoGrado"})
public class E04EcuSegundoGrado extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");//iso-8859-1
        try (PrintWriter out = response.getWriter()) {

            //Obtener datos, validar y convertir
            boolean valoresRecibidos = request.getParameter("numero1") != null;
            double num1 = 0.0;
            double num2 = 0.0;
            double num3 = 0.0;
            double raiz;
            double x1, x2;
            String resultado = "";

            if (request.getParameter("numero1") != null) {
                try {
                    num1 = Double.parseDouble(request.getParameter("numero1"));
                } catch (NumberFormatException e) {

                }
            }
            if (request.getParameter("numero2") != null) {
                try {
                    num2 = Double.parseDouble(request.getParameter("numero2"));
                } catch (NumberFormatException e) {

                }
            }
            if (request.getParameter("numero3") != null) {
                try {
                    num3 = Double.parseDouble(request.getParameter("numero3"));
                } catch (NumberFormatException e) {

                }
            }

            //Lógica negocio
            if (valoresRecibidos) {
                raiz = ((num2 * num2) - (4 * num1 * num3));
                if (raiz < 0) {
                    resultado = "No tiene soluciones reales";
                } else {
                    if (num1 == 0) {
                        resultado = "La ecuacion no es de segundo grado. O no se ha introducido valores";
                    } else {
                        x1 = (-num2 + Math.sqrt(raiz)) / (2 * num1);
                        x2 = (-num2 - Math.sqrt(raiz)) / (2 * num1);
                        resultado = "Resultados: <br> " + "x1 = " + x1 + "<br>x2=  " + x2;
                    }
                }
            }

            //Vista
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ecuacion Segundo Grado B02E04</title>");
            out.println("<style>"
                    + "body{background-color: #7fffd4; width: 800px; margin: 0 auto; border: 1px solid red;}"
                    + "h1{text-align: center;}"
                    + "form{text-align: center;}"
                    + "p:first-line{color: red; font-size: xx-large}"
                    + "p{text-align: center;}"
                    + "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calculadora Ecuación Segundo Grado</h1>");
            out.println("");
            out.println("<form>");
            out.println("<label> a </label>");
            out.println("<input type='number' name='numero1' step='0.1' value ='"
                    + (valoresRecibidos ? num1 : "") + "'>");
            out.println("<label> b </label>");
            out.println("<input type='number' name='numero2' value ='"
                    + (valoresRecibidos ? num2 : "") + "'>");
            out.println("<label> c </label>");
            out.println("<input type='number' name='numero3' value ='"
                    + (valoresRecibidos ? num3 : "") + "'>");
            out.println("<input type='submit' value='Enviar'>");
            out.println("</form>");
            out.println("<p>" + resultado + "</p>");
            out.println("<a href='index.html'>Volver</a>");
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
        return "Calculadora ecuaciones segundo grado";
    }// </editor-fold>

}
