
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    
    public String Errores="";
    
    public boolean validarCampos(){
        boolean verificarFinal = false;
        Pattern strings = Pattern.compile("[a-zA-Z\\s']+");
        Pattern numbers = Pattern.compile("[0-9]+");
        Pattern correo = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
        
        Matcher cedula = numbers.matcher(txtCedulaPaciente.getText().trim());
        Matcher nombre1 = strings.matcher(txtPNombrePaciente.getText().trim());
        Matcher nombre2 = strings.matcher(txtSNombrePaciente.getText().trim());
        Matcher apellido1 = strings.matcher(txtPApellidoPaciente.getText().trim());
        Matcher apellido2 = strings.matcher(txtSApellidoPaciente.getText().trim());
        Matcher telefono1 = numbers.matcher(txtPTelefonoPaciente.getText().trim());
        Matcher telefono2 = numbers.matcher(txtSTelefonoPaciente.getText().trim());
        Matcher mail = correo.matcher(txtEmailPaciente.getText().trim());
                
        boolean isCedulaValid = cedula.matches();
        boolean isPNombreValid = nombre1.matches();
        boolean isSNombreValid = nombre2.matches();
        boolean isPApellidoValid = apellido1.matches();
        boolean isSApellidoValid = apellido2.matches();
        boolean isPTelefonoValid = telefono1.matches();
        boolean isSTelefonoValid = telefono2.matches();
        boolean isMailValid = mail.matches();
       
        
        if(!isCedulaValid){Errores = Errores + "Cedula: Se permiten caracteres numéricos\n";}
        if(!isPNombreValid){Errores = Errores + "Primer Nombre: Se permiten caracteres alfabeticos\n";}
        if(!(String.valueOf(txtSNombrePaciente.getText().trim()).compareTo("")==0)){
            if(!isSNombreValid){Errores = Errores + "Segundo Nombre: Se permiten caracteres alfabeticos\n";}
        }
        if(!(String.valueOf(txtSApellidoPaciente.getText().trim()).compareTo("")==0)){
            if(!isSApellidoValid){Errores = Errores + "Segundo Apellido: Se permiten caracteres alfabeticos\n";}
        }
        if(!isPApellidoValid){Errores = Errores + "Primer Apellido: Se permiten caracteres alfabeticos\n";}
        if(!isPTelefonoValid){Errores = Errores + "Primer Teléfono: Se permiten caracteres numéricos\n";}
        if(!(String.valueOf(txtSTelefonoPaciente.getText().trim()).compareTo("")==0)){
            if(!isSTelefonoValid){Errores = Errores + "Segundo Teléfono: Se permiten caracteres numéricos\n";}
        }
        if(!isMailValid){Errores = Errores + "Correo: Ejemplo nombre@organizacion.com\n";}   
        if(String.valueOf(txtCedulaPaciente.getText().trim()).compareTo("")==0 || 
           String.valueOf(txtPNombrePaciente.getText().trim()).compareTo("")==0 ||
           String.valueOf(txtPApellidoPaciente.getText().trim()).compareTo("")==0 ||
           String.valueOf(txtPTelefonoPaciente.getText().trim()).compareTo("")==0 ||
           String.valueOf(txtDireccionPaciente.getText().trim()).compareTo("")==0 ||
           String.valueOf(txtEmailPaciente.getText().trim()).compareTo("")==0){
            Errores = Errores + "Campos Obligatorios Vacios";
        }
        
        if(Errores==""){
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
            verificarFinal=true;
            Errores="";
        }
        else{
            JOptionPane.showMessageDialog(null, Errores);
            Errores = "";
        }
        return verificarFinal;
    }
    
    public boolean datosCorrectos;
    public void guardarDatosPaciente(){
        datosCorrectos=validarCampos();
        if(datosCorrectos){
            //Validar Existencia de Cedula
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
            limpiarCampos();
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
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDireccionPaciente = new javax.swing.JTextField();
        txtFechaNacimientoPaciente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPTelefonoPaciente = new javax.swing.JTextField();
        txtSTelefonoPaciente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmailPaciente = new javax.swing.JTextField();
        txtRecuperarCedulaPaciente = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario Paciente Nuevo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("* Cedula");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("* Primer Nombre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Segundo Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("* Primer Apellido");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Segundo Apellido");

        txtSApellidoPaciente.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("* Fecha Nacimiento");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("* Direccion");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("* Telefono 1");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Telefono 2");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("* Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(304, 304, 304)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSApellidoPaciente)
                                    .addComponent(txtPTelefonoPaciente)
                                    .addComponent(txtSTelefonoPaciente)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPNombrePaciente)
                                .addComponent(txtPApellidoPaciente)
                                .addComponent(txtFechaNacimientoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addComponent(jLabel9))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtFechaNacimientoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDireccionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmailPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Registrar Paciente");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("* Campos Obligatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(btnAceptar)
                        .addGap(41, 41, 41)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRecuperarCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
                    .addComponent(txtRecuperarCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(40, 40, 40))
        );

        jLabel12.getAccessibleContext().setAccessibleName("jLabelInfo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        guardarDatosPaciente();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
