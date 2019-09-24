<%-- 
    Document   : cerrarSesion
    Created on : 22-nov-2018, 20:50:45
    Author     : jose
--%>
<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>