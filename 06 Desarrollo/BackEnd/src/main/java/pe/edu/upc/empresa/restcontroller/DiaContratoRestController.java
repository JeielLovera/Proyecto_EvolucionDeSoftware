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
import pe.edu.upc.empresa.model.entity.DiaContrato;
import pe.edu.upc.empresa.service.DiaContratoService;

@RestController
@RequestMapping("/diacontratos")
@Api(value = "REST para diacontratos")
public class DiaContratoRestController {

	@Autowired
	private DiaContratoService diacontratoServ;
	
	@ApiOperation("Recuperar todos los diacontratos")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DiaContrato>>fetchAll()
	{
		try {
			List<DiaContrato> diacontratos=diacontratoServ.findAll();
			return new ResponseEntity<List<DiaContrato>>(diacontratos,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<DiaContrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Recuperar todos los diacontratos por cliente")
	@GetMapping(value = "/cliente/{ccliente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DiaContrato>>fetchByContrato(@PathVariable("ccliente") Integer ccliente)
	{
		try {
			List<DiaContrato> diacontratos=diacontratoServ.fetchByCliente(ccliente);
			if(diacontratos.size() > 0)
				return new ResponseEntity<List<DiaContrato>>(diacontratos,HttpStatus.OK);
			else
				return new ResponseEntity<List<DiaContrato>>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<List<DiaContrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save diacontrato")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>save(@Valid @RequestBody DiaContrato diacontrato)
	{
		try {
			DiaContrato temp=diacontratoServ.save(diacontrato);
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
	
	@ApiOperation("Update diacontrato")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>update(@Valid @RequestBody DiaContrato diacontrato)
	{
		try {
			Optional<DiaContrato> buscado=diacontratoServ.findById(diacontrato.getCdiacontrato());
			if(buscado.isPresent()) {
				diacontratoServ.update(diacontrato);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@ApiOperation("Remove all diacontratos")
	@DeleteMapping(produces = "text/plain")
	public ResponseEntity<String>deleteAll()
	{
		try {
			diacontratoServ.deleteAll();
			return new ResponseEntity<String>("Dia Contratos eliminados", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch diacontrato by Id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DiaContrato>fetchById(@PathVariable("id") Integer id)
	{
		try {
			Optional<DiaContrato> diacontrato=diacontratoServ.findById(id);
			if(diacontrato.isPresent()) {
				return new ResponseEntity<DiaContrato>(diacontrato.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<DiaContrato>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<DiaContrato>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove diacontrato by Id")
	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public ResponseEntity<String>deleteById(@PathVariable("id") Integer id)
	{
		try {
			Optional<DiaContrato> buscado=diacontratoServ.findById(id);
			if(buscado.isPresent()) {
				diacontratoServ.deleteById(id);
				return new ResponseEntity<String>("DiaContrato remove",HttpStatus.OK);
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
