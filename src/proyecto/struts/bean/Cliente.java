package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cliente")
	String id;
	@Column(name = "razonsocial")
	String razonSoc;
	@Column(name = "direccion")
	String direccion;
	@Column(name = "telefono")
	String telefono;

	public Cliente() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRazonSoc() {
		return razonSoc;
	}

	public void setRazonSoc(String razonSoc) {
		this.razonSoc = razonSoc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
