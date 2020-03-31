<%-- 
    Document   : Sales
    Created on : Mar 27, 2020, 6:34:34 AM
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
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-header"><h5>Nueva Venta</h5></div>
                    <form action="controlador?menu=Sales" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="txtCodCli" value="${search.getDni()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="Buscar" class="btn btn-outline-info"><i class="fas fa-search-plus"></i></button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="cliente" value="${search.getCustomer()}" class="form-control" placeholder="Cliente" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" id="CodProd" name="txtCodProd" value="${Productos.getId()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" onclick="return ValidarForm();" value="buscar" class="btn btn-outline-info"><i class="fas fa-search-plus"></i></button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtProd" value="${Productos.getProduct()}" class="form-control" placeholder="Producto" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="number" name="txtPrecio" value="${Productos.getAmount()}" class="form-control" placeholder="S/.0.00" readonly="readonly">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="txtCantidad" value="1" class="form-control">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="txtStock" id="Stock" value="${Productos.getStock()}" class="form-control" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="accion" onclick="return ValidPeod();" value="Agregar" class="btn btn-outline-info">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-outline-success">
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto"> 
                            <label>Numero Serie</label>
                            <input type="text" value="${NumSerie}" name="numerSerie" class="form-control" readonly="readonly">
                        </div>
                        <br/>
                        <table id="table" class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="sals" items="${Lista}">
                                    <tr>
                                        <td>${sals.getItem()}</td>
                                        <td>${sals.getIdProd()}</td>
                                        <td>${sals.getDescrip()}</td>
                                        <td>${sals.getPrecio()}</td>
                                        <td>${sals.getCant()}</td>
                                        <td>${sals.getSubTot()}</td>
                                        <td class="d-flex">
                                            <input type="hidden" id="idP" value="">
                                            <a href="controlador?menu=Sales&accion=Quitar" class="btn btn-danger" style="margin-left: 10px;"><i class="fas fa-trash-alt"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="controlador?menu=Sales&accion=Generar" class="btn btn-success">Generar Venta</a>
                            <a href="controlador?menu=Sales&accion=Cancelar" class="btn btn-warning">Cancelar Venta</a>
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txtTotal" value="S/. ${TotalPag}" class="form-control" readonly="readonly">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="Includes/js/jquery-3.4.1.min.js" type="text/javascript"></script>
    <script src="Includes/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="Includes/js/custom.js" type="text/javascript"></script>
</body>
</html>
