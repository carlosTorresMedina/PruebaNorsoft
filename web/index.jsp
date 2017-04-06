<%-- 
    Document   : index
    Created on : 02-jul-2016, 21:06:38
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  if(session.getAttribute("sesion") != null){
        response.sendRedirect("registrarpersona.jsp");
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
        <title>login</title>
    </head>
    <body>
        <section>
            <div class="container well" id="sha">
                <div class="row">
                    <div class="col-xs-12">
                        <img src="img/home.png" class="img-responsive" id="avatar">
                    </div>
                </div>
                <form class="login" onSubmit="iniciarSesionQuery();
                    return false">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="usuario" name="user" id="user" required autofocus>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="contraseña" id="password" required>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">iniciar sesión</button>

                </form>
            </div>
            <div id="mensaje"></div>
        </section>
        <jsp:include page="incluidos/footer.jsp"/>
    </body>
</html>
