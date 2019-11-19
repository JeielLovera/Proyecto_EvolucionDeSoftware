document.addEventListener("DOMContentLoaded", inicializarVariables, false);

var numFamiliares = 0;
var numEnfermedades = [];
var maxUsuario;
var auxFamRegistrados = 0;

function inicializarVariables(){
    agregarFrmFamiliar();
    getLastUsuario();
}

function getLastUsuario(){

    ruta = 'http://localhost:8081/usuarios';

    axios.get(ruta)
    .then(data => {
        maxUsuario = data.data[data.data.length-1].cusuario;
        console.log(maxUsuario);
    })
}

function agregarFrmFamiliar(){
    var FrmFamiliar = document.getElementById('frmFamiliar');
    numFamiliares++;
    numEnfermedades.push(0);

    FrmFamiliar.insertAdjacentHTML("beforeend", `
    </br>
    <div class="body">
        <div class="row clearfix">  
            <div class="col-md-3">Nombre del Familiar</div>
        </div>
        <div class="row clearfix"> 
            <div class="col-sm-8">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Nombre del Familiar" id="nombreUsuario${numFamiliares}">
                </div>
            </div>
        </div>
        </br>
        <div class="row clearfix">  
            <div class="col-md-3">Documento de Identificación del Familiar</div>
        </div>
        <div class="row clearfix"> 
            <div class="col-sm-8">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Ejm. 56478541" id="dniUsuario${numFamiliares}">
                </div>
            </div>
        </div>
        </br>
        <div class="row clearfix">  
            <div class="col-md-3">Fecha de Nacimiento del Familiar</div>
        </div>
        <div class="row clearfix"> 
            <div class="col-sm-8">
                <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="zmdi zmdi-calendar"></i></span>
                        </div>
                        <input type="date" class="form-control date" id="fnacimientousuario${numFamiliares}">
                </div>
            </div>
        </div>
        <div class="row clearfix">  
            <div class="col-md-3">Enfermedades</div>
        </div>
        <div class="col-sm-2">                                
                <button onclick="agregarEnfermedad(${numFamiliares})" class="btn btn-primary btn-icon btn-icon-mini btn-round"> + </button>
        </div>
        <div  id="comboEnfermedades${numFamiliares}">

        </div>
    </div>
    `)

    agregarEnfermedad(numFamiliares);
}

function agregarEnfermedad(Familiar){
    var FrmEnfermedad = document.getElementById('comboEnfermedades'+Familiar);
    numEnfermedades[Familiar-1]++;

    FrmEnfermedad.insertAdjacentHTML("beforeend", `
    </br>
    <div class="row">
        <div class="col-sm-8">
            <select class="form-control show-tick" id="enfermedadUsuario${Familiar}Enfermedad${numEnfermedades[Familiar-1]}">
                <option value="">Seleccione una Enfermedad</option>
                <option value="1">Alzheimer</option>
                <option value="2">Parkinson</option>
                <option value="3">Artritis</option>
                <option value="4">Hipertension Arterial</option>
                <option value="5">Diabetes</option>
                <option value="6">Desnutricion</option>
                <option value="7">Hipertrofia de Prostata</option>
                <option value="8">Osteoporosis</option>
                <option value="9">Infarto</option>
                <option value="10">Accidente Cerebro Vascular (ICTUS)</option>
            </select>
        </div>
    </div>
    `)
}

function registrar(){
    var cbTerminos = document.getElementById('cbTerminos').checked;

    if(cbTerminos)
    {
        //Datos personales
        var nombreCliente = document.getElementById('nombreCliente').value;
        var dniCliente = document.getElementById('dniCliente').value;
        var telefonoCliente = document.getElementById('telefonoCliente').value;

        //Datos de sistema
        var usuarioCliente = document.getElementById('usuarioCliente').value;
        var contraseniaCliente = document.getElementById('contraseniaCliente').value;

        var rutaPOSTCliente = 'http://localhost:8081/clientes';

        //Insertar del Cliente
        axios({
            method:'post',
            url:rutaPOSTCliente,
            data:{
                ncliente: nombreCliente,
                tdnicliente: dniCliente,
                ttelefono: telefonoCliente,
                tcorreo: usuarioCliente,
                tcontrasenya: contraseniaCliente,
            }
        }).then(data => {

            //familiares
            var nombreUsuario;
            var dniUsuario;
            var fnacimientousuario;
            var cliente = [];

            var rutaGETCliente = 'http://localhost:8081/clientes';

            //Se obtiene el último cliente ingresado
            axios.get(rutaGETCliente)
            .then(data => {
                for(var i = 1; i <= numFamiliares; i++)
                {
                    nombreUsuario = document.getElementById('nombreUsuario'+i).value;
                    dniUsuario = document.getElementById('dniUsuario'+i).value;
                    fnacimientousuario = document.getElementById('fnacimientousuario'+i).value;

                    var rutaPOSTUsuario = 'http://localhost:8081/usuarios';

                    cliente = data.data[data.data.length - 1];

                    localStorage.setItem("idCliente",cliente.ccliente); 
                    localStorage.setItem("nombreCliente", cliente.ncliente);

                    //Insertar del Usuario
                    axios({
                        method:'post',
                        url:rutaPOSTUsuario,
                        data:{
                            nusuario: nombreUsuario,
                            tdniusuario: dniUsuario,
                            dnacimiento: fnacimientousuario,
                            ccliente: cliente,
                        }
                    }).then(data => {
                        auxFamRegistrados++;
                        if(auxFamRegistrados == numFamiliares)
                        {
                            insertarEnfermedad();
                        }
                    }).catch(function(error) {
                        console.log(error);
                    });

                }
            })
            .catch(function(error) {
                console.log(error);
            })
        }).catch(function(error) {
            console.log(error);
        });
        
    }
    else{
        alert('Acepte los términos y condiciones');
    }
}

function insertarEnfermedad(){
    //enfermedades
    var idEnfermedad;
    var idUsuario;

    for(var i = 1; i <= numFamiliares; i++)
    {
        for(var j = 1; j <= numEnfermedades[i-1]; j++)
        {
            idEnfermedad = document.getElementById('enfermedadUsuario'+i+'Enfermedad'+j).value;
            idUsuario = Number(maxUsuario) + Number(i);

            var rutaPOSTEnfermedad = 'http://localhost:8081/usuarioEnfermedades';
        
            console.log(idEnfermedad);
            console.log(idUsuario);

        
            //Insertar del Usuario
            axios({
                method:'post',
                url:rutaPOSTEnfermedad,
                data:{
                    cusuario: { 
                        cusuario: Number(idUsuario),
                    },
                    cenfermedad: {
                        cenfermedad: Number(idEnfermedad),
                    }
                }
            }).then(data => {
                window.location="./index.html";
            }).catch(function(error) {
                console.log(error);
            });
        }
    }
    
            
}

function volverSignIn() {
    window.location="./sign-in.html";
}