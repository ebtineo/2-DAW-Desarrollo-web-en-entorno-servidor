<%-- 
    Document   : ejercicio3
    Created on : 13-nov-2018, 13:10:23
    Author     : Ricardo
--%>

<%@page import="java.util.Random"%>
<% 
    String error = "";
    int n1=0, n2=0;
    int aleatorio=0;
    String cadenaN1 = request.getParameter("campo1");
    String cadenaN2 = request.getParameter("campo2");
    if (cadenaN1 != null) {
        try {
            n1 = Integer.parseInt(cadenaN1);
        } catch (NumberFormatException e) {
            error += "El limite inferior no es correcto";
        }
    }
    if (cadenaN2 != null) {
        try {
            n2 = Integer.parseInt(cadenaN2);
        } catch (NumberFormatException e) {
            error += "El limite superior no es correcto";
        }
    }
    if (error.equals("") && cadenaN1!=null && cadenaN2!=null) {
        if (n1 > n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        Random r = new Random();
        aleatorio = n1 + r.nextInt(n2-n1);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Generador de numeros aleatorios</h1>
        <form method="post">
        Introduzca el primer numero: <input type="text" name="campo1" <%= "value='"+n1+"'"%>> <br>
        Introduzca el segundo numero: <input type="text" name="campo2" <%= "value='"+n2+"'"%>> <br>
        <input type="submit" value="Generar numero">
        </form>
        <%
            if (!error.equals("")) {
                out.println("<div style='color:red;'>" + error + "</div>");
            } else {
                if (cadenaN1!=null && cadenaN2!=null) {
                    out.println("<h2>" + aleatorio + "</h2>");
                }
            }
        %>
    </body>
</html>
