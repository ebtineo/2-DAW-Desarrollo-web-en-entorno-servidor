<%-- 
    Document   : index
    Created on : 18-dic-2018, 1:32:13
    Author     : jose
--%>

<%
    if (request.getParameter("nombre")!=null) {
        session.setAttribute("nombre", request.getParameter("nombre"));
        session.removeAttribute("arbol");
        response.sendRedirect("arbolNavidad.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Feliz Navidad</title>
    </head>
    <body>
        <form>
            <label>Introduce tu nombre</label>
            <input type="text" name="nombre">
            <input type="submit" value="Aceptar">
        </form>
    </body>
</html>
