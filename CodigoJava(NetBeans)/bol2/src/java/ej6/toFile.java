package ej6;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* ENUNCIADO
6. Desarrollar una pequeña aplicación web para registrar datos del personal de una
organizción. La aplicación contendrá una página HTML con un formulario que permitirá
introducir los datos de una persona (nombre, apellidos, categoría profesional , fecha de
nacimiento, etc). También tendrá un servlet que recibirá los datos del formulario anterior y
los escribirá en un fichero de texto. Además tendrá otro servlet que listará los datos del
personal. El formulario debe tener algún control de tipo combo (<select>) y algún grupo de
checkbox.
*/
public class toFile extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet toFile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet toFile at " + request.getContextPath() + "</h1>");
            
            if (request.getHeader("referer").equals("http://localhost:8080/bol2/form6.html")) {
                out.println("<p>Accedido desde el formulario: " + request.getHeader("referer") + "</p>");
                
                Persona p = new Persona(request.getParameter("nombre"), 
                    request.getParameter("apellidos"),
                    request.getParameter("categoria"), 
                    request.getParameter("nacimiento"));
                
                p.toFile("personas.txt");
                
                out.println("<p>" + p.toString() + "</p>");
                
            } else {
                out.println("<p>Necesitas acceder desde el formulario<p>");
                out.println("<p>" + request.getHeader("referer") + "<p>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}