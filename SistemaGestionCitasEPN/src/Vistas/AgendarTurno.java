/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Vistas;

import Controlador.Conexion;
import static Vistas.RegistrarEmpleado.txtCedulaEmpleado;
import java.awt.JobAttributes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daro
 */
public class AgendarTurno extends javax.swing.JFrame {

    /**
     * Creates new form AgendarTurno
     */
    public AgendarTurno() {
        initComponents();
        setLocationRelativeTo(null);// centrado
        setResizable(false); // impide maximizar
        setTitle("Agendar Turno");
        //cargarComboBoxElegirMedico();
        setModeloTabla();
        txtNombreCompletoProfesional.setVisible(false);
        txtPrimerNombreDoc.setVisible(false);
        txtSegundoNombreDoc.setVisible(false);
        txtPrimerApellidoDoc.setVisible(false);
        txtSegundoApellidoDoc.setVisible(false);
        txtIdMedico.setVisible(false);
        txtIdPacienteTurno.setVisible(false);
        txtIdMedicoRecuperado.setVisible(false);
        txtFechaCitaRecuperada.setVisible(false);
        txtHoraCitaRecuperada.setVisible(false);
        txtHoraCita.setVisible(false);
        txtFechaCompletaCita.setVisible(false);

    }
    
    Conexion miConexion = new Conexion();
    
    public static String textoId;
    public static String nombreProfesional;
    
    
    
    
    public void cargarComboBoxElegirMedico(){
        jComboBoxNombreMedico.removeAllItems();
        String sql = "select EMPLEADOID, concat(PRIMERNOMBRE,' ',SEGUNDONOMBRE,' ',PRIMERAPELLIDO,' ',SEGUNDOAPELLIDO) as NOMBRECOMPLETO from EMPLEADO WHERE ESPECIALIDAD= '"+jComboBoxEspecialidad.getSelectedItem()+"'";
        try{
            Statement st = miConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                jComboBoxNombreMedico.addItem(rs.getString("NOMBRECOMPLETO"));
 
            }
            
           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
   
    }
    
 
    
    
    public void capturarDatosDataChooser(){
      int anio, mes, dia;
      
      anio = jDateChooserTurnos.getCalendar().get(Calendar.YEAR);
      mes = jDateChooserTurnos.getCalendar().get(Calendar.MONTH);
      dia = jDateChooserTurnos.getCalendar().get(Calendar.DAY_OF_MONTH);
      
      String anioS = String.valueOf(anio);
      String mesS = String.valueOf(mes);
      String diaS = String.valueOf(dia);
      
      String fecha = anioS+'-'+mesS+'-'+diaS;
      txtFechaCompletaCita.setText(fecha);
      
        JOptionPane.showMessageDialog(null, "Fecha asiganada correctamente");
  
    }
    
    public void setModeloTabla(){
      
        DefaultTableModel miModeloTabla = new DefaultTableModel();
        miModeloTabla.addColumn("CÉDULA");
        miModeloTabla.addColumn("P.NOMBRE");
        miModeloTabla.addColumn("S.NOMBRE");
        miModeloTabla.addColumn("P.APELLIDO");
        miModeloTabla.addColumn("S.APELLIDO");
        miModeloTabla.addColumn("P.TELEFONO");
        //miModeloTabla.addColumn("S.TELEFONO");
        miModeloTabla.addColumn("EMAIL");
        //miModeloTabla.addColumn("DIRECCION");
        //miModeloTabla.addColumn("F.NACIMIENTO");
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
        miModeloTabla.addColumn("EMAIL");
        
        String cedulaPaciente;
        String sql = null;
        cedulaPaciente = txtCedulaPacienteBuscar.getText();
        
        if(String.valueOf(cedulaPaciente).compareTo("")==0){
            JOptionPane.showMessageDialog(null, "Ingrese parámetro de búsqueda");
        }else{
            sql = "SELECT CEDULA,PRIMERNOMBRE,SEGUNDONOMBRE,PRIMERAPELLIDO,SEGUNDOAPELLIDO,PRIMERTELEFONO,EMAIL,PACIENTEID FROM PACIENTE WHERE CEDULA = '"+cedulaPaciente+"'"; 
        }
        
        String datos [] = new String[8];
        try {
            Statement st= miConexion.Conectar().createStatement();
            ResultSet rs2=st.executeQuery(sql);
            System.out.println(rs2);
            while(rs2.next()){
                datos[0]=rs2.getString(1);
                datos[1]=rs2.getString(2);
                datos[2]=rs2.getString(3);
                datos[3]=rs2.getString(4);
                datos[4]=rs2.getString(5);
                datos[5]=rs2.getString(6);
                datos[6]=rs2.getString(7);
                datos[7]=rs2.getString(8);
                miModeloTabla.addRow(datos);         
            }
            
            if (!cedulaPaciente.equals(datos[0])) {

                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias con la búsqueda");


            }else{
                
                 
            jTablePaciente.setModel(miModeloTabla);
            txtCedulaPacienteBuscar.setText("");
            txtIdPacienteTurno.setText(datos[7]);
         
            
            }

         
        } catch (SQLException ex) {
            System.out.println("Error busqueda"); 
        }

    }
      
    
    public void agendarTurno(){
        
        String empleadoid,pacienteid,especialidadTurno, fechaTurno, horaTurno;
        
        empleadoid = txtIdMedico.getText();
        pacienteid = txtIdPacienteTurno.getText();
        especialidadTurno = jComboBoxEspecialidad.getSelectedItem().toString();
        fechaTurno = txtFechaCompletaCita.getText();
        horaTurno = txtHoraCita.getText();
        
        if( String.valueOf(txtIdMedico.getText()).compareTo("")==0 || String.valueOf(txtIdPacienteTurno.getText()).compareTo("")==0 ||
            String.valueOf(jComboBoxEspecialidad.getSelectedItem()).compareTo("")==0 || String.valueOf(txtFechaCompletaCita.getText()).compareTo("")==0 ||
            String.valueOf(txtHoraCita.getText()).compareTo("")==0){
            
            JOptionPane.showMessageDialog(null,"Uno o mas campos vacios","Error",JOptionPane.ERROR_MESSAGE);
            
        }else{
            
            /****************antes de insertar dato, realizo una consulta en la bd, de los campos EMPLEADOID,FECHATURNO,HORATURNO*********************/
           String consultaCI = "SELECT EMPLEADOID,FECHATURNO,HORATURNO FROM TURNO WHERE EMPLEADOID='"+txtIdMedico.getText()+"' AND FECHATURNO= '"+txtFechaCompletaCita.getText()+"' AND HORATURNO= '"+txtHoraCita.getText()+"'";
           
           //String consultaCI = "SELECT EMPLEADOID FROM TURNO WHERE EMPLEADOID='"+txtIdMedico.getText()+"' ";
           String valorConsultaEmpleadoId=null; 
           String valorConsulaFechaTurno=null;
           String valorConsultaHoraTurno=null;
           
            try {
            Statement st= miConexion.Conectar().createStatement();
            ResultSet rs2=st.executeQuery(consultaCI);
            while(rs2.next()){
                valorConsultaEmpleadoId=rs2.getString(1);
                valorConsulaFechaTurno=rs2.getString(2);
                valorConsultaHoraTurno=rs2.getString(3);
                
            }
            
            txtIdMedicoRecuperado.setText(valorConsultaEmpleadoId);
            txtFechaCitaRecuperada.setText(valorConsulaFechaTurno);
            txtHoraCitaRecuperada.setText(valorConsultaHoraTurno);
      
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            
            
            
            
            if (txtIdMedicoRecuperado.getText().equals(txtIdMedico.getText()) || txtFechaCitaRecuperada.getText().equals(txtFechaCompletaCita.getText()) || txtHoraCitaRecuperada.getText().equals(txtHoraCita.getText())     ) {
                
                JOptionPane.showMessageDialog(null,"Medico no disponible en la fecha y hora seleccionada","Error",JOptionPane.ERROR_MESSAGE);
                
            }else{
             
                 ///////////////////////////////////////// INSERTAR DATOS ///////////////////////////////////////////////////////////////////
            String sql="INSERT INTO TURNO (EMPLEADOID,PACIENTEID,ESPECIALIDADTURNO,FECHATURNO,HORATURNO)VALUES(?,?,?,?,?)";
            try {
            PreparedStatement pst = miConexion.Conectar().prepareStatement(sql);
            pst.setString(1,empleadoid);
            pst.setString(2,pacienteid);
            pst.setString(3,especialidadTurno);
            pst.setString(4,fechaTurno);
            pst.setString(5,horaTurno);
            int n= pst.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "Datos Registrados Exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error Datos No Registrados");
            }
               }catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Datos No Registrados");
            Logger.getLogger(RegistrarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
               }
      
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                
            }
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxEspecialidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxNombreMedico = new javax.swing.JComboBox<>();
        txtPrimerNombreDoc = new javax.swing.JTextField();
        txtNombreCompletoProfesional = new javax.swing.JTextField();
        txtSegundoNombreDoc = new javax.swing.JTextField();
        txtPrimerApellidoDoc = new javax.swing.JTextField();
        txtSegundoApellidoDoc = new javax.swing.JTextField();
        txtIdMedico = new javax.swing.JTextField();
        btnVerificarDisponibilidadMedico = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jDateChooserTurnos = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jComboBoxHoraCita = new javax.swing.JComboBox<>();
        txtFechaCompletaCita = new javax.swing.JTextField();
        txtHoraCita = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalleDeTurno = new javax.swing.JTextArea();
        btnGenerarDetalleTurno = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCedulaPacienteBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtCedulaPaciente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPirmerNombrePaciente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrimerApellidoPaciente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSegundoNombrePaciente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSegundoApellidoPaciente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefonoPaciente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmailPaciente = new javax.swing.JTextField();
        txtIdPacienteTurno = new javax.swing.JTextField();
        txtIdMedicoRecuperado = new javax.swing.JTextField();
        txtFechaCitaRecuperada = new javax.swing.JTextField();
        txtHoraCitaRecuperada = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Agendar Turno");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formulario para Agendar Turnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione un Profesional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Especialidad:");

        jComboBoxEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione una opción --", "MEDICINA GENERAL", "GINECOLOGÍA", "ODONTOLOGÍA", "PSICOLOGÍA", "ENFERMERÍA", "NUTRICIÓN", "TRABAJO SOCIAL " }));
        jComboBoxEspecialidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEspecialidadItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre del Profesional:");

        jComboBoxNombreMedico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxNombreMedico.setMaximumRowCount(2);
        jComboBoxNombreMedico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxNombreMedicoItemStateChanged(evt);
            }
        });

        btnVerificarDisponibilidadMedico.setText("Disponibilidad Profesional");
        btnVerificarDisponibilidadMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarDisponibilidadMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20)
                        .addComponent(jComboBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxNombreMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerificarDisponibilidadMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNombreCompletoProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrimerNombreDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrimerApellidoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSegundoNombreDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSegundoApellidoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBoxNombreMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVerificarDisponibilidadMedico))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSegundoApellidoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSegundoNombreDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrimerApellidoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrimerNombreDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreCompletoProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha y Hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione año, mes y día", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jDateChooserTurnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooserTurnosMouseClicked(evt);
            }
        });
        jDateChooserTurnos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserTurnosPropertyChange(evt);
            }
        });

        jButton3.setText("Asignar Fecha");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jDateChooserTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(jDateChooserTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione hora", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jComboBoxHoraCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione una opción --", "8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00" }));
        jComboBoxHoraCita.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHoraCitaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxHoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtHoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaCompletaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxHoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCompletaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle turno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        txtDetalleDeTurno.setColumns(20);
        txtDetalleDeTurno.setRows(5);
        jScrollPane1.setViewportView(txtDetalleDeTurno);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        btnGenerarDetalleTurno.setText("Detalle Turno");
        btnGenerarDetalleTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarDetalleTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarDetalleTurno)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnGenerarDetalleTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione un paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese los datos para buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Número de Cédula:");

        txtCedulaPacienteBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtCedulaPacienteBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCedulaPacienteBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jScrollPane2.setViewportView(jTablePaciente);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cédula:");

        txtCedulaPaciente.setEditable(false);
        txtCedulaPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Primer Nombre:");

        txtPirmerNombrePaciente.setEditable(false);
        txtPirmerNombrePaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Primer Apellido:");

        txtPrimerApellidoPaciente.setEditable(false);
        txtPrimerApellidoPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Segundo Nombre:");

        txtSegundoNombrePaciente.setEditable(false);
        txtSegundoNombrePaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Segundo Apellido:");

        txtSegundoApellidoPaciente.setEditable(false);
        txtSegundoApellidoPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Teléfono:");

        txtTelefonoPaciente.setEditable(false);
        txtTelefonoPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Correo Electrónico:");

        txtEmailPaciente.setEditable(false);
        txtEmailPaciente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmailPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPirmerNombrePaciente)
                    .addComponent(txtCedulaPaciente)
                    .addComponent(txtPrimerApellidoPaciente)
                    .addComponent(txtTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSegundoNombrePaciente)
                    .addComponent(txtSegundoApellidoPaciente)
                    .addComponent(txtEmailPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPirmerNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(txtSegundoNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrimerApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(txtSegundoApellidoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTelefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtEmailPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdPacienteTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtHoraCitaRecuperada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaCitaRecuperada, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdMedicoRecuperado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdPacienteTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoraCitaRecuperada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaCitaRecuperada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdMedicoRecuperado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)))
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Agendar Turno");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jComboBoxEspecialidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEspecialidadItemStateChanged
        cargarComboBoxElegirMedico();
    }//GEN-LAST:event_jComboBoxEspecialidadItemStateChanged

    private void txtEmailPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailPacienteActionPerformed

    private void jDateChooserTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserTurnosMouseClicked
       
    }//GEN-LAST:event_jDateChooserTurnosMouseClicked

    private void btnGenerarDetalleTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarDetalleTurnoActionPerformed
      String decorator = "************ DATOS DE LA CITA ************\n";
      String cadena = "\n• Fecha Cita ---->  "+txtFechaCompletaCita.getText()+"\n\n• Hora ---->  "+txtHoraCita.getText()+"\n";
      String decorator2= "\n***********************************************";
      txtDetalleDeTurno.setText(decorator+cadena+decorator2);
        
    }//GEN-LAST:event_btnGenerarDetalleTurnoActionPerformed

    private void jComboBoxHoraCitaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHoraCitaItemStateChanged
        txtHoraCita.setText(jComboBoxHoraCita.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxHoraCitaItemStateChanged

    private void jDateChooserTurnosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserTurnosPropertyChange
        
    }//GEN-LAST:event_jDateChooserTurnosPropertyChange

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        capturarDatosDataChooser();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarPaciente(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
        int fila = jTablePaciente.getSelectedRow();
        if(fila>=0){
            txtCedulaPaciente.setText(jTablePaciente.getValueAt(fila, 0).toString());
            txtPirmerNombrePaciente.setText(jTablePaciente.getValueAt(fila, 1).toString());
            txtSegundoNombrePaciente.setText(jTablePaciente.getValueAt(fila, 2).toString());
            txtPrimerApellidoPaciente.setText(jTablePaciente.getValueAt(fila, 3).toString());
            txtSegundoApellidoPaciente.setText(jTablePaciente.getValueAt(fila, 4).toString());
            txtTelefonoPaciente.setText(jTablePaciente.getValueAt(fila, 5).toString());
            txtEmailPaciente.setText(jTablePaciente.getValueAt(fila, 6).toString());

        }else{
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jComboBoxNombreMedicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxNombreMedicoItemStateChanged
       txtNombreCompletoProfesional.setText((String) jComboBoxNombreMedico.getSelectedItem());
       
       String primerNombre,segundoNombre,primerApellido,segundoApellido;  

        StringTokenizer tokens=new StringTokenizer(txtNombreCompletoProfesional.getText()," ");
        while(tokens.hasMoreTokens()){
            primerNombre = tokens.nextToken();
            segundoNombre = tokens.nextToken();
            primerApellido = tokens.nextToken();
            segundoApellido = tokens.nextToken();
            
            txtPrimerNombreDoc.setText(primerNombre);
            txtSegundoNombreDoc.setText(segundoNombre);
            txtPrimerApellidoDoc.setText(primerApellido);
            txtSegundoApellidoDoc.setText(segundoApellido);
            
        }

        String datos [] = new String[1];
        String sql = "select EMPLEADOID from EMPLEADO WHERE PRIMERNOMBRE= '"+txtPrimerNombreDoc.getText()+"' AND SEGUNDONOMBRE= '"+txtSegundoNombreDoc.getText()+"' AND PRIMERAPELLIDO= '"+txtPrimerApellidoDoc.getText()+"' AND SEGUNDOAPELLIDO= '"+txtSegundoApellidoDoc.getText()+"' ";
        try{
            Statement st = miConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
            }
            
             txtIdMedico.setText(datos[0]);
            
           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        
    }//GEN-LAST:event_jComboBoxNombreMedicoItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        agendarTurno();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnVerificarDisponibilidadMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarDisponibilidadMedicoActionPerformed
        
    
        if (jComboBoxNombreMedico.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "Primero elija un profesional");
        }else{
            
            textoId = txtIdMedico.getText();
            nombreProfesional = txtNombreCompletoProfesional.getText();
            
            VerDisponibilidadMedico verD = new VerDisponibilidadMedico();
        
            verD.setVisible(true);
        
        
        }
    }//GEN-LAST:event_btnVerificarDisponibilidadMedicoActionPerformed

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
            java.util.logging.Logger.getLogger(AgendarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendarTurno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerarDetalleTurno;
    private javax.swing.JButton btnVerificarDisponibilidadMedico;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxEspecialidad;
    private javax.swing.JComboBox<String> jComboBoxHoraCita;
    private javax.swing.JComboBox<String> jComboBoxNombreMedico;
    private com.toedter.calendar.JDateChooser jDateChooserTurnos;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField txtCedulaPaciente;
    private javax.swing.JTextField txtCedulaPacienteBuscar;
    private javax.swing.JTextArea txtDetalleDeTurno;
    private javax.swing.JTextField txtEmailPaciente;
    private javax.swing.JTextField txtFechaCitaRecuperada;
    private javax.swing.JTextField txtFechaCompletaCita;
    private javax.swing.JTextField txtHoraCita;
    private javax.swing.JTextField txtHoraCitaRecuperada;
    private javax.swing.JTextField txtIdMedico;
    private javax.swing.JTextField txtIdMedicoRecuperado;
    private javax.swing.JTextField txtIdPacienteTurno;
    private javax.swing.JTextField txtNombreCompletoProfesional;
    private javax.swing.JTextField txtPirmerNombrePaciente;
    private javax.swing.JTextField txtPrimerApellidoDoc;
    private javax.swing.JTextField txtPrimerApellidoPaciente;
    private javax.swing.JTextField txtPrimerNombreDoc;
    private javax.swing.JTextField txtSegundoApellidoDoc;
    private javax.swing.JTextField txtSegundoApellidoPaciente;
    private javax.swing.JTextField txtSegundoNombreDoc;
    private javax.swing.JTextField txtSegundoNombrePaciente;
    private javax.swing.JTextField txtTelefonoPaciente;
    // End of variables declaration//GEN-END:variables
}
