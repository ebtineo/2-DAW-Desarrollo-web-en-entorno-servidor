package beans;

/*
 * Bean Temperatura
 * Almacena temperaturas
 * y las convierte entre Celsius y Fharenheit
 */


import java.io.Serializable;


/**
 *
 * @author Jonatán
 */
public class Temperatura implements Serializable{

    //Temperaturas en grados C 
    private double temperatura;
    
    //Constructor por defecto
    public Temperatura(){
        
    }
    
    //Segundo constructor
    public Temperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getGradoC() {
        return temperatura;
    }
    
    public void setGradoC(double gradosC){
        temperatura=gradosC;
    }

    public double getGradoF() {
        return (temperatura * (double)9 / 5) + 32;
    }
    
    public void setGradoF(double gradosF){
        temperatura=(gradosF - 32) * (double)5 / 9;
    }
    
}
