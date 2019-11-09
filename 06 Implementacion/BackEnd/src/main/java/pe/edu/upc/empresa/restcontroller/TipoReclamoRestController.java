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
import pe.edu.upc.empresa.model.entity.TipoReclamo;
import pe.edu.upc.empresa.service.TipoReclamoService;

@RestController
@RequestMapping("/tiporeclamos")
@Api(value = "REST para tipos de reclamo")
public class TipoReclamoRestController {

	@Autowired
	private TipoReclamoService tiporeclamoServ;

	@ApiOperation("Recuperar todos los tipos de reclamo")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoReclamo>>fetchAll()
	{
		try {
			List<TipoReclamo> tiporeclamo=tiporeclamoServ.findAll();
			return new ResponseEntity<List<TipoReclamo>>(tiporeclamo,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<TipoReclamo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save tipo reclamo")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>save(@Valid @RequestBody TipoReclamo tiporeclamo)
	{
		try {
			TipoReclamo temp=tiporeclamoServ.save(tiporeclamo);
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
	
	@ApiOperation("Update tipo reclamo")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>update(@Valid @RequestBody TipoReclamo tiporeclamo)
	{
		try {
			Optional<TipoReclamo> buscado=tiporeclamoServ.findById(tiporeclamo.getCtiporeclamo());
			if(buscado.isPresent()) {
				tiporeclamoServ.update(tiporeclamo);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Remove all tipo reclamo")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String>deleteAll()
	{
		try {
			tiporeclamoServ.deleteAll();
			return new ResponseEntity<String>("Tipo reclamo eliminados", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch tipo reclamo by Id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoReclamo>fetchById(@PathVariable("id") Integer id)
	{
		try {
			Optional<TipoReclamo> tiporeclamo=tiporeclamoServ.findById(id);
			if(tiporeclamo.isPresent()) {
				return new ResponseEntity<TipoReclamo>(tiporeclamo.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<TipoReclamo>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<TipoReclamo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove tipo reclamo by Id")
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String>deleteById(@PathVariable("id") Integer id)
	{
		try {
			Optional<TipoReclamo> buscado=tiporeclamoServ.findById(id);
			if(buscado.isPresent()) {
				tiporeclamoServ.deleteById(id);
				return new ResponseEntity<String>("Tipo reclamo remove",HttpStatus.OK);
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
