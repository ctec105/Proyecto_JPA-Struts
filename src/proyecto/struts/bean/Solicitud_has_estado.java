package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tb_solicitud_has_tb_estado")
public class Solicitud_has_estado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tb_solicitud_id_solicitud")
	private int solicitud_solicitud;

	@Id
	@Column(name = "tb_estado_idtb_estado")
	private int estado_idestado;

	@Column(name = "fecha")
	private String fecha;

	@Column(name = "usuario")
	private String usuario;

	public Solicitud_has_estado() {
	}

}