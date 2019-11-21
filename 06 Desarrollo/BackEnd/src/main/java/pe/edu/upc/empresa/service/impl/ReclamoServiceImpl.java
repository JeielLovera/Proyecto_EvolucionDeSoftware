package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.Reclamo;
import pe.edu.upc.empresa.model.repository.ReclamoRepository;
import pe.edu.upc.empresa.service.ReclamoService;

@Service
public class ReclamoServiceImpl implements ReclamoService {

	@Autowired
	private ReclamoRepository reclamoRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Reclamo> findAll() throws Exception {
		return reclamoRepo.findAll();
	}

	@Transactional
	@Override
	public Reclamo save(Reclamo t) throws Exception {
		return reclamoRepo.save(t);
	}

	@Transactional
	@Override
	public Reclamo update(Reclamo t) throws Exception {
		return reclamoRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Reclamo> findById(Integer id) throws Exception {
		return reclamoRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		reclamoRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		reclamoRepo.deleteAll();
	}

}
