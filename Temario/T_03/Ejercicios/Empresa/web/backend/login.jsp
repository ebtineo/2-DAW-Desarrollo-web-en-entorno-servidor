<%-- 
    Document   : login
    Created on : 20-ene-2019, 16:28:52
    Author     : jose
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="empresa" class="beans.ModeloEmpresa" scope="session"/>
<c:remove var="empleadoConectado"/>
<c:if test="${!empty param.login}">
    <c:set var="empleado" value="${empresa.autenticarEmpleado(param.login, param.password)}"/>
    <c:choose>
        <c:when test="${!empty empleado}">
            <c:set var="empleadoConectado" value="${empleado}" scope="session"/>
            <c:redirect url="principal.jsp"/>
        </c:when>
        <c:otherwise>
            <c:set var="error" value="Fallo de autenticación"/>
        </c:otherwise>
    </c:choose>
</c:if>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <h2>Inicio de Sesión</h2>
        <br>
        <form method="post" action="login.jsp">
            <label>Usuario</label>
            <input type="text" name="login">
            <br>
            <label>Contraseña</label>
            <input type="password" name="password">
            <br>
            <input type="submit">
        </form>
        <br>
        <div style="color:red; font-size: larger;">
            ${error}
        </div>
    </body>
</html>
