/*
 * Clase MultiThread.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

/**
 *
 * @author jose
 */
public class MultiThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumeroEntero n = new NumeroEntero();
        
        //new ThreadContar(n).start();
        //new ThreadDescontar(n).start();
        ThreadContar t1 = new ThreadContar(n);
        ThreadDescontar t2 = new ThreadDescontar(n);
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {}
        System.out.println("Terminado");
        
    }
    
}
