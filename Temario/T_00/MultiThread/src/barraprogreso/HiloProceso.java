/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barraprogreso;

import javax.swing.JProgressBar;


/**
 *
 * @author jose
 */
public class HiloProceso extends Thread {
    
    private JProgressBar barraProgreso;
    
    public HiloProceso(JProgressBar bp) {
        barraProgreso = bp;
    }
    
    @Override
    public void run() {
        for (long i=0;i<1000000000l;i++) {
            barraProgreso.setValue((int)(i/10000000));
        }

    }
}
