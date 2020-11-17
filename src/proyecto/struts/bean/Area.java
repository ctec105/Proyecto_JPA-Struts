package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tb_area")
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_area")
	private int area;

	@Column(name = "descripcion")
	private String descripcion;

	public Area() {

	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}