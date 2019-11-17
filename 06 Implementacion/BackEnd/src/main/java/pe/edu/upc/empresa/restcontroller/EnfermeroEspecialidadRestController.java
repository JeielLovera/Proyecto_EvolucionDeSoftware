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
import pe.edu.upc.empresa.model.entity.EnfermeroEspecialidad;
import pe.edu.upc.empresa.service.EnfermeroEspecialidadService;
import pe.edu.upc.empresa.service.EnfermeroService;


@RestController
@RequestMapping("/enfermeroEspecialidades")
@Api(value = "REST para EnfermeroEspecialidad")
public class EnfermeroEspecialidadRestController {

	@Autowired
	private EnfermeroEspecialidadService enfermespecServ;
	@Autowired
	private EnfermeroService enfServ;

	
	@ApiOperation("Recuperar todos los enfermeroEspecialidades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EnfermeroEspecialidad>>fetchAll()
	{
		try {
			List<EnfermeroEspecialidad> enfermeroEspecialidades=enfermespecServ.findAll();
			return new ResponseEntity<List<EnfermeroEspecialidad>>(enfermeroEspecialidades,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<EnfermeroEspecialidad>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save enfermeroEspecialidad")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>save(@Valid @RequestBody EnfermeroEspecialidad enfermeroEspecialidad)
	{
		try {
			EnfermeroEspecialidad temp=enfermespecServ.save(enfermeroEspecialidad);
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
	
	@ApiOperation("Update enfermeroEspecialidad")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>update(@Valid @RequestBody EnfermeroEspecialidad enfermeroEspecialidad)
	{
		try {
			Optional<EnfermeroEspecialidad> buscado=enfermespecServ.findById(enfermeroEspecialidad.getCenfermero_especialidad());
			if(buscado.isPresent()) {
				enfermespecServ.update(enfermeroEspecialidad);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Remove all enfermeroEspecialidades")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String>deleteAll()
	{
		try {
			enfermespecServ.deleteAll();
			return new ResponseEntity<String>("EnfermeroEspecialidades eliminados", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch enfermeroEspecialidad by Id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EnfermeroEspecialidad>fetchById(@PathVariable("id") Integer id)
	{
		try {
			Optional<EnfermeroEspecialidad> enfermero=enfermespecServ.findById(id);
			if(enfermero.isPresent()) {
				return new ResponseEntity<EnfermeroEspecialidad>(enfermero.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<EnfermeroEspecialidad>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<EnfermeroEspecialidad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove enfermeroEspecialidad by Id")
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String>deleteById(@PathVariable("id") Integer id)
	{
		try {
			Optional<EnfermeroEspecialidad> buscado=enfermespecServ.findById(id);
			if(buscado.isPresent()) {
				enfermespecServ.deleteById(id);
				return new ResponseEntity<String>("EnfermeroEspecialidad remove",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch enfermeroEspecialidad by Id enfermero")
	@GetMapping(value = "/enfermero/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EnfermeroEspecialidad>> fetchByIdEnfermero(@PathVariable("id") Integer id){
		try {
			Optional<Enfermero> ef=enfServ.findById(id);
			List<EnfermeroEspecialidad> lista=enfermespecServ.findByCenfermero(ef.get());
			if(!lista.isEmpty()) {
				return new ResponseEntity<List<EnfermeroEspecialidad>>(lista,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<EnfermeroEspecialidad>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<EnfermeroEspecialidad>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
