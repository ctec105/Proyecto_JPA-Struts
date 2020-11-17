package proyecto.struts.bean;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tb_equipo")
public class Equipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nrotarjeta")
	private String nrotarjeta;

	@Column(name = "nroserie")
	private String nroserie;

	@Column(name = "tb_claseEquipo_id_claseEquipo")
	private int claseEquipo;

	@Column(name = "tb_cliente_id_cliente")
	private String cliente;

	@Column(name = "tb_modelo_id_modelo")
	private int modelo;

	public Equipo() {

	}

	public String getNrotarjeta() {
		return nrotarjeta;
	}

	public void setNrotarjeta(String nrotarjeta) {
		this.nrotarjeta = nrotarjeta;
	}

	public String getNroserie() {
		return nroserie;
	}

	public void setNroserie(String nroserie) {
		this.nroserie = nroserie;
	}

	public int getClaseEquipo() {
		return claseEquipo;
	}

	public void setClaseEquipo(int claseEquipo) {
		this.claseEquipo = claseEquipo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

}