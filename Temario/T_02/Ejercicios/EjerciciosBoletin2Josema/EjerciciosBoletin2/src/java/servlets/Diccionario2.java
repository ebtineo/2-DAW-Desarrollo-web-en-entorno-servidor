/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


/**
 *
 * @author josem
 */
public class Diccionario2 {
    List<Palabra> diccionario = new ArrayList();

    public Diccionario2() {
        cargarDatos(diccionario);
        
    }
    
    
    void añadir(String p, String d){
        Palabra aP = new Palabra(p, d);
        diccionario.add(aP);  
        guardarDatosEnFichero(diccionario);
    }
    
    String buscar(String n){
        String devolver="";
        boolean encontrado=false;
        for(int i= 0; i<diccionario.size() && encontrado==false;i++){
            Palabra p = diccionario.get(i);
            String palabraMinuscula=p.getPalabra().toLowerCase();
            String nMinuscula=n.toLowerCase();
            if(nMinuscula.equals(palabraMinuscula)){
                devolver=p.getDefinicion();
                encontrado=true;
            }else{
                devolver="No existe";
            }     
           
        }
        return devolver;
    }
    
    
   //CARGA DE DATOS
    public void cargarDatos(List diccionario) {
        try {
            Palabra p = null;
            BufferedReader lectura = new BufferedReader(new FileReader("diccionario.txt"));
            String linea = lectura.readLine();
            while (linea != null) {

                StringTokenizer dato = new StringTokenizer(linea, ";");
                try {
                    while (dato.hasMoreTokens()) {
                        String palabra = dato.nextToken();
                        String definicion = dato.nextToken();
                        
                        p = new Palabra(palabra.trim(),definicion.trim() );
                    }
                    diccionario.add(p);
                } catch (NoSuchElementException e) {
                    System.out.println("El fichero esta vacio");
                }
                linea = lectura.readLine();

            }
            lectura.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException ex) {
            System.out.println("Error al leer el fichero");
        }

    }

    // GUARDAR EN FICHEROS
    public void guardarDatosEnFichero(List lista) {

        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter("diccionario.txt"));
            for (int i = 0; i < lista.size(); i++) {
                Palabra p = (Palabra) lista.get(i);
                escribir.write(p.getPalabra().trim() + " ;" + p.getDefinicion().trim());
                escribir.newLine();
            }
            escribir.close();

        } catch (IOException ex) {
            System.out.println("Error al guardar datos en el fichero");
        }

    }
    
    
}
