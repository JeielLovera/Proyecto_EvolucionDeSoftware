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
import pe.edu.upc.empresa.model.entity.Enfermero;
import pe.edu.upc.empresa.service.EnfermeroService;

@RestController
@RequestMapping("/enfermeros")
@Api(value = "REST para enfermeros")
public class EnfermeroRestController {

	@Autowired
	private EnfermeroService enfermeroServ;
	
	@ApiOperation("Recuperar todos los enfermeros")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Enfermero>>fetchAll()
	{
		try {
			List<Enfermero> enfermeros=enfermeroServ.findAll();
			return new ResponseEntity<List<Enfermero>>(enfermeros,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Enfermero>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save enfermero")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>save(@Valid @RequestBody Enfermero enfermero)
	{
		try {
			Enfermero temp=enfermeroServ.save(enfermero);
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
	
	@ApiOperation("Update enfermero")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>update(@Valid @RequestBody Enfermero enfermero)
	{
		try {
			Optional<Enfermero> buscado=enfermeroServ.findById(enfermero.getCenfermero());
			if(buscado.isPresent()) {
				enfermeroServ.update(enfermero);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Remove all enfermeros")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String>deleteAll()
	{
		try {
			enfermeroServ.deleteAll();
			return new ResponseEntity<String>("Enfermeros eliminados", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch enfermero by Id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Enfermero>fetchById(@PathVariable("id") Integer id)
	{
		try {
			Optional<Enfermero> enfermero=enfermeroServ.findById(id);
			if(enfermero.isPresent()) {
				return new ResponseEntity<Enfermero>(enfermero.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Enfermero>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Enfermero>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove enfermero by Id")
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String>deleteById(@PathVariable("id") Integer id)
	{
		try {
			Optional<Enfermero> buscado=enfermeroServ.findById(id);
			if(buscado.isPresent()) {
				enfermeroServ.deleteById(id);
				return new ResponseEntity<String>("Enfermero remove",HttpStatus.OK);
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
