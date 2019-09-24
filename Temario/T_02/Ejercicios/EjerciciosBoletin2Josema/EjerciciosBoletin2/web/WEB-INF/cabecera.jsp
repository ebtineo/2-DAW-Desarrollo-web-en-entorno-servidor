<%-- 
    Document   : cabecera
    Created on : 12-nov-2018, 13:11:56
    Author     : jose
--%>

<%
           out.println("<div style='background-color:lightblue; margin: auto;'>");
           out.println("Usuario " + request.getSession().getAttribute("usuario"));
           out.println("</div>");
 
%>