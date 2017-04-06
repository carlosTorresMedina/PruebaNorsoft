/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dto.DtoDepartamento;
import Dto.DtoMunicipio;
import Dto.DtoPersona;
import Modelo.GestorPersona;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos esta clase tiene como funcion Responder a eventos (usualmente
 * acciones del usuario) e invoca peticiones al 'modelo' cuando se hace alguna
 * solicitud sobre la información
 */
@WebServlet(name = "Controlador", urlPatterns = {"/controlador"})
public class Controlador extends HttpServlet {

    /**
     * inicia sesion en el sistema
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            GestorPersona gestor = new GestorPersona();
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("contra");

            if (gestor.iniciarSesion(usuario, password)) {
                try {
                    gestor.cargarDepartamentos();
                    request.getSession().setAttribute("sesion", "creada");
                    request.getSession().setAttribute("gestorPersona", gestor);
                    response.getWriter().print("exito");
                } catch (Exception ex) {
                    response.getWriter().print("Existe un problema al cargar los departamentos y ciudades");
                }
            } else {
                response.getWriter().print("Usuario o contraseña invalidos");
            }

        }
    }

    /**
     * registra una persona en el sistema
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void registrarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String estado = request.getParameter("estado");
                String fecha = request.getParameter("fecha");
                String sueldo = request.getParameter("sueldo");
                String correo = request.getParameter("email");
                String departamento = request.getParameter("departamento");
                String ciudad = request.getParameter("ciudad");
                String mensaje = validarCampos(nombre, apellido, estado, fecha, sueldo, correo, departamento, ciudad);
                if (mensaje.isEmpty()) {
                    int sueldor = Integer.parseInt(sueldo);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechar = format.parse(fecha);
                    DtoPersona dto = new DtoPersona(nombre, apellido, estado, fechar, sueldor, correo, departamento, ciudad);
                    GestorPersona gestor = (GestorPersona) request.getSession().getAttribute("gestorPersona");
                    boolean val = gestor.registrarPersona(dto);
                    if (val) {
                        response.getWriter().print("exito");
                    } else {
                        response.getWriter().print("Ese correo ya se encuentra registrado");
                    }
                } else {
                    response.getWriter().print(mensaje);
                }

            } catch (java.text.ParseException ex) {
                response.getWriter().print("La fecha no esta en el formato esperado");
            } catch (java.lang.NumberFormatException ex) {
                response.getWriter().print("El sueldo debe ser un valor numerico");
            }
        }
    }

    /**
     * consulta las personas registradas en el sistema
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void consultarPersona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            GestorPersona gestor = (GestorPersona) request.getSession().getAttribute("gestorPersona");
            ArrayList<DtoPersona> lista = gestor.consultarPersonas();
            JsonArray array = new JsonArray();

            for (DtoPersona dto : lista) {
                JsonObject object = new JsonObject();
                object.addProperty("nombre", dto.getNombre());
                object.addProperty("apellido", dto.getApellido());
                object.addProperty("estadoCivil", dto.getEstadoCivil());
                object.addProperty("fecha", dto.getFormatoFecha());
                object.addProperty("sueldo", dto.getFormatoSueldo());
                object.addProperty("correo", dto.getCorreo());
                object.addProperty("departamento", dto.getDepartamento());
                object.addProperty("ciudad", dto.getCiudad());
                array.add(object);
            }
            
            String listado = array.toString();
            response.getWriter().print(listado);
            /* TODO output your page here. You may use following sample code. */

        }
    }

    /**
     * lista los departamentos de colombia
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void cargarDepartamentos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            GestorPersona gestor = (GestorPersona) request.getSession().getAttribute("gestorPersona");
            ArrayList<DtoDepartamento> lista = gestor.listarDepartamento();
            Gson gson = new Gson();
            String listado = gson.toJson(lista);
            response.getWriter().print(listado);
            /* TODO output your page here. You may use following sample code. */

        }
    }

    /**
     * lista todas las ciudades que hay en un determinado municipio
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void cargarCiudades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            GestorPersona gestor = (GestorPersona) request.getSession().getAttribute("gestorPersona");
            String departamento = request.getParameter("departamento");
            ArrayList<DtoMunicipio> lista = gestor.listarMunicipio(departamento);
            Gson gson = new Gson();
            String listado = gson.toJson(lista);
            response.getWriter().print(listado);
            /* TODO output your page here. You may use following sample code. */

        }
    }

    /**
     * registra una persona en el sistema
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");

        }
    }

    /**
     * verifica que los datos sean los esperados por modelo
     *
     * @param nombre
     * @param apellido
     * @param estado
     * @param fecha
     * @param sueldo
     * @param correo
     * @param departamento
     * @param ciudad
     * @return
     */
    private String validarCampos(String nombre, String apellido, String estado, String fecha, String sueldo, String correo, String departamento, String ciudad) {
        String mensaje = "";
        if (nombre.isEmpty() || apellido.isEmpty() || estado.isEmpty() || fecha.isEmpty() || sueldo.isEmpty() || correo.isEmpty() || departamento.isEmpty() || ciudad.isEmpty()) {
            mensaje = "Debe llenar todos los campos";
        } else if (!estado.equalsIgnoreCase("SOLTERO") && !estado.equalsIgnoreCase("CASADO")) {
            mensaje = "Debe seleccionar un estado civil";
        } else if (!correo.contains("@") && correo.contains(".")) {
            mensaje = "El correo no es valido";
        } else if (departamento.equalsIgnoreCase("SELECCIONAR")) {
            mensaje = "Debe seleccionar un departamento";
        } else if (ciudad.equalsIgnoreCase("SELECCIONAR")) {
            mensaje = "Debe seleccionar una ciudad";
        }
        return mensaje;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("cerrarSesion") != null) {
            cerrarSesion(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("iniciarSesion") != null) {
            iniciarSesion(request, response);
        } else if (request.getParameter("cargarDepartamento") != null) {
            cargarDepartamentos(request, response);
        } else if (request.getParameter("cargarCiudades") != null) {
            cargarCiudades(request, response);
        } else if (request.getParameter("registrarPersona") != null) {
            registrarPersona(request, response);
        } else if (request.getParameter("consultarPersona") != null) {
            consultarPersona(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
