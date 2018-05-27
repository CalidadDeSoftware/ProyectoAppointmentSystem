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
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daro
 */
public class ActualizarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form ActualizarEmpleado
     */
    public ActualizarEmpleado() {
        initComponents();
        setLocationRelativeTo(null);// centrado
        setResizable(false); // impide maximizar
        setTitle("Actualizar Empleado");
        setModeloTabla();
        jComboBoxDepartamentoEmpleado.removeAllItems();
        jComboBoxEspecialidadEmpleado.removeAllItems();
        txtIdEmpleado.setVisible(false);
     
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
        miModeloTabla.addColumn("F.NACIMIENTO");
        miModeloTabla.addColumn("EMAIL");
        jTableEmpleado.setModel(miModeloTabla);
    
    }
    
    public void buscarEmpleado(){
        
        DefaultTableModel miModeloTabla = new DefaultTableModel();
        miModeloTabla.addColumn("CÉDULA");
        miModeloTabla.addColumn("P.NOMBRE");
        miModeloTabla.addColumn("S.NOMBRE");
        miModeloTabla.addColumn("P.APELLIDO");
        miModeloTabla.addColumn("S.APELLIDO");
        miModeloTabla.addColumn("F.NACIMIENTO");
        miModeloTabla.addColumn("EMAIL");
        
        String cedulaEmpleado;
        String sql = null;
        cedulaEmpleado = txtBuscarCedulaEmpleado.getText();
        
        if(String.valueOf(cedulaEmpleado).compareTo("")==0){
            JOptionPane.showMessageDialog(null, "Ingrese parámetro de búsqueda");
        }else{
            sql = "SELECT CEDULA,PRIMERNOMBRE,SEGUNDONOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,FECHANACIMIENTO,EMAIL,DEPARTAMENTO,ESPECIALIDAD,EMPLEADOID FROM EMPLEADO WHERE CEDULA = '"+cedulaEmpleado+"'"; 
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
                
                miModeloTabla.addRow(datos);
               
               
                
            }
            jTableEmpleado.setModel(miModeloTabla);
            jComboBoxDepartamentoEmpleado.addItem(datos[7]);
            jComboBoxEspecialidadEmpleado.addItem(datos[8]);
            txtIdEmpleado.setText(datos[9]);
            txtBuscarCedulaEmpleado.setText("");
           
            jTableEmpleado.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(6).setPreferredWidth(15);
         
        } catch (SQLException ex) {
            System.out.println("Error al insertar datos"); 
        }

    }
    
    public void mostrarDatosEmpleado(){
        DefaultTableModel miModeloTabla = new DefaultTableModel();
        miModeloTabla.addColumn("CÉDULA");
        miModeloTabla.addColumn("P.NOMBRE");
        miModeloTabla.addColumn("S.NOMBRE");
        miModeloTabla.addColumn("P.APELLIDO");
        miModeloTabla.addColumn("S.APELLIDO");
        miModeloTabla.addColumn("F.NACIMIENTO");
        miModeloTabla.addColumn("EMAIL");
        String sql = null;
        
        sql = "SELECT CEDULA,PRIMERNOMBRE,SEGUNDONOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,FECHANACIMIENTO,EMAIL,DEPARTAMENTO,ESPECIALIDAD FROM EMPLEADO";
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
                
                miModeloTabla.addRow(datos);
                
            }
            jTableEmpleado.setModel(miModeloTabla);
            jComboBoxDepartamentoEmpleado.addItem(datos[7]);
            jComboBoxEspecialidadEmpleado.addItem(datos[8]);
            
            jTableEmpleado.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTableEmpleado.getColumnModel().getColumn(6).setPreferredWidth(15);

         
        } catch (SQLException ex) {
            System.out.println("Error al mostrar datos"); 
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
        jComboBoxDepartamentoEmpleado.removeAllItems();
        jComboBoxEspecialidadEmpleado.removeAllItems();
    }
    
    public void actualizarDatosEmpleado(){
        String sql;
        sql = "UPDATE EMPLEADO SET CEDULA='"+txtCedulaEmpleado.getText()+"',PRIMERNOMBRE='"+txtPrimerNombreEmpleado.getText()+"',SEGUNDONOMBRE='"+txtSegundoNombreEmpleado.getText()+"',PRIMERAPELLIDO='"+txtPrimerApellidoEmpleado.getText()+"',SEGUNDOAPELLIDO='"+txtSegundoApellidoEmpleado.getText()+ "',FECHANACIMIENTO='"+txtFechaNacimientoEmpleado.getText()+"',EMAIL='"+txtEmailEmpleado.getText()+"' WHERE EMPLEADOID ='"+txtIdEmpleado.getText()+"'";

        try {
            PreparedStatement pps = miConexion.Conectar().prepareStatement(sql);
            int n= pps.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos Actualizados Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error Datos No Actualizados");
            }
            mostrarDatosEmpleado();
            limpiarCampos();

        } catch (SQLException | HeadlessException ex) {
            System.out.println("Error al actualizar datos");
        }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // ********************************************************///

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
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtBuscarCedulaEmpleado = new javax.swing.JTextField();
        btnBuscarEmpleado = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxDepartamentoEmpleado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxEspecialidadEmpleado = new javax.swing.JComboBox<>();
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
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmpleado = new javax.swing.JTable();
        txtIdEmpleado = new javax.swing.JTextField();
        btnActualizarEmpleado = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Empleado");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario Actualizar Empleado ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingresa los datos para buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Número de Cédula:");

        txtBuscarCedulaEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnBuscarEmpleado.setText("Buscar");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
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
                .addComponent(txtBuscarCedulaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnBuscarEmpleado)
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
                    .addComponent(txtBuscarCedulaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleado)
                    .addComponent(btnLimpiar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Laboral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Departamento:");

        jComboBoxDepartamentoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxDepartamentoEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UNIDAD DE BIENESTAR ESTUDIANTIL Y SOCIAL" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Especialidad:");

        jComboBoxEspecialidadEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxEspecialidadEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TRABAJO SOCIAL ", "MEDICINA GENERAL", "GINECOLOGÍA", "ODONTOLOGÍA", "PSICOLOGÍA", "ENFERMERÍA", "NUTRICIÓN", "SEGURO ESTUDIANTIL", " " }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxDepartamentoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(27, 27, 27)
                .addComponent(jComboBoxEspecialidadEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
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

        txtPrimerNombreEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPrimerApellidoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtFechaNacimientoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Segundo Nombre:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Segundo Apellido:");

        txtSegundoNombreEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSegundoApellidoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados de búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTableEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmpleado);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnActualizarEmpleado.setText("Actualizar");
        btnActualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEmpleadoActionPerformed(evt);
            }
        });

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
                        .addGap(363, 363, 363)
                        .addComponent(btnActualizarEmpleado)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarEmpleado)
                    .addComponent(btnCancelar))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        buscarEmpleado();
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void jTableEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadoMouseClicked
        int fila = jTableEmpleado.getSelectedRow();
        if(fila>=0){
            txtCedulaEmpleado.setText(jTableEmpleado.getValueAt(fila, 0).toString());
            txtPrimerNombreEmpleado.setText(jTableEmpleado.getValueAt(fila, 1).toString());
            txtSegundoNombreEmpleado.setText(jTableEmpleado.getValueAt(fila, 2).toString());
            txtPrimerApellidoEmpleado.setText(jTableEmpleado.getValueAt(fila, 3).toString());
            txtSegundoApellidoEmpleado.setText(jTableEmpleado.getValueAt(fila, 4).toString());
            txtFechaNacimientoEmpleado.setText(jTableEmpleado.getValueAt(fila, 5).toString());
            txtEmailEmpleado.setText(jTableEmpleado.getValueAt(fila, 6).toString());
            
        }else{
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
    }//GEN-LAST:event_jTableEmpleadoMouseClicked

    private void btnActualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEmpleadoActionPerformed
        actualizarDatosEmpleado();
    }//GEN-LAST:event_btnActualizarEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarEmpleado;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> jComboBoxDepartamentoEmpleado;
    private javax.swing.JComboBox<String> jComboBoxEspecialidadEmpleado;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmpleado;
    private javax.swing.JTextField txtBuscarCedulaEmpleado;
    public static javax.swing.JTextField txtCedulaEmpleado;
    private javax.swing.JTextField txtEmailEmpleado;
    private javax.swing.JTextField txtFechaNacimientoEmpleado;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtPrimerApellidoEmpleado;
    private javax.swing.JTextField txtPrimerNombreEmpleado;
    private javax.swing.JTextField txtSegundoApellidoEmpleado;
    private javax.swing.JTextField txtSegundoNombreEmpleado;
    // End of variables declaration//GEN-END:variables
}
