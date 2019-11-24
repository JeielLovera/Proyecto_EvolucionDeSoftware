document.addEventListener("DOMContentLoaded", limpiarMemoria, false);

var vieneAContratar = false;

function limpiarMemoria() {
    if(localStorage.getItem("enfermeroSeleccionado") != null)
    {
        vieneAContratar = true;
        var enfermero =  localStorage.getItem("enfermeroSeleccionado");
        localStorage.clear();
        localStorage.setItem("enfermeroSeleccionado", enfermero);
    }
    else
    {
        localStorage.clear();
    }
}

function loguearse() {
  var usuario = document.getElementById('usuario').value;
  var contraseña = document.getElementById('contraseña').value;

  var ruta = 'http://localhost:8081/clientes/'+usuario+'/'+contraseña;

  fetch(ruta)
    .then(res => res.json())
    .then(datos => {
        for(let valor of datos)
        {
            localStorage.setItem("idCliente",Number(valor.ccliente)); 
            localStorage.setItem("nombreCliente", valor.ncliente);
            if(vieneAContratar) window.location="./index.html";
            else window.location="./index.html";
        }
    })
    .catch(function(error)
    {
        console.log(error);
        alert('Usuario o contraseña incorrecta');
    });    
}