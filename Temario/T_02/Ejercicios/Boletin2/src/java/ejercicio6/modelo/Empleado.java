/*
 * Clase Empleado
 */
package ejercicio6.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author jose
 */
public class Empleado {

    private String dni;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String categoriaProfesional;
    // true para Mujer, false para Hombre
    private boolean sexo;
    private List<String> aficiones;

    public Empleado(String dni, String nombre, String apellidos, Date fechaNacimiento, String categoriaProfesional, boolean sexo, List<String> aficiones) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.categoriaProfesional = categoriaProfesional;
        this.sexo = sexo;
        this.aficiones = aficiones;
    }
    
    public Empleado() {
        this("", "" , "", new Date(), "", true, null);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCategoriaProfesional() {
        return categoriaProfesional;
    }

    public void setCategoriaProfesional(String categoriaProfesional) {
        this.categoriaProfesional = categoriaProfesional;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public List<String> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<String> aficiones) {
        this.aficiones = aficiones;
    }

    public int getEdad() {
        //Calendar edad = Calendar.getInstance();
        //edad.setTimeInMillis(new Date().getTime() - fechaNacimiento.getTime());
        //return edad.get(Calendar.YEAR) - 1970;
        Calendar ahora = Calendar.getInstance();
        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);
        ahora.add(Calendar.YEAR, -nacimiento.get(Calendar.YEAR));
        ahora.add(Calendar.MONTH, -nacimiento.get(Calendar.MONTH));
        ahora.add(Calendar.DAY_OF_MONTH, -nacimiento.get(Calendar.DAY_OF_MONTH));
        return ahora.get(Calendar.YEAR);
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
    public static boolean comprobarFormatoDNI(String dni) {
        if (dni.length() == 9) {
            if (Character.isLetter(dni.charAt(8))) {
                for (int i=0; i<8; i++) {
                    if (!Character.isDigit(dni.charAt(i))) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
}
