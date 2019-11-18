package ej5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* ENUNCIADO
5. Realizar un servlet que muestre todos los parámetros recibidos en 
la petición, sean cuales sean su número y sus nombres. 
Mostrar todos los valores de cada parámetro
*/
public class verParametros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet verParametros</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet verParametros at " + request.getContextPath() + "</h1>");
            out.println("<form action='/bol2/verParametros'>");
                
                out.println("<label>Texto: </label>");
                out.println("<input name='texto' type='text'>");
                out.println("<br>");
                
                out.println("<label>Password </label>");
                out.println("<input name='password' type='password'>");
                out.println("<br>");
                
                out.println("<label>Numero: </label>");
                out.println("<input name='numero' type='number'>");
                out.println("<br>");
                
                out.println("<label>Radio: </label>");
                out.println("<input name='radio' type='radio' value='radio1'>");
                out.println("<input name='radio' type='radio' value='radio2'>");
                out.println("<input name='radio' type='radio' value='radio3'>");
                out.println("<br>");
                
                out.println("<label>Checkbox: </label>");
                out.println("<input name='check' type='checkbox' value='check1'>");
                out.println("<input name='check' type='checkbox' value='check2'>");
                out.println("<input name='check' type='checkbox' value='check3'>");
                out.println("<br>");
                
                out.println("<label>Color: </label>");
                out.println("<input name='color' type='color'>");
                out.println("<br>");
                
                out.println("<label>Date: </label>");
                out.println("<input name='date' type='date'>");
                out.println("<br>");
                
                out.println("<input name='Evaluar' type='submit'>");
                out.println("<hr>");
                
                if (!request.getParameterMap().isEmpty()) {
                    /* 
                        Existen tres metodos para obtener TODOS los parametros de HttpServletRequest:
                    
                        1 - request.getParameterMap()
                            Te da un mapa que tiene por claves, los name de los input del formulario y
                            por cada clave, un array de String con los valores
                        2 - request.getParameterNames()
                        3 - request.getParameterValues()
                    
                    */
                    out.println("<p>Iterando usando request.getParameterMap().entrySet()<br />");
                    for (Map.Entry<String,String[]> i : request.getParameterMap().entrySet())  {
                        out.println("Clave: " + i.getKey() + ", Valor: " + Arrays.deepToString(i.getValue()) + "<br />");
                    }
                    out.println("</p");
                    out.println("<hr>");
                    
                    /* - - - El mas facil de aprender - - - */
                    out.println("<p>Iterando usando expresion lambda foreach<br />");
                    request.getParameterMap().forEach((clave, valor) ->
                        out.println("Clave: " + clave + ", Valor: " + Arrays.deepToString(valor) + "<br />"));
                    out.println("</p");
                    
                }
                
            out.println("</form>");
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
