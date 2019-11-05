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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "diacontratos")
public class DiaContrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cdiacontrato;
	
	@NotNull(message = "Ingrese fecha")
	@Temporal(TemporalType.DATE)
	@Column(name = "dfecha", nullable = false)
	private Date dfecha;
	
	@NotNull(message = "Ingrese hora de inicio")
	@Temporal(TemporalType.TIME)
	@Column(name = "dinicio", nullable = false)
	private Date dinicio;
	
	@NotNull(message = "Ingrese hora de fin")
	@Temporal(TemporalType.TIME)
	@Column(name = "dfin", nullable = false)
	private Date dfin;
	
	@NotNull(message = "Ingrese contrato")
	@ManyToOne
	@JoinColumn(name = "ccontrato", nullable = false)
	private Contrato ccontrato;

	public Integer getCdiacontrato() {
		return cdiacontrato;
	}

	public void setCdiacontrato(Integer cdiacontrato) {
		this.cdiacontrato = cdiacontrato;
	}

	public Date getDfecha() {
		return dfecha;
	}

	public void setDfecha(Date dfecha) {
		this.dfecha = dfecha;
	}

	public Date getDinicio() {
		return dinicio;
	}

	public void setDinicio(Date dinicio) {
		this.dinicio = dinicio;
	}

	public Date getDfin() {
		return dfin;
	}

	public void setDfin(Date dfin) {
		this.dfin = dfin;
	}

	public Contrato getCcontrato() {
		return ccontrato;
	}

	public void setCcontrato(Contrato ccontrato) {
		this.ccontrato = ccontrato;
	}
	
	
}
