document.addEventListener("DOMContentLoaded", inicializar, false);

var lista=document.getElementById("listaEnfermeros");
var posibleSeleccionado;

function inicializar() {
    ocultarOpciones();
    listar_enfermeros();
}

function ocultarOpciones() {
    var listaOpciones = document.getElementById("opcionesInvitado");
    var cliente = localStorage.getItem("nombreCliente");

    if(cliente == null)
    {
        listaOpciones.hidden = true;
    }
}

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
                                <img src="${enfermero.imgurl}" class="img-fluid cp_img" />
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
        console.log(localStorage.getItem("idCliente"));
}

function buscar_porgrado(grado){
    var ruta='http://localhost:8081/enfermeros/grados/'+grado;
    lista.innerHTML='';

    fetch(ruta)
        .then(res=>res.json())
        .then(enfermeros => {
            for(let enfermero of enfermeros){
                lista.innerHTML+=`
                    <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
                        <div class="card">
                            <div class="body product_item">
                                <img src="${enfermero.imgurl}" class="img-fluid cp_img" />
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

function buscar_porespecialidad(especialidad){
    var ruta='http://localhost:8081/enfermeros/especialidades/'+especialidad;
    lista.innerHTML='';

    fetch(ruta)
        .then(res=>res.json())
        .then(enfermeros => {
            for(let enfermero of enfermeros){
                lista.innerHTML+=`
                    <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
                        <div class="card">
                            <div class="body product_item">
                                <img src="${enfermero.imgurl}" class="img-fluid cp_img" />
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

function detalle_enfermero(id){
    var ruta = 'http://localhost:8081/enfermeros/'+id;
    var ruta2= 'http://localhost:8081/enfermeroEspecialidades/enfermero/'+id;

    var nombre=document.getElementById("nombreModal");
    var descripcion=document.getElementById("descripcionModal");
    var especialidades=document.getElementById("especialidadesModal");
    var img=document.getElementById("imgModal");

    nombre.innerHTML='';
    descripcion.innerHTML='';
    especialidades.innerHTML='';
    img.innerHTML='';
     
    fetch(ruta)
        .then(res => res.json())
        .then(enfermero => {
            nombre.innerHTML+=`${enfermero.nenfermero}, ${enfermero.cgrado.ngrado}.`;
            descripcion.innerHTML+=`${enfermero.tdescripcion}`;  
            posibleSeleccionado=Number(enfermero.cenfermero);
            img.innerHTML+=`<img src="${enfermero.imgurl}" class="img-fluid"/>`;
            console.log(posibleSeleccionado);
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
    localStorage.setItem("enfermeroSeleccionado",posibleSeleccionado);
    var cliente = localStorage.getItem("nombreCliente");

    if(cliente == null)
    {
        window.location="./sign-in.html";
    }
    else
    {
        window.location="./contrato-registrar.html";
    }
}

function find_codigo(num,arr){
    for(var i=0;i<arr.length;i++){
        if(arr[i]==num) return true;
    }
    return false;
}

function buscar_personalizado(){
    var ruta = 'http://localhost:8081/enfermeroEspecialidades';
    var condicion=document.getElementById('busqueda').value;
    var codigo=[0];
    lista.innerHTML='';

    fetch(ruta)
        .then(res=>res.json())
        .then(datos => {
            for(let ef  of datos){
                var nombre=ef.cenfermero.nenfermero;
                var grado=ef.cenfermero.cgrado.ngrado;
                var especialidad=ef.cespecialidad.nespecialidad;
                if(!find_codigo(ef.cenfermero.cenfermero,codigo)){
                    if(nombre.toLowerCase().indexOf(condicion.toLowerCase())!=-1 ||
                        grado.toLowerCase().indexOf(condicion.toLowerCase())!=-1 ||
                        especialidad.toLowerCase().indexOf(condicion.toLowerCase())!=-1){
                            lista.innerHTML+=`
                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
                                <div class="card">
                                    <div class="body product_item">
                                        <img src="${ef.cenfermero.imgurl}" class="img-fluid cp_img" />
                                        <div>
                                            <h5></h5>
                                        </div>
                                        <div class="row justify-content-md-center">
                                            <h6>${ef.cenfermero.nenfermero}<h6>                              
                                        </div>
                                        <div class="row justify-content-md-center">
                                            <span class="m-l-10">
                                                ${ef.cenfermero.numvaloracion}
                                                <i class="zmdi zmdi-star col-amber"></i>
                                            </span>
                                        </div>
                                        <div class="row justify-content-md-center">
                                            <button type="button" class="btn btn-primary waves-effect" data-toggle="modal" data-target=#enfermeroModal onclick=detalle_enfermero(${ef.cenfermero.cenfermero})>VER DETALLES</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        `;
                        codigo.push(ef.cenfermero.cenfermero);
                    }
                    
                }
            }
        })
        .catch(function(error){
            console.log(error);
        });

    
    //AUN EN DESARROLLO >.O
}

$('#busqueda').keypress(function(e){
    var k=(e.keyCode ? e.keyCode : e.which);
    if(k=='13'){
        buscar_personalizado();
    }
});
