/*
 * Bean Usuario
 */
package modelo;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Usuario implements Serializable {
    
    private String login;
    private String password;
    private String nombre;
    private List<Receta> recetasFavoritas;
    
    public Usuario() {
        recetasFavoritas = new LinkedList();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Receta> getRecetasFavoritas() {
        return recetasFavoritas;
    }

    public void nuevaRecetaFavorita(Receta nuevaReceta) {
        this.recetasFavoritas.add(nuevaReceta);
        Collections.sort(recetasFavoritas);
    }
    
}
