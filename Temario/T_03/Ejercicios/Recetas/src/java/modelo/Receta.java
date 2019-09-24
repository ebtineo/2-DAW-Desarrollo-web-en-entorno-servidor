/*
 * Bean Receta
 * Contiene una receta de cocina
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author jose
 */
public class Receta implements Serializable, Comparable {
    
    private Usuario autor;
    private String nombre;
    private String contenido;

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Receta)) {
            return false;
        } else {
            Receta otra = (Receta) o;
            return otra.nombre.equalsIgnoreCase(nombre);
        } 
    }
    
    @Override
    public int compareTo(Object otra) {
        Receta otraReceta = (Receta) otra;
        return nombre.compareTo(otraReceta.nombre);
    }
}
