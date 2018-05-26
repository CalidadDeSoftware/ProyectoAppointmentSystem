/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daro
 */
public class Conexion {
    public Connection Conectar(){
        Connection con = null;
        try {
            String connectionUrl = "jdbc:sqlserver://;database=GestionCitasEpn;integratedSecurity=true;";
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("Conectado.");
            JOptionPane.showMessageDialog(null, "Conectado");
        }catch (SQLException ex){
            System.out.println("Error.");
        }
        return con;
    }

}
