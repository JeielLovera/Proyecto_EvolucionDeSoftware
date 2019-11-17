document.addEventListener("DOMContentLoaded", listar_enfermeros, false);

var lista=document.getElementById("listaEnfermeros");

function listar_enfermeros(){
    var ruta = 'http://localhost:8081/enfermeros';

    lista.innerHTML='';

    fetch(ruta)
        .then(res=>res.json())
        .then(enfermeros => {
            for(let enfermero of enfermeros){
                lista.innerHTML+=`
                    <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
                        <div class="card">
                            <div class="body product_item">
                                <img src="assets/images/ecommerce/mona.jpg" class="img-fluid cp_img" />
                                <div>
                                    <h5></h5>
                                </div>
                                <div class="row justify-content-md-center">
                                    <h6>${enfermero.nenfermero}<h6>                              
                                </div>
                                <div class="row justify-content-md-center">
                                    <span class="m-l-10">
                                        ${enfermero.numvaloracion}
                                        <i class="zmdi zmdi-star col-amber"></i>
                                    </span>
                                </div>
                                <div class="row justify-content-md-center">
                                    <button type="button" class="btn btn-primary waves-effect" data-toggle="modal" data-target=#enfermeroModal onclick=detalle_enfermero(${enfermero.cenfermero})>VER DETALLES</button>
                                </div>
                            </div>
                        </div>
                    </div>
                `;
            }
        })
        .catch(function(error){
            console.log(error);
            
        });
}

function buscar_enfermeros(){
    
}

function detalle_enfermero(id){
    var ruta = 'http://localhost:8081/enfermeros/'+id;
    var ruta2= 'http://localhost:8081/enfermeroEspecialidades/enfermero/'+id;

    var nombre=document.getElementById("nombreModal");
    var descripcion=document.getElementById("descripcionModal");
    var especialidades=document.getElementById("especialidadesModal");

    nombre.innerHTML='';
    descripcion.innerHTML='';
    especialidades.innerHTML='';
     
    fetch(ruta)
        .then(res => res.json())
        .then(enfermero => {
            nombre.innerHTML+=`${enfermero.nenfermero}, ${enfermero.cgrado.ngrado}.`;
            descripcion.innerHTML+=`${enfermero.tdescripcion}`;  
            localStorage.setItem("enfermeroSeleccionado",Number(enfermero.cenfermero));
            console.log(localStorage.getItem("enfermeroSeleccionado"));
        })
        .catch(function(error){
            console.log(error);
        });
    
    fetch(ruta2)
        .then(res => res.json())
        .then(enfermero_especialidades => {
            for(let esp of enfermero_especialidades){
                especialidades.innerHTML+=`
                    <span class="badge badge-info">${esp.cespecialidad.nespecialidad}</span>
                `;
            }    
        })
        .catch(function(error){
            console.log(error);
        });  
}

function realizar_contrato(){
    window.location="./contrato-registrar.html";
}