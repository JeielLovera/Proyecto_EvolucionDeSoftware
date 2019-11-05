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
import pe.edu.upc.empresa.model.entity.Grado;
import pe.edu.upc.empresa.service.GradoService;

@RestController
@RequestMapping("/grados")
@Api(value = "REST para grados")
public class GradoRestController {

	@Autowired
	private GradoService gradoService;
	
	@ApiOperation("Recuperar todos los grados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Grado>>fetchAll()
	{
		try {
			List<Grado> grados=gradoService.findAll();
			return new ResponseEntity<List<Grado>>(grados,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Grado>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save grado")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>save(@Valid @RequestBody Grado grado)
	{
		try {
			Grado temp=gradoService.save(grado);
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
	
	@ApiOperation("Update grado")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>update(@Valid @RequestBody Grado grado)
	{
		try {
			Optional<Grado> buscado=gradoService.findById(grado.getCgrado());
			if(buscado.isPresent()) {
				gradoService.update(grado);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Remove all grados")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String>deleteAll()
	{
		try {
			gradoService.deleteAll();
			return new ResponseEntity<String>("Grados eliminados", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch grado by Id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Grado>fetchById(@PathVariable("id") Integer id)
	{
		try {
			Optional<Grado> grado=gradoService.findById(id);
			if(grado.isPresent()) {
				return new ResponseEntity<Grado>(grado.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Grado>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Grado>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove grado by Id")
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String>deleteById(@PathVariable("id") Integer id)
	{
		try {
			Optional<Grado> buscado=gradoService.findById(id);
			if(buscado.isPresent()) {
				gradoService.deleteById(id);
				return new ResponseEntity<String>("Grado remove",HttpStatus.OK);
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
