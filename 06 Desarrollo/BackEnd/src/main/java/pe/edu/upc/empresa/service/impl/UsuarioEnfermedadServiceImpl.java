package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.empresa.model.entity.UsuarioEnfermedad;
import pe.edu.upc.empresa.model.repository.UsuarioEnfermedadRepository;
import pe.edu.upc.empresa.service.UsuarioEnfermedadService;

@Service
public class UsuarioEnfermedadServiceImpl implements UsuarioEnfermedadService{

	@Autowired
	private UsuarioEnfermedadRepository usuarioEnferRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<UsuarioEnfermedad> findAll() throws Exception {
		return usuarioEnferRepo.findAll();
	}

	@Transactional
	@Override
	public UsuarioEnfermedad save(UsuarioEnfermedad t) throws Exception {
		return usuarioEnferRepo.save(t);
	}
	
	@Transactional
	@Override
	public UsuarioEnfermedad update(UsuarioEnfermedad t) throws Exception {
		return usuarioEnferRepo.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<UsuarioEnfermedad> findById(Integer id) throws Exception {
		return usuarioEnferRepo.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		usuarioEnferRepo.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		usuarioEnferRepo.deleteAll();
	}

}
