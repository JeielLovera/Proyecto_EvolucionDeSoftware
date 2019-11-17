package pe.edu.upc.empresa.service;

import java.util.List;

import pe.edu.upc.empresa.model.entity.Enfermero;
import pe.edu.upc.empresa.model.entity.EnfermeroEspecialidad;

public interface EnfermeroEspecialidadService extends CrudService<EnfermeroEspecialidad, Integer> {
	List<EnfermeroEspecialidad> findByCenfermero(Enfermero cenfermero) throws Exception; 
}
