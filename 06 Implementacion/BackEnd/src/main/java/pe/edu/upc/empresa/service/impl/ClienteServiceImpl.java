package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.Cliente;
import pe.edu.upc.empresa.model.repository.ClienteRepository;
import pe.edu.upc.empresa.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() throws Exception {
		return clienteRepo.findAll();
	}

	@Transactional
	@Override
	public Cliente save(Cliente t) throws Exception {
		return clienteRepo.save(t);
	}

	@Transactional
	@Override
	public Cliente update(Cliente t) throws Exception {
		return clienteRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		return clienteRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		clienteRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		clienteRepo.deleteAll();
	}

}
