package pe.edu.upc.empresa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="grados")
public class Grado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cgrado;
	
	@Column(name = "ngrado", length = 100, nullable = false)
	@NotEmpty(message = "Ingrese grado")
	private String ngrado;

	public Integer getCgrado() {
		return cgrado;
	}

	public void setCgrado(Integer cgrado) {
		this.cgrado = cgrado;
	}

	public String getNgrado() {
		return ngrado;
	}

	public void setNgrado(String ngrado) {
		this.ngrado = ngrado;
	}
	
	
}
