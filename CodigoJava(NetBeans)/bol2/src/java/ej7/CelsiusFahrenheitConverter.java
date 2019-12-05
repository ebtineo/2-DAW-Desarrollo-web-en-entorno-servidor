package ej7;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
7. Realizar un servlet que convierta temperaturas en grados Celsius a Fahrenheit y viceversa.
Los datos introducidos deben ser validados y formateados correctamente.
 */
public class CelsiusFahrenheitConverter extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CelsiusFahrenheitConverter</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CelsiusFahrenheitConverter at " + request.getContextPath() + "</h1>");
            out.println("<p>7. Realizar un servlet que convierta temperaturas en grados Celsius a Fahrenheit y viceversa.\n" +
"Los datos introducidos deben ser validados y formateados correctamente.</p>");
            
            out.println("<form action='/bol2/CelsiusFahrenheitConverter'>");
            
                out.println("<label>Temperatura: </label>");
                out.println("<input name='temperatura' type='number' step='any'>");
                out.println("<br>");
                
                out.println("<label>Conversion: </label><br>");
                out.println("<label>A celsius<input name='conversion' type='radio' value='aCelsius'></label><br>");
                out.println("<label>A Fahrenheit<input name='conversion' type='radio' value='aFahrenheit'></label>");
                out.println("<br>");
                
                out.println("<input type='submit' vlaue='Enviar'>");
                out.println("<br>");
                
            out.println("</form>");
            
            if (!request.getParameter("temperatura").isEmpty() && !request.getParameter("conversion").isEmpty()) {
                out.println("<p>");
                float res;
                    if (request.getParameter("conversion").equals("aCelsius")) {
                        res = CFConverter.fahrenheitToCelsius(request.getParameter("temperatura"));
                        out.println("Celsius: " + res);
                    } else {
                        res = CFConverter.celsiusToFahrenheit(request.getParameter("temperatura"));
                        out.println("Fahrenheit: " + res);
                    }
                out.println("</p>");
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