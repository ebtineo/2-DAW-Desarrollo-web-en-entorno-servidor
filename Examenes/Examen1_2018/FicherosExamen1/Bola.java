/*
 * Bean Bola
 * Representa una bola del árbol
 * con un color que puede ser Rojo, Verde o Azul
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author jose
 */
public class Bola implements Serializable {
    
    public static final int ROJO = 1;
    public static final int VERDE = 2;
    public static final int AZUL = 3;

    private int color;
    
    public Bola() {
    }
    
    public Bola (int color) {
        if (color < 1 || color > 3) {
            throw new IllegalArgumentException("Color incorrecto");
        }
        this.color = color;
    }
    
    public int getColor() {
        return color;
    }
    
 
    /**
     * Devlover un String que contenga el nombre del fichero de imagen
     * por ejemplo: imagenes/bola_verde.png
    */   
    public String getImagen() {
    }
    
    @Override
    public String toString() {
    }
}
