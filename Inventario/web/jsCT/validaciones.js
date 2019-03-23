


jQuery('#logIn').click(function(){
    var user = jQuery('#user').val();
    var pass = jQuery('#pass').val();
    if (!validaVacio(user.trim()) && !validaVacio(pass.trim())){
        alert('Todo Ok');
    }  else {
        alert('Complete todos los datos del formulario');
    }
});


function validaVacio(dato){
    var traeVacio;
    if (dato == null || dato == "" ){
        traeVacio = true;
    }else{
        traeVacio = false;
    }
    return traeVacio;
}

