/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.CModelosConductor;
import utilitarios.CUtilitarios;

/**
 *
 * @author rocio
 */
public class JFConductor extends javax.swing.JFrame {
//PERMITE LLAMAR LAS CONSULTAS DE LOS MODELOS

    CModelosConductor modelos = new CModelosConductor();
    ArrayList<String[]> resultados = new ArrayList<>();
    int numero;

    //***************METODOS PROPIOS**********
    private void limpiar_campos() {
        jTFNombre.setText("");
        jTFApellidoP.setText("");
        jTFApellidoM.setText("");
    }

    private boolean campos_vacios() {
        return jTFNombre.getText().isEmpty()
                || jTFApellidoP.getText().isEmpty()
                || jTFApellidoM.getText().isEmpty();

    }

    private void limpiar_tabla() {
        DefaultTableModel modelTabla
                = (DefaultTableModel) jTDatos.getModel();
        for (int i = (modelTabla.getRowCount() - 1); i >= 0; i--) {
            modelTabla.removeRow(i);
        }
    }

    private void lee_datos() {
        numero = 1;
        //2.- obtener modelo de la tabla de datos
        DefaultTableModel modelTabla
                = (DefaultTableModel) jTDatos.getModel();
        try {
            //3. leer los dtos
            resultados = modelos.busca_objetos_model();
            limpiar_tabla();
            //asignar dtos a la tabla
            for (String[] resultado : resultados) {
                //añadir datos al modelo de la tabla
                modelTabla.addRow(new Object[]{
                    resultado[0],
                    resultado[1],
                    resultado[2],
                    resultado[3]});
            }

        } catch (SQLException e) {
        }
    }

    private void inserta_dato() {
        if (campos_vacios()) {
            CUtilitarios.msg_adver("hay datos vacios", "INSERTA DATO");
        } else {
            //1. OBTENER LOS DATOS DE LOS CUADROS DE TEXTO
            String nombre = jTFNombre.getText();
            String apellidop = jTFApellidoP.getText();
            String apellidom = jTFApellidoM.getText();
            //2. insertar datos
            try {
                if (modelos.inserta_objeto_model(nombre, apellidop, apellidom)) {
                    // CUtilitarios.msg("Insercion correcta", "inserta datos");

                } else {
                    CUtilitarios.msg_adver("Insercion no procesada", "inserta dato");
                }
                limpiar_campos();
                lee_datos();
            } catch (Exception e) {
            }

        }
    }

    private void elimina_dato() {
        int idEliminar;
        //obtener el modelo de la tabla
        DefaultTableModel modelTabla
                = (DefaultTableModel) jTDatos.getModel();
        //si la cantidaxd de filas es direfente de 0
        if (modelTabla.getRowCount() != 0) {//TABLA CON FILAS
            if (jTDatos.getSelectedRow() != -1) {
                idEliminar = Integer.parseInt((String) modelTabla.getValueAt(jTDatos.getSelectedRow(), 0));
                System.out.println(" " + idEliminar);//prueba
                try {
                    if (modelos.elimina_objeto_model(idEliminar)) {
                        CUtilitarios.msg("Eliminacion correcta", "Elimina datos");
                    }
                    lee_datos();
                } catch (Exception e) {
                }
            } else {
            }
        } else {//SI LA TABLA NO TIENE FILAS
            CUtilitarios.msg_adver("TABLA VACIA", "ELIMINA DATO");
        }
        limpiar_campos();
    }

    private int lee_fila_seleccionada() {
        int id=-1;
        DefaultTableModel modelTabla
                = (DefaultTableModel) jTDatos.getModel();
        if (modelTabla.getRowCount() != 0) {//TABLA CON FILAS
            if (jTDatos.getSelectedRow() != -1) {
                id = Integer.parseInt((String) modelTabla.getValueAt(jTDatos.getSelectedRow(), 0));
                // System.out.println(" " + idEliminar);//prueba
                jTFNombre.setText((String) modelTabla.getValueAt(jTDatos.getSelectedRow(), 1));
                jTFApellidoP.setText((String) modelTabla.getValueAt(jTDatos.getSelectedRow(), 2));
                jTFApellidoM.setText((String) modelTabla.getValueAt(jTDatos.getSelectedRow(), 3));
                /* try {
                    if (modelos.elimina_objeto_model(idEliminar)) {
                        CUtilitarios.msg("Eliminacion correcta", "Elimina datos");
                    }
                    lee_datos();
                } catch (Exception e) {
                }*/
            } else {
            }
        } else {//SI LA TABLA NO TIENE FILAS
            CUtilitarios.msg_adver("TABLA VACIA", "ELIMINA DATO");
        }
        return id;
    }

    private void actualiza_dato() {
        int id;
         DefaultTableModel modelTabla
                = (DefaultTableModel) jTDatos.getModel();
        if (campos_vacios()) {
            CUtilitarios.msg_adver("Datos vacios", "Actualiza datos");
        } else {
            try {
                 id = Integer.parseInt((String) modelTabla.getValueAt(jTDatos.getSelectedRow(), 0));
                String marca=jTFNombre.getText();
                String modelo=jTFApellidoP.getText();
                String color=jTFApellidoM.getText();
                modelos.actualiza_objeto_model(id, marca, modelo, color);
                lee_datos();
            } catch (Exception e) {
            }
        }
        limpiar_campos();
    }
    
    public JFConductor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jTFApellidoP = new javax.swing.JTextField();
        jTFApellidoM = new javax.swing.JTextField();
        jBEliminar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jBAgregar = new javax.swing.JButton();
        jBConsultar = new javax.swing.JButton();
        jBLimpiarTabla = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDatos = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("CONDUCTORES");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido Paterno");

        jLabel4.setText("Apellido Materno");

        jTFApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFApellidoMActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBConsultar.setText("Consultar");
        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarActionPerformed(evt);
            }
        });

        jBLimpiarTabla.setText("Limpiar Tabla");
        jBLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarTablaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Conductor"));

        jTDatos.setBackground(new java.awt.Color(204, 204, 255));
        jTDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ));
        jTDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTDatos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
        );

        jBSalir.setText("Salir");
        jBSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBSalirMouseClicked(evt);
            }
        });
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jBActualizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTFApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTFApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jBAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBConsultar)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBLimpiarTabla, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBSalir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTFApellidoM, jTFApellidoP, jTFNombre});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBActualizar, jBAgregar, jBConsultar, jBEliminar, jBLimpiarTabla});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminar)
                    .addComponent(jBActualizar)
                    .addComponent(jBAgregar)
                    .addComponent(jBConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBLimpiarTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSalir)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFApellidoMActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        // TODO add your handling code here:
        actualiza_dato();
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirMouseClicked
        // TODO add your handling code here:
        JFVistaPrincipal cliente = new JFVistaPrincipal();
        cliente.setVisible(true);
        cliente.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jBSalirMouseClicked

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
        // TODO add your handling code here:
        lee_datos();
    }//GEN-LAST:event_jBConsultarActionPerformed

    private void jBLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarTablaActionPerformed
        // TODO add your handling code here:
        limpiar_tabla();
    }//GEN-LAST:event_jBLimpiarTablaActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        elimina_dato();
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // TODO add your handling code here:
        inserta_dato();
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jTDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDatosMouseClicked
        // TODO add your handling code here:
        lee_fila_seleccionada();
    }//GEN-LAST:event_jTDatosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFConductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFConductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBLimpiarTabla;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDatos;
    private javax.swing.JTextField jTFApellidoM;
    private javax.swing.JTextField jTFApellidoP;
    private javax.swing.JTextField jTFNombre;
    // End of variables declaration//GEN-END:variables
}
