<%-- 
    Document   : comprobar_sesion
    Created on : 12-nov-2018, 13:05:25
    Author     : jose
--%>

<%
        if (request.getSession().getAttribute("usuario")==null) {
            // La sesi�n no es v�lida
            request.getRequestDispatcher("/Ejercicio10").forward(request, response);
        }

%>