/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vistas.RegistrarEmpleado;

/**
 *
 * @author Daro
 */
public class Empleado {
    
    private String cedulaEmpleado;
    private String primerNombreEmpleado;
    private String segundoNombreEmpleado;
    private String primerApellidoEmpleado;
    private String segundoApellidoEmpleado;
    private String fechaNacimientoEmpleado;
    private String correoElectronicoEmpleado;
    private String departamentoEmpleado;
    private String especialidadEmpleado;
    private String sql;
    

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getPrimerNombreEmpleado() {
        return primerNombreEmpleado;
    }

    public void setPrimerNombreEmpleado(String primerNombreEmpleado) {
        this.primerNombreEmpleado = primerNombreEmpleado;
    }

    public String getSegundoNombreEmpleado() {
        return segundoNombreEmpleado;
    }

    public void setSegundoNombreEmpleado(String segundoNombreEmpleado) {
        this.segundoNombreEmpleado = segundoNombreEmpleado;
    }

    public String getPrimerApellidoEmpleado() {
        return primerApellidoEmpleado;
    }

    public void setPrimerApellidoEmpleado(String primerApellidoEmpleado) {
        this.primerApellidoEmpleado = primerApellidoEmpleado;
    }

    public String getSegundoApellidoEmpleado() {
        return segundoApellidoEmpleado;
    }

    public void setSegundoApellidoEmpleado(String segundoApellidoEmpleado) {
        this.segundoApellidoEmpleado = segundoApellidoEmpleado;
    }

    public String getFechaNacimientoEmpleado() {
        return fechaNacimientoEmpleado;
    }

    public void setFechaNacimientoEmpleado(String fechaNacimientoEmpleado) {
        this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
    }

    public String getCorreoElectronicoEmpleado() {
        return correoElectronicoEmpleado;
    }

    public void setCorreoElectronicoEmpleado(String correoElectronicoEmpleado) {
        this.correoElectronicoEmpleado = correoElectronicoEmpleado;
    }

    public String getDepartamentoEmpleado() {
        return departamentoEmpleado;
    }

    public void setDepartamentoEmpleado(String departamentoEmpleado) {
        this.departamentoEmpleado = departamentoEmpleado;
    }

    public String getEspecialidadEmpleado() {
        return especialidadEmpleado;
    }

    public void setEspecialidadEmpleado(String especialidadEmpleado) {
        this.especialidadEmpleado = especialidadEmpleado;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    
}

