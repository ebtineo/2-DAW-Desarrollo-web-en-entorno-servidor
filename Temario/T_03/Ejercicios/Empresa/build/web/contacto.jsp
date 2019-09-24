<%-- 
    Document   : contacto
    Created on : 18-ene-2019, 20:49:07
    Author     : jose
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="empresa" class="beans.ModeloEmpresa" scope="session"/>
<c:if test="${!empty param.nombre && !empty param.apellidos && !empty param.idEmpleado}">
    <c:set var="empleado" value="${empresa.getEmpleado(param.idEmpleado)}"/>
    <c:set var="usuario" value="${empresa.crearUsuario(param.nombre, param.apellidos, param.ocupacion, param.email)}"/>
    <c:set var="ip" value="${pageContext.request.remoteAddr}"/>
    <c:set var="mensaje" value="${empresa.crearMensaje(usuario, empleado, param.texto, ip)}"/>
</c:if>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Contacto</title>
    </head>
    <body>
        <h2>Contacto</h2>
        <form>
            <label>Nombre</label>
            <input type="text" name="nombre">
            <br>
            <label>Apellidos</label>
            <input type="text" name="apellidos">
            <br>
            <label>Ocupación</label>
            <input type="text" name="ocupacion">
            <br>
            <label>e-mail</label>
            <input type="text" name="email">
            <br>
            <label>Empleado al que va dirigido el mensaje</label>
            <select name="idEmpleado">
                <c:forEach var="emp" items="${empresa.empleados}">
                    <option value="${emp.id}">
                    ${emp.apellidos}, ${emp.nombre} : ${emp.departamento.nombre}
                    </option>
                </c:forEach>
            </select>
            <br>
            <label>Mensaje</label>
            <br>
            <textarea name="texto" cols="20"></textarea>
            <br>
            <input type="submit">
        </form>
    </body>
</html>