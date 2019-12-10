/*
 * Bean Arbol
 * Representa al árbol de navidad con todas sus
 * bolas dispuestas en filas
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jose
 */
public class Arbol implements Serializable {
    
    int intentos = 0;
    private Bola[][] bolas;
    
    public Arbol() {
        // Por defecto creamos un árbol de profundidad 6
        this(6);
    }
    
    public Arbol(int profundidad) {
        bolas = new Bola[profundidad][profundidad];
        colocarBolasAleatorias();
    }
    
    public void colocarBolasAleatorias() {
        List<Bola> listaBolas = new ArrayList();
        int[] colores = {Bola.ROJO, Bola.VERDE, Bola.AZUL};
        // El número total de bolas es
        int numeroBolas = bolas.length * (bolas.length +1) / 2;
        // Le vamos dando colores a las bolas de la lista
        for (int i=0; i< numeroBolas; i++) {
            listaBolas.add(new Bola(colores[i%3]));
        }
        // Desordenamos la lista
        Collections.shuffle(listaBolas);
        // Y colocamos las bolas en sus posiciones
        for (int fila = 0; fila < bolas.length; fila++) {
            for (int columna = 0; columna <= fila; columna++) {
                bolas[fila][columna] = listaBolas.remove(0);
            }
        }
    }
    
    // Comprueba cuántas bolas adyacentes tienen el mismo color
    public int coloresConsecutivos() {

    }
    
    /**
     * Intercambia la bola indicada con una de las dos que están debajo de forma aleatoria
     * @param fila la fila de la bola
     * @param columna la columna de la bola
     */
    public void cambiar(int fila, int columna) {
    }
    
    /**
     * Devuelve la profundidad del árbol
     * @return el número de filas
     */
    public int getProfundidad() {
        return bolas.length;
    }
    
    /**
     * Devuelve las bolas del árbol en forma de array bidimensional
     * @return el array de bolas
     */
    public Bola[][] getBolas() {
        return bolas;
    }
    
    /**
     * Devuelve una fila de bolas en forma de array
     * @param i el índice de la fila
     * @return un array de Bola
     */
    public Bola[] getFila(int i) {
        return Arrays.copyOf(bolas[i], i + 1);
    }
    
    /**
     * Devuelve el número de intentos realizados hasta el momento
     * @return el número de intentos
     */
    public int getIntentos() {
        return intentos;
    }
}
