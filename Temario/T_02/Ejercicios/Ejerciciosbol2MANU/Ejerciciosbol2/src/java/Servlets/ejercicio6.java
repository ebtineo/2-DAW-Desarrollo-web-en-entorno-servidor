/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ManuelEspino
 */
public class ejercicio6 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    static File carpetaDatos;
    static File carpetaWEBINF;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            carpetaWEBINF = new File(getServletContext().getRealPath("WEB-INF/"));
            String campo = request.getParameter("boton");
                       
            //out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<title>Servlet Ejercicio6procesa</title>");            
            out.println("</head>");
            out.println("<body>");
            Personas personas = cargarDatos();
            System.out.println(request.getParameter("inNombre"));
        if(campo != null){
            List<String> variables = Collections.list(request.getParameterNames());
            try{            
                personas.añadir(crearPersona(variables, request));

                guardarDatos(personas);
            } catch (IllegalArgumentException e) {
                out.println("<div style='color:red'>La persona introducida ya existe</div>");
            }

        }
        out.println(mostrar(personas));

        out.println("<a href='formularioPersona.html'>Insertar persona</a>");
        out.println("</body>");
        out.println("</html>");
        }
    }

    public Persona crearPersona(List<String> variables, HttpServletRequest request) {

        String nombre = request.getParameter("inNombre");
        String apellido1 = request.getParameter("inApellido1");
        String apellido2 = request.getParameter("inApellido2");
        String fecha = request.getParameter("fecha");
        String categoria = request.getParameter("categoria");
        String[] sectores = request.getParameterValues("sectores");
        
        Persona p = new Persona(nombre, apellido1, apellido2, fecha, categoria, sectores);
        
        return p;
    }

    public static Personas cargarDatos() {
        
        carpetaDatos = new File(carpetaWEBINF,"datos");
        File archivoDatos = new File(carpetaDatos,"datos.dat");

        if (!archivoDatos.exists()) {
            carpetaDatos.mkdir();
            System.out.println("No existe y fue creado");
        }else{
            System.out.println("Archivo existente.");

        }
                
        ObjectInputStream in = null;
        Personas personas;
        try {
            in = new ObjectInputStream(new FileInputStream(archivoDatos));
            personas = (Personas) in.readObject();
            System.out.println("Cargadas objeto Personas");
            System.out.println("En " + archivoDatos.getAbsolutePath());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            //Si no existe, se crea la estructura
            personas = new Personas();
            System.out.println("Creado objeto Personas");


        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return personas;
    }
     
    private static void guardarDatos(Personas personas) {
        carpetaDatos = new File(carpetaWEBINF,"datos");
        
        File archivo = new File(carpetaDatos,"datos.dat");

        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(archivo));
            out.writeObject(personas);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
     
    public String mostrar(Personas personas){
        
        String resultado ="";
//        for(Persona p : personas){
//            resultado += p.toStringHTML();
//        }

resultado = personas.toString();

        return resultado;
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
