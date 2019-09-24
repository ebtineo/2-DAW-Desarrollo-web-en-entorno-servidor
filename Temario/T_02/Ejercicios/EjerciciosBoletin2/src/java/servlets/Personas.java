
package servlets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Personas implements Serializable{
    
    List<Persona> personas;

    public Personas() {
        this.personas = new ArrayList();
    }
    
    
    public void añadir(Persona p) {
        Persona personaExistente;
        for (int i = 0; i < personas.size(); i++) {
            personaExistente = personas.get(i);
            if (personaExistente.equals(p)) {
                throw new IllegalArgumentException("Persona existente");
            }
        }
        personas.add(p);
        System.out.println("Persona insertada");
    }
        
    
    public void eliminar(int indice) {
        personas.remove(indice);
    }
    
    @Override
    public String toString() {
        String res = "";

        Iterator it = personas.iterator();
        while (it.hasNext()) {
            Persona p = (Persona)it.next();
            res += p.toStringHTML();
        }
        return res;
    }

}
