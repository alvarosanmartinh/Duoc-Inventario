<%-- 
    Document   : sidebar
    Created on : 12-04-2019, 19:27:37
    Author     : Alvaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dashboard.jsp">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-dolly"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Inventario</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">


    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Menú
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item ${pageContext.request.requestURI eq '/Inventario-MVC/private/nuevoProducto.jsp' or pageContext.request.requestURI eq '/Inventario-MVC/private/listaProducto.jsp' ? ' active' : ''}">
        <a class="nav-link 
           ${pageContext.request.requestURI eq '/Inventario-MVC/private/nuevoProducto.jsp' or pageContext.request.requestURI eq '/Inventario-MVC/private/listaProducto.jsp' ? ' uncollapsed' : ' collapsed'}
           " href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-boxes"></i>
            <span>Productos</span>
        </a>
        <div id="collapseTwo" class="collapse ${pageContext.request.requestURI eq '/Inventario-MVC/private/nuevoProducto.jsp' or pageContext.request.requestURI eq '/Inventario-MVC/private/listaProducto.jsp' ? ' show' : ''}" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Opciones:</h6>
                <a class="collapse-item  ${pageContext.request.requestURI eq '/Inventario-MVC/private/nuevoProducto.jsp' ? ' active' : ''}" href="nuevoProducto.jsp">Crear producto</a>
                <a class="collapse-item  ${pageContext.request.requestURI eq '/Inventario-MVC/private/listaProducto.jsp' ? ' active' : ''}" href="listaProducto.jsp">Ver lista</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item ${pageContext.request.requestURI eq '/Inventario-MVC/private/nuevoUsuario.jsp' or pageContext.request.requestURI eq '/Inventario-MVC/private/listaUsuario.jsp' ? ' active' : ''}">
        <a class="nav-link 
           ${pageContext.request.requestURI eq '/Inventario-MVC/private/nuevoUsuario.jsp' or pageContext.request.requestURI eq '/Inventario-MVC/private/listaUsuario.jsp' ? ' uncollapsed' : ' collapsed'}
           " href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-fw fa-user-friends"></i>
            <span>Usuarios</span>
        </a>
        <div id="collapseUtilities" class="collapse ${pageContext.request.requestURI eq '/Inventario-MVC/private/nuevoUsuario.jsp' or pageContext.request.requestURI eq '/Inventario-MVC/private/listaUsuario.jsp' ? ' show' : ''}" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Opciones:</h6>
                <a class="collapse-item ${pageContext.request.requestURI eq '/Inventario-MVC/private/nuevoUsuario.jsp' ? ' active' : ''}" href="nuevoUsuario.jsp">Crear usuario</a>
                <a class="collapse-item ${pageContext.request.requestURI eq '/Inventario-MVC/private/listaUsuario.jsp' ? ' active' : ''}" href="listaUsuario.jsp">Ver lista</a>
            </div>
        </div>
    </li>
    
    <li class="nav-item ${pageContext.request.requestURI eq '/Inventario-MVC/private/verContacto.jsp' or pageContext.request.requestURI eq '/Inventario-MVC/private/listaContacto.jsp' ? ' active' : ''}">
        <a class="nav-link " href="listaContacto.jsp">
          <i class="fas fa-fw fa-envelope"></i>
          <span>Mensajes</span></a>
      </li>

    <!-- Divider -->
    <hr class="sidebar-divider">


    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>
            
            
<!-- End of Sidebar -->
