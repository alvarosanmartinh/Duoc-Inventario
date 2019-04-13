<%-- 
    Document   : about
    Created on : 12-04-2019, 19:11:26
    Author     : Alvaro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Inventario</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <c:choose>
            <c:when test="${usuarioActivo!=null}">
        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <jsp:include page="./include/sidebar.jsp" flush="true"/>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <jsp:include page="./include/topbar.jsp" flush="true"/>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-4 text-gray-800">Nuevo Producto</h1>
                                        <c:if test="${error!=null}">
                                            <hr/>
                                            <div class="alert alert-danger" role="alert">
                                                <c:out value="${error}"/>
                                                <c:remove var="error"/>
                                            </div>

                                            <%
                                                session.invalidate();
                                            %>

                                        </c:if>            
                                        <c:if test="${exito!=null}">
                                            <hr/>
                                            <div class="alert alert-success" role="alert">
                                                <c:out value="${exito}"/>
                                                <c:remove var="exito"/>
                                            </div>
                                        </c:if>
                        <div class="row">

                            <div class="col-md-12">

                                <!-- Basic Card Example -->
                                <div class="card shadow mb-4">
                                    <div class="card-body">

                                        <form>
                                            <div class="form-group row">
                                                <label for="inputUsername" class="col-sm-2 col-form-label">Nombre del producto</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputUsername" placeholder="Ingrese un nombre para identificar el producto">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="inputCodigo" class="col-sm-2 col-form-label">Codigo del producto</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputCodigo" placeholder="Ingrese/Escanee el código único">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="inputPrecio" class="col-sm-2 col-form-label">Precio por Unidad / Kilo</label>
                                                <div class="col-sm-3">
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <div class="input-group-text">$</div>
                                                        </div>
                                                        <input type="number" class="form-control" id="inputPrecio" step="1000">
                                                    </div>
                                                </div>
                                            </div>




                                            <fieldset class="form-group">
                                                <div class="row">
                                                    <legend class="col-form-label col-sm-2 pt-0">Tipo de venta</legend>
                                                    <div class="col-sm-10">
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="radio" name="gridRadios" id="rdUnitaria" value="unitaria">
                                                            <label class="form-check-label" for="rdUnitaria">
                                                                Unitaria
                                                            </label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="radio" name="gridRadios" id="rdPorPeso" value="peso">
                                                            <label class="form-check-label" for="rdPorPeso">
                                                                Por Peso
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </fieldset>
                                            <div class="form-group row">
                                                <div class="col-sm-10">
                                                    <button type="submit" class="btn btn-success">Guardar</button>
                                                </div>
                                            </div>
                                        </form>

                                    </div>
                                </div>

                            </div>

                        </div>

                    </div>

                </div>
                <!-- End of Main Content -->

            </div>

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <jsp:include page="./include/logoutModal.jsp" flush="true"/>
        </c:when><c:otherwise>
                <c:redirect url="/private/login.jsp"/>
            </c:otherwise>
    </c:choose>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>
