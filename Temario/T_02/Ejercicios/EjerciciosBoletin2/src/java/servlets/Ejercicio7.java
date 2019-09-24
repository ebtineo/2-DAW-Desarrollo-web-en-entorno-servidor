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
 * @author Jonatán
 */
@WebServlet(urlPatterns={"/Ejercicio7"})
public class Ejercicio7 extends HttpServlet {

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
        
        String convertirCaF = request.getParameter("submit");
        String convertirFaC = request.getParameter("submit2");
        String gradosCelcius = request.getParameter("celcius");
        String gradosFahrenheit = request.getParameter("fahrenheit");
        
        String errores = "";
        double gradosC = 0, gradosF = 0;
        Temperatura t;
        
        try (PrintWriter out = response.getWriter()) {
            
            if (convertirCaF != null) {
                if (!gradosCelcius.equals("")) {
                    gradosC = Double.parseDouble(gradosCelcius);
                    t = new Temperatura(gradosC);
                    gradosC = Math.round(t.getGradoF()*100)/100.0;
                } else {
                    errores += "Introduzca grados Celcius";
                }
            }

            if (convertirFaC != null) {
                if (!gradosFahrenheit.equals("")) {
                    gradosF = Double.parseDouble(gradosFahrenheit);
                    t = new Temperatura(gradosF);
                    gradosF = Math.round(t.getGradoC()*100)/100.0;
                }else{
                    errores += "Introduzca grados Fahrenheit";
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio7</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Temperatura</h1>");
            out.println("<form method='get'>");
            out.println("<br>");
            out.println("<label for='Celcius'>Grados Celcius: </label><input type='number' name='celcius' value="+gradosF+" step='0.02'> <input type='submit' name='submit' value='Convertir...'>");
            out.println("<br>");
            out.println("<label for='Fahrenheit'>Grados Fahrenheit: </label><input type='number' name='fahrenheit' value="+gradosC+" step='0.02'>  <input type='submit' name='submit2' value='Convertir...'>");
            out.println("<br>");
            out.println("</form>");
            out.println("<br>");
            if(!errores.equals("")){
              out.println("<p style=color:red>"+errores+"</p>");  
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
