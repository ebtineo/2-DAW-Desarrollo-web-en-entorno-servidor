package ej3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* ENUNCIADO
3. Realizar una aplicación web que pida dos números enteros al usuario y muestre
un número aleatorio que esté dentro del rango comprendido por esos dos números.
El resultado se mostrará junto al formulario, de forma que el usuario 
pueda volver a pedir otro número sin cambiar de página
*/
/* - - - Ejercicio del profesor - - - */
public class numeroAleatorio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // obtener datos, convertir y validar
            int limiteInferior = 0, limiteSuperior = 0;
            boolean valoresRecibidos = request.getParameter("limiteInferior") != null;
            String error = "";
            if (request.getParameter("limiteInferior") != null) {
                try {
                    limiteInferior = Integer.parseInt(request.getParameter("limiteInferior"));
                } catch (NumberFormatException n) {
                    error += "El limite inferior debe ser un numero\n";
                }
            }
            if (request.getParameter("limiteSuperior") != null) {
                try {
                    limiteSuperior = Integer.parseInt(request.getParameter("limiteSuperior"));
                } catch (NumberFormatException n) {
                    error += "El limite superior debe ser un numero\n";
                }
            }
            
            // Logica de negocio
            int numeroAleatorio = 0;
            if (valoresRecibidos && error.equals("")) {
                if (limiteInferior > limiteSuperior) {
                    error += "Limite superior es mayor que el superior";
                }
                numeroAleatorio = limiteInferior + (int)(Math.random() * (limiteSuperior - limiteInferior));
            }
            
            // Vista
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                out.println("<title>Servlet numeroAleatorio</title>");            
            out.println("</head>");
            out.println("<body>");
                out.println("<h1>Servlet numeroAleatorio at " + request.getContextPath() + "</h1>");
                out.println("<p>" + 
                        "3. Realizar una aplicación web que pida dos números enteros al usuario y muestre un número\n" +
"aleatorio que esté dentro del rango comprendido por esos dos números. El resultado se\n" +
"mostrará junto al formulario, de forma que el usuario pueda volver a pedir otro número sin\n" +
"cambiar de página."
                        + "</p>");
                out.println("<form>");
                    out.println("<label>Limite inferior: </label>");
                    out.println("<input name='limiteInferior' type='number'>");
                    out.println("<label>Limite superior: </label>");
                    out.println("<input name='limiteSuperior' type='number'>");
                    out.println("<input name='Boton' type='submit'>");
                out.println("</form>");
                out.println("<hr>");
            if (valoresRecibidos) {
                if (error.equals("")) {
                    out.println("<h3>" + numeroAleatorio + "</h3>");
                }
            } else {
                out.println("<div style='color: red;'>" + error + "</div>");
            }
            out.println("<hr><a href='/bol2/'>Volver al boletin 2</a>");
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
