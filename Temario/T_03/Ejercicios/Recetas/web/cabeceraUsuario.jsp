<%-- 
    Document   : cabeceraUsuario
    Created on : 22-nov-2018, 20:39:01
    Author     : jose
--%>

<%@page import="modelo.Usuario"%>
<%
    Usuario usuario = (Usuario)session.getAttribute("usuario");
    // Forzar la excepción si nombre es nulo
    usuario.getNombre().toUpperCase();
%>
<div class="cabecera">
    ${usuario.nombre}
    <div style="float: right;">
        <form action="cerrarSesion.jsp">
            <input type="submit" value="Salir">
        </form>
    </div>
</div>

