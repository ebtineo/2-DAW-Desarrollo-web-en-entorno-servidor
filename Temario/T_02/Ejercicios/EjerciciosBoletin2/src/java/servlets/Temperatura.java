/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


/**
 *
 * @author Jonatán
 */
public class Temperatura {

    private double temperatura;

    public Temperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getGradoC() {
        
        return (temperatura - 32) * (double)5 / 9;
    }

    public double getGradoF() {
        return (temperatura * (double)9 / 5) + 32;
    }
    

    
}
