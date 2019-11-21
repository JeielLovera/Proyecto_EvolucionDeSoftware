document.addEventListener("DOMContentLoaded",main,false);

function main(){

}

function finalizar(){
    localStorage.removeItem("enfermeroSeleccionado");
    window.location="./index.html";
}

function volverRegistroContrato(){
    window.location="./contrato-registrar.html";
}