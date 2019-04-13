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
