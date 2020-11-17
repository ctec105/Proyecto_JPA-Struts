package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tb_paquetes_has_tb_paquetesherramientas")
public class Paquetes_has_paquetesherramientas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tb_paquetes_id_paquetes")
	private int paquetes_paquetes;

	@Id
	@Column(name = "tb_paquetesHerramientas_id_herramientas")
	private int paquetesHerramientas_herramientas;

	@Column(name = "precio")
	private Double precio;

	public Paquetes_has_paquetesherramientas() {
	}

	public int getPaquetes_paquetes() {
		return paquetes_paquetes;
	}

	public void setPaquetes_paquetes(int paquetesPaquetes) {
		paquetes_paquetes = paquetesPaquetes;
	}

	public int getPaquetesHerramientas_herramientas() {
		return paquetesHerramientas_herramientas;
	}

	public void setPaquetesHerramientas_herramientas(
			int paquetesHerramientasHerramientas) {
		paquetesHerramientas_herramientas = paquetesHerramientasHerramientas;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}