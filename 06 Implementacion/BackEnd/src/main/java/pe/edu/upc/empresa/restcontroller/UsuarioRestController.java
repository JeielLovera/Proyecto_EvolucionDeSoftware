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
import pe.edu.upc.empresa.model.entity.Usuario;
import pe.edu.upc.empresa.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@Api(value = "REST pata usuarios")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioServ;
	
	@ApiOperation("Fetch all uusarios")
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>>fetchAll(){
		try {
			List<Usuario> usuarios = usuarioServ.findAll();
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save usuario")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>save(@Valid @RequestBody Usuario usuario){
		try {
			Usuario tmp = usuarioServ.save(usuario);
			if(tmp != null)
				return new ResponseEntity<Object>(HttpStatus.OK);
			else
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("update usuarios")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update (@Valid @RequestBody Usuario usuario){
		try {
			Optional<Usuario>buscado = usuarioServ.findById(usuario.getCusuario());
			if( buscado.isPresent()) {
				usuarioServ.update(usuario);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Remove all usuarios")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> delleteAll(){
		try {
			usuarioServ.deleteAll();
			return new ResponseEntity<String>("usuarios eliminados", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch cleinte by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<Usuario>usuario = usuarioServ.findById(id);
			if(usuario.isPresent())
				return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
			else
				return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove usuario by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String>deleteById(@PathVariable("id") Integer id){
		try {
			Optional<Usuario>usuario = usuarioServ.findById(id);
			if(usuario.isPresent())
				return new ResponseEntity<String>("usuario eliminado", HttpStatus.OK);
			else
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
