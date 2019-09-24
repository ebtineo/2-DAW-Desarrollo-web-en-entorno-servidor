/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jose
 */
@WebServlet(name = "LoginPIN", urlPatterns = {"/LoginPIN"})
public class LoginPIN extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        List<Integer> teclas = (List)sesion.getAttribute("teclas");
        if (teclas == null) {
            teclas = generarTeclasAleatorias();
            sesion.setAttribute("teclas", teclas);
        }
        String pin = (String)sesion.getAttribute("pin");
        if (pin==null) {
            pin = "";
            sesion.setAttribute("pin", pin);
        }
        if (request.getParameter("pos")!=null) {
            int posicion = Integer.parseInt(request.getParameter("pos"));
            pin = pin + teclas.get(posicion);
            sesion.setAttribute("pin", pin);
        }
        if (request.getParameter("aceptar")!=null) {
            String nombre = request.getParameter("nombre");
            sesion.removeAttribute("teclas");
            if (Usuarios.validarUsuario(nombre, pin)) {
                sesion.setAttribute("nombre", nombre);
                response.sendRedirect("bienvenida.jsp");
                return;
            } else {
                response.sendRedirect("NoValidado");
                return;
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginPIN</title>");            
            out.println("</head>");
            out.println("<body>");
            for (int i=0;i<teclas.size();i++) {
                out.println("<form>");
                out.println("<input type='hidden' name='pos' value='" + i +"'>");
                out.println("<input type='submit' value='"+ teclas.get(i) + "'>");
                out.println("</form>");
            }
            out.println("<br>");
            out.println("<form>");
            out.println("<input type='text' name='nombre'>");
            out.println("<input type='submit' name='aceptar' value='aceptar'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public List<Integer> generarTeclasAleatorias() {
        List<Integer> teclas = new ArrayList();
        for (int i=0;i<10;i++) {
            teclas.add(i);
        }
        Collections.shuffle(teclas);
        return teclas;
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
