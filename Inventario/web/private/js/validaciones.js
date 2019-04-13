jQuery('#logIn').click(function(){
    var user = jQuery('#user').val();
    var pass = jQuery('#pass').val();
    if (!user || !pass){
        alert('Complete todos los datos del formulario');
    }
});

$(function(){

  $("#contact-form").validate({
    rules:{
      nombres:{required:true, minlength:4, maxlength:40,lettersonly:true},
      apellidos:{required:true, minlength:4, maxlength:40,lettersonly:true},
      email:{required:true, email:true},
      phone:{required:true,minlength:6, maxlength:40},
      message:{required:true, minlength:4, maxlength:40}
    },
    messages:{
      nombres:{
        required:"Ingresar Nombres",lettersonly:"Solo ingrese Letras"}
    }
  });

});

function phonenumber(numero)
{
    var formato = /^\+?([5][6][9])\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;
    if(numero.value.match(formato)){        
        return true;
    }else{        
        alert("Por favor ingresar número en formato + xxx xxxx xxxx");
        return false;
    }
}

