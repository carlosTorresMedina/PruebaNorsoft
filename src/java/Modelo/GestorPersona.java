/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Dto.DtoDepartamento;
import Dto.DtoMunicipio;
import Dto.DtoPersona;
import java.util.ArrayList;
import Util.ArchivoLeerURL;

/**
 *
 * @author carlos Esta clase tiene como funcion el manejo de la informacion de
 * los objetos DtoPersona y DtoDepartamento
 */
public class GestorPersona {

    private String usuario;
    private String password;
    private ArrayList<DtoPersona> listaPersonas;
    private ArrayList<DtoDepartamento> listaDepartamento;
    //url del archivo que contiene los departamentos y  municipios
    private static String archivoTxtDepartamentos = " http://sandbox1.ufps.edu.co/~ufps_76/Departamentos.txt";

    public GestorPersona() {
        this.usuario = "user";
        this.password = "12345";
        this.listaPersonas = new ArrayList();
        this.listaDepartamento = new ArrayList();
    }

    /**
     * valida si el usuario puede ingresar al sistema
     *
     * @param usuario
     * @param password
     * @return
     */
    public boolean iniciarSesion(String usuario, String password) {
        return (this.usuario.equals(usuario) && this.password.equals(password));
    }

    /**
     * consulta todas las personas registradas en el sistema
     *
     * @return
     */
    public ArrayList<DtoPersona> consultarPersonas() {
        return this.listaPersonas;
    }

    /**
     * registra una persona en el sistema
     *
     * @param dto
     * @return
     */
    public boolean registrarPersona(DtoPersona dto) {
        boolean rest = false;
        if (!this.listaPersonas.contains(dto)) {
            this.listaPersonas.add(dto);
            rest = true;
        }
        return rest;
    }

    /**
     * Este metodo carga los departamentos de colombia en base al documento txt
     * que esta en la web Este archivo al realizarce el split(,) esta dividido
     * en dos partes fundamentales: sub[0]: municipio sub[1]: departamento
     *
     * @throws Exception
     */
    public void cargarDepartamentos() throws Exception {

        ArchivoLeerURL file = new ArchivoLeerURL(archivoTxtDepartamentos);
        //Lee el archivo
        Object v[] = file.leerArchivo();
        DtoDepartamento dtoA = null;
        DtoDepartamento dtoN = null;
        for (Object datos : v) {
            String sub[] = datos.toString().split(",");
            dtoN = new DtoDepartamento(sub[1]);
            if (this.listaDepartamento.contains(dtoN)) {
                dtoA.getMunicipios().add(new DtoMunicipio(sub[0]));
            } else {
                dtoA = new DtoDepartamento(dtoN.getNombre());
                dtoA.getMunicipios().add(new DtoMunicipio(sub[0]));
                this.listaDepartamento.add(dtoA);
            }
        }
    }

    /**
     * este metodo lista todos los departamentos registrados en el sistema
     *
     * @return
     */
    public ArrayList<DtoDepartamento> listarDepartamento() {
        return this.listaDepartamento;
    }

    /**
     * este metodo lista todos los municipios de un determinado departamento
     *
     * @param nombreDepar
     * @return
     */
    public ArrayList<DtoMunicipio> listarMunicipio(String nombreDepar) {
        ArrayList<DtoMunicipio> lista = new ArrayList();
        for (DtoDepartamento dto : this.listaDepartamento) {
            if (dto.getNombre().equals(nombreDepar)) {
                lista = dto.getMunicipios();
                return lista;
            }
        }
        return lista;
    }

}
