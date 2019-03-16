// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
        "language": {
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            },
            "oPaginate": {
                "sFirst":    "Primera pagina",
                "sLast":     "Última pagina",
                "sNext":     "Siguiente",
                "sPrevious": "Anterior"
            },
            "emptyTable":"No hay nada que mostrar",
            "info":"Mostrando del _START_ al _END_ de _TOTAL_",
            "infoEmpty":"No hay registros",
            "infoFiltered":"(filtrado de un total de _MAX_)",
            "infoPostFix":"",
            "decimal":",",
            "tousands":".",
            "lengthMenu":"Mostrar _MENU_ registros",
            "loadingRecords":"Cargando...",
            "processing":"Procesando...",
            "search":"Buscar:",
            "searchPlaceholder":"",
            "url":"",
            "zeroRecords":"No hay coincidencias"
        }
    });
});
