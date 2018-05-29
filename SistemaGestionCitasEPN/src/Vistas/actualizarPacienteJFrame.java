/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Conexion;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ToshibaSk
 */
public class actualizarPacienteJFrame extends javax.swing.JFrame {

    /**
     * Creates new form actualizarPacienteJFrame
     */
    public actualizarPacienteJFrame() {
        initComponents();
        setDefaultCloseOperation(actualizarPacienteJFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);// centrado
        setResizable(false); // impide maximizar
        setModeloTabla();
        
    }
    Conexion miConexion = new Conexion();
    //**************** IMPLEMENTACION **********************//
    public void setModeloTabla(){
        DefaultTableModel miModeloTabla = new DefaultTableModel();
        miModeloTabla.addColumn("CÉDULA");
        miModeloTabla.addColumn("P.NOMBRE");
        miModeloTabla.addColumn("S.NOMBRE");
        miModeloTabla.addColumn("P.APELLIDO");
        miModeloTabla.addColumn("S.APELLIDO");
        miModeloTabla.addColumn("P.TELEFONO");
        miModeloTabla.addColumn("S.TELEFONO");
        miModeloTabla.addColumn("EMAIL");
        miModeloTabla.addColumn("DIRECCION");
        miModeloTabla.addColumn("F.NACIMIENTO");
        jTablePaciente.setModel(miModeloTabla);
    }
    
    public void buscarPaciente(){
        
        DefaultTableModel miModeloTabla = new DefaultTableModel();
        miModeloTabla.addColumn("CÉDULA");
        miModeloTabla.addColumn("P.NOMBRE");
        miModeloTabla.addColumn("S.NOMBRE");
        miModeloTabla.addColumn("P.APELLIDO");
        miModeloTabla.addColumn("S.APELLIDO");
        miModeloTabla.addColumn("P.TELEFONO");
        miModeloTabla.addColumn("S.TELEFONO");
        miModeloTabla.addColumn("EMAIL");
        miModeloTabla.addColumn("DIRECCION");
        miModeloTabla.addColumn("F.NACIMIENTO");
        
        String cedulaPaciente;
        String sql = null;
        cedulaPaciente = txtBuscarCedulaPaciente.getText();
        
        if(String.valueOf(cedulaPaciente).compareTo("")==0){
            JOptionPane.showMessageDialog(null, "Ingrese parámetro de búsqueda");
        }else{
            sql = "SELECT CEDULA,PRIMERNOMBRE,SEGUNDONOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,PRIMERTELEFONO,SEGUNDOTELEFONO,EMAIL,DIRECCION,FECHANACIMIENTO,PACIENTEID FROM PACIENTE WHERE CEDULA = '"+cedulaPaciente+"'"; 
        }
        
        String datos [] = new String[12];
        try {
            Statement st= miConexion.Conectar().createStatement();
            ResultSet rs2=st.executeQuery(sql);
            while(rs2.next()){
                datos[0]=rs2.getString(1);
                datos[1]=rs2.getString(2);
                datos[2]=rs2.getString(3);
                datos[3]=rs2.getString(4);
                datos[4]=rs2.getString(5);
                datos[5]=rs2.getString(6);
                datos[6]=rs2.getString(7);
                datos[7]=rs2.getString(8);
                datos[8]=rs2.getString(9);
                datos[9]=rs2.getString(10);
                datos[10]=rs2.getString(11);
              
                miModeloTabla.addRow(datos);
            }
            
            if (!cedulaPaciente.equals(datos[0])) {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias con la Búsqueda");    
           }else{
            jTablePaciente.setModel(miModeloTabla);
            txtIdPaciente.setText(datos[10]);
            txtBuscarCedulaPaciente.setText("");
            
            }
        } catch (SQLException ex) {
            System.out.println("Error al Insertar Datos"); 
        }
    }
    
    public void mostrarDatosPaciente(){
        DefaultTableModel miModeloTabla = new DefaultTableModel();
        miModeloTabla.addColumn("CÉDULA");
        miModeloTabla.addColumn("P.NOMBRE");
        miModeloTabla.addColumn("S.NOMBRE");
        miModeloTabla.addColumn("P.APELLIDO");
        miModeloTabla.addColumn("S.APELLIDO");
        miModeloTabla.addColumn("P.TELEFONO");
        miModeloTabla.addColumn("S.TELEFONO");
        miModeloTabla.addColumn("EMAIL");
        miModeloTabla.addColumn("DIRECCION");
        miModeloTabla.addColumn("F.NACIMIENTO");;
        String sql = null;
       
        sql = "SELECT CEDULA,PRIMERNOMBRE,SEGUNDONOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,PRIMERTELEFONO,SEGUNDOTELEFONO,EMAIL,DIRECCION,FECHANACIMIENTO,PACIENTEID FROM PACIENTE"; 
        
        String datos [] = new String[12];
        try {
            Statement st= miConexion.Conectar().createStatement();
            ResultSet rs2=st.executeQuery(sql);
            while(rs2.next()){
                datos[0]=rs2.getString(1);
                datos[1]=rs2.getString(2);
                datos[2]=rs2.getString(3);
                datos[3]=rs2.getString(4);
                datos[4]=rs2.getString(5);
                datos[5]=rs2.getString(6);
                datos[6]=rs2.getString(7);
                datos[7]=rs2.getString(8);
                datos[8]=rs2.getString(9);
                datos[9]=rs2.getString(10);
                datos[10]=rs2.getString(11);
        
                miModeloTabla.addRow(datos);
            }
           
        } catch (SQLException ex) {
            System.out.println("Error al mostrar Datos"); 
        }
    }
    
    public void limpiarCampos(){
        txtCedulaPaciente.setText("");
        txtPNombrePaciente.setText("");
        txtSNombrePaciente.setText("");
        txtPApellidoPaciente.setText("");
        txtSApellidoPaciente.setText("");
        txtPTelefonoPaciente.setText("");
        txtSTelefonoPaciente.setText("");
        txtDireccionPaciente.setText("");
        txtEmailPaciente.setText("");
    }
    
    public void actualizarDatosPaciente(){
        String sql;
        sql = "UPDATE PACIENTE SET "
                + "CEDULA='"+txtCedulaPaciente.getText()
                +"',PRIMERNOMBRE='"+txtPNombrePaciente.getText()
                +"',SEGUNDONOMBRE='"+txtSNombrePaciente.getText()
                +"',PRIMERAPELLIDO='"+txtPApellidoPaciente.getText()
                +"',SEGUNDOAPELLIDO='"+txtSApellidoPaciente.getText()
                +"',PRIMERTELEFONO='"+txtPApellidoPaciente.getText()
                +"',SEGUNDOTELEFONO='"+txtSApellidoPaciente.getText()
                +"',EMAIL='"+txtEmailPaciente.getText()
                +"',DIRECCION='"+txtEmailPaciente.getText()
                +"' WHERE PACIENTEID ='"+txtIdPaciente.getText()+"'";
        try {
            PreparedStatement pps = miConexion.Conectar().prepareStatement(sql);
            int n= pps.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos Actualizados Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error Datos No Actualizados");
            }
            mostrarDatosPaciente();
            limpiarCampos();
        } catch (SQLException | HeadlessException ex) {
            System.out.println("Error al actualizar datos");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPTelefonoPaciente = new javax.swing.JTextField();
        txtSApellidoPaciente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtSTelefonoPaciente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPNombrePaciente = new javax.swing.JTextField();
        txtEmailPaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPApellidoPaciente = new javax.swing.JTextField();
        txtDireccionPaciente = new javax.swing.JTextField();
        txtSNombrePaciente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedulaPaciente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtBuscarCedulaPaciente = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();
        btnLimpiarPaciente = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        txtIdPaciente = new javax.swing.JTextField();
        txtFechaNacimientoPaciente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSApellidoPaciente.setToolTipText("");

        jLabel10.setText("Fecha Nacimiento");

        jLabel5.setText("Telefono 1");

        btnActualizar.setText("Actualizar");

        jLabel6.setText("Telefono 2");

        btnCancelar.setText("Cancelar");

        jLabel1.setText("Primer Nombre");

        jLabel7.setText("Email");

        jLabel2.setText("Segundo Nombre");

        jLabel8.setText("Direccion");

        jLabel9.setText("Cedula");

        jLabel3.setText("Primer Apellido");

        jLabel4.setText("Segundo Apellido");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingresa los datos para buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Número de Cédula:");

        txtBuscarCedulaPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        btnLimpiarPaciente.setText("Limpiar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(btnBuscarPaciente)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiarPaciente)
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtBuscarCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPaciente)
                    .addComponent(btnLimpiarPaciente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados de búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePaciente);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtIdPaciente.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnActualizar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSApellidoPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPApellidoPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSNombrePaciente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPNombrePaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmailPaciente)
                                    .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSTelefonoPaciente)
                                    .addComponent(txtPTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCancelar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFechaNacimientoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtSTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmailPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtFechaNacimientoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnActualizar))
                .addGap(57, 57, 57)
                .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        int fila = jTablePaciente.getSelectedRow();
        if(fila>=0){
            txtCedulaPaciente.setText(jTablePaciente.getValueAt(fila, 0).toString());
            txtPNombrePaciente.setText(jTablePaciente.getValueAt(fila, 1).toString());
            txtSNombrePaciente.setText(jTablePaciente.getValueAt(fila, 2).toString());
            txtPApellidoPaciente.setText(jTablePaciente.getValueAt(fila, 3).toString());
            txtSApellidoPaciente.setText(jTablePaciente.getValueAt(fila, 4).toString());
            txtPTelefonoPaciente.setText(jTablePaciente.getValueAt(fila, 5).toString());
            txtSTelefonoPaciente.setText(jTablePaciente.getValueAt(fila, 6).toString());

        }else{
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        buscarPaciente();
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

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
            java.util.logging.Logger.getLogger(actualizarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(actualizarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(actualizarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(actualizarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new actualizarPacienteJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiarPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField txtBuscarCedulaPaciente;
    private javax.swing.JTextField txtCedulaPaciente;
    private javax.swing.JTextField txtDireccionPaciente;
    private javax.swing.JTextField txtEmailPaciente;
    private javax.swing.JTextField txtFechaNacimientoPaciente;
    private javax.swing.JTextField txtIdPaciente;
    private javax.swing.JTextField txtPApellidoPaciente;
    private javax.swing.JTextField txtPNombrePaciente;
    private javax.swing.JTextField txtPTelefonoPaciente;
    private javax.swing.JTextField txtSApellidoPaciente;
    private javax.swing.JTextField txtSNombrePaciente;
    private javax.swing.JTextField txtSTelefonoPaciente;
    // End of variables declaration//GEN-END:variables

}
