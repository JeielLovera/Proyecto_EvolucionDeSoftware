package pe.edu.upc.empresa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.empresa.model.entity.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Integer>{
	@Query("SELECT a FROM Actividad a WHERE a.ccontrato.ccontrato = :ccontrato")
	List<Actividad> fetchByContrato(Integer ccontrato);
}
