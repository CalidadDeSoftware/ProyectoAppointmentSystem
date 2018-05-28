/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alexis
 */
public class Paciente {
    private String idPaciente;
    private String cedulaPaciente;
    private String pNombrePaciente;
    private String sNombrePaciente;
    private String pApellidoPaciente;
    private String sApellidoPaciente;
    private String pTelefonoPaciente;    
    private String sTelefonoPaciente;
    private String emaiPaciente;
    private String fechaNacimientoPaciente;
    private String direccionPaciente;
    
    public Paciente() {
    }

    public Paciente(String idPaciente, String cedula, String nombreP, String nombreS, String apellidoP, String apellidoS, String telefonoP, String telefonoS, String email, String fechaNacimiento, String direccion) {
        this.idPaciente = idPaciente;
        this.cedulaPaciente = cedula;
        this.pNombrePaciente = nombreP;
        this.sNombrePaciente = nombreS;
        this.pApellidoPaciente = apellidoP;
        this.sApellidoPaciente = apellidoS;
        this.pTelefonoPaciente = telefonoP;
        this.sTelefonoPaciente = telefonoS;
        this.emaiPaciente = email;
        this.fechaNacimientoPaciente = fechaNacimiento;
        this.direccionPaciente = direccion;
    }

    /**
     * @return the cedulaPaciente
     */
    public String getCedulaPaciente() {
        return cedulaPaciente;
    }

    /**
     * @return the direccionPaciente
     */
    public String getDireccionPaciente() {
        return direccionPaciente;
    }

    /**
     * @return the emaiPaciente
     */
    public String getEmaiPaciente() {
        return emaiPaciente;
    }

    /**
     * @return the fechaNacimientoPaciente
     */
    public String getFechaNacimientoPaciente() {
        return fechaNacimientoPaciente;
    }

    /**
     * @return the idPaciente
     */
    public String getIdPaciente() {
        return idPaciente;
    }

    /**
     * @return the pApellidoPaciente
     */
    public String getpApellidoPaciente() {
        return pApellidoPaciente;
    }

    /**
     * @return the pNombrePaciente
     */
    public String getpNombrePaciente() {
        return pNombrePaciente;
    }

    /**
     * @return the pTelefonoPaciente
     */
    public String getpTelefonoPaciente() {
        return pTelefonoPaciente;
    }

    /**
     * @return the sApellidoPaciente
     */
    public String getsApellidoPaciente() {
        return sApellidoPaciente;
    }

    /**
     * @return the sNombrePaciente
     */
    public String getsNombrePaciente() {
        return sNombrePaciente;
    }

    /**
     * @return the sTelefonoPaciente
     */
    public String getsTelefonoPaciente() {
        return sTelefonoPaciente;
    }

    /**
     * @param cedulaPaciente the cedulaPaciente to set
     */
    public void setCedulaPaciente(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }

    /**
     * @param direccionPaciente the direccionPaciente to set
     */
    public void setDireccionPaciente(String direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }

    /**
     * @param emaiPaciente the emaiPaciente to set
     */
    public void setEmaiPaciente(String emaiPaciente) {
        this.emaiPaciente = emaiPaciente;
    }

    /**
     * @param fechaNacimientoPaciente the fechaNacimientoPaciente to set
     */
    public void setFechaNacimientoPaciente(String fechaNacimientoPaciente) {
        this.fechaNacimientoPaciente = fechaNacimientoPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @param pApellidoPaciente the pApellidoPaciente to set
     */
    public void setpApellidoPaciente(String pApellidoPaciente) {
        this.pApellidoPaciente = pApellidoPaciente;
    }

    /**
     * @param pNombrePaciente the pNombrePaciente to set
     */
    public void setpNombrePaciente(String pNombrePaciente) {
        this.pNombrePaciente = pNombrePaciente;
    }

    /**
     * @param pTelefonoPaciente the pTelefonoPaciente to set
     */
    public void setpTelefonoPaciente(String pTelefonoPaciente) {
        this.pTelefonoPaciente = pTelefonoPaciente;
    }

    /**
     * @param sApellidoPaciente the sApellidoPaciente to set
     */
    public void setsApellidoPaciente(String sApellidoPaciente) {
        this.sApellidoPaciente = sApellidoPaciente;
    }

    /**
     * @param sNombrePaciente the sNombrePaciente to set
     */
    public void setsNombrePaciente(String sNombrePaciente) {
        this.sNombrePaciente = sNombrePaciente;
    }

    /**
     * @param sTelefonoPaciente the sTelefonoPaciente to set
     */
    public void setsTelefonoPaciente(String sTelefonoPaciente) {
        this.sTelefonoPaciente = sTelefonoPaciente;
    }
    
    
}
