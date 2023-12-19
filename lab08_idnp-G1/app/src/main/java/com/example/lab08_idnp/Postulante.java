package com.example.lab08_idnp;
import java.io.Serializable;

public class Postulante implements Serializable  {
    private String dni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String fechaNacimiento;
    private String colegioProcedencia;
    private String carreraPostula;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getColegioProcedencia() {
        return colegioProcedencia;
    }

    public void setColegioProcedencia(String colegioProcedencia) {
        this.colegioProcedencia = colegioProcedencia;
    }

    public String getCarreraPostula() {
        return carreraPostula;
    }

    public void setCarreraPostula(String carreraPostula) {
        this.carreraPostula = carreraPostula;
    }

    // Constructor
    public Postulante(String dni, String apellidoPaterno, String apellidoMaterno, String nombres, String fechaNacimiento, String colegioProcedencia, String carreraPostula) {
        this.dni = dni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.colegioProcedencia = colegioProcedencia;
        this.carreraPostula = carreraPostula;
    }



    // Getters y settersS
    // ...
}
