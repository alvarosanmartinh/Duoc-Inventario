function phonenumber(numero)
{
  var formato = /^\+?([0-9]{3})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;
  if((numero.value.match(formato))
        
      return true;
        
      else
        
        alert("Por favor ingresar número en formato + xxx xxxx xxxx");
        return false;
        
}