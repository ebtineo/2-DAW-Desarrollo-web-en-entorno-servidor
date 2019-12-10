/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin2ejercicio8;

import java.util.Scanner;

/**
 *
 * @author Amieva
 */
public class Boletin2Ejercicio8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c; // Coeficientes de la ecuación
        double discriminante;
        double x1, x2;  // Las dos soluciones que buscamos
        
        System.out.println(
                "Introduzca los coeficientes de una ecuación de tipo ax2+bx+c=0");
        System.out.println("a:");
        a = sc.nextDouble();
        System.out.println("b:");
        b = sc.nextDouble();
        System.out.println("c:");
        c = sc.nextDouble();
        discriminante = b*b - 4*a*c;
        if (discriminante < 0) {
            System.out.println("La ecuación no tiene soluciones reales.");
        } else {
            if (a==0) {
                System.out.println("La ecuación no es de segundo grado");
                System.out.println("Su solución es x=" + -c/b);
            } else {
                x1 = (-b + Math.sqrt(discriminante)) / (2*a);
                x2 = (-b - Math.sqrt(discriminante)) / (2*a);
                System.out.println("Las soluciones son: " + x1 + " y " + x2);
            }
        }
    }
    
}
