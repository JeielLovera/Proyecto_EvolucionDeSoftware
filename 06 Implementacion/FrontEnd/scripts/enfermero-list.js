document.addEventListener("DOMContentLoaded", listar_enfermeros, false);

function listar_enfermeros(){
    var ruta = 'http://localhost:8081/enfermeros';

    /*fetch(ruta)
        .then(res=>res.json())
        .then(enfermeros => {

        })
        .catch(function(error){
            console.log(error);
        })*/
    var lista=document.getElementById("listaEnfermeros");
    lista.innerHTML+=`
        <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
            <div class="card">
                <div class="body product_item">
                    <img src="assets/images/ecommerce/mona.jpg" class="img-fluid cp_img" />
                    <div>
                        <h5></h5>
                    </div>
                    <div class="row justify-content-md-center">
                        <h5>Alfredo Durango</h5>                              
                    </div>
                    <div class="row justify-content-md-center">
                        <span class="m-l-10">
                            <i class="zmdi zmdi-star col-amber"></i>
                            <i class="zmdi zmdi-star col-amber"></i>
                            <i class="zmdi zmdi-star col-amber"></i>
                            <i class="zmdi zmdi-star col-amber"></i>
                            <i class="zmdi zmdi-star-outline text-muted"></i>
                        </span>
                    </div>
                    <div class="row justify-content-md-center">
                        <button type="button" class="btn btn-primary waves-effect" data-toggle="modal" data-target="#enfermeroModal">VER DETALLES</button>
                    </div>
                </div>
            </div>
        </div>
    `
}