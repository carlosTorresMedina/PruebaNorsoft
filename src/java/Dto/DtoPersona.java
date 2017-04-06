/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author carlos esta clase tiene la funcion de crear objetos de transferencia
 * de datos de personas
 */
public class DtoPersona {

    private String nombre;
    private String apellido;
    private String estadoCivil;
    private Date fecha;
    private int sueldo;
    private String correo;
    private String departamento;
    private String ciudad;

    public DtoPersona(String nombre, String apellido, String estadoCivil, Date fecha, int sueldo, String correo, String departamento, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estadoCivil = estadoCivil;
        this.fecha = fecha;
        this.sueldo = sueldo;
        this.correo = correo;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }  
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DtoPersona other = (DtoPersona) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }

    /**
     * da un formato especifico a la fecha
     * @return 
     */
    public String getFormatoFecha(){
        DateFormat fechar = new SimpleDateFormat("yyyy/MM/dd");
	String	convertido = fechar.format(fecha);
        return convertido; 
    }
    
    /**
     * da un formato al valor sueldo
     * @return 
     */
    public String getFormatoSueldo(){
     NumberFormat formatoNumero = NumberFormat.getNumberInstance();
    return formatoNumero.format(sueldo);
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
