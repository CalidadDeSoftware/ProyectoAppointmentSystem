package Vistas;

import Controlador.Conexion;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form menuJFrame
     */
    public PantallaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);// centrado
        setExtendedState(PantallaPrincipal.MAXIMIZED_BOTH); // inicia Maximizada
        setTitle("Sistema de Gestión de Turnos");
        

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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPaciente = new javax.swing.JMenu();
        jMenuItemCreatePaciente = new javax.swing.JMenuItem();
        jMenuIUpdatePaciente = new javax.swing.JMenuItem();
        jMenuItemSelectPaciente = new javax.swing.JMenuItem();
        jMenuDeletePaciente = new javax.swing.JMenuItem();
        jMenuEmpleado = new javax.swing.JMenu();
        itemRegistrarEmpleado = new javax.swing.JMenuItem();
        itemActualizarEmpleado = new javax.swing.JMenuItem();
        itemBuscarEmpleado = new javax.swing.JMenuItem();
        itemEliminarEmpleado = new javax.swing.JMenuItem();
        jMenuTurno = new javax.swing.JMenu();
        itemAgendarTurno = new javax.swing.JMenuItem();
        itemReagendarTurno = new javax.swing.JMenuItem();
        itemEliminarTurno = new javax.swing.JMenuItem();
        jMenuReporte = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuAdministracion = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        itemCrearUsuario = new javax.swing.JMenuItem();
        itemModificarUsuario = new javax.swing.JMenuItem();
        itemEliminarUsuario = new javax.swing.JMenuItem();
        jMenuCerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/backgroundPrincipal.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N

        jMenuPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Paciente.png"))); // NOI18N
        jMenuPaciente.setText("Paciente");
        jMenuPaciente.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jMenuItemCreatePaciente.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jMenuItemCreatePaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevoP.png"))); // NOI18N
        jMenuItemCreatePaciente.setText("Registrar Paciente");
        jMenuItemCreatePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCreatePacienteActionPerformed(evt);
            }
        });
        jMenuPaciente.add(jMenuItemCreatePaciente);

        jMenuIUpdatePaciente.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jMenuIUpdatePaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/actualizarPaciente.png"))); // NOI18N
        jMenuIUpdatePaciente.setText("Actualizar Paciente");
        jMenuIUpdatePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIUpdatePacienteActionPerformed(evt);
            }
        });
        jMenuPaciente.add(jMenuIUpdatePaciente);

        jMenuItemSelectPaciente.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jMenuItemSelectPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscarPaciente.png"))); // NOI18N
        jMenuItemSelectPaciente.setText("Buscar Paciente");
        jMenuItemSelectPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSelectPacienteActionPerformed(evt);
            }
        });
        jMenuPaciente.add(jMenuItemSelectPaciente);

        jMenuDeletePaciente.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jMenuDeletePaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/EliminarPaciente.png"))); // NOI18N
        jMenuDeletePaciente.setText("Eliminar Paciente");
        jMenuDeletePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDeletePacienteActionPerformed(evt);
            }
        });
        jMenuPaciente.add(jMenuDeletePaciente);

        jMenuBar1.add(jMenuPaciente);

        jMenuEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/doctor.png"))); // NOI18N
        jMenuEmpleado.setText("Empleado");
        jMenuEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        itemRegistrarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemRegistrarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevoEmpleado.png"))); // NOI18N
        itemRegistrarEmpleado.setText("Registrar Empleado");
        itemRegistrarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemRegistrarEmpleadoMouseClicked(evt);
            }
        });
        itemRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarEmpleadoActionPerformed(evt);
            }
        });
        jMenuEmpleado.add(itemRegistrarEmpleado);

        itemActualizarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemActualizarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/actualizar.png"))); // NOI18N
        itemActualizarEmpleado.setText("Actualizar Empleado");
        itemActualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActualizarEmpleadoActionPerformed(evt);
            }
        });
        jMenuEmpleado.add(itemActualizarEmpleado);

        itemBuscarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemBuscarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscarEmpleado.png"))); // NOI18N
        itemBuscarEmpleado.setText("Buscar Empleado");
        itemBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBuscarEmpleadoActionPerformed(evt);
            }
        });
        jMenuEmpleado.add(itemBuscarEmpleado);

        itemEliminarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemEliminarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminarEmpleado.png"))); // NOI18N
        itemEliminarEmpleado.setText("Eliminar Empleado");
        itemEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarEmpleadoActionPerformed(evt);
            }
        });
        jMenuEmpleado.add(itemEliminarEmpleado);

        jMenuBar1.add(jMenuEmpleado);

        jMenuTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/turno.png"))); // NOI18N
        jMenuTurno.setText("Turno");
        jMenuTurno.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        itemAgendarTurno.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemAgendarTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agendarTurno.png"))); // NOI18N
        itemAgendarTurno.setText("Agendar Turno");
        itemAgendarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgendarTurnoActionPerformed(evt);
            }
        });
        jMenuTurno.add(itemAgendarTurno);

        itemReagendarTurno.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemReagendarTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reagendarTurno.png"))); // NOI18N
        itemReagendarTurno.setText("Reagendar Tunro");
        itemReagendarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReagendarTurnoActionPerformed(evt);
            }
        });
        jMenuTurno.add(itemReagendarTurno);

        itemEliminarTurno.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemEliminarTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/EliminarTurno.png"))); // NOI18N
        itemEliminarTurno.setText("Eliminar Turno");
        itemEliminarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarTurnoActionPerformed(evt);
            }
        });
        jMenuTurno.add(itemEliminarTurno);

        jMenuBar1.add(jMenuTurno);

        jMenuReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reporte.png"))); // NOI18N
        jMenuReporte.setText("Reporte");
        jMenuReporte.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jMenuItem11.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jMenuItem11.setText("Generar Reporte");
        jMenuReporte.add(jMenuItem11);

        jMenuBar1.add(jMenuReporte);

        jMenuAdministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/admin.png"))); // NOI18N
        jMenuAdministracion.setText("Administración");
        jMenuAdministracion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-administrador-del-hombre-40.png"))); // NOI18N
        jMenu11.setText("Administración de Usuarios");
        jMenu11.setFocusable(false);
        jMenu11.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N

        itemCrearUsuario.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/icons8-crear-nuevo-40.png"))); // NOI18N
        itemCrearUsuario.setText("Crear Usuario");
        itemCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearUsuarioActionPerformed(evt);
            }
        });
        jMenu11.add(itemCrearUsuario);

        itemModificarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemModificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/icons8-editar-propiedad-40.png"))); // NOI18N
        itemModificarUsuario.setText("Modificar Usuario");
        itemModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarUsuarioActionPerformed(evt);
            }
        });
        jMenu11.add(itemModificarUsuario);

        itemEliminarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        itemEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-eliminar-40.png"))); // NOI18N
        itemEliminarUsuario.setText("Eliminar Usuario");
        itemEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarUsuarioActionPerformed(evt);
            }
        });
        jMenu11.add(itemEliminarUsuario);

        jMenuAdministracion.add(jMenu11);

        jMenuBar1.add(jMenuAdministracion);

        jMenuCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrarSesion.png"))); // NOI18N
        jMenuCerrarSesion.setText("Cerrar Sesión");
        jMenuCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenuCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuCerrarSesionMouseClicked(evt);
            }
        });
        jMenuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCerrarSesionActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuCerrarSesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemRegistrarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemRegistrarEmpleadoMouseClicked

    }//GEN-LAST:event_itemRegistrarEmpleadoMouseClicked

    private void itemRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarEmpleadoActionPerformed
        RegistrarEmpleado re = new RegistrarEmpleado();
        re.setVisible(true);
    }//GEN-LAST:event_itemRegistrarEmpleadoActionPerformed

    private void itemActualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActualizarEmpleadoActionPerformed
        ActualizarEmpleado ae = new ActualizarEmpleado();
        ae.setVisible(true);
    }//GEN-LAST:event_itemActualizarEmpleadoActionPerformed

    private void itemBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBuscarEmpleadoActionPerformed
        BuscarEmpleado be = new BuscarEmpleado();
        be.setVisible(true);
    }//GEN-LAST:event_itemBuscarEmpleadoActionPerformed

    private void itemEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarEmpleadoActionPerformed
        EliminarEmpleado ee = new EliminarEmpleado();
        ee.setVisible(true);
    }//GEN-LAST:event_itemEliminarEmpleadoActionPerformed

    private void itemAgendarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgendarTurnoActionPerformed
        AgendarTurno at = new AgendarTurno();
        at.setVisible(true);
    }//GEN-LAST:event_itemAgendarTurnoActionPerformed

    private void itemReagendarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReagendarTurnoActionPerformed
     
    }//GEN-LAST:event_itemReagendarTurnoActionPerformed

    private void jMenuDeletePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDeletePacienteActionPerformed
        // TODO add your handling code here:
       eliminarPacienteJFrame ep = new eliminarPacienteJFrame();
       ep.setVisible(true);
    }//GEN-LAST:event_jMenuDeletePacienteActionPerformed

    private void jMenuIUpdatePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIUpdatePacienteActionPerformed
        // TODO add your handling code here:
       actualizarPacienteJFrame ap = new actualizarPacienteJFrame();
       ap.setVisible(true);
    }//GEN-LAST:event_jMenuIUpdatePacienteActionPerformed

    private void jMenuItemSelectPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSelectPacienteActionPerformed
        // TODO add your handling code here:
        buscarPacienteJFrame bp = new buscarPacienteJFrame();
        bp.setVisible(true);
    }//GEN-LAST:event_jMenuItemSelectPacienteActionPerformed

    private void jMenuItemCreatePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCreatePacienteActionPerformed
        // TODO add your handling code here:        
       registrarPacienteJFrame rp = new registrarPacienteJFrame();
       rp.setVisible(true);
    }//GEN-LAST:event_jMenuItemCreatePacienteActionPerformed

    private void itemCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearUsuarioActionPerformed
            CrearUsuario cu = new CrearUsuario();
            cu.setVisible(true);
    }//GEN-LAST:event_itemCrearUsuarioActionPerformed

    private void itemModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarUsuarioActionPerformed
            ModificarUsuario mu = new ModificarUsuario();
            mu.setVisible(true);
    }//GEN-LAST:event_itemModificarUsuarioActionPerformed

    private void itemEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarUsuarioActionPerformed
            EliminarUsuario eu = new EliminarUsuario();
            eu.setVisible(true);
    }//GEN-LAST:event_itemEliminarUsuarioActionPerformed

    private void jMenuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCerrarSesionActionPerformed

    }//GEN-LAST:event_jMenuCerrarSesionActionPerformed

    private void jMenuCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuCerrarSesionMouseClicked
         if (JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cerrar su sesión?", "Confirmación",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jMenuCerrarSesionMouseClicked

    private void itemEliminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarTurnoActionPerformed
       EliminarTurno rt = new EliminarTurno();
       rt.setVisible(true);
    }//GEN-LAST:event_itemEliminarTurnoActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemActualizarEmpleado;
    private javax.swing.JMenuItem itemAgendarTurno;
    private javax.swing.JMenuItem itemBuscarEmpleado;
    private javax.swing.JMenuItem itemCrearUsuario;
    private javax.swing.JMenuItem itemEliminarEmpleado;
    private javax.swing.JMenuItem itemEliminarTurno;
    private javax.swing.JMenuItem itemEliminarUsuario;
    private javax.swing.JMenuItem itemModificarUsuario;
    private javax.swing.JMenuItem itemReagendarTurno;
    private javax.swing.JMenuItem itemRegistrarEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenuAdministracion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCerrarSesion;
    private javax.swing.JMenuItem jMenuDeletePaciente;
    private javax.swing.JMenu jMenuEmpleado;
    private javax.swing.JMenuItem jMenuIUpdatePaciente;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItemCreatePaciente;
    private javax.swing.JMenuItem jMenuItemSelectPaciente;
    private javax.swing.JMenu jMenuPaciente;
    private javax.swing.JMenu jMenuReporte;
    private javax.swing.JMenu jMenuTurno;
    // End of variables declaration//GEN-END:variables
}
