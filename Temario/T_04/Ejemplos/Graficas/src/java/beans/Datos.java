/*
 * Bean Datos
 * Proporciona los datos obtenidos por el sensor
 */
package beans;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Datos implements java.io.Serializable {
    
    public List<Dato> getDatos () {
        List<Dato> datos = new ArrayList();
        BufferedReader ficheroDatos = null;
        String lineaDatos;
        try {
            ficheroDatos = new BufferedReader(new FileReader("/home/jose/datos_temperatura_prueba"));
            while ((lineaDatos = ficheroDatos.readLine()) != null) {
                Dato dato = new Dato();
                double temperatura = Double.parseDouble(lineaDatos);
                dato.setTemperatura(temperatura);
                datos.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Datos.getDatos() : " + e.getMessage());
        } finally {
            try {
                ficheroDatos.close();
            } catch (IOException ex) {
                System.out.println("Datos.getDatos() : " + ex.getMessage());
            }
        }
        return datos;
    }
}
