<%-- 
    Document   : mostrarDatos
    Created on : 09-mar-2015, 18:42:31
    Author     : jose
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="datos" class="beans.Datos" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos</title>
    </head>
    <body>
        <h3>Datos de Temperatura</h3>
        
        <c:forEach items="${datos.datos}" var="dato">
            <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${dato.temperatura}">
                <%--${ḍato.temperatura}--%>
            </fmt:formatNumber>
            <hr>
        </c:forEach>
        
    </body>
</html>
