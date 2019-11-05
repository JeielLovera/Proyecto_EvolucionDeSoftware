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
import pe.edu.upc.empresa.model.entity.Cliente;
import pe.edu.upc.empresa.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@Api(value="REST para clientes")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteServ;
	
	@ApiOperation("Fetch all clientes")
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> fetchAll(){
		try {
			List<Cliente> clientes = clienteServ.findAll();
			return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Save cliente")
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Cliente cliente){
		try {
			Cliente tmp= clienteServ.save(cliente);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("update de cliente")
	@PutMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Cliente cliente){
		try {
			Optional<Cliente> buscado= clienteServ.findById(cliente.getCcliente());
			if(buscado.isPresent()) {
				clienteServ.update(cliente);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}			
	}
	
	@ApiOperation("Fetch cliente por id")
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Cliente> cliente = clienteServ.findById(id);
			if(cliente.isPresent())
				return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove cliente por id")
	@DeleteMapping(value= "/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Cliente> cliente= clienteServ.findById(id);
			if(cliente.isPresent()) {
				clienteServ.deleteById(id);
				return new ResponseEntity<String>("cliente eliminado",HttpStatus.OK);
			}
			else return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
