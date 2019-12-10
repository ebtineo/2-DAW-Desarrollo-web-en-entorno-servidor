/*
 * Servlet Login
 * Pide usuario y contraseña, las valida, y si son correctas
 * crea una sesión con los datos del usuario
 */
package ejercicio10;

import ejercicio10.modelo.Usuario;
import ejercicio10.modelo.Validacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jose
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            // controlador
            String error = "";
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            if (login != null && password != null) {
                Validacion v = new Validacion();
                Usuario u = v.validar(login, password);
                if (u != null){
                    HttpSession sesion = request.getSession();
                    // Creamos el atributo de sesión para el usuario
                    sesion.setAttribute("usuario", u);
                    Integer cuentaUsuarios = (Integer)getServletContext().getAttribute("cuentaUsuarios");
                    if (cuentaUsuarios == null) {
                        cuentaUsuarios = new Integer(1);
                    } else {
                        cuentaUsuarios = cuentaUsuarios + 1;
                    }
                    getServletContext().setAttribute("cuentaUsuarios", cuentaUsuarios);
                    response.sendRedirect("InsertarTermino");
                    return;
                } else {
                    error = "Login o password incorrevtos";
                }
            }
            // vista
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Login</h2>");
            out.println("<form method='post'>");
            out.println("<label for='login'>Login</label>");
            out.println("<input type='text' name='login' id='login'>");
            out.println("<br>");
            out.println("<label id='password'>Password</label>");
            out.println("<input type='password' name='password' id='password'>");
            out.println("<br>");
            out.println("<input type='submit' value='Acceder'>");
            out.println("</form>");
            if (!error.equals("")) {
                out.println("<div style='color:red;'>" + error + "</div>");
            }
            out.println("</body>");
            out.println("</html>");
        }
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
