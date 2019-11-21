package pe.edu.upc.empresa.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enfermeroEspecialidades")
public class EnfermeroEspecialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cenfermero_especialidad;
	
	@ManyToOne
	@JoinColumn(name = "cenfermero", nullable = false)
	private Enfermero cenfermero;
	
	@ManyToOne
	@JoinColumn(name = "cespecialidad", nullable = false)
	private Especialidad cespecialidad;

	public Integer getCenfermero_especialidad() {
		return cenfermero_especialidad;
	}

	public void setCenfermero_especialidad(Integer cenfermero_especialidad) {
		this.cenfermero_especialidad = cenfermero_especialidad;
	}

	public Enfermero getCenfermero() {
		return cenfermero;
	}

	public void setCenfermero(Enfermero cenfermero) {
		this.cenfermero = cenfermero;
	}

	public Especialidad getCespecialidad() {
		return cespecialidad;
	}

	public void setCespecialidad(Especialidad cespecialidad) {
		this.cespecialidad = cespecialidad;
	}
	
	
}
