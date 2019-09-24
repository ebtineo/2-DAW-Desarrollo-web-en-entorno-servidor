/*
 * Mostrar todos los parámetros de la petición
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "Ejercicio5", urlPatterns = {"/Ejercicio5"})
public class Ejercicio5 extends HttpServlet {

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
     /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ejercicio5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Parámetros de la petición</h1><br><br>");
            String tablaParametros = muestraParametrosMapa(request);
            out.println(tablaParametros);
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /**
     * Muestra una tabala HTML con los parámetros y sus valores
     * @param r la petición
     * @return una cadena con el código HTML de la tabla
     */
    public String muestraParametros(HttpServletRequest r){
        List<String> nombres = Collections.list(r.getParameterNames());
        String[] valores;
        String resultado = "<table border='1'>";
        
        for (String nombre : nombres) {
            valores = r.getParameterValues(nombre);
            resultado += "<tr>";
            resultado += "<td>" + nombre + "</td>";
            resultado += "<td>";
            for (String valor:valores) {
                resultado += valor + "<br>"; 
            }
            resultado +="</td>";
            resultado += "</tr>";
        }
        
        resultado += "</table>";
        
        return resultado;
    }

    /**
     * Muestra una tabala HTML con los parámetros y sus valores
     * usando getParameterMap
     * @param r la petición
     * @return una cadena con el código HTML de la tabla
     */
    
    public String muestraParametrosMapa(HttpServletRequest r) {
        String[] valores;
        Map<String,String[]> mapa = r.getParameterMap();
        Set<String>nombres = mapa.keySet();

        String resultado = "<table border='1'>";
        
        for (String nombre : nombres) {
            valores = mapa.get(nombre);
            resultado += "<tr>";
            resultado += "<td>" + nombre + "</td>";
            resultado += "<td>";
            for (String valor:valores) {
                resultado += valor + "<br>"; 
            }
            resultado +="</td>";
            resultado += "</tr>";
        }
        
        resultado += "</table>";
        
        return resultado;        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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
