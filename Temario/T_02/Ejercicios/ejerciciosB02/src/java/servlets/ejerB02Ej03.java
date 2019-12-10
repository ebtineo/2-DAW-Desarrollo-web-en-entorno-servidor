/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alberto
 */
@WebServlet(name = "ejerB02Ej02", urlPatterns = {"/ejerB02Ej02"})
public class ejerB02Ej03 extends HttpServlet {

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
            out.println("<title>Servlet ejerB02Ej02</title>");
            out.println("</head>");
            out.println("<body>");
            //Ejercicio 02
            //out.println("<p>Contenido de la frase en mayusculas<br> " + request.getParameter("texto").toUpperCase() + "</p>");
            //Ejercicio 03
            
            if (request.getParameter("numero1") == null || request.getParameter("numero1") == null) {
                out.println("<p>Aun no se han introducido ningun numero</p>");
                out.println("<form action=\"ejerB02Ej02\" method=\"get\">\n"
                        + "<label>Primer numero\n"
                        + "<input type=\"number\" name=\"numero1\"></label>\n"
                        + "<label>Segundo numero\n"
                        + "<input type=\"number\" name=\"numero2\"></label>\n"
                        + "<input type=\"submit\" value=\"Enviar\">\n"
                        + "</form>");
            } else {
                out.println("<form action=\"ejerB02Ej02\" method=\"get\">\n"
                        + "<label>Primer numero\n"
                        + "<input type=\"number\" name=\"numero1\"></label>\n"
                        + "<label>Segundo numero\n"
                        + "<input type=\"number\" name=\"numero2\"></label>\n"
                        + "<input type=\"submit\" value=\"Enviar\">\n"
                        + "</form>");
                int num1 = Integer.parseInt(request.getParameter("numero1"));
                int num2 = Integer.parseInt(request.getParameter("numero2"));
                int numero;
                if(num1>num2){
                    numero = (int)(Math.random()*(num1-num2+1)+num2);
                    out.println("<p>Numero aleatorio: "+ numero +"</p>");
                }else{
                    numero = (int)(int)(Math.random()*(num2-num1+1)+num1);
                    out.println("<p>Numero aleatorio: "+ numero +"</p>");
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
        return "Short description";
    }// </editor-fold>

}
