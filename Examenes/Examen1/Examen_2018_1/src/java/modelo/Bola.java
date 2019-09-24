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
    
    public String getImagen() {
        String c;
        switch (color) {
            case ROJO :
                c = "roja";
                break;
            case VERDE :
                c = "verde";
                break;
            default :
                c = "azul";
        }
        return "imagenes/bola_" + c + ".png";
    }
    
    @Override
    public String toString() {
        String[] colores = {"roja", "verde", "azul"};
        return "Bola " + colores[color-1];
    }
}
