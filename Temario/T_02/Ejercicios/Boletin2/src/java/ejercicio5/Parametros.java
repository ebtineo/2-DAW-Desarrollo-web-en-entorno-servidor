/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "Parametros", urlPatterns = {"/Parametros"})
public class Parametros extends HttpServlet {

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

            //Obtener datos, validar y convertir.
            Enumeration<String> parametros;
            parametros = request.getParameterNames();
            String nombre = null;
            String[] valores = null;

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParametrosB02E05</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Nombre y valores de los parametros</h2>");
            //out.println("<h1>Servlet ParametrosB02E05 at " + request.getContextPath() + "</h1>");
            if (!parametros.hasMoreElements()) {
                out.println("<p>No se han introducido parametros</p>");
            } else {
                out.println("<ul>");
                while (parametros.hasMoreElements()) {
                    nombre = parametros.nextElement();
                    valores = request.getParameterValues(nombre);
                    out.println("<li>");
                    if (valores.length == 1) {
                        out.println(nombre + " = " + valores[0]);
                    } else {
                        out.println(nombre + ":");
                        out.println("<ul>");
                        for (String valor : valores) {
                            out.println("<li>" + valor + "</li>");
                        }
                        out.println("</ul>");
                    }
                    out.println("</li>");
                }
                out.println("</ul>");
            }

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
        return "Short description";
    }// </editor-fold>

}
