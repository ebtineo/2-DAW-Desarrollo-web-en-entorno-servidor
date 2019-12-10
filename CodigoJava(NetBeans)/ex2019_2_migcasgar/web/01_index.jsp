<%-- 
    Document   : 01_index
    Created on : 10-dic-2019, 12:50:41
    Author     : WorKeLid
--%>
<%@page import="modelo.Partida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>01 Indice</title>
    </head>
    <body>
    <%
        HttpSession sesion = request.getSession();
        
        if (request.getParameter("nombre") != null) {
            session.setAttribute("nombre", (String) request.getParameter("nombre"));
        }
        
        if (sesion.getAttribute("nombre") != null) {
            session.setAttribute("partida", new Partida());
            response.sendRedirect("02_tablero.jsp");
        } else {
    %>
        <form action="01_index.jsp">
            <label>Nombre de usuario: <input type="text" name="nombre"></label>
            <input type="submit" value="Enviar">
        </form>
    <%
        }
    %>
    </body>
</html>
