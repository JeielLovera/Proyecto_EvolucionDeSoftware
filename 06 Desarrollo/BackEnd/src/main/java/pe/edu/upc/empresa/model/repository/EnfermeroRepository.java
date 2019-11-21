package pe.edu.upc.empresa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.empresa.model.entity.Enfermero;

@Repository
public interface EnfermeroRepository extends JpaRepository<Enfermero, Integer> {
	
	@Query("SELECT e FROM Enfermero e, Grado g WHERE e.cgrado=g.cgrado and g.ngrado=?1")
	List<Enfermero> fetchByGrado(String ngrado);
	
	@Query("SELECT e FROM Enfermero e, EnfermeroEspecialidad ep, Especialidad sp WHERE ep.cenfermero=e.cenfermero and ep.cespecialidad=sp.cespecialidad and sp.nespecialidad=?1")
	List<Enfermero> fetchByEspecialidad(String nespecialidad);
}
