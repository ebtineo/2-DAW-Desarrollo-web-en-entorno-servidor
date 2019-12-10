<%-- 
    Document   : 03_gameOver
    Created on : 10-dic-2019, 13:51:53
    Author     : WorKeLid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>03 GameOver</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            if (session.getAttribute("derrota") != null) {
                %>
                <h1>Mira el lado positivo, <%= session.getAttribute("nombre")%> , te llevas los regalos</h1>
                <img src="img/muchosRegalos.jpg">
                <%
            } else {
                response.sendRedirect("01_index.jsp");
            }
        %>
    </body>
</html>
