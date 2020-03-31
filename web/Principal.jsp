<%-- 
    Document   : Principal
    Created on : Mar 26, 2020, 4:50:31 PM
    Author     : Meza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Online</title>
        <link href="Includes/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Includes/css/Owner.css" rel="stylesheet" type="text/css"/>
        <link href="Includes/fontawesome-free/css/all.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="btn btn-outline-light MenuHeader" href="controlador?menu=Home" 
                           target="myFrame"><i class="fas fa-home"></i> Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light MenuHeader" href="controlador?menu=Products&accion=List" 
                           target="myFrame"><i class="fas fa-shopping-basket"></i> Producto</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light MenuHeader" href="controlador?menu=Empleado&accion=Listar" 
                           target="myFrame"><i class="fas fa-user"></i> Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light MenuHeader" href="controlador?menu=Customer&accion=List" 
                           target="myFrame"><i class="fas fa-address-card"></i> Cliente</a>
                    </li>
                    <li class="nav-item">
                        <a class="btn btn-outline-light MenuHeader" href="controlador?menu=Sales&accion=default" 
                           target="myFrame"><i class="fas fa-cart-plus"></i> Ventas</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-outline-light dropdown-toggle MenuHeader" type="button" data-toggle="dropdown">
                    ${usuario.getEmpleyees()}
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="#" class="dropdown-item"><i class="fas fa-user-tie"></i> ${usuario.getUser()}</a></li>
                    <li><a href="#" class="dropdown-item"><i class="fas fa-cog"></i> Configuracion</a></li>
                    <div class="dropdown-divider"></div>
                    <form class="Validar" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item"><i class="fas fa-times-circle"></i> Salir</button>
                    </form>
                </ul>
            </div>
        </nav>

        <div class="m-4" style="height: 530px;">
            <iframe name="myFrame" src="Design/Home.jsp" style="width: 100%; height: 100%; border: none;"></iframe>
        </div>
        <script src="Includes/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="Includes/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="Includes/js/custom.js" type="text/javascript"></script>
    </body>
</html>
