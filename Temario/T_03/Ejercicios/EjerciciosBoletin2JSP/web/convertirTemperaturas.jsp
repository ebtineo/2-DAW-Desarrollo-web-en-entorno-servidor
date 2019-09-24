<%-- 
    Document   : convertirTemperaturas
    Created on : 10-dic-2018, 14:24:58
    Author     : jose
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="temperatura" class="beans.Temperatura" scope="session"></jsp:useBean>
<c:if test="${! empty param.convertirAF}">
    <jsp:setProperty name="temperatura" property="gradoC"/>
</c:if>
<%
    if (request.getParameter("convertirAC")!=null) {
%>
<jsp:setProperty name="temperatura" property="gradoF"/>
<%
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Conversor de Temperaturas</h1>
        <br>
        <form>
            <table>
                <tr>
                    <td><label>Temperatura en ºC</label></td>
                    <td><input type="text" name="gradoC" value="${temperatura.gradoC}"></td>
                    <td><input type="submit" name="convertirAF" value="Convertir a ºF"></td>
                </tr>
                <tr>
                    <td><label>Temperatura en ºF</label></td>
                    <td><input type="text" name="gradoF" value="${temperatura.gradoF}"></td>
                    <td><input type="submit" name="convertirAC" value="Convertir a ºC"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
