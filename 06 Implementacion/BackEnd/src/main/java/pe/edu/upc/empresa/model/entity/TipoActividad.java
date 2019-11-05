package pe.edu.upc.empresa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tipoactividades")
public class TipoActividad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ctipoactividad;
	
	@NotEmpty(message = "Ingrese tipo de actividad")
	@Column(name = "ntipoactividad", length = 100, nullable = false)
	private String ntipoactividad;

	public Integer getCtipoactividad() {
		return ctipoactividad;
	}

	public void setCtipoactividad(Integer ctipoactividad) {
		this.ctipoactividad = ctipoactividad;
	}

	public String getNtipoactividad() {
		return ntipoactividad;
	}

	public void setNtipoactividad(String ntipoactividad) {
		this.ntipoactividad = ntipoactividad;
	}
	
	
}
