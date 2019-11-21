package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.Especialidad;
import pe.edu.upc.empresa.model.repository.EspecialidadRepository;
import pe.edu.upc.empresa.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Especialidad> findAll() throws Exception {
		return especialidadRepository.findAll();
	}

	@Transactional
	@Override
	public Especialidad save(Especialidad t) throws Exception {
		return especialidadRepository.save(t);
	}

	@Transactional
	@Override
	public Especialidad update(Especialidad t) throws Exception {
		return especialidadRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Especialidad> findById(Integer id) throws Exception {
		return especialidadRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		especialidadRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		especialidadRepository.deleteAll();
		
	}

}
