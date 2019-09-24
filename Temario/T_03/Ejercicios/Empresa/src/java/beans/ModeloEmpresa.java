/*
 * Bean ModeloEmpresa.
 * Contiene el modelo de la aplicación
 */
package beans;

import dao.EmpleadoJpaController;
import dao.MensajeJpaController;
import dao.UsuarioJpaController;
import entidades.Empleado;
import entidades.Mensaje;
import entidades.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jose
 */
public class ModeloEmpresa implements Serializable {
    
    /**
     * Obtiene todos los empleados de la empresa
     * @return Una lista con todos los empleados
     */    
    public List<Empleado> getEmpleados() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaPU");
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        List<Empleado> empleados = ejc.findEmpleadoEntities();
        emf.close();
        return empleados;
    }
    
    /**
     * Busca un empleado de la empresa
     * @param id El id del empleado a buscar
     * @return El empleado buscado o null si no se encuentra
     */
    public Empleado getEmpleado(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaPU");
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        Empleado empleado = ejc.findEmpleado(id);
        return empleado;
    }
    
    /**
     * Obtiene todos los usuarios
     * @return Una lista con todos los usuarios
     */
    public List<Usuario> getUsuarios() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaPU");
        UsuarioJpaController ujc = new UsuarioJpaController(emf);
        List<Usuario> usuarios = ujc.findUsuarioEntities();
        emf.close();
        return usuarios;
    }
    
    /**
     * Crea un nuevo usuario o lo busca, si ya existe
     * @param nombre El nombre del usuario
     * @param apellidos Los apellidos del usuario
     * @param ocupacion La ocupación del usuario
     * @param email La dirección de e-mail del usuario
     * @return El usuario creado o el que ya existía, si coincide el email
     */
    public Usuario crearUsuario(String nombre, String apellidos, String ocupacion, String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaPU");
        UsuarioJpaController ujc = new UsuarioJpaController(emf);
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setOcupacion(ocupacion);
        usuario.setEmail(email);
        List<Usuario> usuarios = ujc.findUsuarioEntities();
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(usuario.getEmail())) {
                return u;
            }
        }
        try {
            ujc.create(usuario);
        } catch (Exception e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
        }
        return usuario;
    }
    
    /**
     * Crea un mensaje de un usuario hacia un empleado de la empresa
     * @param usuario El usuario que envía el mensaje
     * @param empleado El destinatario del mensaje
     * @param texto El texto del mensaje
     * @param ip La dirección ip desde la que se envió el mensaje
     * @return El mensaje registrado
     */
    public Mensaje crearMensaje(Usuario usuario, Empleado empleado, String texto, String ip) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaPU");
        MensajeJpaController mjc = new MensajeJpaController(emf);
        Mensaje mensaje = new Mensaje();
        mensaje.setUsuario(usuario);
        mensaje.setEmpleado(empleado);
        mensaje.setFechaYHora(new Date());
        mensaje.setTexto(texto);
        mensaje.setIpUsuario(ip);
        try {
            mjc.create(mensaje);
        } catch (Exception e) {
            System.err.println("Error al registrar mensaje: " + e.getMessage());
        }
        return mensaje;
    }
    
    /**
     * Valida un empleado mediante login y password
     * @param login el login usado para autenticar al empleado
     * @param password el password usado para autenticar al empleado
     * @return El empleado autenticado o null si falla la validación
     */
    public Empleado autenticarEmpleado(String login, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaPU");
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        List<Empleado> empleados = ejc.findEmpleadoEntities();
        for (Empleado empleado : empleados) {
            if (empleado.getLogin() != null && empleado.getPassword() != null && 
                    empleado.getLogin().equals(login) && empleado.getPassword().equals(password)) {
                return empleado;
            }
        }
        return null;
    }
}