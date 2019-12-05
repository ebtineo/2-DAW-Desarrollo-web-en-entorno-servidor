package ej2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* ENUNCIADO
2. Realizar una aplicación web que pida una frase al usuario y la muestre en mayúsculas.
*/
public class texMayus extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                    out.println("<head>");
                        out.println("<title>Servlet texMayus</title>");            
                    out.println("</head>");
                out.println("<body>");
                    out.println("<h1>Servlet texMayus at " + request.getContextPath() + "</h1>");
                    out.println("<p>2. Realizar una aplicación web que pida una frase al usuario "
                            + "y la muestre en mayúsculas.</p>");
                    
                    /* - - - FORMULARIO - - -*/
                    out.println("<form action='/bol2/texMayus'>");
                        out.println("<label>Texto: </label>");
                        out.println("<input name='texto' type='text'>");
                        out.println("<input name='Evaluar' type='submit'>");
                    out.println("</form>");
                out.println("<br>");
                
                /* - - - LOGICA - - - */
                if (request.getParameter("texto") != null) {
                    String mayus = request.getParameter("texto").toUpperCase();
                    // Se puede utilizar javascript
                    out.println("<script type=\'text/javascript\'>");
                        out.print("alert('" + mayus + "')");
                    out.println("</script>");
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
