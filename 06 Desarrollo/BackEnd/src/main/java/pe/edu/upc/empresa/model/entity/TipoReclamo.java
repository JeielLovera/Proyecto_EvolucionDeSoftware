package pe.edu.upc.empresa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tiporeclamos")
public class TipoReclamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ctiporeclamo;
	
	@NotEmpty(message = "Ingrese el nombre del tipo de reclamo")
	@Column(name = "ntiporeclamo", length = 500, nullable = false)
	private String ntiporeclamo;

	public Integer getCtiporeclamo() {
		return ctiporeclamo;
	}

	public void setCtiporeclamo(Integer ctiporeclamo) {
		this.ctiporeclamo = ctiporeclamo;
	}

	public String getNtiporeclamo() {
		return ntiporeclamo;
	}

	public void setNtiporeclamo(String ntiporeclamo) {
		this.ntiporeclamo = ntiporeclamo;
	}
	
	
}
