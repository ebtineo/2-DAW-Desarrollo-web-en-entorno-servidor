package ej8;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
8. Realizar un servlet que muestre la fecha y la hora obtenida en el servidor. El formato debe
ser adecuado a la configuración local del cliente (lenguaje y zona de cada navegador).
 */
public class horaServidor extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet horaServidor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet horaServidor at " + request.getContextPath() + "</h1>");
            
            /*
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            java.util.TimeZone timeZone = calendar.getTimeZone();
            out.println(timeZone.getDisplayName());
            */
            
            String js = "<script type='text/javascript'>\n" +
                            "var dateVar = new Date();\n" +
                            "var timezone = dateVar.getTimezoneOffset()/60 * (-1);  \n" +
                            "AJAXResuest('localhost:8080/bol2/horaServidor', timezone) \n" +
                        "</script>";
            out.println(js);
             
            String strFromJavaScript = request.getParameter("timezone");
            int timeZone = Integer.parseInt(strFromJavaScript);
            if (timeZone >= 0) {
                strFromJavaScript = "+" + timeZone;
            }

            TimeZone tz = TimeZone.getTimeZone("GMT" + strFromJavaScript);
            out.println(tz.getDisplayName());
            out.println(tz.getRawOffset());

            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
