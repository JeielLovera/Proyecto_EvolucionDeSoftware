package pe.edu.upc.empresa.service;

import java.util.List;

import pe.edu.upc.empresa.model.entity.Actividad;

public interface ActividadService extends CrudService<Actividad, Integer> {
	List<Actividad> fetchByContrato(Integer ccontrato) throws Exception;
}
