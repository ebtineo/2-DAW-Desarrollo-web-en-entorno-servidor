/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author jose
 */
public class Usuarios {
    public static boolean validarUsuario(String nombre, String pin) {
        String[][] usuarios = {{"usuario1","123456"},
                               {"usuario2","654321"}};
        for (int i=0;i<usuarios.length;i++) {
            if (nombre.equals(usuarios[i][0]) && pin.equals(usuarios[i][1])) {
                return true;
            }
        }
        return false;
    }
}
