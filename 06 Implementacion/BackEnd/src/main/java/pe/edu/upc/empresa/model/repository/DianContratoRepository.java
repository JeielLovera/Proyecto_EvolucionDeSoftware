package pe.edu.upc.empresa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.empresa.model.entity.DiaContrato;

@Repository
public interface DianContratoRepository extends JpaRepository<DiaContrato, Integer> {
	@Query("SELECT d FROM DiaContrato d WHERE d.ccontrato.cusuario.ccliente.ccliente = :ccliente")
	List<DiaContrato> fetchByCliente(Integer ccliente);
}
