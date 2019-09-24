/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificarsha256;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author jose
 */
public class CodificarSHA256 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(codificar("mensaje"));
    }
    
    public static String codificar(String mensaje) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(mensaje.getBytes(StandardCharsets.UTF_8));
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i] & 0xff);
            if (hex.length() == 1) {
                hexString.append("0");
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
