package proyecto.struts.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_prefactura")
public class Prefactura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_prefactura")
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;

	// @Column(name="tb_ordenLiquidacion_id_liquidacion")
	@ManyToOne
	@JoinColumn(name = "tb_ordenLiquidacion_id_liquidacion")
	private Ordenliquidacion liquidacion;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "cliente")
	private String cliente;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "RUC")
	private String ruc;

	public Prefactura() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Ordenliquidacion getLiquidacion() {
		return liquidacion;
	}

	public void setLiquidacion(Ordenliquidacion liquidacion) {
		this.liquidacion = liquidacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

}