/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6.servlets;

import ejercicio6.modelo.Empleado;
import ejercicio6.modelo.GestionEmpleados;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
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
@WebServlet(name = "IntroducirEmpleado", urlPatterns = {"/IntroducirEmpleado"})
public class IntroducirEmpleado extends HttpServlet {

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
        request.getRequestDispatcher("ComprobarSesion").include(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Lógica de control
            String error = "";
            boolean hayParametros = false;
            String dni = "", nombre = "", apellidos = "", fechaNacimiento = "",
                    categoriaProfesional = "", sexo = "";
            List<String> aficiones = new LinkedList();
            Empleado emp;
            hayParametros = request.getParameter("dni") != null;
            if (hayParametros) {
                emp = new Empleado();
                dni = request.getParameter("dni");
                if (Empleado.comprobarFormatoDNI(dni)) {
                    emp.setDni(dni);
                } else {
                    error += "El formato del DNI no es correcto<br>";
                }
                nombre = request.getParameter("nombre");
                emp.setNombre(nombre);
                apellidos = request.getParameter("apellidos");
                emp.setApellidos(apellidos);
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                fechaNacimiento = request.getParameter("fechaNacimiento");
                try {
                    emp.setFechaNacimiento(formato.parse(fechaNacimiento));
                } catch (ParseException ex) {
                    error += "La fecha de Nacimiento es incorrecta<br>";
                }
                categoriaProfesional = request.getParameter("categoriaProfesional");
                emp.setCategoriaProfesional(categoriaProfesional);
                sexo = request.getParameter("sexo");
                emp.setSexo(sexo.equals("M"));
                String[] arrayAficiones = request.getParameterValues("aficiones");
                if (arrayAficiones != null) {
                    for (String aficion : arrayAficiones) {
                        aficiones.add(aficion);
                    }
                }
                emp.setAficiones(aficiones);
                if (error.equals("")) {
                    GestionEmpleados ge = new GestionEmpleados(getServletContext().getInitParameter("fichero"));
                    ge.guardarEmpleado(emp);
                    response.sendRedirect("menuEmpleados.html");
                    return;
                }
            }
            
            
            // Lógica de Presentación
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Introducir Empleado</title>");            
            out.println("</head>");
            out.println("<body>");
            
            // Incluimos la cabecera
            request.setAttribute("titulo", "Introducir Empleado");
            request.getRequestDispatcher("/CabeceraEmpleado").include(request, response);
            out.println("        <form>\n");
            out.println("            <label for='dni'>DNI</label>\n");
            out.println("            <input type='text' name='dni' id='dni' required value ='" + dni + "'>");
            out.println("            <br>\n");
            out.println("            <label for='nombre'>Nombre</label>\n");
            out.println("            <input type='text' name='nombre' id='nombre' required value='" + nombre + "'>");
            out.println("            <br>\n");
            out.println("            <label for='apellidos'>Apellidos</label>\n");
            out.println("            <input type='text' name='apellidos' id='apellidos' required value='" + apellidos + "'>");
            out.println("            <br>\n");
            out.println("            <label for='fechaNacimiento'>Fecha de Nacimiento</label>\n");
            out.println("<input type='date' name='fechaNacimiento' id='fechaNacimiento' required value='" + fechaNacimiento  +"'>");
            out.println("<br>\n");
            out.println("<label for='categoriaProfesional'>Categoría Profesional</label>\n");
            out.println("<select name='categoriaProfesional' id='categoriaProfesional' required>\n");
            out.println("    <option value='Administrativo' " + (categoriaProfesional.equals("Administrativo")?"selected":"") + ">Administrativo</option>\n");
            out.println("    <option value='Operario' "+ (categoriaProfesional.equals("Operario")?"selected":"") + ">Operario</option>\n");
            out.println("    <option value='Jefe de Departamento' "+ (categoriaProfesional.equals("Jefe de Departamento")?"selected":"") +">Jefe de Departamento</option>\n");
            out.println("    <option value='Director' "+ (categoriaProfesional.equals("Director")?"selected":"") +">Director</option>\n");
            out.println("</select>\n");
            out.println("<br>\n");
            out.println("<label>Sexo</label>\n");
            out.println("<br>\n");
            out.println("<label for='hombre'>Hombre</label>\n");
            out.println("<input type='radio' name='sexo' value='H' id='hombre' " + (sexo.equals("H") || sexo.equals("")?"checked":"") +">");
            out.println("<label for='mujer'>Mujer</label>\n");
            out.println("<input type='radio' name='sexo' value='M' id='mujer' "+ (sexo.equals("M")?"checked":"") +">");
            out.println("<br>\n");
            out.println("<label>Aficiones</label>\n");
            out.println("<br>\n");
            out.println("<label for='musica'>Música</label>\n");
            out.println("<input type='checkbox' name='aficiones' value='Musica' id='musica' " + (aficiones.contains("Musica")?"checked":"") + ">");
            out.println("<label for='cine'>Cine</label>\n");
            out.println("<input type='checkbox' name='aficiones' value='Cine' id='cine' " + (aficiones.contains("Cine")?"checked":"") + ">");
            out.println("<label for='deportes'>Deportes</label>\n");
            out.println("<input type='checkbox' name='aficiones' value='Deportes' id='deportes' "+ (aficiones.contains("Deportes")?"checked":"") +">");
            out.println("<br>\n");
            out.println("<input type='submit' value='Aceptar'>\n");
            out.println("</form>\n");
            out.println("<div style='color: red;'><h3>" + error + "</h3></div>");

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
