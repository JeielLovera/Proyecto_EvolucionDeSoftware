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
import pe.edu.upc.empresa.model.entity.Enfermedad;
import pe.edu.upc.empresa.service.EnfermedadService;

@RestController
@RequestMapping("/enfermedades")
@Api(value = "REST para enfermedades")
public class EnfermedadRestController {
	
	@Autowired
	 private EnfermedadService enfermedadServ;
	
	@ApiOperation("Fetch all enfermedades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Enfermedad>>fetchAll(){
		try {
			List<Enfermedad>enfermedades = enfermedadServ.findAll();
			return new ResponseEntity<List<Enfermedad>>(enfermedades,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Enfermedad>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save enfermedad")
	@PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Enfermedad enfermedad){
		try {
			Enfermedad tmp = enfermedadServ.save(enfermedad);
			if(tmp != null)
				return new ResponseEntity<Object>(HttpStatus.OK);
			else
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Update enfermedad")
	@PutMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Enfermedad enfermedad){
		try {
			Optional<Enfermedad>buscado = enfermedadServ.findById(enfermedad.getCenfermedad());
			if(buscado.isPresent()) {
				enfermedadServ.update(enfermedad);
				return new ResponseEntity<Object>(HttpStatus.OK);
				}
			else
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation("Remove all enfermedades")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			enfermedadServ.deleteAll();
			return new ResponseEntity<String>("enfermedades elimiandas", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch enfermedad by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Enfermedad> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Enfermedad> enfermedad=enfermedadServ.findById(id);
			if(enfermedad.isPresent()) {
				return new ResponseEntity<Enfermedad>(enfermedad.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Enfermedad>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Enfermedad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation("Remove enfermedad by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Enfermedad> enfermedad=enfermedadServ.findById(id);
			if(enfermedad.isPresent()) {
				enfermedadServ.deleteById(id);
				return new ResponseEntity<String>("enfermedad eliminada",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
