<%-- 
    Document   : comprobar_sesion
    Created on : 12-nov-2018, 13:05:25
    Author     : jose
--%>

<%
        if (request.getSession().getAttribute("usuario")==null) {
            // La sesión no es válida
            request.getRequestDispatcher("/Ejercicio10").forward(request, response);
        }

%>