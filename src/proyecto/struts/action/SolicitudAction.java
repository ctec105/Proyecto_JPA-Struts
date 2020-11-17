package proyecto.struts.action;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.Cliente;
import proyecto.struts.bean.Equipo;
import proyecto.struts.bean.Estado;
import proyecto.struts.bean.Solicitud;
import proyecto.struts.services.ClienteService;
import proyecto.struts.services.EquipoService;
import proyecto.struts.services.EstadoService;
import proyecto.struts.services.SolicitudService;
import proyecto.struts.services.UtilService;
import proyecto.struts.util.UtilesVarios;

public class SolicitudAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3907558341980790961L;
	private Solicitud solicitud;
	private Equipo equipo;
	private Cliente cliente;
	private List<Solicitud> solicitudes;
	private String buscTarjeta;

	private static SolicitudService solServ = new SolicitudService();
	private static EquipoService equServ = new EquipoService();
	private static ClienteService cliServ = new ClienteService();
	private static EstadoService estServ = new EstadoService();
	private static UtilService utlServ = new UtilService();
	private UtilesVarios var = new UtilesVarios();

	public String execute() {
		try {
			if (solicitud == null)
				solicitud = new Solicitud();

			if (solicitud.getId() != 0) {
				System.out.println("Entrando a Editar");
				solicitud = solServ.getSolicitud(solicitud.getId());
				equipo = equServ.getEquipo(solicitud.getEquipo().getNrotarjeta());
				cliente = cliServ.getCliente(solicitud.getEquipo().getCliente());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String ListaSolicitudes() {
		try {
			solicitudes = solServ.buscarSolicitud(0, "");
			Map session = ActionContext.getContext().getSession();
			session.put("solicitudes", solicitudes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String InsertaActualizaSolicitud() {
		try {
			if (solicitud.getFecha() == null) {
				addActionMessage("Debe ingresar una Fecha");
				return "error";
//			} else if (solicitud.getEquipo() == null) {
//				addActionMessage("Ingrese un Equipo Valido");
//				return "error";
			} else {
				if (solicitud.getId() == 0) {
					System.out.println("Insertando Solicitud");
					// El equipo ya se cargó en el método ObtenerEquipo 
					//equipo = equServ.getEquipo(equipo.getNrotarjeta());
					solicitud.setEquipo(equipo);
					solicitud.setEstado(estServ.getEstado(1));
					if (solServ.inserta(solicitud) == 1) {
						System.out.println("Error en el Insert");
						;
					}
				} else {
					System.out.println("Actualizando Solicitud");
					equipo = equServ.getEquipo(equipo.getNrotarjeta());
					solicitud.setEquipo(equipo);
					solServ.edita(solicitud);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	// Modificamos aki ....
	public String EliminaSolicitud() throws Exception {
		try {
			solicitud = solServ.getSolicitud(solicitud.getId());
			solServ.elimina(solicitud);
			System.out.println("Solicitud eliminado: " + solicitud.getId());
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

	// Estos métodos serán llamados mediante AJAX - Ini
	public String ObtenerEquipo() {
		try {
			System.out.println("Id Equipo: " + buscTarjeta);
			equipo = equServ.getEquipo(buscTarjeta);
			// solicitud.setEquipo(eq);
			if (equipo != null) {
				solicitud.setEquipo(equipo);
				System.out.println("Id Cliente: " + equipo.getCliente());
				cliente = cliServ.getCliente(equipo.getCliente());
				System.out.println("Empresa:  " + cliente.getRazonSoc());
				Calendar c1 = Calendar.getInstance();
				solicitud.setFecha(c1.getTime());
			} else {
				addActionMessage("El equipo no esta registrado..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	// Estos métodos serán llamados mediante AJAX - Fin
	
	public String popBuscarSolicitud() {
		Map session = ActionContext.getContext().getSession();
		try {
			List<Estado> estados = utlServ.getEstados();
			session.put("estados", estados);
			if (solicitud != null) {
				solicitudes = solServ.buscarSolicitud(solicitud.getRepresentante(), solicitud.getEstado().getIdestado());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	/*public String popSolicitud() {
		return "success";
	}*/

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getBuscTarjeta() {
		return buscTarjeta;
	}

	public void setBuscTarjeta(String buscTarjeta) {
		this.buscTarjeta = buscTarjeta;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

}
