package Servlets;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Persona implements Serializable{

    public enum Categoria {
        TECNICO, AUXILIAR, PEON
    };

    String nombre;
    String apellido1;
    String apellido2;
    Categoria categoria;
    LocalDate fechaNac;

    List<String> sectores = new ArrayList();
    int posicion=0;

    public Persona() {

    }

    public Persona(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public Persona(String nombre, String apellido1, String apellido2, LocalDate fechaNac, Categoria categoria, List<String> sectores) {
        this(nombre, apellido1, apellido2);
        this.categoria = categoria;
        this.fechaNac = fechaNac;
    }

    //Crea persona a partir de Strings
    public Persona(String nombre, String apellido1, String apellido2, String fechaNac, String categoria, String[] sectores) {
        this(nombre, apellido1, apellido2);

        //Conversión de fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaConvertida = LocalDate.parse(fechaNac, formatter);
        this.fechaNac = fechaConvertida;

        //Conversión de categoría
        if (categoria.equals("tecnico")) {
            this.categoria = Categoria.TECNICO;
        } else if (categoria.equals("auxiliar")) {
            this.categoria = Categoria.AUXILIAR;
        } else {
            this.categoria = Categoria.PEON;
        }
        
        if (sectores != null) {
            //Conversión de array de string a list de string de sectores
            this.sectores= Arrays.asList(sectores);
        }
               
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public List<String> getSectores() {
        return sectores;
    }

    public void setSectores(List<String> sectores) {
        this.sectores = sectores;
    }

 
    @Override
    public String toString() {        
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", categoria=" + categoria + ", fechaNac=" + fechaNac + ", sectores=" + sectores + '}';
    }
    
    public String toStringHTML(){
        String lineaHTML = "<p> Nombre y apellidos: " + nombre + " " + apellido1 + " " + apellido2 + "</p>";
        lineaHTML += "<p>Nacido/a: " + fechaNac.toString() + "</p>";
        lineaHTML += "<p> Categoría profesional: " + categoria.toString()+"</p>";
        lineaHTML += "<p> Con experiencia en los secotres: " + sectores.toString() + "</p>";
        lineaHTML += "<hr/>";

        return lineaHTML;
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof Persona) {
            Persona otra = (Persona)o;
             return otra.nombre.equals(nombre) 
                    && otra.apellido1.equals(apellido1)
                            && otra.apellido2.equals(apellido2);
        }
        return false;
    }
}
