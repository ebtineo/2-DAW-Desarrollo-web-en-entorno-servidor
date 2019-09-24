<%-- 
    Document   : mostrarRecetas
    Created on : 22-nov-2018, 20:03:20
    Author     : jose
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Receta"%>
<%@page import="modelo.Usuario"%>

<jsp:useBean id="todasLasRecetas" class="modelo.ModeloRecetas" scope="application"/>
<jsp:useBean id="usuario" class="modelo.Usuario" scope="session"/>
<%-- Si estamos añadiendo una nueva receta favorita ... --%>
<jsp:useBean id="recetaNueva" class="modelo.Receta" scope="page"/>
<jsp:setProperty name="recetaNueva" property="nombre" param="nuevaReceta"/>
<%
    //Usuario usuario = (Usuario)session.getAttribute("usuario");
    // Buscamos la receta entre la lista global
    //String nuevaReceta = request.getParameter("nuevaReceta");
    if (recetaNueva.getNombre()!=null) {
        usuario.nuevaRecetaFavorita(
                todasLasRecetas.buscarReceta(recetaNueva.getNombre()));                
    }
    pageContext.setAttribute("mensaje", session.getAttribute("mensaje"));
    session.removeAttribute("mensaje");
%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Mis Recetas Favoritas</title>
        <link rel="stylesheet" type="text/css" href="css/principal.css">
        <script src="js/miScript.js"></script>
    </head>
    <body onload="mostrar('${mensaje}')">
        <br>
        <jsp:include page="cabeceraUsuario.jsp"/>
        <div class="titulo">
            <h2>Mis Recetas Favoritas</h2>
        </div>
        <br>
        <div class="centrado">
            <%= usuario.getRecetasFavoritas().isEmpty()?"<h3>No hay ninguna receta favorita</h3>":"" %>

            <table>
                <%
                    for (Receta receta : usuario.getRecetasFavoritas()) {
                %>
                <tr>
                    <td><b><%=receta.getNombre() %></b></td>
                    <td> de <%=receta.getAutor().getNombre() %></td>
                    <td>
                        <form action="detalleReceta.jsp" method="post">
                            <input type="hidden" name="receta" value="<%=receta.getNombre() %>">
                            <input type="submit" name="receta" value="Ver Detalles">
                        </form>

                    </td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        <br>
        <div class="formulario centrado">
            <label>Añadir una receta a mis favoritas </label>
            <form method="post">
                <select name="nuevaReceta">
                    <%
                        for (Receta receta : todasLasRecetas.getTodasLasRecetas()) {
                            if (!usuario.getRecetasFavoritas().contains(receta)) {
                    %>   
                    <option value="<%=receta.getNombre() %>"><b><%=receta.getNombre()%></b> de <%=receta.getAutor().getNombre()%> </option>
                    <%
                            }
                        }
                    %>
                </select>
                <input type="submit" value="Añadir">
            </form>
        </div>
        <br>
        <div class="centrado" style="text-align: center;">
            <a href="crearReceta.jsp"><button>Crear una nueva receta</button></a>
        </div>
    </body>
</html>
