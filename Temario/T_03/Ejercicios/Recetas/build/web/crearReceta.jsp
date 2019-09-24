<%-- 
    Document   : crearReceta
    Created on : 22-nov-2018, 21:22:19
    Author     : jose
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Receta"%>
<jsp:useBean id="todasLasRecetas" class="modelo.ModeloRecetas" scope="application"/>
<%
    String error = "";
    String nombre = request.getParameter("nombre");
    String contenido = request.getParameter("contenido");
    if (nombre!=null && contenido!=null && !nombre.equals("")) {
        if (todasLasRecetas.buscarReceta(nombre)==null) {
            todasLasRecetas.crearReceta(nombre, contenido, (Usuario)session.getAttribute("usuario"));
            session.setAttribute("mensaje", "Se ha añadido la receta");
            response.sendRedirect("mostrarRecetas.jsp");
            return;
        } else {
            error = "La receta ya existe";
            // Lo ponemos en el ámbito de página para que sea accesible
            // desde las expresiones &{}
            pageContext.setAttribute("error", error);
        }
    }
%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Mis Recetas Favoritas</title>
        <link rel="stylesheet" type="text/css" href="css/principal.css">
        <script src="js/miScript.js"></script>
    </head>
    <body onload="mostrar('${error}')">
        <jsp:include page="cabeceraUsuario.jsp"/>
        <br>
        <div class="titulo">
            <h2>Mis Recetas Favoritas</h2>
        </div>
        <br>
        <div class="centrado formulario">
            <form method="post">
                <label>Nombre de la Receta </label>
                <input type="text" name="nombre">
                <br>
                <label>Escriba aquí la receta</label>
                <textarea name="contenido" cols="80" rows="20">${param.contenido}</textarea>
                <br>
                <input type="submit" value="Aceptar">
            </form>
        </div>
    </body>
</html>
