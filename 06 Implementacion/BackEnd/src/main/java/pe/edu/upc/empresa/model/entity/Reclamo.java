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

@Entity
@Table(name = "reclamos")
public class Reclamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer creclamo;
	
	@NotNull(message = "Ingrese dia de contrato")
	@ManyToOne
	@JoinColumn(name = "cdiacontrato", nullable = false)
	private DiaContrato cdiacontrato;
	
	@NotEmpty(message = "Ingrese descripcion")
	@Column(name = "tdescripcion", length = 500, nullable = false)
	private String tdescripcion;
	
	@NotNull(message = "Ingrese la fecha del reclamo")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dfechareclamo", nullable = false)
	private Date dfechareclamo;
	
	@NotNull(message = "Ingrese tipo reclamo")
	@ManyToOne
	@JoinColumn(name = "ctiporeclamo", nullable = false)
	private TipoReclamo ctiporeclamo;

	public Integer getCreclamo() {
		return creclamo;
	}

	public void setCreclamo(Integer creclamo) {
		this.creclamo = creclamo;
	}

	public DiaContrato getCdiacontrato() {
		return cdiacontrato;
	}

	public void setCdiacontrato(DiaContrato cdiacontrato) {
		this.cdiacontrato = cdiacontrato;
	}

	public String getTdescripcion() {
		return tdescripcion;
	}

	public void setTdescripcion(String tdescripcion) {
		this.tdescripcion = tdescripcion;
	}

	public Date getDfechareclamo() {
		return dfechareclamo;
	}

	public void setDfechareclamo(Date dfechareclamo) {
		this.dfechareclamo = dfechareclamo;
	}

	public TipoReclamo getCtiporeclamo() {
		return ctiporeclamo;
	}

	public void setCtiporeclamo(TipoReclamo ctiporeclamo) {
		this.ctiporeclamo = ctiporeclamo;
	}
	
}
