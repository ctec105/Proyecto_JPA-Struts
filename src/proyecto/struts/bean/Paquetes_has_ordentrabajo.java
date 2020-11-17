package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tb_paquetes_has_tb_ordentrabajo")
public class Paquetes_has_ordentrabajo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tb_paquetes_id_paquetes")
	private int paquetes_paquetes;

	@Id
	@Column(name = "tb_ordenTrabajo_id_otrabajo")
	private int ordenTrabajo_otrabajo;

	@Column(name = "precio")
	private Double precio;

	public Paquetes_has_ordentrabajo() {
	}

	public int getPaquetes_paquetes() {
		return paquetes_paquetes;
	}

	public void setPaquetes_paquetes(int paquetesPaquetes) {
		paquetes_paquetes = paquetesPaquetes;
	}

	public int getOrdenTrabajo_otrabajo() {
		return ordenTrabajo_otrabajo;
	}

	public void setOrdenTrabajo_otrabajo(int ordenTrabajoOtrabajo) {
		ordenTrabajo_otrabajo = ordenTrabajoOtrabajo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
	
}