
package Vistas;

import Controlador.Conexion;
import Modelo.Paciente;
import Modelo.ValidarCedula;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class registrarPacienteJFrame extends javax.swing.JFrame {

    /**
     * Creates new form nuevoPacienteJFrame
     */
    public registrarPacienteJFrame() {
        initComponents();
        setLocationRelativeTo(null);// centrado
        setResizable(false); // impide maximizar
        setDefaultCloseOperation(registrarPacienteJFrame.DISPOSE_ON_CLOSE);
        txtRecuperarCedulaPaciente.setVisible(false);
    }
    
    //// IMPLEMENTACION DE METODOS PARA MANEJAR EL FORMULARO ////
    Paciente nuevoPaciente = new Paciente();
    Conexion miConexion = new Conexion();
    ValidarCedula validarCedula = new ValidarCedula();
    
    public void guardarDatosPaciente(){
        
        nuevoPaciente.setCedulaPaciente(txtCedulaPaciente.getText().trim());
        nuevoPaciente.setpNombrePaciente(txtPNombrePaciente.getText().trim());
        nuevoPaciente.setsNombrePaciente(txtSNombrePaciente.getText().trim());
        nuevoPaciente.setpApellidoPaciente(txtPApellidoPaciente.getText().trim());
        nuevoPaciente.setsApellidoPaciente(txtSApellidoPaciente.getText().trim());
        nuevoPaciente.setpTelefonoPaciente(txtPTelefonoPaciente.getText().trim());
        nuevoPaciente.setsTelefonoPaciente(txtSTelefonoPaciente.getText().trim());
        nuevoPaciente.setDireccionPaciente(txtDireccionPaciente.getText().trim());
        nuevoPaciente.setEmaiPaciente(txtEmailPaciente.getText().trim());
        nuevoPaciente.setFechaNacimientoPaciente(txtFechaNacimientoPaciente.getText());
           
        if(String.valueOf(nuevoPaciente.getCedulaPaciente()).compareTo("")==0 || 
           String.valueOf(nuevoPaciente.getpNombrePaciente()).compareTo("")==0 ||
           String.valueOf(nuevoPaciente.getpApellidoPaciente()).compareTo("")==0 ||
           String.valueOf(nuevoPaciente.getpTelefonoPaciente()).compareTo("")==0 ||
           String.valueOf(nuevoPaciente.getDireccionPaciente()).compareTo("")==0 ||
           String.valueOf(nuevoPaciente.getEmaiPaciente()).compareTo("")==0){
           JOptionPane.showMessageDialog(null, "Error - Uno o mas campos vacios");
        }
        else
        {
            /*Validar Existencia de Cedula*/
            String consultaCI = "SELECT CEDULA FROM PACIENTE WHERE CEDULA='"+txtRecuperarCedulaPaciente.getText()+"'";
            String valorConsulaCI=null;
            try {
            Statement st= miConexion.Conectar().createStatement();
            ResultSet rs2=st.executeQuery(consultaCI);
            while(rs2.next()){
                valorConsulaCI=rs2.getString(1);
            }
            txtRecuperarCedulaPaciente.setText(valorConsulaCI);
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            if (txtRecuperarCedulaPaciente.getText().equals(txtCedulaPaciente.getText())) {
                JOptionPane.showMessageDialog(null, "Cédula ya se encuentra Registrada");  
            }else{
                if (validarCedula.validadorDeCedula(txtCedulaPaciente.getText())== false) {
                }else{
            String sql="INSERT INTO PACIENTE (CEDULA,PRIMERNOMBRE,SEGUNDONOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,PRIMERTELEFONO,SEGUNDOTELEFONO,EMAIL,DIRECCION,FECHANACIMIENTO)VALUES(?,?,?,?,?,?,?,?,?,?)";
               try {
            PreparedStatement pst = miConexion.Conectar().prepareStatement(sql);
            pst.setString(1,nuevoPaciente.getCedulaPaciente());
            pst.setString(2,nuevoPaciente.getpNombrePaciente());
            pst.setString(3,nuevoPaciente.getsNombrePaciente());
            pst.setString(4,nuevoPaciente.getpApellidoPaciente());
            pst.setString(5,nuevoPaciente.getsApellidoPaciente());
            pst.setString(6,nuevoPaciente.getpTelefonoPaciente());
            pst.setString(7,nuevoPaciente.getsTelefonoPaciente());
            pst.setString(8,nuevoPaciente.getEmaiPaciente());
            pst.setString(9,nuevoPaciente.getDireccionPaciente());
            pst.setString(10,nuevoPaciente.getFechaNacimientoPaciente());
            int n= pst.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos Registrados Exitosamente");
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(null, "Error Datos No Registrados");
            }
               }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Datos No Registrados");
            Logger.getLogger(registrarPacienteJFrame.class.getName()).log(Level.SEVERE, null, ex);
               }
                }
            }
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
        txtFechaNacimientoPaciente.setText("");
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
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSApellidoPaciente = new javax.swing.JTextField();
        txtPNombrePaciente = new javax.swing.JTextField();
        txtPApellidoPaciente = new javax.swing.JTextField();
        txtSNombrePaciente = new javax.swing.JTextField();
        txtCedulaPaciente = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSTelefonoPaciente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmailPaciente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDireccionPaciente = new javax.swing.JTextField();
        txtPTelefonoPaciente = new javax.swing.JTextField();
        txtFechaNacimientoPaciente = new javax.swing.JTextField();
        txtRecuperarCedulaPaciente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setText("Cedula");

        jLabel1.setText("Primer Nombre");

        jLabel2.setText("Segundo Nombre");

        jLabel3.setText("Primer Apellido");

        jLabel4.setText("Segundo Apellido");

        txtSApellidoPaciente.setToolTipText("");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha Nacimiento");

        jLabel5.setText("Telefono 1");

        jLabel6.setText("Telefono 2");

        jLabel7.setText("Email");

        jLabel8.setText("Direccion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSApellidoPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPApellidoPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSNombrePaciente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPNombrePaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAceptar))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaNacimientoPaciente)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEmailPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(txtSTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(txtFechaNacimientoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtRecuperarCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addComponent(txtRecuperarCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        guardarDatosPaciente();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(registrarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrarPacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarPacienteJFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCedulaPaciente;
    private javax.swing.JTextField txtDireccionPaciente;
    private javax.swing.JTextField txtEmailPaciente;
    private javax.swing.JTextField txtFechaNacimientoPaciente;
    private javax.swing.JTextField txtPApellidoPaciente;
    private javax.swing.JTextField txtPNombrePaciente;
    private javax.swing.JTextField txtPTelefonoPaciente;
    private javax.swing.JTextField txtRecuperarCedulaPaciente;
    private javax.swing.JTextField txtSApellidoPaciente;
    private javax.swing.JTextField txtSNombrePaciente;
    private javax.swing.JTextField txtSTelefonoPaciente;
    // End of variables declaration//GEN-END:variables
}
