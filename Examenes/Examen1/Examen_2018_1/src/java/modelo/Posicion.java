/*
 * Bean Posición
 * Almacena una posición con dos coordenadas enteras llamadas fila y columna
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author jose
 */
public class Posicion implements Serializable {
    
    private int fila;
    private int columna;

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
}
