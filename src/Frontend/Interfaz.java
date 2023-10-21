package Frontend;

import Algoritmos.Secuencial;
import Algoritmos.Concurrente;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.SwingConstants;

public class Interfaz extends javax.swing.JFrame {

    private String rutaArchivoSeleccionado;
    private List<String> contenidoArchivo;
    private Cipher cipher;

    FondoPanel fondoUI = new FondoPanel();

    public Interfaz() {

        this.setContentPane(fondoUI);

        initComponents();

        this.lblOcultar.setVisible(false);
        this.txtTiempo.setEditable(false);
        this.lblEstado.setHorizontalAlignment(SwingConstants.CENTER);

        bngMetodo.add(rbConcurrente);
        bngMetodo.add(rbSecuencial);

        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bngMetodo = new javax.swing.ButtonGroup();
        jPanel2 = new FondoPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSeleccionarArchivo = new javax.swing.JButton();
        txtTiempo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbConcurrente = new javax.swing.JRadioButton();
        rbSecuencial = new javax.swing.JRadioButton();
        btnDescifrar = new javax.swing.JButton();
        btnCifrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        lblOcultar = new javax.swing.JLabel();
        lblVer = new javax.swing.JLabel();
        lblArchivo = new javax.swing.JLabel();
        cmboxIteraciones = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido a este cifrador \"AES\"");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html></p>El programa permite al usuario especificar una clave de cifrado, para que el texto que este ponga empiece a cifrarse. Luego, las palabras se generan aleatoriamente o se proporcionan en una lista y se cifran utilizando hilos concurrentes o de manera secuencial, a como desee el usuario.</p><html>");
        jLabel2.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Clave de Cifrado");
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Subir el Archivo");
        jLabel5.setOpaque(true);

        btnSeleccionarArchivo.setBackground(new java.awt.Color(0, 153, 153));
        btnSeleccionarArchivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSeleccionarArchivo.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarArchivo.setText("Seleccionar Archivo");
        btnSeleccionarArchivo.setBorder(null);
        btnSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarArchivoActionPerformed(evt);
            }
        });

        txtTiempo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tiempo Total");
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Metodo de AES");
        jLabel7.setOpaque(true);

        rbConcurrente.setBackground(new java.awt.Color(0, 0, 0));
        rbConcurrente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbConcurrente.setForeground(new java.awt.Color(255, 255, 255));
        rbConcurrente.setText("Concurrente");
        rbConcurrente.setBorder(null);
        rbConcurrente.setOpaque(true);

        rbSecuencial.setBackground(new java.awt.Color(0, 0, 0));
        rbSecuencial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbSecuencial.setForeground(new java.awt.Color(255, 255, 255));
        rbSecuencial.setText("Secuencial");
        rbSecuencial.setBorder(null);
        rbSecuencial.setOpaque(true);

        btnDescifrar.setBackground(new java.awt.Color(255, 255, 255));
        btnDescifrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDescifrar.setForeground(new java.awt.Color(153, 0, 0));
        btnDescifrar.setText("Descifrar");
        btnDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescifrarActionPerformed(evt);
            }
        });

        btnCifrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCifrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCifrar.setForeground(new java.awt.Color(102, 0, 102));
        btnCifrar.setText("Cifrar");
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCifrarActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Accion");
        jLabel3.setOpaque(true);

        txt_Password.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txt_Password.setBorder(null);

        lblOcultar.setBackground(new java.awt.Color(255, 255, 255));
        lblOcultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_CifradoAES/eye_slash_visible_hide_hidden_show_icon_145987.png"))); // NOI18N
        lblOcultar.setOpaque(true);
        lblOcultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOcultarMouseClicked(evt);
            }
        });

        lblVer.setBackground(new java.awt.Color(255, 255, 255));
        lblVer.setForeground(new java.awt.Color(255, 255, 255));
        lblVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_CifradoAES/eye_visible_hide_hidden_show_icon_145988.png"))); // NOI18N
        lblVer.setOpaque(true);
        lblVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerMouseClicked(evt);
            }
        });

        lblArchivo.setBackground(new java.awt.Color(0, 0, 0));
        lblArchivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArchivo.setForeground(new java.awt.Color(255, 255, 255));
        lblArchivo.setOpaque(true);

        cmboxIteraciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmboxIteraciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "5", "10", "15", "20" }));

        lblEstado.setBackground(new java.awt.Color(0, 0, 0));
        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblEstado.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Iteraciones");
        jLabel8.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(259, 259, 259))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnSeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(lblArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(rbConcurrente)
                        .addGap(39, 39, 39)
                        .addComponent(rbSecuencial))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(251, 251, 251)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblVer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(cmboxIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCifrar)
                                .addGap(94, 94, 94)
                                .addComponent(btnDescifrar)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblOcultar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblVer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbConcurrente)
                    .addComponent(rbSecuencial))
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmboxIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDescifrar)
                    .addComponent(btnCifrar))
                .addGap(17, 17, 17)
                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCifrarActionPerformed

        if (rbSecuencial.isSelected()) {
            lblEstado.setText("Cifrando el contenido del archivo...");

            if (contenidoArchivo != null) {
                // Obtener la clave del campo de contraseña
                String clave = new String(txt_Password.getPassword());

                long tiempoInicio = System.currentTimeMillis(); //Capturar el tiempo

                // Obtener el número de iteraciones seleccionado en el comboBox
                int iteraciones = Integer.parseInt(cmboxIteraciones.getSelectedItem().toString());

                // Llamar al método de cifrado de la clase Secuencial
                List<byte[]> ciphertexts = Secuencial.cifrarTextos(contenidoArchivo, cipher, new SecretKeySpec(clave.getBytes(), "AES"), iteraciones);

                long tiempoFin = System.currentTimeMillis(); // Capturar el tiempo de finalización
                long tiempoTotal = tiempoFin - tiempoInicio;

                txtTiempo.setText(tiempoTotal + "Milisegundos");
                lblEstado.setText("Cifrado Finalizado!");

                // Guardar los textos cifrados en un archivo
                String rutaArchivoCifrado = "archivo_cifrado_Secuencial.key"; // Cambia la ruta según tus necesidades
                guardarArchivoCifrado(ciphertexts, rutaArchivoCifrado);
                System.out.println("Archivo Guardado Con Exito!");
                // Mostrar resultados en la interfaz o realizar otras acciones necesarias
            } else {
                lblEstado.setText("No se ha seleccionado un archivo.");
            }
        } else if (rbConcurrente.isSelected()) {
            lblEstado.setText("Cifrando el contenido del archivo...");

            if (contenidoArchivo != null) {
                String clave = new String(txt_Password.getPassword());

                long tiempoInicio = System.currentTimeMillis(); // Capturar el tiempo

                int iteraciones = Integer.parseInt(cmboxIteraciones.getSelectedItem().toString());

                // Llamar al método de cifrado de la clase Concurrente
                List<byte[]> ciphertexts = null;
                
                try {
                    ciphertexts = Concurrente.cifrarTextosConcurrente(contenidoArchivo, new SecretKeySpec(clave.getBytes(), "AES"), iteraciones);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                long tiempoFin = System.currentTimeMillis(); // Capturar el tiempo de finalización
                long tiempoTotal = tiempoFin - tiempoInicio;

                txtTiempo.setText(tiempoTotal + " Milisegundos");
                lblEstado.setText("Cifrado Finalizado!");

                // Guardar los textos cifrados en un archivo
                String rutaArchivoCifrado = "archivo_cifrado_Concurrente.txt"; // Cambia la ruta según tus necesidades
                guardarArchivoCifrado(ciphertexts, rutaArchivoCifrado);
                System.out.println("Archivo Guardado Con Éxito!");
                // Mostrar resultados en la interfaz o realizar otras acciones necesarias
            }else {
                lblEstado.setText("No se ha seleccionado un archivo.");
            }
        } else {
            lblEstado.setText("No se ha seleccionado un método de cifrado.");
        }
    }//GEN-LAST:event_btnCifrarActionPerformed

    private void btnDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescifrarActionPerformed
        // TODO add your handling code here:
        if (rbConcurrente.isSelected()) {
            System.out.println("El metodo a cifrar sera Concurrente");
        } else if (rbSecuencial.isSelected()) {
            System.out.println("El metodo a cifrar sera Secuencial");
        } else {
            System.out.println("No selecciono nada");
        }
    }//GEN-LAST:event_btnDescifrarActionPerformed

    private void lblVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerMouseClicked
        // TODO add your handling code here:
        lblVer.setVisible(false);
        lblOcultar.setVisible(true);
        txt_Password.setEchoChar((char) 0);
    }//GEN-LAST:event_lblVerMouseClicked

    private void lblOcultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOcultarMouseClicked
        // TODO add your handling code here:
        lblVer.setVisible(true);
        lblOcultar.setVisible(false);
        txt_Password.setEchoChar('●');
    }//GEN-LAST:event_lblOcultarMouseClicked

    private void btnSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarArchivoActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        // Configurar el file chooser
        fileChooser.setDialogTitle("Seleccionar Archivo");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // El usuario ha seleccionado un archivo
            java.io.File selectedFile = fileChooser.getSelectedFile();
            rutaArchivoSeleccionado = selectedFile.getAbsolutePath(); // Obtener la ruta del archivo

            // Leer el contenido del archivo y almacenarlo en la variable "contenidoArchivo"
            contenidoArchivo = Secuencial.cargarPalabrasDesdeArchivo(rutaArchivoSeleccionado);

            lblArchivo.setText(selectedFile.getName());
        } else {
            lblArchivo.setText("Ningún archivo seleccionado");
        }
    }//GEN-LAST:event_btnSeleccionarArchivoActionPerformed

    private void guardarArchivoCifrado(List<byte[]> ciphertexts, String nombreArchivo) {
        String rutaDirectorio = "C:\\Users\\PC REINDEER\\Desktop\\PruebasArchivosGuardados";

        // Asegurarte de que el directorio de destino exista
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            directorio.mkdirs(); // Crear el directorio si no existe
        }

        try {
            // Crear el archivo de salida en la ruta especificada
            String rutaCompleta = rutaDirectorio + File.separator + nombreArchivo;
            FileOutputStream fos = new FileOutputStream(rutaCompleta);
            for (byte[] ciphertext : ciphertexts) {
                fos.write(ciphertext);
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics d) {
            imagen = new ImageIcon(getClass().getResource("/IMG_CifradoAES/Fondo_GUI.png")).getImage();

            d.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(d);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bngMetodo;
    private javax.swing.JButton btnCifrar;
    private javax.swing.JButton btnDescifrar;
    private javax.swing.JButton btnSeleccionarArchivo;
    private javax.swing.JComboBox<String> cmboxIteraciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblArchivo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblOcultar;
    private javax.swing.JLabel lblVer;
    private javax.swing.JRadioButton rbConcurrente;
    private javax.swing.JRadioButton rbSecuencial;
    private javax.swing.JTextField txtTiempo;
    private javax.swing.JPasswordField txt_Password;
    // End of variables declaration//GEN-END:variables
}
