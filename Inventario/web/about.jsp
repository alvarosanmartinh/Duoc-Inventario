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
        <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">


        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>

        <div class="site-wrap">
            <header class="site-navbar" role="banner">
                <div class="site-navbar-top">
                    <div class="container">
                        <div class="row align-items-center">


                            <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
                                <form action="" class="site-block-top-search">
                                    <a href="./private/login.jsp" class="btn btn-light">
                                        Ingresar
                                    </a>
                                </form>
                            </div>

                            <div class="col-12 mb-3 mb-md-0 col-md-4 order-2 order-md-2 text-center">
                                <div class="site-logo">
                                    <a href="index.jsp" class="js-logo-clone">Inventario</a>
                                </div>
                            </div>


                        </div>
                    </div>
                </div> 
                <nav class="site-navigation text-right text-md-center" role="navigation">
                    <div class="container">
                        <ul class="site-menu js-clone-nav d-none d-md-block">

                            <li><a href="index.jsp">Inicio</a></li>
                            <li class="active"><a href="about.jsp">Sobre nosotros</a></li>
                            <li><a href="contact.jsp">Contactanos</a></li>
                        </ul>
                    </div>
                </nav>
            </header>

            <div class="bg-light py-3">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 mb-0"><a href="index.jsp">Inicio</a> <span class="mx-2 mb-0">/</span> <strong class="text-black">Sobre nosotros</strong></div>
                    </div>
                </div>
            </div>  
            <c:if test="${error!=null}">
                <hr/>
                <div class="alert alert-danger" role="alert">
                    <c:out value="${error}"/>
                    <c:remove var="error"/>
                </div>


            </c:if>            
            <c:if test="${exito!=null}">
                <hr/>
                <div class="alert alert-success" role="alert">
                    <c:out value="${exito}"/>
                    <c:remove var="exito"/>
                </div>
            </c:if>

            <div class="site-section border-bottom" data-aos="fade">
                <div class="container">
                    <div class="row mb-5">
                        <div class="col-md-6">
                            <div class="block-16">
                                <figure>
                                    <img src="images/blog_1.jpg" alt="Image placeholder" class="img-fluid rounded">
                                    <a href="https://vimeo.com/channels/staffpicks/93951774" class="play-button popup-vimeo"><span class="ion-md-play"></span></a>

                                </figure>
                            </div>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-5">


                            <div class="site-section-heading pt-3 mb-4">
                                <h2 class="text-black">Nuestra historia</h2>
                            </div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eius repellat, dicta at laboriosam, nemo exercitationem itaque eveniet architecto cumque, deleniti commodi molestias repellendus quos sequi hic fugiat asperiores illum. Atque, in, fuga excepturi corrupti error corporis aliquam unde nostrum quas.</p>
                            <p>Accusantium dolor ratione maiores est deleniti nihil? Dignissimos est, sunt nulla illum autem in, quibusdam cumque recusandae, laudantium minima repellendus.</p>

                        </div>
                    </div>
                </div>
            </div>

            <div class="site-section border-bottom" data-aos="fade">
                <div class="container">
                    <div class="row justify-content-center mb-5">
                        <div class="col-md-7 site-section-heading text-center pt-4">
                            <h2>El equipo</h2>
                        </div>
                    </div>
                    <div class="row">

                        <div class="col-md-6 col-lg-3">
                            <div class="block-38 text-center">
                                <div class="block-38-img">
                                    <div class="block-38-header">
                                        <img src="images/person_4.jpg" alt="Image placeholder" class="mb-4">
                                        <h3 class="block-38-heading h4">-</h3>
                                        <p class="block-38-subheading">Desarrollador</p>
                                    </div>
                                    <div class="block-38-body">
                                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae aut minima nihil sit distinctio recusandae doloribus ut fugit officia voluptate soluta. </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-3">
                            <div class="block-38 text-center">
                                <div class="block-38-img">
                                    <div class="block-38-header">
                                        <img src="images/person_4.jpg" alt="Image placeholder" class="mb-4">
                                        <h3 class="block-38-heading h4">Juan</h3>
                                        <p class="block-38-subheading">Desarrollador</p>
                                    </div>
                                    <div class="block-38-body">
                                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae aut minima nihil sit distinctio recusandae doloribus ut fugit officia voluptate soluta. </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-3">
                            <div class="block-38 text-center">
                                <div class="block-38-img">
                                    <div class="block-38-header">
                                        <img src="images/person_4.jpg" alt="Image placeholder" class="mb-4">
                                        <h3 class="block-38-heading h4">Camilo</h3>
                                        <p class="block-38-subheading">Desarrollador</p>
                                    </div>
                                    <div class="block-38-body">
                                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae aut minima nihil sit distinctio recusandae doloribus ut fugit officia voluptate soluta. </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-3">
                            <div class="block-38 text-center">
                                <div class="block-38-img">
                                    <div class="block-38-header">
                                        <img src="images/person_4.jpg" alt="Image placeholder" class="mb-4">
                                        <h3 class="block-38-heading h4">Alvaro</h3>
                                        <p class="block-38-subheading">Desarrollador</p>
                                    </div>
                                    <div class="block-38-body">
                                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae aut minima nihil sit distinctio recusandae doloribus ut fugit officia voluptate soluta. </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>





            <footer class="site-footer border-top">
                <div class="container">
                    <div class="row pt-5 mt-5 text-center">
                        <div class="col-md-12">
                            <p>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" class="text-primary">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </p>
                        </div>

                    </div>
                </div>
            </footer>
        </div>

        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>

        <script src="js/main.js"></script>

    </body>
</html>