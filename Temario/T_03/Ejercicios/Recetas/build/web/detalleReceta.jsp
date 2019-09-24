<%-- 
    Document   : detalleReceta
    Created on : 26-nov-2018, 13:40:56
    Author     : jose
--%>
<%@page import="modelo.Receta"%>
<%@page import="modelo.Usuario"%>
<%
    String nombre=request.getParameter("receta");
    Usuario usuario = (Usuario)session.getAttribute("usuario");
    Receta recetaSeleccionada = null;
    for (Receta r : usuario.getRecetasFavoritas()) {
        if (nombre.equals(r.getNombre())) {
            recetaSeleccionada = r;
            break;
        }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Recetas Favoritas</title>
    </head>
    <body>
        <%
            request.getRequestDispatcher("cabeceraUsuario.jsp").include(request, response);
        %>
        <h2><%=recetaSeleccionada.getNombre() %></h2>
        
        <br>
        <div>
            <%=recetaSeleccionada.getContenido() %>
        </div>
    </body>
</html>
