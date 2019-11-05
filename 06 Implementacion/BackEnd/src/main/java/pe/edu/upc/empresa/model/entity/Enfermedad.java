package pe.edu.upc.empresa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "enfermedades")
public class Enfermedad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cenfermedad;
	
	@NotEmpty(message = "Ingrese enfermedad")
	@Column(name="nenfermedad", length = 100, nullable = false)
	private String nenfermedad;
	
	@NotEmpty(message = "Ingrese descripcion")
	@Column(name = "tdescripcion", length = 300, nullable = false)
	private String tdescripcion;

	public Integer getCenfermedad() {
		return cenfermedad;
	}

	public void setCenfermedad(Integer cenfermedad) {
		this.cenfermedad = cenfermedad;
	}

	public String getNenfermedad() {
		return nenfermedad;
	}

	public void setNenfermedad(String nenfermedad) {
		this.nenfermedad = nenfermedad;
	}

	public String getTdescripcion() {
		return tdescripcion;
	}

	public void setTdescripcion(String tdescripcion) {
		this.tdescripcion = tdescripcion;
	}
	
}
