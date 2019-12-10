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
@WebServlet(name = "ejerB02Ej04", urlPatterns = {"/ejerB02Ej04"})
public class ejerB02Ej04 extends HttpServlet {

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
            out.println("<title>Servlet ejerB02Ej03</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ejerB02Ej03 at " + request.getContextPath() + "</h1>");

            if (request.getParameter("numero1") == null || request.getParameter("numero1") == null || request.getParameter("numero3") == null) {
                out.println("<p>Aun no se han introducido ningun numero</p>");
                out.println("<form action=\"ejerB02Ej03\" method=\"get\">\n"
                        + "<label>Primer numero\n"
                        + "<input type=\"number\" name=\"numero1\"></label>\n"
                        + "<label>Segundo numero\n"
                        + "<input type=\"number\" name=\"numero2\"></label>\n"
                        + "<label>Tercer numero\n"
                        + "<input type=\"number\" name=\"numero3\"></label>\n"
                        + "<input type=\"submit\" value=\"Enviar\">\n"
                        + "</form>");
            } else {
                out.println("<form action=\"ejerB02Ej03\" method=\"get\">\n"
                        + "<label>Primer numero\n"
                        + "<input type=\"number\" name=\"numero1\"></label>\n"
                        + "<label>Segundo numero\n"
                        + "<input type=\"number\" name=\"numero2\"></label>\n"
                        + "<label>Tercer numero\n"
                        + "<input type=\"number\" name=\"numero3\"></label>\n"
                        + "<input type=\"submit\" value=\"Enviar\">\n"
                        + "</form>");
                double num1 = Double.parseDouble(request.getParameter("numero1"));
                double num2 = Double.parseDouble(request.getParameter("numero2"));
                double num3 = Double.parseDouble(request.getParameter("numero2"));
                //int numero;
                double raiz;
                double x1, x2;
                raiz = ((num2 * num2) - (4 * num1 * num3));
                if (raiz < 0) {
                    out.println("<p>No tiene soluciones reales</p>");
                } else {
                    if (num1 == 0) {
                        out.println("<p>La ecuacion no es de segundo grado</p>");
                    } else {
                        x1 = (-num2 + Math.sqrt(raiz)) / (2 * num1);
                        x2 = (-num2 - Math.sqrt(raiz)) / (2 * num1);
                        out.println("<p>Resultado " + x1 + "</p>");
                        out.println("<p>Resultado " + x2 + "</p>");
                    }
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
