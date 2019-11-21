package pe.edu.upc.empresa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "especialidades")
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cespecialidad;
	
	@Column(name = "nespecialidad", length = 100, nullable = false)
	@NotEmpty(message = "Ingrese especialidad")
	private String nespecialidad;

	public Integer getCespecialidad() {
		return cespecialidad;
	}

	public void setCespecialidad(Integer cespecialidad) {
		this.cespecialidad = cespecialidad;
	}

	public String getNespecialidad() {
		return nespecialidad;
	}

	public void setNespecialidad(String nespecialidad) {
		this.nespecialidad = nespecialidad;
	}
	
}
