
document.addEventListener("DOMContentLoaded", InicioCarga, false);
var numServicios=1;
var numActividades=1;
var idcontrato=1;
var TotalServEnviados=0;
var lstaFamiliares={};

function CargarFamiliares(){  
  var ruta='http://localhost:8081/clientes/'+String(localStorage.getItem("idCliente"))+ '/usuarios';
  fetch(ruta)
  .then(res => res.json())
  .then(datos => {
  var contFamiliares=document.getElementById("contFamiliares");
  lstaFamiliares=datos;
    for(let dato of datos){      
      contFamiliares.innerHTML+=
      `<tr>
      <td width=50>
         <div class="radio">
          <input type="radio" name="selFamiliar" id="gg" value="${dato.cusuario}" >
            <label for="gg">
            <td  width=80><img src="assets/images/ecommerce/1.png" width="48" alt="Product img"></td>
      <td>
          <h5>${dato.nusuario}</h5>
      </td>
            </label>
          </div>
      </td>      
      </tr>`;
    }
  });  
}

function EnviarFamiliares(){
  var ruta='http://localhost:8081/diacontratos';
  var ruta2='http://localhost:8081/contratos';

  console.log($('#fechaServ0').val());
  console.log(document.getElementById("hiniServ0").value);
  console.log(document.getElementById("hfinServ0").value);
  fetch(ruta2)
  .then(res => res.json())
  .then(datos => {
    var size=datos.length;
    idcontrato=datos[size-1].ccontrato;      
    for (var i=0;i<numServicios;i++){
      var cadenafecha="#fechaServ"+String(i);
      var cadenahfin="hiniServ"+String(i);
      var cadenahini="hfinServ"+String(i);
      var fecha=$(cadenafecha).val();      
      var hfin=document.getElementById(cadenahfin).value;    
      var hini=document.getElementById(cadenahini).value;    
      hfin=fecha+"T"+hfin+":00.403Z";
      hini=fecha+"T"+hini+":00.403Z";      
      axios({
        method:'post',
        url:ruta,
        data:{
          ccontrato: {
            ccontrato: idcontrato      
          },     
          dfecha: fecha,
          dfin: hfin,
          dinicio: hini
        }
        }).then(data=>{      
          TotalServEnviados++;
          if (TotalServEnviados==numServicios)EnviarActividades();    
     }).catch(function(error) {
         console.log(error);
     });      
    }
  });
} 

function EnviarActividades(){
  var ruta='http://localhost:8081/actividades';

  for (var i=0;i<numActividades;i++){
    var cadenaTitulo="tituloAct"+String(i);
    var cadenaDescrip="descripAct"+String(i);
    var cadenatipoAct="tipoAct"+String(i);
    
    var Titulo=document.getElementById(cadenaTitulo).value;    
    var Descrip=document.getElementById(cadenaDescrip).value;    
    var tipoAct=document.getElementById(cadenatipoAct).value;     

    axios({
      method:'post',
      url:ruta,
      data:{        
        ccontrato: {
          ccontrato:idcontrato,   
        },
        ctipoactividad: {
          ctipoactividad: tipoAct,    
        },
        nactividad: Titulo,
        tdescripcion: Descrip,
      }
    }).then(data=>{       
      window.location="pagar-registrar.html";  
    }).catch(function(error) {
       console.log(error);
   });
  
  }
}




function AgregarServicios(){  
  var contServicios=document.getElementById("contServicios");  
  contServicios.insertAdjacentHTML("beforeend",` 
  <br>
<div class="col-sm-4" >
  <div class="input-group" >
      <div class="input-group-prepend">
          <span class="input-group-text"><i class="zmdi zmdi-calendar"></i></span>
      </div>
      <input type="date" class="form-control" 
          placeholder="Fecha" id="fechaServ${numServicios}">
  </div>
</div>
<div class="col-sm-4">
  <div class="input-group">
      <div class="input-group-prepend">
          <span class="input-group-text"><i class="zmdi zmdi-time"></i></span>
      </div>
      <input type="text" class="form-control" size="4" placeholder="Hora de inicio" id="hiniServ${numServicios}">
  </div>
</div>
<div class="col-sm-4">
  <div class="input-group">
      <div class="input-group-prepend">
          <span class="input-group-text"><i class="zmdi zmdi-time"></i></span>
      </div>
      <input type="text" class="form-control " placeholder="Hora fin" id="hfinServ${numServicios}">
  </div>
</div>
</br>
`);
numServicios++;
}

function AgregarActividad(){
  var contActividades=document.getElementById("contActividades");   
  contActividades.insertAdjacentHTML("beforeend",` 
  <h2 class="card-inside-title">Actividad</h2>
                          <div class="row">
                              <div class="col-md-12">
                                  <div class="form-group">
                                      <input type="text" class="form-control" placeholder="Titulo" id="tituloAct${numActividades}" />
                                  </div>
                              </div>
                          </div>
                          <div class="row">
                              <div class="col-md-12">
                                  <div class="form-group">
                                      <input type="text" class="form-control" placeholder="Descripcion" id="descripAct${numActividades}" />
                                  </div>
                              </div>
                          </div>
                          <div class="row">
                              <div class="col-sm-3">
                                  <select class="form-control show-tick" id="tipoAct${numActividades}">
                                      <option value="sinSeleccion">Seleccione Tipo</option>
                                      <option value="1">Terapia Fisica</option>
                                      <option value="2">Terapia Cognitiva</option>
                                      <option value="3">Analisis y Control</option>
                                      <option value="4">Cuidado Personal</option>
                                      <option value="5">Administracion de medicamentos y/o inyecciones</option>
                                      <option value="6">Otros</option>
                                  </select>
                              </div>
                          </div>`);
  numActividades++;
}

function AceptarContrato(){
  var aceptarContrato=document.getElementById("aceptarContrato"); 
  if (aceptarContrato.value==true){
    return "si";
  }else{
    return "no";
  }
}

function InicioCarga(){
  CargarFamiliares();

  var contServicios=document.getElementById("contServicios"); 
  contServicios.innerHTML='';
  contServicios.innerHTML+=`
  <br>
<div class="col-sm-4" >
  <div class="input-group" >
      <div class="input-group-prepend">
          <span class="input-group-text"><i class="zmdi zmdi-calendar"></i></span>
      </div>
      <input type="date" class="form-control" 
          placeholder="Fecha" id="fechaServ0">
  </div>
</div>
<div class="col-sm-4">
  <div class="input-group">
      <div class="input-group-prepend">
          <span class="input-group-text"><i class="zmdi zmdi-time"></i></span>
      </div>
      <input type="text" class="form-control" size="4" placeholder="Hora de inicio" id="hiniServ0">
  </div>
</div>
<div class="col-sm-4">
  <div class="input-group">
      <div class="input-group-prepend">
          <span class="input-group-text"><i class="zmdi zmdi-time"></i></span>
      </div>
      <input type="text" class="form-control " placeholder="Hora fin" id="hfinServ0" >
  </div>
</div>
</br>
`;

var contActividades=document.getElementById("contActividades"); 
contActividades.innerHTML='';
contActividades.innerHTML=`
<h2 class="card-inside-title">Actividad</h2>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Titulo" id="tituloAct0" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Descripcion" id="descripAct0" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <select class="form-control  show-tick" id="tipoAct0">
                                <option value="sinSeleccion">Seleccione Tipo</option>
                                <option value="1">Terapia Fisica</option>
                                <option value="2">Terapia Cognitiva</option>
                                <option value="3">Analisis y Control</option>
                                <option value="4">Cuidado Personal</option>
                                <option value="5">Administracion de medicamentos y/o inyecciones</option>
                                <option value="6">Otros</option>
                                </select>
                            </div>
                        </div>`;


}

function RegistrarContrato(){
  var aceptarContrato=document.getElementById("aceptarContrato").checked; 
  if (aceptarContrato==true){
    var direccion=document.getElementById("direccion").value; 
    var ruta='http://localhost:8081/contratos';
    var selFamiliar=document.querySelector('input[name="selFamiliar"]:checked').value;  
    axios({
      method:'post',
      url:ruta,
      data:{             
        cenfermero: {
          cenfermero:localStorage.getItem("enfermeroSeleccionado"),     
        },
        cusuario: {
          cusuario:selFamiliar,    
        },
        ffinalizado: false,
        tdireccion:direccion
      }
      }).then(data=>{      
        EnviarFamiliares();
    }).catch(function(error) {
        console.log(error);
    }); 
  }else{
    alert("Tiene que aceptar el contrato");
  }

}

function volverIndex() {
  window.location="./index.html";
}


 