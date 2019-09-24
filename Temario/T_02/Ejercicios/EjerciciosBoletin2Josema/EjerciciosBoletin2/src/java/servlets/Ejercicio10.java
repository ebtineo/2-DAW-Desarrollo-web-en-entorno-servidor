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
import javax.servlet.http.HttpSession;

/**
 *
 * @author josem
 */
@WebServlet(name = "Ejercicio10", urlPatterns = {"/Ejercicio10"})
public class Ejercicio10 extends HttpServlet {

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
        
        
        Validaciones va= new Validaciones();
        va.guardarDatosEnFichero("Josema", "1234");
        va.guardarDatosEnFichero("Anama", "1234");
        va.guardarDatosEnFichero("Lucia", "1234");
        
        //Creamos la sesion
        HttpSession misession= request.getSession(true);
        
        //Recogemos los parametros del formulario
        String botonEnviar = request.getParameter("enviar");
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("c");

        

        //Creamos una variale booleana para ver si el usuario ha sido encontrado
        boolean encontrado = false;
        
        if(botonEnviar != null){
            Validaciones v= new Validaciones();
            //Creamos un nuevo usuario con los datos recogidos en el formulario
            Usuario u= new Usuario(usuario, contraseña);
            //Metemos ne la variable el valor devuelto(trueo o false)
            encontrado=v.comprobarDatos(u);
        }
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ejercicio10</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ejercicio 10</h1>");
            out.println("<div style=\"text-align: center; background-color: blue; width: 400px; border: 2px solid black; margin: auto;\">");
            out.println("<h1>Inicio de Sesion</h1>");
            out.println("<form method='post'>");
            out.println("<label>Usuario: </label>");
            out.println("<input style=\"margin-left: 40px; margin-bottom: 10px;\" type=\"text\" name=\"usuario\"><br>");
            out.println("<label>Contraseña: </label>");
            out.println("<input style='margin-left: 20px;' type='password' name='c'><br>");
            out.println("<input style=\"margin: 10px;\" type=\"submit\" name=\"enviar\">");
            out.println("</form>");
            out.println("</div>");
            
 
            if(usuario!=null){
                if(encontrado!=true){
                     out.println("<h1 style='color:red; text-align:center;'>El usuario introducido o contraseña no son validos</h1>");
                }else{
                    //Cargamos la sesion 
                    misession.setAttribute("usuario",usuario);
                    //Abrimos el nuevo servlet
                    request.getRequestDispatcher("Bienvenida").forward(request, response);
                    //response.sendRedirect("Bienvenida");
                }     
            }
            
            
            out.println("<br><br><a href='index.html'>Volver al menú</a>");
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
