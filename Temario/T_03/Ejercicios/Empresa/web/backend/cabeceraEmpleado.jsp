<%-- 
    Document   : cabeceraEmpleado
    Created on : 20-ene-2019, 23:16:04
    Author     : jose
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty sessionScope.empleadoConectado}">
    <jsp:forward page="login.jsp"/>
</c:if>
<div>
    <c:out value="${empleadoConectado.apellidos}, ${empleadoConectado.nombre}"/>
    <div style="float: right;">
        <form action="cerrarSesion.jsp">
            <input type="submit" value="Cerrar Sesión">
        </form>
    </div>
</div>