package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.Actividad;
import pe.edu.upc.empresa.model.repository.ActividadRepository;
import pe.edu.upc.empresa.service.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService{

	@Autowired
	private ActividadRepository actividadRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Actividad> findAll() throws Exception {
		return actividadRepo.findAll();
	}

	@Transactional
	@Override
	public Actividad save(Actividad t) throws Exception {
		return actividadRepo.save(t);
	}

	@Transactional
	@Override
	public Actividad update(Actividad t) throws Exception {
		return actividadRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Actividad> findById(Integer id) throws Exception {
		return actividadRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		actividadRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		actividadRepo.deleteAll();
	}

	@Override
	public List<Actividad> fetchByContrato(Integer ccontrato) throws Exception {
		return actividadRepo.fetchByContrato(ccontrato);
	}

}
