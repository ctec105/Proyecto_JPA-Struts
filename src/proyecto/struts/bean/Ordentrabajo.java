package proyecto.struts.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_ordentrabajo")
@NamedQuery(name = "findTrabajosByCliente", query = "SELECT t FROM Ordentrabajo t, Solicitud s "
		+ "WHERE s.equipo.cliente = :cliente "
		+ "AND   t.idLiquidacion = -1  "
		+ "AND   t.solicitud = s.id  " + "Order by t.id ;")
public class Ordentrabajo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_otrabajo")
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_termino")
	private Date fecha_termino;

	@Column(name = "comentarios")
	private String comentarios;

	@Id
	@Column(name = "tb_solicitud_id_solicitud")
	private int solicitud;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "id_oliquidacion", nullable = true)
	private int idLiquidacion;

	public Ordentrabajo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fechaInicio) {
		fecha_inicio = fechaInicio;
	}

	public Date getFecha_termino() {
		return fecha_termino;
	}

	public void setFecha_termino(Date fechaTermino) {
		fecha_termino = fechaTermino;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(int solicitud) {
		this.solicitud = solicitud;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getIdLiquidacion() {
		return idLiquidacion;
	}

	public void setIdLiquidacion(int idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
	}

}