/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author carlos
 * Esta clase tiene como funcion ser el objeto de transferencia de datos
 * de departamentos
 */
public class DtoDepartamento {
    
    private String nombre;
    private ArrayList<DtoMunicipio> municipios;

    public DtoDepartamento(String nombre) {
        this.nombre = nombre;
        this.municipios=new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<DtoMunicipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(ArrayList<DtoMunicipio> municipios) {
        this.municipios = municipios;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DtoDepartamento other = (DtoDepartamento) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
