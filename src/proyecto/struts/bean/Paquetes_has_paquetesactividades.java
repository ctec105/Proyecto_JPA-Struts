package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tb_paquetes_has_tb_paquetesactividades")
public class Paquetes_has_paquetesactividades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tb_paquetes_id_paquetes")
	private int paquetes_paquetes;

	@Id
	@Column(name = "tb_paquetesActividades_id_actividades")
	private int paquetesActividades_actividades;

	@Column(name = "precio")
	private Double precio;

	public Paquetes_has_paquetesactividades() {
	}

	public int getPaquetes_paquetes() {
		return paquetes_paquetes;
	}

	public void setPaquetes_paquetes(int paquetesPaquetes) {
		paquetes_paquetes = paquetesPaquetes;
	}

	public int getPaquetesActividades_actividades() {
		return paquetesActividades_actividades;
	}

	public void setPaquetesActividades_actividades(
			int paquetesActividadesActividades) {
		paquetesActividades_actividades = paquetesActividadesActividades;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}