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
import pe.edu.upc.empresa.model.entity.Contrato;
import pe.edu.upc.empresa.service.ContratoService;

@RestController
@RequestMapping("/contratos")
@Api(value = "REST para contratos")
public class ContratoRestController {

	@Autowired
	private ContratoService contratoServ;
	
	@ApiOperation("Fetch all contratos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contrato>> fetchAll(){
		try {
			List<Contrato> contratos=contratoServ.findAll();
			return new ResponseEntity<List<Contrato>>(contratos,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Contrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save contrato")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Contrato contrato){
		try {
			Contrato tmp=contratoServ.save(contrato);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update contrato")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Contrato contrato){
		try {
			Optional<Contrato> buscado=contratoServ.findById(contrato.getCcontrato());
			if(buscado.isPresent()) {
				contratoServ.update(contrato);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove all contratos")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			contratoServ.deleteAll();
			return new ResponseEntity<String>("contratos eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch contrato by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contrato> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Contrato> contrato=contratoServ.findById(id);
			if(contrato.isPresent()) {
				return new ResponseEntity<Contrato>(contrato.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<Contrato>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Contrato>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove contrato by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Contrato> contrato=contratoServ.findById(id);
			if(contrato.isPresent()) {
				contratoServ.deleteById(id);
				return new ResponseEntity<String>("contrato eliminado",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
