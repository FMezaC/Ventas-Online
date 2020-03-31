<%-- 
    Document   : Clientes
    Created on : Mar 27, 2020, 6:34:02 AM
    Author     : Meza
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Includes/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Includes/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-header"><h5>Nuevo Cliente</h5></div>
                <div class="card-body">
                    <form action="controlador?menu=Customer" method="POST">
                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" value="${Customer.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${Customer.getCustomer()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${Customer.getAddress()}" name="txtDireccion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${Customer.getStatus()}" name="txtEstado" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Registrar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>

            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>Nombres</th>
                            <th>Direccion</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cust" items="${Customers}">
                            <tr>
                                <td>${cust.getId()}</td>
                                <td>${cust.getDni()}</td>
                                <td>${cust.getCustomer()}</td>
                                <td>${cust.getAddress()}</td>
                                <td>${cust.getStatus()}</td>
                                <td>
                                    <a class="btn btn-warning" href="controlador?menu=Customer&accion=Edit&id=${cust.getId()}">
                                        <i class="fas fa-edit"></i></a>
                                    <a class="btn btn-danger" href="controlador?menu=Customer&accion=Delete&id=${cust.getId()}">
                                        <i class="fas fa-trash-alt"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="Includes/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="Includes/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
