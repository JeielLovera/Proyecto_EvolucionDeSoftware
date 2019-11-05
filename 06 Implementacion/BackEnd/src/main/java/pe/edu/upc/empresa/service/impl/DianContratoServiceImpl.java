package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.repository.DianContratoRepository;

import pe.edu.upc.empresa.model.entity.DiaContrato;
import pe.edu.upc.empresa.service.DiaContratoService;

@Service
public class DianContratoServiceImpl implements DiaContratoService{

	@Autowired
	private DianContratoRepository diacontratoRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<DiaContrato> findAll() throws Exception {
		return diacontratoRepo.findAll();
	}

	@Transactional
	@Override
	public DiaContrato save(DiaContrato t) throws Exception {
		return diacontratoRepo.save(t);
	}

	@Transactional
	@Override
	public DiaContrato update(DiaContrato t) throws Exception {
		return diacontratoRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<DiaContrato> findById(Integer id) throws Exception {
		return diacontratoRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		diacontratoRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		diacontratoRepo.deleteAll();
	}

}
