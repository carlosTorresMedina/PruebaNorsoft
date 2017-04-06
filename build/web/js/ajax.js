/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function iniciarSesionQuery() {
    user = $("#user").val();
    password = $("#password").val();
    $.ajax({
        url: 'controlador',
        type: 'POST',
        data: {iniciarSesion: "true", usuario: user, contra: password}
    }).done(function (sub) {

        if ((sub.indexOf('exito') >= 0)) {
            window.location = 'registrarpersona.jsp';
        } else {
            $("div").remove("#mensajeAlerta");
            $('#mensaje').append("<div id='mensajeAlerta' class='alert alert-warning login titulo '>" +
                    sub + "</div>");

        }

    });

}

function cargarTablaPersona() {
    $.ajax({
        url: 'controlador',
        type: 'POST',
        data: {consultarPersona: "true"},
        dataType:'JSON'
    }).done(function (sub) {

        $("#tabla tbody tr").remove();
        for (i = 0; i < sub.length; i++) {
            $('#tabla tbody ').append("<tr ><td>" + sub[i]['nombre']+" "  + sub[i]['apellido']+ "</td><td>"
                    + sub[i]['estadoCivil'] + "</td><td>" 
                    + sub[i]['fecha'] + "</td><td>"
                    + sub[i]['sueldo'] + "</td><td>" 
                    + sub[i]['correo'] + "</td><td>" 
                    + sub[i]['departamento'] + "</td><td>"
                    + sub[i]['ciudad'] + "</td></tr>");

        }

    });
}

function registrarPersona() {
    nombrev = $("#nombre").val();
    apellidov = $("#apellido").val();
    estadov = $("#estado").val();
    fechav = $("#fecha").val();
    sueldov = $("#sueldo").val();
    correov = $("#email").val();
    departamentosv = $("#departamentos").val();
    ciudadesv = $("#ciudades").val();

    $.ajax({
        url: 'controlador',
        type: 'POST',
        data: {registrarPersona: "true", nombre: nombrev, apellido: apellidov, estado: estadov,
            fecha: fechav, sueldo: sueldov, email: correov, departamento: departamentosv, ciudad: ciudadesv}
    }).done(function (sub) {

        if ((sub.indexOf('exito')) >= 0) {
            $('#registro')[0].reset();
            $("div").remove("#mensajeAlerta");
            $('#mensaje').append("<div id='mensajeAlerta' class='alert alert-warning  titulo '>" +
                    "Registro exitoso </div>");
        } else {
            $("div").remove("#mensajeAlerta");
            $('#mensaje').append("<div id='mensajeAlerta' class='alert alert-warning  titulo '>" +
                    sub + " </div>");

        }
    });

}


function cargarComboDepartamento() {
    $.ajax({
        url: 'controlador',
        type: 'POST',
        data: {cargarDepartamento: 'true'},
        datType: 'JSON'
    }).done(function (sub) {
        $("option").remove("#seleccionar2");
        $("#departamentos").append("<option id='seleccionar2' value='SELECCIONAR'>SELECCIONAR</option>")
        for (i = 0; i < sub.length; i++) {
            $("option").remove("#" + sub[i]['nombre']);
            $('#departamentos').append("<option id='" + sub[i]['nombre'] + "' value='" + sub[i]['nombre'] + "'>" + sub[i]['nombre'] + "</option>");
        }

    });
}

function cargarComboCiudades() {
    seleccionDepartamento = $('#departamentos').val();

    $.ajax({
        url: 'controlador',
        type: 'POST',
        data: {cargarCiudades: 'true', departamento: seleccionDepartamento},
        datType: 'JSON'
    }).done(function (sub) {
        $("#ciudades option").remove();
        $("option").remove("#seleccionar1");
        $("#ciudades").append("<option id='seleccionar1' value='SELECCIONAR'>SELECCIONAR</option>")
        for (i = 0; i < sub.length; i++) {
            $("option").remove("#" + sub[i]['nombre']);
            $('#ciudades').append("<option id='" + sub[i]['nombre'] + "' value='" + sub[i]['nombre'] + "'>" + sub[i]['nombre'] + "</option>");
        }

    });


}




