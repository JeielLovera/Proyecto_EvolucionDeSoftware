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
@Table(name = "contratos")
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ccontrato;
	
	@ManyToOne
	@JoinColumn(name = "cenfermero", nullable= false)
	@NotNull(message = "Ingrese Enfermero")
	private Enfermero cenfermero;
	
	@ManyToOne
	@JoinColumn(name = "cusuario", nullable= false)
	@NotNull(message = "Ingrese Usuario")
	private Usuario cusuario;
	
	@Column(name = "ffinalizado", nullable= false)
	@NotNull(message ="ingresar estado finalizado")
	private Boolean ffinalizado;
	
	@Column(name = "tdireccion", length = 100,nullable= false)
	@NotEmpty(message ="ingresar direccion")
	private String tdireccion;

	public Integer getCcontrato() {
		return ccontrato;
	}

	public void setCcontrato(Integer ccontrato) {
		this.ccontrato = ccontrato;
	}

	public Enfermero getCenfermero() {
		return cenfermero;
	}

	public void setCenfermero(Enfermero cenfermero) {
		this.cenfermero = cenfermero;
	}

	public Usuario getCusuario() {
		return cusuario;
	}

	public void setCusuario(Usuario cusuario) {
		this.cusuario = cusuario;
	}

	public Boolean getFfinalizado() {
		return ffinalizado;
	}

	public void setFfinalizado(Boolean ffinalizado) {
		this.ffinalizado = ffinalizado;
	}

	public String getTdireccion() {
		return tdireccion;
	}

	public void setTdireccion(String tdireccion) {
		this.tdireccion = tdireccion;
	}

}
