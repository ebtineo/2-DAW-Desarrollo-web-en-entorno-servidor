package ej4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* ENUNCIADO
4. Realizar una aplicación web que resuelva ecuaciones de segundo grado. 
El resultado se mostrará en la misma página.
*/
public class segundoGrado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* - - - VARIABLES - - - */
            double a = 0, b = 0, c = 0;
            double resP = 0, resN = 0;
            String res = "";
            
            /* - - - CONTROLADOR - - - */
            if (request.getParameter("a") != null && request.getParameter("b") != null && request.getParameter("c") != null) {
                a = Double.parseDouble(request.getParameter("a"));
                b = Double.parseDouble(request.getParameter("b"));
                c = Double.parseDouble(request.getParameter("c"));
                
                double discriminante = b * b - (4 * a * c);
                if (discriminante == 0) {
                    resP = (-b + discriminante)/(2*a);
                    res = "Solucion unica: " + "x = " + resP;
                } else if (discriminante < 0) {
                    res = "Sin solucion";
                } else {
                    discriminante = Math.sqrt(discriminante);
                    resP = (-b + discriminante)/(2*a);
                    resN = (-b - discriminante)/(2*a);
                    res = "Resultado dos soluciones: " + "x1 = " + resP + ", x2 = " + resN;
                }
                res += "<br>" + "Valor a = " + a + " Valor B = " + b + " Valor C = " + c + "<br>" + 
                        "Discriminante = " + discriminante;
            } else {
                res = "Introduce valores numericos";
            }
            
            /* - - - VISTA - - - */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet segundoGrado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet segundoGrado at " + request.getContextPath() + "</h1>");
            out.println("<form>");
                    out.println("<legend>Ax^2 + Bx + C = 0</legend>");
                    out.println("<label>A: </label>");
                    out.println("<input name='a' type='number'>");
                    out.println("<label>B: </label>");
                    out.println("<input name='b' type='number'>");
                    out.println("<label>C: </label>");
                    out.println("<input name='c' type='number'>");
                    out.println("<input name='Boton' type='submit'>");
                out.println("<form>");
                out.println("<hr>");
                out.println("<p>"
                        + res
                        + "</p>");
                
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
