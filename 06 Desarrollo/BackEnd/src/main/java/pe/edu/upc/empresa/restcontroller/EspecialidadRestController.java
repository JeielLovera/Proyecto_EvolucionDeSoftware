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
import pe.edu.upc.empresa.model.entity.Especialidad;
import pe.edu.upc.empresa.service.EspecialidadService;

@RestController
@RequestMapping("/especialidades")
@Api(value = "REST para especialidades")
public class EspecialidadRestController {

	@Autowired
	private EspecialidadService especialidadServ;
	
	@ApiOperation("Recuperar todos las especialidades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Especialidad>>fetchAll()
	{
		try {
			List<Especialidad> especialidades=especialidadServ.findAll();
			return new ResponseEntity<List<Especialidad>>(especialidades,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Especialidad>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save especialidad")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>save(@Valid @RequestBody Especialidad especialidad)
	{
		try {
			Especialidad temp=especialidadServ.save(especialidad);
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
	
	@ApiOperation("Update especialidad")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>update(@Valid @RequestBody Especialidad especialidad)
	{
		try {
			Optional<Especialidad> buscado=especialidadServ.findById(especialidad.getCespecialidad());
			if(buscado.isPresent()) {
				especialidadServ.update(especialidad);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Remove all especialidades")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String>deleteAll()
	{
		try {
			especialidadServ.deleteAll();
			return new ResponseEntity<String>("Especialidades eliminadas", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch especialidad by Id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Especialidad>fetchById(@PathVariable("id") Integer id)
	{
		try {
			Optional<Especialidad> especialidad=especialidadServ.findById(id);
			if(especialidad.isPresent()) {
				return new ResponseEntity<Especialidad>(especialidad.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Especialidad>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Especialidad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove especialidad by Id")
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String>deleteById(@PathVariable("id") Integer id)
	{
		try {
			Optional<Especialidad> buscado=especialidadServ.findById(id);
			if(buscado.isPresent()) {
				especialidadServ.deleteById(id);
				return new ResponseEntity<String>("Especialidad remove",HttpStatus.OK);
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
