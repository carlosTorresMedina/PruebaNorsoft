/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author carlos
 * Esta clase tiene como funcion ser el objeto de transferencia de datos
 * de municipios
 */
public class DtoMunicipio {
  private String nombre;
  
    public DtoMunicipio(String nombre) {
        this.nombre = nombre;
    }
  
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
  
}
