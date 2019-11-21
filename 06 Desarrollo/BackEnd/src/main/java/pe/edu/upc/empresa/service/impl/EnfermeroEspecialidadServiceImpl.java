package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.Enfermero;
import pe.edu.upc.empresa.model.entity.EnfermeroEspecialidad;
import pe.edu.upc.empresa.model.repository.EnfermeroEspecialidadRepository;
import pe.edu.upc.empresa.service.EnfermeroEspecialidadService;

@Service
public class EnfermeroEspecialidadServiceImpl implements EnfermeroEspecialidadService {

	@Autowired
	private EnfermeroEspecialidadRepository enfermespecRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<EnfermeroEspecialidad> findAll() throws Exception {
		return enfermespecRepository.findAll();
	}

	@Transactional
	@Override
	public EnfermeroEspecialidad save(EnfermeroEspecialidad t) throws Exception {
		return enfermespecRepository.save(t);
	}

	@Transactional
	@Override
	public EnfermeroEspecialidad update(EnfermeroEspecialidad t) throws Exception {
		return enfermespecRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<EnfermeroEspecialidad> findById(Integer id) throws Exception {
		return enfermespecRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		enfermespecRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		enfermespecRepository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<EnfermeroEspecialidad> findByCenfermero(Enfermero cenfermero) throws Exception {
		return enfermespecRepository.findByCenfermero(cenfermero);
	}


}
