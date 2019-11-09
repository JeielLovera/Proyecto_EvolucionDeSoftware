package pe.edu.upc.empresa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.empresa.model.entity.Reclamo;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {

}
