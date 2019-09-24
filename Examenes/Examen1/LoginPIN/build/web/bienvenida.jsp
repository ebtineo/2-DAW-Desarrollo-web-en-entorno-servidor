<%-- 
    Document   : bienvenida
    Created on : 20-dic-2018, 13:04:45
    Author     : jose
--%>

<%
    String usuario = (String)session.getAttribute("nombre");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenida</title>
    </head>
    <body>
        <h1>Bienvenido, <%= usuario %></h1>
    </body>
</html>
