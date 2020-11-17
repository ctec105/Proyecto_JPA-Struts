package proyecto.struts.bean;

import java.io.Serializable;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

//@NamedQueries({
//		@NamedQuery(name = "findPaqDetFact", query = "SELECT l.id, p.paquetes_paquetes, pq.nombre, p.precio, "
//				+ "SUM(p.precio), COUNT(pq)"
//				+ "FROM Ordenliquidacion l, Ordentrabajo o, "
//				+ "Paquetes_has_ordentrabajo p, Paquete pq  "
//				+ "WHERE l.id = :idLiquidacion "
//				+ "AND l.id = o.idLiquidacion "
//				+ "AND o.id = p.ordenTrabajo_otrabajo "
//				+ "AND p.paquetes_paquetes = pq.id "
//				+ "GROUP BY l.id, p.paquetes_paquetes, pq.nombre, p.precio"),
//
//		@NamedQuery(name = "findTecDetFact", query = "SELECT l.id, p.tecnicos_tecnicos, pq.nombre, e.costoDia, "
//				+ "SUM(p.dias), COUNT(pq) "
//				+ "FROM Ordenliquidacion l, Ordentrabajo o, "
//				+ "Ordentrabajo_has_tecnicos p, Tecnico pq, Especialidad e "
//				+ "WHERE l.id = :idLiquidacion "
//				+ "AND l.id = o.idLiquidacion "
//				+ "AND o.id = p.ordenTrabajo_otrabajo "
//				+ "AND p.tecnicos_tecnicos = pq.id "
//				+ "AND pq.idEspecialidad = e.id "
//				+ "GROUP BY l.id, p.tecnicos_tecnicos, pq.nombre, e.costoDia") })

@NamedQueries({
		@NamedQuery(name = "findPaqDetFact", query = "SELECT l.id, p.paquetes_paquetes, pq.nombre, p.precio, "
				+ "SUM(p.precio) as total, COUNT(pq) as cantidad "
				+ "FROM Ordenliquidacion l, Ordentrabajo o, "
				+ "Paquetes_has_ordentrabajo p, Paquete pq  "
				+ "WHERE l.id = :idLiquidacion "
				+ "AND l.id = o.idLiquidacion "
				+ "AND o.id = p.ordenTrabajo_otrabajo "
				+ "AND p.paquetes_paquetes = pq.id "
				+ "GROUP BY l.id, p.paquetes_paquetes, pq.nombre, p.precio;"),

		@NamedQuery(name = "findTecDetFact", query = "SELECT l.id, p.tecnicos_tecnicos, pq.nombre, e.costoDia, "
				+ "SUM(p.dias) as total, COUNT(pq) as cantidad "
				+ "FROM Ordenliquidacion l, Ordentrabajo o, "
				+ "Ordentrabajo_has_tecnicos p, Tecnico pq, Especialidad e "
				+ "WHERE l.id = :idLiquidacion "
				+ "AND l.id = o.idLiquidacion "
				+ "AND o.id = p.ordenTrabajo_otrabajo "
				+ "AND p.tecnicos_tecnicos = pq.id "
				+ "AND pq.idEspecialidad = e.id "
				+ "GROUP BY l.id, p.tecnicos_tecnicos, pq.nombre, e.costoDia ;") })


@Entity
@Table(name = "tb_detalleprefactura")
public class Detalleprefactura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "tb_prefactura_id_prefactura")
	private int idPrefactura;

	@Column(name = "item")
	private int item;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio_unitario")
	private Double precio_unitario;

	@Column(name = "precio_total")
	private Double precio_total;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "subtotal")
	private Double subtotal;

	public Detalleprefactura() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPrefactura() {
		return idPrefactura;
	}

	public void setIdPrefactura(int idPrefactura) {
		this.idPrefactura = idPrefactura;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(Double precioUnitario) {
		precio_unitario = precioUnitario;
	}

	public Double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(Double precioTotal) {
		precio_total = precioTotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

}