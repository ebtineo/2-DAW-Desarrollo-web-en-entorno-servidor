/*
 * Servlet CrearEmpleados.
 * Genera varios empleados y los departamentos a los que pertenecen.
 */
package servlets;

import dao.DepartamentoJpaController;
import dao.EmpleadoJpaController;
import entidades.Departamento;
import entidades.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose
 */
@WebServlet(name = "CrearEmpleados", urlPatterns = {"/CrearEmpleados"})
public class CrearEmpleados extends HttpServlet {

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
            String error = "";
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaPU");
            DepartamentoJpaController djc = new DepartamentoJpaController(emf);
            EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
            Departamento dInf = new Departamento();
            dInf.setNombre("Informática");
            Departamento dVentas = new Departamento();
            dVentas.setNombre("Ventas");
            Departamento dRRHH = new Departamento();
            dRRHH.setNombre("Recursos Humanos");
            try {
                djc.create(dInf);
                djc.create(dVentas);
                djc.create(dRRHH);
            } catch (Exception e) {
                error += "Error al crear departamentos: " + e.getMessage() + "<br>";
            }
            Empleado e1 = new Empleado();
            e1.setNombre("Gervasio");
            e1.setApellidos("Fernández López");
            e1.setDni("11111111H");
            e1.setDepartamento(dVentas);
            e1.setTipo("normal");
            Empleado e2 = new Empleado();
            e2.setNombre("Leovigilda");
            e2.setApellidos("Ríos Pérez");
            e2.setDni("22222222J");
            e2.setDepartamento(dInf);
            e2.setTipo("normal");
            Empleado e3 = new Empleado();
            e3.setNombre("Teodoro");
            e3.setApellidos("Cuesta Caro");
            e3.setDni("33333333P");
            e3.setDepartamento(dVentas);
            e3.setTipo("administrador");
            Empleado e4 = new Empleado();
            e4.setNombre("Federica");
            e4.setApellidos("Gómez Arregui");
            e4.setDni("44444444A");
            e4.setDepartamento(dInf);
            e4.setTipo("normal");
            Empleado e5 = new Empleado();
            e5.setNombre("Nicasio");
            e5.setApellidos("Carretero Rico");
            e5.setDni("55555555K");
            e5.setDepartamento(dRRHH);
            e5.setTipo("administrador");
            try{
                ejc.create(e1);
                ejc.create(e2);
                ejc.create(e3);
                ejc.create(e4);
                ejc.create(e5);
            } catch (Exception e) {
                error += "Error al crear departamentos: " + e.getMessage() + "<br>";
            }
            emf.close();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearEmpleados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Creando Departamentos y Empleados</h1>");
            if (error.equals("")) {
                out.println("Se han creado con éxito los departamentos <br>");
                out.println(dInf + "<br>");
                out.println(dVentas + "<br>");
                out.println(dRRHH + "<br>");
                out.println("<br> y los empleados <br>");
                out.println(e1 + "<br>");
                out.println(e2 + "<br>");
                out.println(e3 + "<br>");
                out.println(e4 + "<br>");
                out.println(e5 + "<br>");
            } else {
                out.println(error);
            }
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
