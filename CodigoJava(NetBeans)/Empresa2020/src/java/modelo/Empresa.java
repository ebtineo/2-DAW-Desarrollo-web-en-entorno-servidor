/*
 * Clase Empresa
 * JavaBean de acceso al modelo
 */
package modelo;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.dao.EmpleadoJpaController;
import modelo.entidades.Empleado;

/**
 *
 * @author jose
 */
public class Empresa implements Serializable {
    
    // Unidad de Persistencia
    public static final String PU = "Empresa2020PU";
    
    public Empleado login(String login, String password) {
        Empleado emp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("buscarPorLogin");
        consulta.setParameter("login", login);
        List<Empleado> resultado  = consulta.getResultList();
        if (resultado.size() > 0) {
            if (resultado.get(0).getPassword().equals(password)) {
                emp = resultado.get(0);
            } 
        }
        em.close();
        return emp;
    }
    
    public void crearEmpleado(Empleado e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        try {
            ejc.create(e);
        } catch (Exception ex) {
            System.err.println("Error al crear empleado: " + ex.getMessage());
        }
    }
    
    public String codificarSHA256(String mensaje) throws NoSuchAlgorithmException {
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
