package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.Grado;
import pe.edu.upc.empresa.model.repository.GradoRepository;
import pe.edu.upc.empresa.service.GradoService;

@Service
public class GradoServiceImpl implements GradoService{

	@Autowired
	private GradoRepository gradoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Grado> findAll() throws Exception {
		return gradoRepository.findAll();
	}

	@Transactional
	@Override
	public Grado save(Grado t) throws Exception {
		return gradoRepository.save(t);
	}

	@Transactional
	@Override
	public Grado update(Grado t) throws Exception {
		return gradoRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Grado> findById(Integer id) throws Exception {
		return gradoRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		gradoRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		gradoRepository.deleteAll();
	}

}
