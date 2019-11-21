package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.Contrato;
import pe.edu.upc.empresa.model.repository.ContratoRepository;
import pe.edu.upc.empresa.service.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService{

	@Autowired
	private ContratoRepository contratoRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Contrato> findAll() throws Exception {
		return contratoRepo.findAll();
	}

	@Transactional
	@Override
	public Contrato save(Contrato t) throws Exception {
		return contratoRepo.save(t);
	}

	@Transactional
	@Override
	public Contrato update(Contrato t) throws Exception {
		return contratoRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Contrato> findById(Integer id) throws Exception {
		return contratoRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		contratoRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		contratoRepo.deleteAll();
	}

}
