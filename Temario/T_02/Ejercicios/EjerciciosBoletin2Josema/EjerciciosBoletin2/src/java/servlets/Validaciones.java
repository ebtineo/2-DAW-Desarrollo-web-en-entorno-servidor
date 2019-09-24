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
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 *
 * @author josem
 */
public class Validaciones {
    
    //CARGA DE DATOS
    public boolean comprobarDatos(Usuario u) {
        boolean encontrado = false;
        try { 
            BufferedReader lectura = new BufferedReader(new FileReader("usuarios.txt"));
            String linea = lectura.readLine();
            while (linea != null) {

                StringTokenizer dato = new StringTokenizer(linea, ";");
                try {
                    while (dato.hasMoreTokens() && !encontrado) {
                        
                        String usuario = dato.nextToken();
                        String contraseña = dato.nextToken();
                        
                        if(usuario.equals(u.getUsuario()) && contraseña.equals(u.getContraseña())){      
                            encontrado=true;
                            
                            
                        }
                        
                    }
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
        return encontrado;
        

    }
    
    // GUARDAR EN FICHEROS
    public void guardarDatosEnFichero(String nombre, String contraseña) {

        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter("usuarios.txt",true));
                Usuario u = new Usuario(nombre, contraseña);
                if (!comprobarDatos(u)) {
                    escribir.write(nombre + ";" + contraseña);
                    escribir.newLine();
                }
            escribir.close();

        } catch (IOException ex) {
            System.out.println("Error al guardar datos en el fichero");
        }

    }

}
