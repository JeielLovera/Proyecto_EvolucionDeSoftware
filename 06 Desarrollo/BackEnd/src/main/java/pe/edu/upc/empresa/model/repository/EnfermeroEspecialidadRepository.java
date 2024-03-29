package pe.edu.upc.empresa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.empresa.model.entity.Enfermero;
import pe.edu.upc.empresa.model.entity.EnfermeroEspecialidad;

@Repository
public interface EnfermeroEspecialidadRepository extends JpaRepository<EnfermeroEspecialidad, Integer> {
	
	List<EnfermeroEspecialidad> findByCenfermero(Enfermero cenfermero);
}
