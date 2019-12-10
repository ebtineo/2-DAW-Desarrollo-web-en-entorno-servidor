package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Dato;
import modelo.Datos;

/**
 *
 * @author WorKeLid
 */
public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession sesion = request.getSession();
            Datos datos = (Datos) sesion.getAttribute("datos");
            
            out.println((String) request.getParameter("add"));
            if (request.getParameter("add") != null) {
                
                String etiqueta = (String) request.getParameter("etiqueta");
                Integer valor = Integer.parseInt(request.getParameter("valor"));
                Dato dato = new Dato(etiqueta, valor);
                
                datos.add(dato);
                
                sesion.setAttribute("datos", datos);
                
                // request.getRequestDispatcher("ListaValores").forward(request, response);
                response.sendRedirect("ListaValores");
            } else if (request.getParameter("print") != null) {
                
                response.sendRedirect("Grafica");
            } else {
                response.sendRedirect("ListaValores");
            }
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}