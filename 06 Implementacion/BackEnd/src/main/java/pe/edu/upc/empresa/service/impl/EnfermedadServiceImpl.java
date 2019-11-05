package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.Enfermedad;
import pe.edu.upc.empresa.model.repository.EnfermedadRepository;
import pe.edu.upc.empresa.service.EnfermedadService;

@Service
public class EnfermedadServiceImpl implements EnfermedadService{

	@Autowired
	private EnfermedadRepository enfermedadRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Enfermedad> findAll() throws Exception {
		return enfermedadRepo.findAll();
	}

	@Transactional
	@Override
	public Enfermedad save(Enfermedad t) throws Exception {
		return enfermedadRepo.save(t);
	}

	@Transactional
	@Override
	public Enfermedad update(Enfermedad t) throws Exception {
		return enfermedadRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Enfermedad> findById(Integer id) throws Exception {
		return enfermedadRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		enfermedadRepo.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		enfermedadRepo.deleteAll();
	}

}
