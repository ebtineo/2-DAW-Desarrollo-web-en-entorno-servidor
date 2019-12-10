<%-- 
    Document   : felicitacion
    Created on : 18-dic-2018, 1:20:15
    Author     : jose
--%>

<jsp:useBean id="arbol" class="modelo.Arbol" scope="session"/>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Feliz Navidad</title>
        <link rel="stylesheet" type="text/css" href="css/principal.css">
    </head>
    <body>
        <%
            if (arbol.getIntentos()<5) {
        %>
        <h2>Lo has hecho muy bien</h2>
        <%
            }
        %>
        <br>
        <div id="div_felicitacion">
        </div>
        <br>
        <br>
        <%
            if (session.getAttribute("nombre")!=null) {
        %>
        <h2>Felicidades, ${nombre}</h2>
        <%
            }
        %>
        <br>
        <br>
        <div class="fila">
            <form action="arbolNavidad.jsp">
                <input type="submit" value="Empezar de nuevo">
            </form>
        </div>
    </body>
</html>
<%
    session.invalidate();
%>
