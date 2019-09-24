<%-- 
    Document   : login
    Created on : 22-nov-2018, 18:32:38
    Author     : jose
--%>

<%@page import="modelo.Usuario"%>
<%
    String error="";
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    if (login != null && password != null) {
        if (!login.equals("") && password.equals(login.toLowerCase())) {
            Usuario u = new Usuario();
            u.setLogin(login);
            u.setNombre(login.toUpperCase());
            session.setAttribute("usuario", u);
            response.sendRedirect("mostrarRecetas.jsp");
            return;
        } else {
            error = "Usuario o contraseña incorrectos";
        }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recetas</title>
        <link rel="stylesheet" type="text/css" href="css/principal.css" >
    </head>
    <body>
        <br>
        <br>
        <div class="titulo">
            <h2>Inicio de Sesión</h2>
        </div>
        <br>
        <br>
        <br>
        <div class="centrado formulario">
            <form method="post">
                <table class="centrado">
                    <tr><td><label>Usuario </label></td><td><input type="text" name="login"></td></tr>
                    <tr><td><label>Contraseña </label></td><td><input type="password" name="password"></td></tr>
                    <tr><td></td><td><input type="submit" value="Iniciar Sesión"></td></tr>
                </table>
            </form>
        </div>
        <%
            if (!error.equals("")) {
        %>
        <br><br>
        <div class="error">
            <h1><%=error%></h1>
        </div>
        <%
            }
        %>
    </body>
</html>
