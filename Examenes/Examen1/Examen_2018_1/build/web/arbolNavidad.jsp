<%-- 
    Document   : arbolNavidad
    Created on : 18-dic-2018, 0:07:43
    Author     : jose
--%>

<%@page import="modelo.Bola"%>
<jsp:useBean id="arbol" class="modelo.Arbol" scope="session"/>
<jsp:useBean id="posicion" class="modelo.Posicion" scope="page"/>

<jsp:setProperty name="posicion" property="*"/>
${arbol.cambiar(posicion.fila, posicion.columna)}

<%
    if (arbol.coloresConsecutivos() == 0) {
        response.sendRedirect("felicitacion.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coloca las bolas del árbol</title>
        <link rel="stylesheet" type="text/css" href="css/principal.css">
    </head>
    <body>
        <div id="div_imagen">
            <div class="fila">
            </div>
            <div class="fila">
            </div>
            <%
                for (int fila = 0; fila < arbol.getProfundidad(); fila++) {
            %>
            <div class="fila">
                <%
                    Bola[] filaBolas = arbol.getFila(fila);
                    for (int columna = 0; columna < filaBolas.length; columna++) {
                %>
                <form>
                    <div clas="bola">
                    <input type="image" src="<%= filaBolas[columna].getImagen() %>" name="bola1">
                    <input type="hidden" name="fila" value="<%= fila%>">
                    <input type="hidden" name="columna" value="<%= columna%>">
                    </div>
                </form>
                <%
                    }
                %>
            </div>
            <%
                }
            %>
        </div>
        <div class="panel">
            <br>
            <br>
            <br>
            <br>
            <br>
            Número de Intentos: ${arbol.intentos}
            <br>
            <br>
            <br>
            Número de bolas consecutivas 
            <br>
            del mismo color:
            <br>
            <div class="puntuacion">
                ${arbol.coloresConsecutivos()}
            </div>
        </div>
    </body>
</html>
