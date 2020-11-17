package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tb_ordentrabajo_has_tb_tecnicos")
public class Ordentrabajo_has_tecnicos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tb_ordenTrabajo_id_otrabajo")
	private int ordenTrabajo_otrabajo;

	@Id
	@Column(name = "tb_tecnicos_id_tecnicos")
	private int tecnicos_tecnicos;

	@Column(name = "dias")
	private int dias;

	public Ordentrabajo_has_tecnicos() {
	}

	public int getOrdenTrabajo_otrabajo() {
		return ordenTrabajo_otrabajo;
	}

	public void setOrdenTrabajo_otrabajo(int ordenTrabajoOtrabajo) {
		ordenTrabajo_otrabajo = ordenTrabajoOtrabajo;
	}

	public int getTecnicos_tecnicos() {
		return tecnicos_tecnicos;
	}

	public void setTecnicos_tecnicos(int tecnicosTecnicos) {
		tecnicos_tecnicos = tecnicosTecnicos;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

}