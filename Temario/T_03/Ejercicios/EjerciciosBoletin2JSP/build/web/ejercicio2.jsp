<%-- 
    Document   : ejercicio2
    Created on : 09-nov-2018, 10:07:39
    Author     : jose
--%>

<%
    String frase = request.getParameter("frase");
    if (frase!=null) {
        frase = mayusculas(frase);
    } else {
        frase = "";
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pasar una frase a mayúsculas</title>
    </head>
    <body>
        <h1 style="color: blueviolet; ">Pasar a mayúsculas</h1>
        <form>
            <input type="text" name="frase">
            <input type="submit">
        </form>
        <br>
            <%
                if (!frase.equals("")) {
            %>
            <h2>Frase en mayúsculas:<%=frase%></h2>
            <%
                }
            %>
    </body>
</html>

<%!
    public String mayusculas(String cadena) {
        return cadena.toUpperCase();
    }
%>