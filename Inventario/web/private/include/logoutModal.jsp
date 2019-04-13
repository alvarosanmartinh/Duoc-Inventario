<%-- 
    Document   : logoutModal
    Created on : 12-04-2019, 20:08:12
    Author     : Alvaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Cerrar sesión</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">X</span>
                </button>
            </div>
            <div class="modal-body">Está a punto de cerrar sesión, ¿ está seguro ?</div>
            <div class="modal-footer">
                <form method="POST" action="${pageContext.request.contextPath}/logoutServlet">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">No, volver</button>
                    <button type="submit" class="btn btn-primary">Cerrar sesión</button>
                </form>
            </div>
        </div>
    </div>
</div>
