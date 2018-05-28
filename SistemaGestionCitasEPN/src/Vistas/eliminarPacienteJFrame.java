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
public class eliminarPacienteJFrame extends javax.swing.JFrame {

    /**
     * Creates new form eliminarPacienteJFrame
     */
    public eliminarPacienteJFrame() {
        initComponents();
        setDefaultCloseOperation(actualizarPacienteJFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);// centrado
        setResizable(false); // impide maximizar
        setTitle("Eliminar Paciente");
        setModeloTabla();
        txtIdPaciente.setVisible(false);
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
        
        if(String.valueOf(txtBuscarCedulaPaciente.getText()).compareTo("")==0){
            JOptionPane.showMessageDialog(null, "Ingrese parámetro de búsqueda");
        }else{
            sql = "SELECT CEDULA,PRIMERNOMBRE,SEGUNDONOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,PRIMERTELEFONO,SEGUNDOTELEFONO,EMAIL,DIRECCION,FECHANACIMIENTO,PACIENTEID FROM PACIENTE WHERE CEDULA = '"+cedulaPaciente+"'"; 
        }
        String datos [] = new String[10];
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
                datos[11]=rs2.getString(12);//IP PACIENTE
                miModeloTabla.addRow(datos);
            }
             if (!cedulaPaciente.equals(datos[0])) {
                
                JOptionPane.showMessageDialog(null, "No se econtraron coincidencias con la Búsqueda");
                
            }else{
            jTablePaciente.setModel(miModeloTabla);
            txtIdPaciente.setText(datos[11]);
            txtBuscarCedulaPaciente.setText("");
            jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(6).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(7).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(8).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(9).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(10).setPreferredWidth(15);
             }  
        } catch (SQLException ex) {
            System.out.println("Error al insertar Datos"); 
        }
    }
   
   public void mostrarTabla(){
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
                datos[11]=rs2.getString(12);//IP PACIENTE
                miModeloTabla.addRow(datos);
            }
            jTablePaciente.setModel(miModeloTabla);
            jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(6).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(7).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(8).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(9).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(10).setPreferredWidth(15);
            jTablePaciente.getColumnModel().getColumn(11).setPreferredWidth(15);     
        } catch (SQLException ex) {
            System.out.println("Error al mostrar datos"); 
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

        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtBuscarCedulaPaciente = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();
        btnLimpiarPaciente = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        txtIdPaciente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario Elimina Paciente"));
        jPanel4.setToolTipText("");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingresa los datos para buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Número de Cédula:");

        txtBuscarCedulaPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        btnLimpiarPaciente.setText("Limpiar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnBuscarPaciente)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiarPaciente)
                .addGap(26, 26, 26))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtBuscarCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPaciente)
                    .addComponent(btnLimpiarPaciente))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados de búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 916, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Formulario Elimina Paciente");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        buscarPaciente();
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        String idEmpleado,sql;
        idEmpleado = txtIdPaciente.getText();

        if (JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar Empleado?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // yes option

            sql="DELETE FROM EMPLEADO WHERE EMPLEADOID='"+txtIdPaciente.getText()+"'";
            try {
                PreparedStatement pps = miConexion.Conectar().prepareStatement(sql);
                int n= pps.executeUpdate();
                if(n>0){
                    JOptionPane.showMessageDialog(null, "Datos Eliminados");
                    txtIdPaciente.setText("");
                    txtBuscarCedulaPaciente.setText("");
                    mostrarTabla();
                }else{
                    JOptionPane.showMessageDialog(null, "Error Datos No Eliminados");
                }

            } catch (SQLException | HeadlessException ex){
                System.out.println(ex.getMessage());
            }

        } else {

            JOptionPane.showMessageDialog(null, "Operación Cancelada");

        }

    }//GEN-LAST:event_jTablePacienteMouseClicked

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
            java.util.logging.Logger.getLogger(eliminarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eliminarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eliminarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eliminarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminarPacienteJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnLimpiarPaciente;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField txtBuscarCedulaPaciente;
    private javax.swing.JTextField txtIdPaciente;
    // End of variables declaration//GEN-END:variables
}
