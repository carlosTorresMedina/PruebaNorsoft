<%-- 
    Document   : header
    Created on : 02-jul-2016, 19:40:09
    Author     : carlos
--%>
<header>
    <nav role="navigation" class="navbar navbar-default " role="navigation">
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand">Aplicacion</a>
        </div>

        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li ><a href="registrarpersona.jsp">Registrar persona</a></li>
                <li><a href="consultarpersona.jsp">Consutlar persona</a></li>



            </ul>
            <form role="search" class="navbar-form navbar-right">
                <div class="form-group">
                  <ul class="nav navbar-nav">
                <li ><a href="controlador?cerrarSesion=true">Cerrar sesion</a></li>
                </div>
            </form>
        </div>
    </nav>
</header>


