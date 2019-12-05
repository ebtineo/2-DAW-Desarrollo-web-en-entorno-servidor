package ej6;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            
            /* El request debe de venir del formulario ej6_form.html */
            if (request.getHeader("referer").equals("http://localhost:8080/bol2/ej6_form.html")) {
                out.println("<p>Accedido desde el formulario: " + request.getHeader("referer") + "</p>");
                
                /* En condiciones normales, evaluariamos la validez de los datos */
                Persona p = new Persona(request.getParameter("nombre"), 
                    request.getParameter("apellidos"),
                    request.getParameter("categoria"), 
                    request.getParameter("nacimiento"));
                
                /* 
                    String ruta contiene la direccion donde quiero guardar el archivo de texto.
                
                    getServletContext().getInitParameter() está accediendo al parametro root del web.xml
                            <context-param>
                                <description>Raiz de NetBeans</description>
                                <param-name>root</param-name>
                                <param-value>C:\Users\ . . . \CodigoJava(NetBeans)</param-value>
                            </context-param>
                    root va a ser la direccion raiz donde tengo los projectos netbeans
                    Por eso luego tengo que especificar donde quiero el archivo
                
                        "\\bol2\\src\\java\\ej6" + "\\personas.txt"
                
                    Es necesario las dobles barras
                */
                String ruta = getServletContext().getInitParameter("root") + "\\bol2\\src\\java\\ej6" + "\\personas.txt";
                
                // La clase Persona tiene un metodo para escribir en una direccion dada
                p.toFile(ruta);
                
                // El servlet toFile.java redirecciona a toSee.java
                response.sendRedirect("/bol2/toSee");
                
            } else {
                out.println("<p>Necesitas acceder desde el formulario<p>");
                out.println("<p>" + request.getHeader("referer") + "<p>");
                out.println("<hr><a href='/bol2/ej6_form.html'>Volver al formulario</a>");
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