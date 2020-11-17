package proyecto.struts.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_equipohorometro")
public class Equipohorometro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_horometro")
	private int horometro;

	@Column(name = "horas")
	private int horas;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "tb_equipo_nrotarjeta")
	private int equipo_nrotarjeta;

	public Equipohorometro() {
	}

}