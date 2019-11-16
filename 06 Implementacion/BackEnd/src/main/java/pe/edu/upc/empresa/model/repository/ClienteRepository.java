package pe.edu.upc.empresa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.empresa.model.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Query("SELECT c FROM Cliente c WHERE c.tcorreo = :usuario and c.tcontrasenya = :contraseña")
	List<Cliente> fetchByLogin(String usuario, String contraseña);
}
