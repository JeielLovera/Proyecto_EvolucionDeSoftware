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
import javax.validation.constraints.Size;

@Entity
@Table(name = "enfermeros")
public class Enfermero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cenfermero;
	
	@Column(name = "nenfermero", length = 100, nullable = false)
	@NotEmpty(message = "Ingrese nombre completo")
	private String nenfermero;
	
	@Size(min = 8, max = 8)
	@Column(name = "dnienfermero", length = 8, nullable = false)
	@NotEmpty(message = "Ingrese dni")
	private String dnienfermero;
	
	@Size(min = 7, max = 9)
	@Column(name = "telefono", length = 9, nullable = false)
	@NotEmpty(message = "Ingrese telefono")
	private String telefono;
	
	@NotEmpty(message = "Ingrese correo electronico")
	@Column(name = "tcorreo", length = 100, nullable = false)
	private String tcorreo;
	
	@NotEmpty(message = "Ingrese contraseña")
	@Column(name = "contrasenya", length = 100, nullable = false)
	private String contrasenya;
	
	@NotNull(message = "Ingrese codigo de grado")
	@ManyToOne
	@JoinColumn(name = "cgrado", nullable = false)
	private Grado cgrado;
	
	@NotNull(message = "Ingrese valoracion")
	@Column(name = "numvaloracion")
	private double numvaloracion;
	
	@NotNull(message = "Ingrese disponibilidad")
	@Column(name = "fdisponible", nullable = false)
	private Boolean fdisponible;
	
	@NotEmpty(message = "Ingrese descripcion del enfermero")
	@Column(name = "tdescripcion", nullable = false)
	private String tdescripcion;

	public Integer getCenfermero() {
		return cenfermero;
	}

	public void setCenfermero(Integer cenfermero) {
		this.cenfermero = cenfermero;
	}

	public String getNenfermero() {
		return nenfermero;
	}

	public void setNenfermero(String nenfermero) {
		this.nenfermero = nenfermero;
	}

	public String getDnienfermero() {
		return dnienfermero;
	}

	public void setDnienfermero(String dnienfermero) {
		this.dnienfermero = dnienfermero;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTcorreo() {
		return tcorreo;
	}

	public void setTcorreo(String tcorreo) {
		this.tcorreo = tcorreo;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public Grado getCgrado() {
		return cgrado;
	}

	public void setCgrado(Grado cgrado) {
		this.cgrado = cgrado;
	}

	public double getNumvaloracion() {
		return numvaloracion;
	}

	public void setNumvaloracion(double numvaloracion) {
		this.numvaloracion = numvaloracion;
	}

	public Boolean getFdisponible() {
		return fdisponible;
	}

	public void setFdisponible(Boolean fdisponible) {
		this.fdisponible = fdisponible;
	}

	public String getTdescripcion() {
		return tdescripcion;
	}

	public void setTdescripcion(String tdescripcion) {
		this.tdescripcion = tdescripcion;
	}
	
	
}
