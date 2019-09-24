<%-- 
    Document   : grafica
    Created on : 09-mar-2015, 19:00:19
    Author     : jose
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="datos" class="beans.Datos" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function dibujar_grafica() {
                var datos = [
                    <c:forEach items="${datos.datos}" var="dato" varStatus="status" >
                                ${dato.temperatura}
                                <c:if test="${!status.last}">
                                    ,
                                </c:if>
                    </c:forEach>
                ];
                var canvas = document.getElementById('grafica');
                var gr = canvas.getContext('2d');
                gr.font='15px Arial';
                gr.beginPath();
                // obtenemos las dimensiones del canvas
                ancho = canvas.clientWidth;
                alto = canvas.clientHeight;
                // Dibujamos dejando un margen del 10%
                x_derecha = ancho * 0.1;
                y_abajo = alto * 0.9;
                // Buscamos el maximo de las temperaturas
                min =  100000;
                max = -100000;
                for (i=0;i<datos.length;i++) {
                    if (datos[i]>max) {
                        max = datos[i];
                    }
                    if (datos[i]<min) {
                        min = datos[i];
                    }    
                }
                // Calculamos la escala vertical y el paso horizontal
                escala_y = alto*0.8/(max-min);
                paso_x = ancho*0.8/datos.length;
                gr.fillStyle='#F02000';
                // Nos posicionamos en el primer punto de la grafica
                gr.moveTo(x_derecha, y_abajo-(datos[0]-min)*escala_y);
                x = x_derecha;
                // Recorremos el resto de los datos dibujando segmentos de linea
                for(i=1;i<datos.length;i++) {
                    x+=paso_x;
                    gr.lineTo(x,y_abajo-(datos[i]-min)*escala_y);
                    // Cada 6 puntos mostramos el valor
                    if(i%6==0) {
                        gr.fillText(datos[i]+'º',x+10,y_abajo-(datos[i]-min)*escala_y);
                    }    
                }
                gr.strokeStyle='#0020F0';
                gr.lineWidth = 4;
                // Terminamos la grafica
                gr.stroke();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Temperaturas</title>
    </head>
    <body onload="dibujar_grafica()">
        <h3>Temperaturas</h3>
        
        <canvas id="grafica" height="400" width="800" style="background-color: lightgrey" ></canvas>
    </body>
</html>
