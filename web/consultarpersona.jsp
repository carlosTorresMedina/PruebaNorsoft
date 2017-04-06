<%-- 
    Document   : consultarpersona
    Created on : 02-jul-2016, 19:41:24
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  if(session.getAttribute("sesion") == null){
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
        <title>consultar persona</title>
        <script type="text/javascript">
            cargarTablaPersona();
        </script>
    </head>
    <body>
        <jsp:include page="incluidos/header.jsp"/>
        <section>
        <div class="panel panel-primary contenido2">
            <div class="fondo panel-heading titulo">Consultar personas</div>
            <div class="panel-body">
              
                <div class="row">
                    
                    <div class="col-md-12">
                        <div class="table-responsive ">
                            <table class="table table-bordered" id="tabla">
                                <thead>
                                    <tr>
                                        <th class="centrar-texto">Nombre Completo</th>
                                        <th class="centrar-texto">Estado Civil</th>
                                        <th class="centrar-texto">Fecha Nacimiento</th>
                                        <th class="centrar-texto">Sueldo</th>
                                        <th class="centrar-texto">Correo</th>
                                        <th class="centrar-texto">Departamento</th>
                                        <th class="centrar-texto">Ciudad</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    
                </div>
          
            </div>
        </div>
            </section>
        <jsp:include page="incluidos/footer.jsp"/>
    </body>
</html>
