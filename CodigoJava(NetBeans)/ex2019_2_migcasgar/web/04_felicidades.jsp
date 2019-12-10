<%-- 
    Document   : 04_felicidades
    Created on : 10-dic-2019, 13:54:24
    Author     : WorKeLid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>04 Felicidades</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            if (session.getAttribute("victora") != null) {
                %>
                <h1>Enhorabuena <%= session.getAttribute("nombre")%>, Le has cazado</h1>
                <img src="img/SantaClaus.jpg">
                <%
            } else {
                response.sendRedirect("01_index.jsp");
            }
        %>
    </body>
</html>
