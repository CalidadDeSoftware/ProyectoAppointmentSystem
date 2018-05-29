/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class buscarPacienteJFrame extends javax.swing.JFrame {

    /**
     * Creates new form buscarPacienteJFrame
     */
    public buscarPacienteJFrame() {
        initComponents();
        setDefaultCloseOperation(buscarPacienteJFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);// centrado
        setResizable(false); // impide maximizar
        setTitle("Buscar Paciente");
        setModeloTabla();
        
        txtBuscarCedulaPaciente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarPaciente();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buscarPaciente();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               buscarPaciente();
            }
        });
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
        jTablePacienteBuscar.setModel(miModeloTabla);
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
        String sql2 = null;
        cedulaPaciente = txtBuscarCedulaPaciente.getText().trim();
        if(String.valueOf(cedulaPaciente).compareTo("")==0){
            JOptionPane.showMessageDialog(null, "Ingrese parámetro de búsqueda");
        }else{
               sql2 = "SELECT CEDULA,PRIMERNOMBRE,SEGUNDONOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,PRIMERTELEFONO,SEGUNDOTELEFONO,EMAIL,DIRECCION,FECHANACIMIENTO FROM PACIENTE WHERE CEDULA LIKE '"+cedulaPaciente+"%'"; 
        }
        String datos [] = new String[12];
        try {
            Statement st= miConexion.Conectar().createStatement();
            ResultSet rs3=st.executeQuery(sql2);
            //System.out.println(rs2);
            while(rs3.next()){
                datos[0]=rs3.getString(1);
                datos[1]=rs3.getString(2);
                datos[2]=rs3.getString(3);
                datos[3]=rs3.getString(4);
                datos[4]=rs3.getString(5);
                datos[5]=rs3.getString(6);
                datos[6]=rs3.getString(7);
                datos[7]=rs3.getString(8);
                datos[8]=rs3.getString(9);
                datos[9]=rs3.getString(10);
                //datos[10]=rs3.getString(11);//FECHA NACIMIENTO
                //datos[11]=rs3.getString(12);//IDPACIENTE
                miModeloTabla.addRow(datos);
            }
            jTablePacienteBuscar.setModel(miModeloTabla);
        
            /*if (!cedulaPaciente.equals(datos[0])) {
                
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias con la búsqueda ");
                
            }else{
                
            jTablePacienteBuscar.setModel(miModeloTabla);
            txtBuscarCedulaPaciente.setText("");
            }*/
        } catch (SQLException ex) {
            System.out.println("Error al Consultar Datos"); 
        }
    }
//public void     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtBuscarCedulaPaciente = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacienteBuscar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario Buscar Empleado ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese los datos para buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Número de Cédula:");

        txtBuscarCedulaPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscarCedulaPaciente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtBuscarCedulaPacientePropertyChange(evt);
            }
        });

        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnBuscarPaciente)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
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
                    .addComponent(btnLimpiar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados de búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTablePacienteBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePacienteBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteBuscarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePacienteBuscar);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Buscar Paciente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.getAccessibleContext().setAccessibleName("Formulario Buscar Paciente");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePacienteBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteBuscarMouseClicked

    }//GEN-LAST:event_jTablePacienteBuscarMouseClicked

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        buscarPaciente();
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void txtBuscarCedulaPacientePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtBuscarCedulaPacientePropertyChange
        // TODO add your handling code here:
        //buscarPaciente();
    }//GEN-LAST:event_txtBuscarCedulaPacientePropertyChange

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
            java.util.logging.Logger.getLogger(buscarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscarPacienteJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePacienteBuscar;
    private javax.swing.JTextField txtBuscarCedulaPaciente;
    // End of variables declaration//GEN-END:variables
}
