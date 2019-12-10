/*
 * Servlet ListarEmpleados
 * Lista todos los empleados
 */
package ejercicio6.servlets;

import ejercicio6.modelo.Empleado;
import ejercicio6.modelo.GestionEmpleados;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "ListarEmpleados", urlPatterns = {"/ListarEmpleados","/listar"})
public class ListarEmpleados extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            GestionEmpleados ge = new GestionEmpleados(getServletContext().getInitParameter("fichero"));
            List<Empleado> empleados = ge.getEmpleados();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Empleados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Listado de Empleados </h2>");
            out.println("<table>");
            out.println("<tr><th>DNI</th><th>Apellidos</th><th>Nombre</th>"
                    + "<th>Edad</th><th>Sexo</th><th>Categoría Profesional</th>"
                    + "<th>Aficiones</th></tr>");
            for (Empleado e : empleados) {
                out.println("<tr>");
                out.println("<td>" + e.getDni() + "</td>");
                out.println("<td>" + e.getApellidos() + "</td>");
                out.println("<td>" + e.getNombre() + "</td>");
                out.println("<td>" + e.getEdad() + "</td>");
                out.println("<td>" + (e.isSexo()?"Mujer":"Hombre") + "</td>");
                out.println("<td>" + e.getCategoriaProfesional() + "</td>");
                String aficiones = "";
                //for (String aficion : e.getAficiones()) {
                //    aficiones += aficion + ", ";
                //}
                aficiones = String.join(",", e.getAficiones());
                out.println("<td>" + aficiones + "</td>");

                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br>");
            out.println("<a href='menuEmpleados.html'>Volver al Menú</a>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

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
