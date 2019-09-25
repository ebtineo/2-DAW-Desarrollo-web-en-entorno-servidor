
/*
 * FileClientV1.java
 *
 * Created on 07-mar-2011, 22:54:00
 */

package fileserver_v1;

import fileserver.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author jose
 */
public class FileClientV1 extends javax.swing.JFrame {
    /**
     * Puerto del servidor
     */
    public final static int PUERTO = 2223;
    
    /** Creates new form FileClientV1 */
    public FileClientV1() {
        initComponents();
        panelDescarga.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoServidor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoFichero = new javax.swing.JTextField();
        botonDescargar = new javax.swing.JButton();
        panelDescarga = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        barraProgreso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Servidor:");

        campoServidor.setText("localhost");

        jLabel2.setText("Fichero Remoto:");

        botonDescargar.setText("Descargar");
        botonDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descargarFichero(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        jLabel3.setText("descargando...");

        barraProgreso.setStringPainted(true);

        javax.swing.GroupLayout panelDescargaLayout = new javax.swing.GroupLayout(panelDescarga);
        panelDescarga.setLayout(panelDescargaLayout);
        panelDescargaLayout.setHorizontalGroup(
            panelDescargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescargaLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel3)
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(panelDescargaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDescargaLayout.setVerticalGroup(
            panelDescargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescargaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonDescargar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoFichero)
                            .addComponent(campoServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoFichero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(botonDescargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDescarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descargarFichero(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descargarFichero
        new Descarga(this).start();
    }//GEN-LAST:event_descargarFichero


    public class Descarga extends Thread {

        private FileClientV1 ventanaPrincipal;

        public Descarga(FileClientV1 ventana) {
            ventanaPrincipal = ventana;
        }
        @Override
        public void run() {
            JFileChooser dialogoFichero = new JFileChooser();
            if (dialogoFichero.showSaveDialog(ventanaPrincipal)==JFileChooser.APPROVE_OPTION) {
                File fichero = dialogoFichero.getSelectedFile();
                Socket conexion;
                try {
                    conexion = new Socket(campoServidor.getText(),PUERTO);
                } catch (UnknownHostException e) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "No se ha podido encontrar el host", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "No se ha podido establecer la conexión con el host", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // salida de texto de la conexión
                PrintWriter salida;
                // entrada binaria de la conexión
                InputStream entrada;
                // entrada de texto de la conexion
                BufferedReader entradaTexto;
                // fichero de escritura
                FileOutputStream salidaFichero;
                // longitud del fichero
                long longitud;
                // numero de bytes leidos en cada momento
                long bytesLeidos = 0;
                try {
                    salida = new PrintWriter(new OutputStreamWriter(conexion.getOutputStream()),true);
                    entrada = conexion.getInputStream();
                    entradaTexto = new BufferedReader(new InputStreamReader(entrada));
                    salidaFichero = new FileOutputStream(fichero);
                    panelDescarga.setVisible(true);
                    barraProgreso.setValue(0);
                    botonDescargar.setEnabled(false);
                    int dato;
                    System.out.println("Descargando " +campoFichero.getText());
                    // Enviamos al servidor la ruta del fichero a descargar
                    salida.println(campoFichero.getText());
                    // leemos primero la longitud del fichero
                    String cadenaLongitud = "";
                    while ((dato=entrada.read())!=-1) {
                        if ((char)dato=='\n')
                            break;
                        else
                            cadenaLongitud += (char)dato;
                    }
                    longitud = Long.parseLong(cadenaLongitud);//longitud = Long.parseLong(entradaTexto.readLine());
                    System.out.println("Recibiendo " + longitud + " bytes ...");
                    // Leemos el contenido binario enviado por el servidor
                    while ((dato=entrada.read())!=-1) {
                        salidaFichero.write(dato);
                        bytesLeidos++;
                        //System.out.print((char)dato);
                        if (bytesLeidos % 1024 == 0)
                            barraProgreso.setValue((int)(bytesLeidos * 100.0 / longitud));
                    }
                    System.out.println("Se han recibido " + bytesLeidos + " bytes");
                    if (bytesLeidos == longitud) {
                        barraProgreso.setValue(100);
                    }
                    salidaFichero.close();
                    salida.close();
                    entrada.close();
                    conexion.close();
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Se ha completado la descarga", "Descarga completa", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Error de Entrada/Salida: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Error en el formato de los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    panelDescarga.setVisible(false);
                    botonDescargar.setEnabled(true);
                }
            }
        }
    }
    
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileClientV1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton botonDescargar;
    private javax.swing.JTextField campoFichero;
    private javax.swing.JTextField campoServidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelDescarga;
    // End of variables declaration//GEN-END:variables

}