package ej6;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/*
6. Desarrollar una pequeña aplicación web para registrar datos del personal de una
organizción. La aplicación contendrá una página HTML con un formulario que permitirá
introducir los datos de una persona (nombre, apellidos, categoría profesional , fecha de
nacimiento, etc). También tendrá un servlet que recibirá los datos del formulario anterior y
los escribirá en un fichero de texto. Además tendrá otro servlet que listará los datos del
personal. El formulario debe tener algún control de tipo combo y algún grupo de
checkbox.
*/
public class Persona {
    
    private final String nombre, apellidos, nacimiento;
    private final Cat categoriaPro;
    
    public Persona(String nombre, String apellidos, String categoriaPro, String nacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        switch (categoriaPro) {
            case "cat1":
                this.categoriaPro = Cat.cat1;
                break;
            case "cat2":
                this.categoriaPro = Cat.cat2;
                break;
            case "cat3":
                this.categoriaPro = Cat.cat3;
                break;
            case "cat4":
                this.categoriaPro = Cat.cat4;
                break;
            default:
                this.categoriaPro = Cat.cat1;
            
        }
        this.nacimiento = nacimiento;
    }
    
    public void toFile(String uri) throws IOException {
        String res = "[" +
                "nombre: " + this.nombre +
                "apellidos: " + this.apellidos + 
                "categoriaPro: " + this.categoriaPro + 
                "nacimiento: " + this.nacimiento +
                "]\n";
        FileWriter fw = new FileWriter("C:\\Users\\WKL\\Google_Drive\\Formacion\\Desarrollo_de_aplicaciones_web\\Desarrollo web en entorno servidor\\CodigoJava(NetBeans)\\bol2\\web");
        fw.write(res);
        fw.close();
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "<br>" +
                "Apellidos: " + this.apellidos + "<br>" +
                "Categoria: " + this.categoriaPro +"<br>" +
                "Nacimiento: " + this.nacimiento + "<br>";
    }
}
enum Cat {
    cat1,
    cat2,
    cat3,
    cat4
}