<%-- 
    Document   : Productos
    Created on : Mar 27, 2020, 6:33:34 AM
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
                <div class="card-header"><h5>Nuevo Producto</h5></div>
                <div class="card-body">
                    <form action="controlador?menu=Products" method="POST">
                        <div class="form-group">
                            <label>Prducto</label>
                            <input type="text" value="${Product.getProduct()}" name="txtProduct" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${Product.getAmount()}" name="txtPrecio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" value="${Product.getStock()}" name="txtStock" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${Product.getStatus()}" name="txtEstad" class="form-control">
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
                            <th>Producto</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="prod" items="${Productos}">
                            <tr>
                                <td>${prod.getId()}</td>
                                <td>${prod.getProduct()}</td>
                                <td>${prod.getAmount()}</td>
                                <td>${prod.getStock()}</td>
                                <td>${prod.getStatus()}</td>
                                <td>
                                    <a class="btn btn-warning" href="controlador?menu=Products&accion=Edit&id=${prod.getId()}">
                                        <i class="fas fa-edit"></i></a>
                                    <a class="btn btn-danger" href="controlador?menu=Products&accion=Delete&id=${prod.getId()}">
                                        <i class="fas fa-trash-alt"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="../Includes/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="../Includes/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
