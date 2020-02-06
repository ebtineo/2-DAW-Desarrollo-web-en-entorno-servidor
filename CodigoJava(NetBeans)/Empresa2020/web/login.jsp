<%-- 
    Document   : login
    Created on : 28-ene-2020, 12:35:30
    Author     : jose
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="Login" method="POST">
            Usuario <input type="text" name="login">
            <br>
            Contraseña <input type="password" name="password">
            <br>
            <input type="submit" value="Iniciar Sesión">
        </form>
        <c:if test="${!empty requestScope.error}">
            <div style="width: 60%; margin: auto; background-color: hotpink; color: white">
                <br>
                <h1 style="text-align: center;"><c:out value="${error}"/></h1>
                <br>
            </div>
        </c:if>
    </body>
</html>
