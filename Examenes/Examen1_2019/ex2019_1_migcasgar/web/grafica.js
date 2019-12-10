            function dibujar_grafica() {
                var canvas = document.getElementById('grafica');
                var gr = canvas.getContext('2d');
                var colores = ['#8010ff','#1080ff','#1010ff'];
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
                //gr.moveTo(x_derecha, y_abajo-(datos[0]-min)*escala_y);
                //x = x_derecha;
                // Recorremos el resto de los datos dibujando segmentos de linea
                for(i=0;i<datos.length;i++) {
                    gr.fillStyle = colores[i % colores.length];
                    gr.fillRect(x_derecha + i * paso_x, y_abajo, paso_x * 0.8 ,- (datos[i]-min + 0.5)*escala_y );
                    if (typeof(etiquetas) != 'undefined') {
                        if (etiquetas.length > i) {
                            gr.fillText(etiquetas[i], x_derecha + i * paso_x , y_abajo + 15 * ((i % 2)+1));
                        }
                    }
                    //x+=paso_x;
                    //gr.lineTo(x,y_abajo-(datos[i]-min)*escala_y);
                    // Cada 6 puntos mostramos el valor
                    //if(i%6==0) {
                    //    gr.fillText(datos[i]+'º',x+10,y_abajo-(datos[i]-min)*escala_y);
                    //}    
                }
                gr.strokeStyle='#0020F0';
                gr.lineWidth = 4;
                // Terminamos la grafica
                gr.stroke();
            }

