<%-- 
    Document   : formulario
    Created on : 28-ene-2019, 13:44:55
    Author     : jose
--%>
<jsp:useBean id="bean" class="beans.BeanFecha"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<fmt:setLocale value="es_es"/>
<c:if test="${!empty param.numero}">
    <%--<fmt:parseNumber var="num" value="${param.numero}" type="number"/>--%>
    <c:set var="num" value="${param.numero}"/>
    <fmt:parseDate value="${param.fecha}" var="fecha" pattern="yyyy-MM-dd"/>
    <%--<jsp:setProperty name="bean" property="fecha" value="${fecha}"/>--%>
    <c:set target="${bean}" property="fecha" value="${fecha}"/>
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formatos</h1>
        <form>
            <label>Introduzca número</label>
            <input type="number" step="0.01" name="numero">
            <input type="date" name="fecha">
            <input type="submit">
        </form>
        <br>

            <fmt:formatNumber value="${num}" type="number" minFractionDigits="2"/>
            <fmt:formatDate value="${fecha}" type="date" dateStyle="full"/>
            <fmt:formatDate value="${bean.fecha}" type="both"/>
    </body>
</html>
