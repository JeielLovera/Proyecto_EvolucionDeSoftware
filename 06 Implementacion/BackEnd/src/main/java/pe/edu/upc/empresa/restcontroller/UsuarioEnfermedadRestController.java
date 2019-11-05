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
import pe.edu.upc.empresa.model.entity.UsuarioEnfermedad;
import pe.edu.upc.empresa.service.UsuarioEnfermedadService;

@RestController
@RequestMapping("/usuarioEnfermedades")
@Api(value = "REST para usuarioEnfermedades")
public class UsuarioEnfermedadRestController {

	@Autowired
	private UsuarioEnfermedadService usuarioEnferServ;	
	
	@ApiOperation("Fetch all usuarioEnfermedades")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioEnfermedad>> fetchAll(){
		try {
			List<UsuarioEnfermedad> usuaEnfermedades=usuarioEnferServ.findAll();
			return new ResponseEntity<List<UsuarioEnfermedad>>(usuaEnfermedades,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<UsuarioEnfermedad>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save usuarioEnfermedad")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody UsuarioEnfermedad usuaEnfer){
		try {
			UsuarioEnfermedad tmp=usuarioEnferServ.save(usuaEnfer);
			if(tmp!=null) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update usuarioEnfermedad")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody UsuarioEnfermedad usuaEnfer){
		try {
			Optional<UsuarioEnfermedad> buscado=usuarioEnferServ.findById(usuaEnfer.getCusuario_enfermedad());
			if(buscado.isPresent()) {
				usuarioEnferServ.update(usuaEnfer);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove all usuarioEnfermedades")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String> deleteAll(){
		try {
			usuarioEnferServ.deleteAll();
			return new ResponseEntity<String>("usuarioEnfermedades elimiandas", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch usuarioEnfermedad by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioEnfermedad> fetchById(@PathVariable("id") Integer id){
		try {
			Optional<UsuarioEnfermedad> usuaEnfer=usuarioEnferServ.findById(id);
			if(usuaEnfer.isPresent()) {
				return new ResponseEntity<UsuarioEnfermedad>(usuaEnfer.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<UsuarioEnfermedad>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<UsuarioEnfermedad>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove usuarioEnfermedad by id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		try {
			Optional<UsuarioEnfermedad> usuaEnfer=usuarioEnferServ.findById(id);
			if(usuaEnfer.isPresent()) {
				usuarioEnferServ.deleteById(id);
				return new ResponseEntity<String>("usuarioEnfermedad eliminada",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
