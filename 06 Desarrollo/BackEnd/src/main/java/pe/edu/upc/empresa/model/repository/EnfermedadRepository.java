package pe.edu.upc.empresa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.empresa.model.entity.Enfermedad;

@Repository
public interface EnfermedadRepository extends JpaRepository<Enfermedad, Integer>{

}
