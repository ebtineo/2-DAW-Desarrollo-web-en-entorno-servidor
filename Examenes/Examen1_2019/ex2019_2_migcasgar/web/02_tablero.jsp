<%-- 
    Document   : 02_tablero
    Created on : 10-dic-2019, 12:59:01
    Author     : WorKeLid
--%>

<%@page import="modelo.Partida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>02 Tablero</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            
            Partida partida;
            if (session.getAttribute("partida") != null) {
                partida = (Partida) sesion.getAttribute("partida");
            
            if (request.getParameter("intento") != null) {
                int fila = Integer.parseInt(request.getParameter("fila"));
                int columna = Integer.parseInt(request.getParameter("columna"));
                if (partida.getIntentos() == partida.getMaximoIntentos()) {
                    // GameOver
                    sesion.setAttribute("derrota", "derrota");
                    response.sendRedirect("03_gameOver.jsp");
                } else if (partida.descubrir(fila, columna)) {
                    // Ha encontrado a Santa Clauss
                    sesion.setAttribute("victora", "victoria");
                    response.sendRedirect("04_felicidades.jsp");
                }
            }
        %>
                
        <table border="2">
            <% 
            for (int i = 0; i < 6; i++) {
            %>
            <tr>
                <%
                    for (int t = 0; t < 8; t++) {
                    %>
                    <td>
                        <form>
                            <input type="hidden" name="fila" value=<%= i%>>
                            <input type="hidden" name="columna" value=<%= t%>>
                            
                            <%
                              if (partida.getTablero()[i][t].isDescubierta()) {
                            %>
                            <img src="img/regalo.png" width='50px' alt='regalo'>
                            <%
                              } else {
                            %>
                            <input type="submit" name="intento" value="<%=""%>">
                            <%
                              }
                            %>
                            
                        </form>
                    </td>
                    <%
                    }
                %>
            </tr>
            <%
            }
            %>
        </table>     
        <%      
            } else {
                response.sendRedirect("01_index.jsp");
            }
        %>
    </body>
</html>
