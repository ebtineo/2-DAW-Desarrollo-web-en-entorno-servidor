/*
 * Clase GestionEmpleados
 * Contiene métodos para gestionar los empleados
 */
package ejercicio6.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author jose
 */
public class GestionEmpleados {
    public /*static final*/ String FICHERO = "empleados.txt";
    
    public GestionEmpleados(String fichero) {
        FICHERO = fichero;
    }
    
    public void guardarEmpleado(Empleado e) {
        PrintWriter fichero = null;
        try {
          FileWriter fw = new FileWriter(FICHERO, true);
          fichero = new PrintWriter(fw);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            return;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        fichero.println(e.getDni());
        fichero.println(e.getNombre());
        fichero.println(e.getApellidos());
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        fichero.println(formato.format(e.getFechaNacimiento()));
        fichero.println(e.getCategoriaProfesional());
        fichero.println(e.isSexo()?"M":"H");
        if (e.getAficiones() != null) {
            for (String aficion : e.getAficiones()) {
                fichero.print(aficion + "|");
            }
        }
        // Para terminar la línea de las aficiones
        fichero.println();
        // Terminador de empleados
        fichero.println();
        fichero.close();
    }
    
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados = new LinkedList();
        BufferedReader fichero = null;
        try {
            fichero = new BufferedReader(new FileReader(FICHERO));
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            return empleados;
        }
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        try {
            while (fichero.ready()) {
                Empleado e = new Empleado();
                e.setDni(fichero.readLine());
                e.setNombre(fichero.readLine());
                e.setApellidos(fichero.readLine());
                try {
                    e.setFechaNacimiento(formato.parse(fichero.readLine()));
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                    return empleados;
                }
                e.setCategoriaProfesional(fichero.readLine());
                e.setSexo(fichero.readLine().equals("M"));
                StringTokenizer st = new StringTokenizer(fichero.readLine(), "|");
                List<String> aficiones = new LinkedList();
                while (st.hasMoreTokens()) {
                    aficiones.add(st.nextToken());
                }
                e.setAficiones(aficiones);
                empleados.add(e);
                // Leemos el terminador
                fichero.readLine();
            }
            fichero.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return empleados;
        }
        return empleados;
    }
    
}
