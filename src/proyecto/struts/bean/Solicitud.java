package proyecto.struts.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_solicitud")
public class Solicitud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_solicitud")
	private int id;
	@Column(name = "des_problema")
	private String desc;
	@Column(name = "Representante")
	private String representante;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "horometro_actual")
	private int horometro;

	// @Column(name="estado")
	// private String estado;

	@Column(name = "telefono")
	private String telefono;

	@ManyToOne
	@JoinColumn(name = "estado", nullable = false)
	private Estado estado;

	@ManyToOne
	@JoinColumn(name = "tb_equipo_nrotarjeta", nullable = false)
	private Equipo equipo;

	public Solicitud() {

	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getHorometro() {
		return horometro;
	}

	public void setHorometro(int horometro) {
		this.horometro = horometro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
