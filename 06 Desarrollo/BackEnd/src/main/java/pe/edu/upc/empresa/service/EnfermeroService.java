package pe.edu.upc.empresa.service;

import java.util.List;

import pe.edu.upc.empresa.model.entity.Enfermero;

public interface EnfermeroService extends CrudService<Enfermero, Integer> {
	List<Enfermero> fetchByGrado(String ngrado) throws Exception;
	List<Enfermero> fetchByEspecialidad(String nespecialidad)throws Exception;

}
