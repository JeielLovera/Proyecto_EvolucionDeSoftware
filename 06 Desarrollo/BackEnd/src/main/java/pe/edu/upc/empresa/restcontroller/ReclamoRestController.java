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
import pe.edu.upc.empresa.model.entity.Reclamo;
import pe.edu.upc.empresa.service.ReclamoService;

@RestController
@RequestMapping("/reclamos")
@Api(value = "REST para reclamos")
public class ReclamoRestController {

	@Autowired
	private ReclamoService reclamoServ;

	@ApiOperation("Recuperar todos los reclamos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reclamo>>fetchAll()
	{
		try {
			List<Reclamo> reclamos=reclamoServ.findAll();
			return new ResponseEntity<List<Reclamo>>(reclamos,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Reclamo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save reclamo")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>save(@Valid @RequestBody Reclamo reclamo)
	{
		try {
			Reclamo temp=reclamoServ.save(reclamo);
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
	
	@ApiOperation("Update reclamo")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>update(@Valid @RequestBody Reclamo reclamo)
	{
		try {
			Optional<Reclamo> buscado=reclamoServ.findById(reclamo.getCreclamo());
			if(buscado.isPresent()) {
				reclamoServ.update(reclamo);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Remove all reclamos")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String>deleteAll()
	{
		try {
			reclamoServ.deleteAll();
			return new ResponseEntity<String>("Reclamos eliminados", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch reclamos by Id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reclamo>fetchById(@PathVariable("id") Integer id)
	{
		try {
			Optional<Reclamo> reclamo=reclamoServ.findById(id);
			if(reclamo.isPresent()) {
				return new ResponseEntity<Reclamo>(reclamo.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Reclamo>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Reclamo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove reclamos by Id")
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String>deleteById(@PathVariable("id") Integer id)
	{
		try {
			Optional<Reclamo> buscado=reclamoServ.findById(id);
			if(buscado.isPresent()) {
				reclamoServ.deleteById(id);
				return new ResponseEntity<String>("Reclamo remove",HttpStatus.OK);
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
