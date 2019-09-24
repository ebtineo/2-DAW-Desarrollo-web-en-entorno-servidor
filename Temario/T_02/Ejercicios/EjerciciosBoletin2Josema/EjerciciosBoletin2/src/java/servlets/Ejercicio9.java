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
 * @author josem
 */
@WebServlet(name = "Ejercicio9", urlPatterns = {"/Ejercicio9"})
public class Ejercicio9 extends HttpServlet {

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

        String botonAñadir = request.getParameter("add");
        String botonBuscar = request.getParameter("busqueda");
        
        String palabra = request.getParameter("word");
        String añadirD = request.getParameter("d");
        String añadirP = request.getParameter("p");
        String p="";

        Diccionario2 d = new Diccionario2();

        if (botonAñadir != null) {
            d.añadir(añadirP, añadirD);
        }

        if (botonBuscar != null) {
            p = d.buscar(palabra);
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ejercicio9</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ejercicio 9</h1>");
            out.println("<fieldset>");
            out.println("<legend>Buscar Palabras en Diccionario</legend>");
            out.println("<form>");
            out.println("Introduzca la palabra a buscar <input type='text' name='word'>");
            out.println("<input type='submit' name='busqueda'>");
            out.println("</form>");
            out.println("</fieldset>");
            out.println("<fieldset>");
            out.println("<legend>Añadir Palabras</legend>");
            out.println("<form>");
            out.println("Introduzca la palabra: <input type='text' name='p'>");
            out.println("Introduzca la definicion: <input type='text' name='d'>");
            out.println("<input type='submit' name='add'>");
            out.println("</form>");
            out.println("</fieldset>");
            if (p != null) {
                out.println("<h1>" + p + "</h1>");
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
