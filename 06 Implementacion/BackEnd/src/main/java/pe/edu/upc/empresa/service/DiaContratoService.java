package pe.edu.upc.empresa.service;

import java.util.List;

import pe.edu.upc.empresa.model.entity.DiaContrato;

public interface DiaContratoService extends CrudService<DiaContrato, Integer> {
	List<DiaContrato> fetchByCliente(Integer ccliente) throws Exception;
}
