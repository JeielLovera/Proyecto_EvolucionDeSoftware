package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.empresa.model.entity.TipoReclamo;
import pe.edu.upc.empresa.model.repository.TipoReclamoRepository;
import pe.edu.upc.empresa.service.TipoReclamoService;

@Service
public class TipoReclamoServiceImpl implements TipoReclamoService {

	@Autowired
	private TipoReclamoRepository tiporeclamoRepo;
	
	@Override
	public List<TipoReclamo> findAll() throws Exception {
		return tiporeclamoRepo.findAll();
	}

	@Override
	public TipoReclamo save(TipoReclamo t) throws Exception {
		return tiporeclamoRepo.save(t);
	}

	@Override
	public TipoReclamo update(TipoReclamo t) throws Exception {
		return tiporeclamoRepo.save(t);
	}

	@Override
	public Optional<TipoReclamo> findById(Integer id) throws Exception {
		return tiporeclamoRepo.findById(id);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		tiporeclamoRepo.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		tiporeclamoRepo.deleteAll();
	}

}
