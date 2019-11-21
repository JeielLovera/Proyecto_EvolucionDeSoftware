package pe.edu.upc.empresa.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.edu.upc.empresa.model.entity.TipoActividad;
import pe.edu.upc.empresa.service.TipoActividadService;

@RestController
@RequestMapping("/tipoactividades")
@Api(value = "REST para Tipo Actividades")
public class TipoActividadRestController {

	@Autowired
	private TipoActividadService tipoactiServ;
	
	@ApiOperation("Recuperar todos los tipoactividades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoActividad>>fetchAll()
	{
		try {
			List<TipoActividad> tipoactividades=tipoactiServ.findAll();
			return new ResponseEntity<List<TipoActividad>>(tipoactividades,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<TipoActividad>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save tipoactividad")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>save(@Valid @RequestBody TipoActividad tipoactividad)
	{
		try {
			TipoActividad temp=tipoactiServ.save(tipoactividad);
			if(temp!=null)
			{
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Update tipoactividad")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>update(@Valid @RequestBody TipoActividad tipoactividad)
	{
		try {
			Optional<TipoActividad> buscado=tipoactiServ.findById(tipoactividad.getCtipoactividad());
			if(buscado.isPresent()) {
				tipoactiServ.update(tipoactividad);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Remove all tipoactividades")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String>deleteAll()
	{
		try {
			tipoactiServ.deleteAll();
			return new ResponseEntity<String>("Tipo Actividades eliminados", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch tipoactividad by Id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoActividad>fetchById(@PathVariable("id") Integer id)
	{
		try {
			Optional<TipoActividad> tipoactividad=tipoactiServ.findById(id);
			if(tipoactividad.isPresent()) {
				return new ResponseEntity<TipoActividad>(tipoactividad.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<TipoActividad>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<TipoActividad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove tipoactividad by Id")
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String>deleteById(@PathVariable("id") Integer id)
	{
		try {
			Optional<TipoActividad> buscado=tipoactiServ.findById(id);
			if(buscado.isPresent()) {
				tipoactiServ.deleteById(id);
				return new ResponseEntity<String>("TipoActividad remove",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
