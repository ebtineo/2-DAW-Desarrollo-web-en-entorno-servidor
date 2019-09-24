/*
 * Clase NumerEntero.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

/**
 *
 * @author jose
 */
public class NumeroEntero {
    private int numero;
    
    public NumeroEntero() {
        numero = 0;
    }
    
    public NumeroEntero(int n) {
        numero = n;
    }
    
    public synchronized void incrementar() {
        numero++;
    }
    
    public void decrementar() {
        synchronized (this) {
        numero--;
        }
    }
    
    public int getNumero() {
        return numero;
    }
}
