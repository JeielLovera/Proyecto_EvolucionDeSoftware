package pe.edu.upc.empresa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name= "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer ccliente;
	
	@NotEmpty(message="Ingrese cliente")
	@Column(name = "ncliente", length = 100, nullable = false)
	private String ncliente;
	
	@Size(min=8, max=8)
	@NotEmpty(message="Ingrese dni")
	@Column(name="tdnicliente", length=8, nullable=false)
	private String tdnicliente;
	
	@Size(min=9, max=9)
	@NotEmpty(message="Ingrese telefono")
	@Column(name="ttelefono", length=9, nullable=false)
	private String ttelefono;
	
	@NotEmpty(message="Ingrese correo")
	@Column(name="tcorreo", length= 100, nullable=false)
	private String tcorreo;
	
	@NotEmpty(message="Ingrese contraseña")
	@Column(name="tcontrasenya", length= 100, nullable=false)
	private String tcontrasenya;

	public Integer getCcliente() {
		return ccliente;
	}

	public void setCcliente(Integer ccliente) {
		this.ccliente = ccliente;
	}

	public String getNcliente() {
		return ncliente;
	}

	public void setNcliente(String ncliente) {
		this.ncliente = ncliente;
	}

	public String getTdnicliente() {
		return tdnicliente;
	}

	public void setTdnicliente(String tdnicliente) {
		this.tdnicliente = tdnicliente;
	}

	public String getTtelefono() {
		return ttelefono;
	}

	public void setTtelefono(String ttelefono) {
		this.ttelefono = ttelefono;
	}

	public String getTcorreo() {
		return tcorreo;
	}

	public void setTcorreo(String tcorreo) {
		this.tcorreo = tcorreo;
	}

	public String getTcontrasenya() {
		return tcontrasenya;
	}

	public void setTcontrasenya(String tcontrasenya) {
		this.tcontrasenya = tcontrasenya;
	}
	
	
}
