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
