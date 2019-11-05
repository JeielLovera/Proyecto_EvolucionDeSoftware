package pe.edu.upc.empresa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.empresa.model.entity.TipoActividad;
import pe.edu.upc.empresa.model.repository.TipoActividadRepository;
import pe.edu.upc.empresa.service.TipoActividadService;

@Service
public class TipoActividadServiceImpl implements TipoActividadService {

	@Autowired
	private TipoActividadRepository tipoactiRepo;
	
	@Override
	public List<TipoActividad> findAll() throws Exception {
		return tipoactiRepo.findAll();
	}

	@Override
	public TipoActividad save(TipoActividad t) throws Exception {
		return tipoactiRepo.save(t);
	}

	@Override
	public TipoActividad update(TipoActividad t) throws Exception {
		return tipoactiRepo.save(t);
	}

	@Override
	public Optional<TipoActividad> findById(Integer id) throws Exception {
		return tipoactiRepo.findById(id);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		tipoactiRepo.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		tipoactiRepo.deleteAll();
	}

}
