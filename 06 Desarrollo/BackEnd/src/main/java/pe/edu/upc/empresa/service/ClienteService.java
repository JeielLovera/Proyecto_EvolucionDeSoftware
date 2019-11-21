package pe.edu.upc.empresa.service;

import java.util.List;

import pe.edu.upc.empresa.model.entity.Cliente;

public interface ClienteService extends CrudService<Cliente, Integer>{
	List<Cliente> fetchByLogin(String usuario, String contraseña) throws Exception;
}
