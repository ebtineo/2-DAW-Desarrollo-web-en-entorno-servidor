package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class indexController extends HttpServlet {
    
    public String contenido = "Bienvenido";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet acercaDeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet acercaDeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        request.setAttribute("contenido", contenido);
        // request.getRequestDispatcher("/index").forward(request, response);
        // response.sendRedirect("/index");
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
    }

}
