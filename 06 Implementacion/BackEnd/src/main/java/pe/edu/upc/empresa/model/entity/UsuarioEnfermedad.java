package pe.edu.upc.empresa.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarioEnfermedades")
public class UsuarioEnfermedad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cusuario_enfermedad;
	
	@ManyToOne
	@JoinColumn(name = "cusuario", nullable = false)
	private Usuario cusuario;
	
	@ManyToOne
	@JoinColumn(name = "cenfermedad", nullable = false)
	private Enfermedad cenfermedad;

	public Integer getCusuario_enfermedad() {
		return cusuario_enfermedad;
	}

	public void setCusuario_enfermedad(Integer cusuario_enfermedad) {
		this.cusuario_enfermedad = cusuario_enfermedad;
	}

	public Usuario getCusuario() {
		return cusuario;
	}

	public void setCusuario(Usuario cusuario) {
		this.cusuario = cusuario;
	}

	public Enfermedad getCenfermedad() {
		return cenfermedad;
	}

	public void setCenfermedad(Enfermedad cenfermedad) {
		this.cenfermedad = cenfermedad;
	}
	
	
}
