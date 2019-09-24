/*
 * 4. Realizar una aplicación web que resuelva ecuaciones de segundo grado. El resultado se
mostrará en la misma página.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author usuario
 */
public class ejercicio4 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            double n1 = 0, n2 = 0, n3 = 0;
            String error = "";
            String resultado1="", resultado2="";

            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            String num3 = request.getParameter("num3");
            
            if (num1 != null && num2 != null && num3 != null) {
                Scanner sc1 = new Scanner(num1);
                Scanner sc2 = new Scanner(num2);
                Scanner sc3 = new Scanner(num3);

                if (sc1.hasNextDouble()) {
                    System.out.println("entra");
                    n1 = sc1.nextDouble();
                } else {
                    error += "Error en 1er parámetro.<br>";
                }

                if (sc2.hasNextDouble()) {
                    n2 = sc2.nextDouble();
                } else {
                    error += "Error en 2er parámetro.<br>";
                }

                if (sc3.hasNextDouble()) {
                    n3 = sc3.nextDouble();
                } else {
                    error += "Error en 3er parámetro.<br>";
                }
                
             resultado1 = resuelve(n1, n2, n3, error)[0];
             resultado2 = resuelve(n1, n2, n3, error)[1];
             error += resuelve(n1, n2, n3, error)[2];

            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ejercicio4</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Ecuaciones 2ºgrado</h2>");
            out.println("<form method='get' action='ejercicio5'>");
            out.println("<input type='text'name='num1'>");
            out.println("<label>x2+</label>");
            out.println("<input type='text'name='num2'>");
            out.println("<label>x+</label>");
            out.println("<input type='text'name='num3'>");
            out.println("<label>=0</label>");
            out.println("<input type='submit'>");
            out.println("</form>");
            
            if(error!=""){
            out.println("<p> X<sub>1</sub> = "+resultado1+"</p>");
            out.println("<p> X<sub>2</sub> = "+resultado2+"</p>");
            }else{
                 out.println("<p>" + error + "</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    public static String[] resuelve(double a, double b, double c, String error) {
        String[] devuelve = {"","", ""};
    //Pedir los coeficientes de una ecuación de segundo grado, y mostrar sus soluciones reales.
//Si no existen, debe indicarlo. Recordemos que las soluciones de una ecuación de segundo grado,
//ax2 +bx+c=0son,
//
//x = −b±√b2 −4ac / 2a

        //calculamos el interior de la raiz cuadrada para ver si su resultado es positivo
        //si es negativo no tiene soluciones reales
        double interior = (b * b) - (4 * a * c);

        if (interior < 0) {
            devuelve[2] +="No hay soluciones reales para la ecuación <br>";
        } else if (interior == 0) {
           devuelve[2] +="No es una ecuación de segundo grado  <br>";

        } else {
            devuelve[0]= String.valueOf((-b + Math.sqrt(interior)) / (2 * a));
            devuelve[1] = String.valueOf((-b - Math.sqrt(interior)) / (2 * a));
        }
        return devuelve;
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
