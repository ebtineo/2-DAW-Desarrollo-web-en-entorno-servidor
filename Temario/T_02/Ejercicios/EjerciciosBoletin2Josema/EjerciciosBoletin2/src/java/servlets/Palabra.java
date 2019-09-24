/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author josem
 */
public class Palabra {
    String palabra;
    String definicion;

    public Palabra(String palabra, String definicion) {
        this.palabra = palabra;
        this.definicion = definicion;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    @Override
    public String toString() {
        return "Palabra{" + "palabra=" + palabra + ", definicion=" + definicion + '}';
    }
    
    
    
}
