/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;

/**
 *
 * @author Dennis
 */
public class Usuario {
    Conexion conexion = new  Conexion();
    int Id;
    String Nombre, Contraseña, Rol;

    public Usuario() {
    }

    public Usuario(int Id, String Nombre, String Contraseña, String Rol) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    
    public String MD5 (String md5){
        
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
                return sb.toString();
        
        }catch (java.security.NoSuchAlgorithmException e) {
            
        }
        
        return null;
    }
}
