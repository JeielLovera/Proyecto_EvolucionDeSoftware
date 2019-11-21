package pe.edu.upc.empresa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "actividades")
public class Actividad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cactividad;
	
	@NotNull(message = "Ingrese contrato")
	@ManyToOne
	@JoinColumn(name = "ccontrato", nullable = false)
	private Contrato ccontrato;
	
	@NotNull(message = "Ingrese tipo actividad")
	@ManyToOne
	@JoinColumn(name = "ctipoactividad", nullable = false)
	private TipoActividad ctipoactividad;
	
	@NotEmpty(message = "Ingrese actividad")
	@Column(name = "nactividad", length = 100, nullable = false)
	private String nactividad;
	
	@NotEmpty(message = "Ingrese descripcion")
	@Column(name = "tdescripcion", nullable = false)
	private String tdescripcion;

	public Integer getCactividad() {
		return cactividad;
	}

	public void setCactividad(Integer cactividad) {
		this.cactividad = cactividad;
	}

	public TipoActividad getCtipoactividad() {
		return ctipoactividad;
	}

	public void setCtipoactividad(TipoActividad ctipoactividad) {
		this.ctipoactividad = ctipoactividad;
	}

	public String getNactividad() {
		return nactividad;
	}

	public void setNactividad(String nactividad) {
		this.nactividad = nactividad;
	}

	public String getTdescripcion() {
		return tdescripcion;
	}

	public void setTdescripcion(String tdescripcion) {
		this.tdescripcion = tdescripcion;
	}

	public Contrato getCcontrato() {
		return ccontrato;
	}

	public void setCcontrato(Contrato ccontrato) {
		this.ccontrato = ccontrato;
	}
	
	
	
}
