
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : Empleados
    Created on : Mar 27, 2020, 6:33:48 AM
    Author     : Meza
--%>

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
                <div class="card-header"><h5>Nuevo Empleado</h5></div>
                <div class="card-body">
                    <form action="controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" value="${Empleado.getNumDoc()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${Empleado.getEmpleyees()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${Empleado.getTelNumb()}" name="txtTelefono" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${Empleado.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${Empleado.getUser()}" name="txtUsuario" class="form-control">
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
                            <th>Telefono</th>
                            <th>Estado</th>
                            <th>Usuario</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="emp" items="${Empleados}">
                            <tr>
                                <td>${emp.getId()}</td>
                                <td>${emp.getNumDoc()}</td>
                                <td>${emp.getEmpleyees()}</td>
                                <td>${emp.getTelNumb()}</td>
                                <td>${emp.getEstado()}</td>
                                <td>${emp.getUser()}</td>
                                <td>
                                    <a class="btn btn-warning" href="controlador?menu=Empleado&accion=Editar&id=${emp.getId()}">
                                        <i class="fas fa-edit"></i></a>
                                    <a class="btn btn-danger" href="controlador?menu=Empleado&accion=Eliminar&id=${emp.getId()}">
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
