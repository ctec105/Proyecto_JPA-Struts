package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tb_especialidades")
public class Especialidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_especialidad")
	private int id;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "costoDia")
	private Double costoDia;

	public Especialidad() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCostoDia() {
		return costoDia;
	}

	public void setCostoDia(Double costoDia) {
		this.costoDia = costoDia;
	}

}