package ej6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class toSee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet toSee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet toSee at " + request.getContextPath() + "</h1>");
            leerPersonas(out);
            out.println("<hr><a href='/bol2/ej6_form.html'>Volver al formulario</a>");
            out.println("<hr><a href='/bol2/'>Volver al boletin 2</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public Set<Persona> leerPersonas(PrintWriter out) throws IOException {
        Set<Persona> personas = new HashSet<>();
        String personaTexto;
        String ruta = getServletContext().getInitParameter("root") + "\\bol2\\src\\java\\ej6" + "\\personas.txt";
        
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
        
        while ((personaTexto = br.readLine()) != null)
        {
            /* ﻿[nombre = Miguel; apellidos = Castañeda; categoriaPro = cat2; nacimiento = 2019-11-17;] */
            personaTexto = personaTexto.replace("[", "");
            personaTexto = personaTexto.replace("]", "");

            /* ﻿nombre = Miguel; apellidos = Castañeda; categoriaPro = cat2; nacimiento = 2019-11-17; */
            String[] atributos = personaTexto.split(";");
            
            /* ﻿ 
                [0] nombre = Miguel 
                [1] apellidos = Castañeda
                [2] categoriaPro = cat2 
                [3] nacimiento = 2019-11-17 
            */
            String[] aux = atributos[0].split("=");
            /*  
                [0] nombre 
                [1] Miguel 
            */
            String nombre = aux[1].trim();
            /* Miguel */
            
            aux = atributos[1].split("=");
            /* 
                [0] apellidos
                [1] Castañeda
            */
            String apellido = aux[1].trim();
            /* Castañeda */
            
            aux = atributos[2].split("=");
            /* 
                [0] categoria
                [1] cat2
            */
            String categoria = aux[1].trim();
            /* cat1 */
            
            aux = atributos[3].split("=");
            /* 
                [0] nacimiento
                [1] 2019-11-17
            */
            String nacimiento = aux[1].trim();
            /* 2019-11-17 */
            
            Persona p = new Persona(nombre, apellido, categoria, nacimiento);
            
            out.println("<p>" + p.toString() + "</p>");
        }
        return personas;
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
