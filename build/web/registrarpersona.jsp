<%-- 
    Document   : registrarpersona
    Created on : 02-jul-2016, 21:04:22
    Author     : carlos
--%>

<%@page import="Modelo.GestorPersona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  if (session.getAttribute("sesion") == null) {
        response.sendRedirect("index.jsp");
    }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/ajax.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/general.css">
        <link rel="shortcut icon" href="img/icono.ico"> 
        <title>registrar persona</title>
        <script type="text/javascript">
            cargarComboDepartamento();
        </script>
    </head>
    <body>
        <jsp:include page="incluidos/header.jsp"/>
        <section>
            <div class="panel panel-primary contenido ">
                <div class="titulo panel-heading">Registrar persona</div>
                <div class="panel-body ">
                    <div id="mensaje"></div><br>
                    <form id="registro" onSubmit="registrarPersona();
                            return false" id="form">

                        <div class="row "> 
                            <div class="col-md-1 col-lg-1"></div>
                            <div class="col-md-1 col-lg-1"><label>*Nombre:</label></div> <div class="col-md-4 col-lg-4"><input required name="nombre" id="nombre" type="text" class="form-control " placeholder="digite nombre"></div>

                            <div class="col-md-1 col-lg-1"><label>*Apellido:</label></div> <div class="col-md-4 col-lg-4"><input required name="apellido" id="apellido" type="text" class="form-control " placeholder="digite apellido"></div>
                            <div class="col-md-1 col-lg-1"></div>
                        </div><br>

                        <div class="row "> 
                            <div class="col-md-1 col-lg-1"></div>
                            <div class="col-md-1 col-lg-1"><label>*Estado civil:</label></div> <div class="col-md-4 col-lg-4">
                                <select name="estadocivil" class="form-control" id="estado" required>
                                    <option value="">SELECCIONAR</option>
                                    <option value="SOLTERO">SOLTERO</option>
                                    <option value="CASADO">CASADO</option>
                                </select>
                            </div>

                            <div class="col-md-2 col-lg-2"><label>*Fecha de nacimiento:</label></div> <div class="col-md-3 col-lg-3"><input required name="fecha" id="fecha" type="date" class="form-control "></div>
                            <div class="col-md-1 col-lg-1"></div>
                        </div><br>

                        <div class="row "> 
                            <div class="col-md-1 col-lg-1"></div>
                            <div class="col-md-1 col-lg-1"><label>*Sueldo:</label></div> <div class="col-md-4 col-lg-4"><input required name="sueldo" id="sueldo" type="number" class="form-control " placeholder="digite sueldo"></div>

                            <div class="col-md-1 col-lg-1"><label>*Correo:</label></div> <div class="col-md-4 col-lg-4"><input required name="email" id="email" type="email" class="form-control " placeholder="digite correo"></div>
                            <div class="col-md-1 col-lg-1"></div>
                        </div><br>

                        <div class="row "> 
                            <div class="col-md-1 col-lg-1"></div>
                            <div class="col-md-2 col-lg-2"><label>*Departamento:</label></div> <div class="col-md-3 col-lg-3">
                                <select name="departamentos" class="form-control" onchange="cargarComboCiudades()"  id="departamentos"  required>    

                                </select>
                            </div>

                            <div class="col-md-1 col-lg-1"><label>*Ciudad:</label></div> <div class="col-md-4 col-lg-4">
                                <select name="ciudades" class="form-control"  id="ciudades" required>
                                </select>

                            </div>
                            <div class="col-md-1 col-lg-1"></div>
                        </div><br>


                        <div class="row ">
                            <div class="col-md-5 col-lg-5"></div>
                            <div class="col-md-2 col-lg-2">
                                <button class="btn btn-lg btn-primary btn-block">
                                    Registrar
                                </button>
                            </div>

                        </div>
                </div>
                <br>
                
                <br>
                </form>

            </div>
        </section>
        <jsp:include page="incluidos/footer.jsp"/>
    </body>
</html>
