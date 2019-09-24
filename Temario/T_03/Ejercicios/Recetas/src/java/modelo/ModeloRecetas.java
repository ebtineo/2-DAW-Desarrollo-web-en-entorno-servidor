/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jose
 */
public class ModeloRecetas implements Serializable {
    
    private List<Receta> todasLasRecetas;
    
    public ModeloRecetas() {
        todasLasRecetas = new ArrayList();
        System.out.println("Se ha iniciado el bean ModeloRecetas");
    }

    public List<Receta> getTodasLasRecetas() {
        return todasLasRecetas;
    }

    
    public void crearReceta(String nombre, String contenido, Usuario autor) {
        Receta nueva = new Receta();
        nueva.setNombre(nombre);
        nueva.setContenido(contenido);
        nueva.setAutor(autor);
        todasLasRecetas.add(nueva);
        Collections.sort(todasLasRecetas);
    }
    
    public Receta buscarReceta(String nombre) {
        Receta busqueda = new Receta();
        busqueda.setNombre(nombre);
        int i = todasLasRecetas.indexOf(busqueda);
        if (i == -1) {
            busqueda = null;
        } else {
            busqueda = todasLasRecetas.get(i);
        }
        return busqueda;
    }
}
