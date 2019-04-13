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

        <title>Ingreso</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">



    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

                <!--      <div class="col-xl-10 col-lg-12 col-md-9">-->
                <div class="col-sm-6">
                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <!--              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>-->
                                <div class="col-lg-6 d-none d-lg-block"></div>
                                <!--              <div class="col-lg-6 d-none d-lg-block"></div>-->
                                <div class="col-lg-12">
                                    <!--              <div class="col-lg-6">-->
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">Bienvenido !</h1>
                                        </div>
                                        <form name="frmIngreso" class="user" method="POST" action="${pageContext.request.contextPath}/loginServlet">
                                            <div class="form-group">
                                                <input type="text" required maxlength="10"  class="form-control form-control-user" id="user" name="user" placeholder="Usuario">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" required maxlength="11" class="form-control form-control-user" id="pass" name="pass" placeholder="Clave">
                                            </div>
                                            <div class="form-group">
                                                <div class="custom-control custom-checkbox small">
                                                    <input type="checkbox" class="custom-control-input" id="boolRemember" name="boolRemember">
                                                    <label class="custom-control-label" for="boolRemember">Recuérdame</label>
                                                </div>
                                            </div>
                                            <button type="submit" id="logIn" class="btn btn-primary btn-user btn-block">
                                                Enviar
                                            </button>

                                        </form>
                                            
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
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>
        <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

        <script src="js/validaciones.js"></script>
        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

    </body>

</html>
