/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import Modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Controlador.Conexion;
import Modelo.ValidarCedula;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daro
 */
public class RegistrarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarEmpleado
     */
    public RegistrarEmpleado() {
        
        initComponents();
        setLocationRelativeTo(null);// centrado
        setResizable(false); // impide maximizar
        setTitle("Registrar Empleado");
    }
    
    //// IMPLEMENTACION DE METODOS PARA MANEJAR EL FORMULARO ////
    Empleado nuevoEmpleado = new Empleado();
    Conexion miConexion = new Conexion();
    ValidarCedula valirdCi = new ValidarCedula();
            
    public void guardarDatosEmpleado(){
        
        nuevoEmpleado.setCedulaEmpleado(txtCedulaEmpleado.getText());
        nuevoEmpleado.setPrimerNombreEmpleado(txtPrimerNombreEmpleado.getText());
        nuevoEmpleado.setSegundoNombreEmpleado(txtSegundoNombreEmpleado.getText());
        nuevoEmpleado.setPrimerApellidoEmpleado(txtPrimerApellidoEmpleado.getText());
        nuevoEmpleado.setSegundoApellidoEmpleado(txtSegundoApellidoEmpleado.getText());
        nuevoEmpleado.setFechaNacimientoEmpleado(txtFechaNacimientoEmpleado.getText());
        nuevoEmpleado.setCorreoElectronicoEmpleado(txtEmailEmpleado.getText());
        nuevoEmpleado.setDepartamentoEmpleado(jComboBoxDepartamentoEmpleado.getSelectedItem().toString());
        nuevoEmpleado.setEspecialidadEmpleado(jComboBoxEspecialidadEmpleado.getSelectedItem().toString());
        
        
        if(String.valueOf(nuevoEmpleado.getCedulaEmpleado()).compareTo("")==0 || 
           String.valueOf(nuevoEmpleado.getPrimerNombreEmpleado()).compareTo("")==0 ||
           String.valueOf(nuevoEmpleado.getSegundoNombreEmpleado()).compareTo("")==0 ||
           String.valueOf(nuevoEmpleado.getPrimerApellidoEmpleado()).compareTo("")==0 ||
           String.valueOf(nuevoEmpleado.getSegundoApellidoEmpleado()).compareTo("")==0 ||
           String.valueOf(nuevoEmpleado.getFechaNacimientoEmpleado()).compareTo("")==0 ||
           String.valueOf(nuevoEmpleado.getCorreoElectronicoEmpleado()).compareTo("")==0 ||
           String.valueOf(nuevoEmpleado.getDepartamentoEmpleado()).compareTo("")==0 ||
           String.valueOf(nuevoEmpleado.getEspecialidadEmpleado()).compareTo("")==0 ){
            JOptionPane.showMessageDialog(null, "Error - Uno o mas campos vacios");
            
        } else if (!valirdCi.validadorDeCedula(txtCedulaEmpleado.getText())) {
            
            System.err.println("Cedula no valida !!!");

            
        }else{
            
            String consultarCedulaDB = "SELECT CEDULA FROM EMPLEADO WHERE CEDULA='"+txtCedulaEmpleado.getText()+"'"; 
            String datos [] = new String[1];
            
            try {
            Statement st= miConexion.Conectar().createStatement();
            ResultSet rs2=st.executeQuery(consultarCedulaDB);
            while(rs2.next()){
                datos[0]=rs2.getString(1);
            }
      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
            
          if (datos[0].equals(txtCedulaEmpleado.getText())) {
              
                JOptionPane.showMessageDialog(null, datos[0] + " CI YA EXISTE ");
                
                
          }else{
          
              String sql="INSERT INTO EMPLEADO (CEDULA,PRIMERNOMBRE,SEGUNDONOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,FECHANACIMIENTO,EMAIL,DEPARTAMENTO,ESPECIALIDAD)VALUES(?,?,?,?,?,?,?,?,?)";
               try {
            PreparedStatement pst = miConexion.Conectar().prepareStatement(sql);
            pst.setString(1,nuevoEmpleado.getCedulaEmpleado());
            pst.setString(2,nuevoEmpleado.getPrimerNombreEmpleado());
            pst.setString(3,nuevoEmpleado.getSegundoNombreEmpleado());
            pst.setString(4,nuevoEmpleado.getPrimerApellidoEmpleado());
            pst.setString(5,nuevoEmpleado.getSegundoApellidoEmpleado());
            pst.setString(6,nuevoEmpleado.getFechaNacimientoEmpleado());
            pst.setString(7,nuevoEmpleado.getCorreoElectronicoEmpleado());
            pst.setString(8,nuevoEmpleado.getDepartamentoEmpleado());
            pst.setString(9,nuevoEmpleado.getEspecialidadEmpleado());
            int n= pst.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos Registrados Exitosamente");
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(null, "Error Datos No Registrados");
            }
               }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Datos No Registrados");
            Logger.getLogger(RegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
          
          
          
          
          }
            
           
           
           
           

        
           
           
           
           
           
            
            
            
            
            
             
    }
    
    public void limpiarCampos(){
        txtCedulaEmpleado.setText("");
        txtPrimerNombreEmpleado.setText("");
        txtSegundoNombreEmpleado.setText("");
        txtPrimerApellidoEmpleado.setText("");
        txtSegundoApellidoEmpleado.setText("");
        txtFechaNacimientoEmpleado.setText("");
        txtEmailEmpleado.setText("");
    }
    
    
    
    
    
    
    
    /////////////////////////////////////////////////////////////

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCedulaEmpleado = new javax.swing.JTextField();
        txtPrimerNombreEmpleado = new javax.swing.JTextField();
        txtPrimerApellidoEmpleado = new javax.swing.JTextField();
        txtFechaNacimientoEmpleado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSegundoNombreEmpleado = new javax.swing.JTextField();
        txtSegundoApellidoEmpleado = new javax.swing.JTextField();
        txtEmailEmpleado = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxDepartamentoEmpleado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxEspecialidadEmpleado = new javax.swing.JComboBox<>();
        btnGuardaEmpleado = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registrar Empleado");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario Empleado Nuevo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Número de Cédula:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Primer Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Primer Apellido:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Fecha Nacimiento:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Correo Electrónico:");

        txtCedulaEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCedulaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaEmpleadoActionPerformed(evt);
            }
        });
        txtCedulaEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaEmpleadoKeyTyped(evt);
            }
        });

        txtPrimerNombreEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrimerNombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrimerNombreEmpleadoKeyTyped(evt);
            }
        });

        txtPrimerApellidoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrimerApellidoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrimerApellidoEmpleadoKeyTyped(evt);
            }
        });

        txtFechaNacimientoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFechaNacimientoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaNacimientoEmpleadoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Segundo Nombre:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Segundo Apellido:");

        txtSegundoNombreEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSegundoNombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegundoNombreEmpleadoKeyTyped(evt);
            }
        });

        txtSegundoApellidoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSegundoApellidoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegundoApellidoEmpleadoKeyTyped(evt);
            }
        });

        txtEmailEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrimerNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(txtPrimerApellidoEmpleado)
                    .addComponent(txtFechaNacimientoEmpleado)
                    .addComponent(txtCedulaEmpleado))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSegundoNombreEmpleado)
                    .addComponent(txtSegundoApellidoEmpleado)
                    .addComponent(txtEmailEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCedulaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrimerNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtSegundoNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrimerApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtSegundoApellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFechaNacimientoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmailEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Laboral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Departamento:");

        jComboBoxDepartamentoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxDepartamentoEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione una opción --", "UNIDAD DE BIENESTAR ESTUDIANTIL Y SOCIAL" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Especialidad:");

        jComboBoxEspecialidadEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxEspecialidadEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione una opción --", "MEDICINA GENERAL", "GINECOLOGÍA", "ODONTOLOGÍA", "PSICOLOGÍA", "ENFERMERÍA", "NUTRICIÓN", "TRABAJO SOCIAL" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxDepartamentoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxEspecialidadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxDepartamentoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxEspecialidadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnGuardaEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardaEmpleado.setText("Guardar");
        btnGuardaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardaEmpleadoActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(btnGuardaEmpleado)
                        .addGap(84, 84, 84)
                        .addComponent(btnCancelar)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardaEmpleado)
                    .addComponent(btnCancelar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardaEmpleadoActionPerformed
        guardarDatosEmpleado();
    }//GEN-LAST:event_btnGuardaEmpleadoActionPerformed

    private void txtPrimerNombreEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrimerNombreEmpleadoKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A'|| c>'Z')&& (c<' ' || c>' ')){
            //getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrimerNombreEmpleadoKeyTyped

    private void txtSegundoNombreEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegundoNombreEmpleadoKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A'|| c>'Z')&& (c<' ' || c>' ')){
            //getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSegundoNombreEmpleadoKeyTyped

    private void txtPrimerApellidoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrimerApellidoEmpleadoKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A'|| c>'Z')&& (c<' ' || c>' ')){
            //getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrimerApellidoEmpleadoKeyTyped

    private void txtSegundoApellidoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegundoApellidoEmpleadoKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A'|| c>'Z')&& (c<' ' || c>' ')){
            //getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSegundoApellidoEmpleadoKeyTyped

    private void txtCedulaEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaEmpleadoKeyTyped
         char c = evt.getKeyChar();
        if((c<'0' || c>'9') || txtCedulaEmpleado.getText().length()== 10){
            //getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCedulaEmpleadoKeyTyped

    private void txtFechaNacimientoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaNacimientoEmpleadoKeyTyped
          char c = evt.getKeyChar();
        if((c<'0' || c>'9')  && (c<'-' || c>'/') || txtFechaNacimientoEmpleado.getText().length()== 10 ){ 
            //getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtFechaNacimientoEmpleadoKeyTyped

    private void txtCedulaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaEmpleadoActionPerformed
      
    }//GEN-LAST:event_txtCedulaEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardaEmpleado;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoEmpleado;
    private javax.swing.JComboBox<String> jComboBoxEspecialidadEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JTextField txtCedulaEmpleado;
    private javax.swing.JTextField txtEmailEmpleado;
    private javax.swing.JTextField txtFechaNacimientoEmpleado;
    private javax.swing.JTextField txtPrimerApellidoEmpleado;
    private javax.swing.JTextField txtPrimerNombreEmpleado;
    private javax.swing.JTextField txtSegundoApellidoEmpleado;
    private javax.swing.JTextField txtSegundoNombreEmpleado;
    // End of variables declaration//GEN-END:variables
}
