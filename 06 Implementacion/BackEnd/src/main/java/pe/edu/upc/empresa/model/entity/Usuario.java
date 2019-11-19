package pe.edu.upc.empresa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cusuario;
	
	@NotEmpty(message="Ingrese nombre de ususario")
	@Column(name="nusuario", length=100, nullable=false)
	private String nusuario;
	
	@Size(min=8, max=8)
	@NotEmpty(message="Ingrese DNI")
	@Column(name="tdniusuario", nullable=false)
	private String tdniusuario;

	@NotNull(message="Ingrese fecha de nacimiento")
	@Temporal(TemporalType.DATE)
	@Column(name="dnacimiento")
	private Date dnacimiento;
	
	@ManyToOne
	@JoinColumn(name="ccliente",nullable=false)
	@JsonIgnoreProperties("usuarios")
	@NotNull(message = "Ingrese Cliente")
	private Cliente ccliente;

	public Integer getCusuario() {
		return cusuario;
	}

	public void setCusuario(Integer cusuario) {
		this.cusuario = cusuario;
	}

	public String getNusuario() {
		return nusuario;
	}

	public void setNusuario(String nusuario) {
		this.nusuario = nusuario;
	}

	public String getTdniusuario() {
		return tdniusuario;
	}

	public void setTdniusuario(String tdniusuario) {
		this.tdniusuario = tdniusuario;
	}

	public Date getDnacimiento() {
		return dnacimiento;
	}

	public void setDnacimiento(Date dnacimiento) {
		this.dnacimiento = dnacimiento;
	}

	public Cliente getCcliente() {
		return ccliente;
	}

	public void setCcliente(Cliente ccliente) {
		this.ccliente = ccliente;
	}
	
	
}
