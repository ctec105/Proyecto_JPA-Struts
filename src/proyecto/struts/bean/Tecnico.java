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
@Table(name = "tb_tecnicos")
public class Tecnico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tecnicos")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "ape_pat")
	private String ape_pat;

	@Column(name = "ape_mat")
	private String ape_mat;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso")
	private Date fecha_ingreso;

	@Column(name = "disponible")
	private String disponible;

	@Column(name = "tb_especialidades_id_especialidad")
	private int idEspecialidad;

	@Column(name = "supervisor")
	private int supervisor;

	public Tecnico() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe_pat() {
		return ape_pat;
	}

	public void setApe_pat(String apePat) {
		ape_pat = apePat;
	}

	public String getApe_mat() {
		return ape_mat;
	}

	public void setApe_mat(String apeMat) {
		ape_mat = apeMat;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fechaIngreso) {
		fecha_ingreso = fechaIngreso;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public int getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}

}