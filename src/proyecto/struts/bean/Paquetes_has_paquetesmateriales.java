package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tb_paquetes_has_tb_paquetesmateriales")
public class Paquetes_has_paquetesmateriales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tb_paquetes_id_paquetes")
	private int paquetes_paquetes;

	@Id
	@Column(name = "tb_paquetesMateriales_id_materiales")
	private int paquetesMateriales_materiales;

	@Column(name = "precio")
	private Double precio;

	public Paquetes_has_paquetesmateriales() {
	}

	public int getPaquetes_paquetes() {
		return paquetes_paquetes;
	}

	public void setPaquetes_paquetes(int paquetesPaquetes) {
		paquetes_paquetes = paquetesPaquetes;
	}

	public int getPaquetesMateriales_materiales() {
		return paquetesMateriales_materiales;
	}

	public void setPaquetesMateriales_materiales(
			int paquetesMaterialesMateriales) {
		paquetesMateriales_materiales = paquetesMaterialesMateriales;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}