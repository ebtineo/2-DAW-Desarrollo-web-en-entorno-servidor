/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

/**
 *
 * @author jose
 */
public class ThreadContar extends Thread {
    private NumeroEntero n;
    
    public ThreadContar(NumeroEntero n) {
        this.n = n;
    }
    
    @Override
    public void run() {
        for (int i=0;i<2000000;i++) {
            n.incrementar();
        }
        System.out.println("ThreadContar: " + n.getNumero());
    }
}
