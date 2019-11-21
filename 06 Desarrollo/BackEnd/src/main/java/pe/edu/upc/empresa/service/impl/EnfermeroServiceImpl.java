package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.Enfermero;
import pe.edu.upc.empresa.model.repository.EnfermeroRepository;
import pe.edu.upc.empresa.service.EnfermeroService;

@Service
public class EnfermeroServiceImpl implements EnfermeroService {

	@Autowired
	private EnfermeroRepository enfermeroRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Enfermero> findAll() throws Exception {
		return enfermeroRepository.findAll();
	}

	@Transactional
	@Override
	public Enfermero save(Enfermero t) throws Exception {
		return enfermeroRepository.save(t);
	}

	@Transactional
	@Override
	public Enfermero update(Enfermero t) throws Exception {
		return enfermeroRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Enfermero> findById(Integer id) throws Exception {
		return enfermeroRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		enfermeroRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		enfermeroRepository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Enfermero> fetchByGrado(String ngrado) throws Exception {
		return enfermeroRepository.fetchByGrado(ngrado);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Enfermero> fetchByEspecialidad(String nespecialidad) throws Exception {
		return enfermeroRepository.fetchByEspecialidad(nespecialidad);
	}

}
