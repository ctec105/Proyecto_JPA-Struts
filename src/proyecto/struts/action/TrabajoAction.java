package proyecto.struts.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.bean.Ordentrabajo_has_tecnicos;
import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetes_has_ordentrabajo;
import proyecto.struts.bean.Solicitud;
import proyecto.struts.bean.Tecnico;
import proyecto.struts.services.EstadoService;
import proyecto.struts.services.PaqueteService;
import proyecto.struts.services.SolicitudService;
import proyecto.struts.services.TecnicoService;
import proyecto.struts.services.TrabajoService;
import proyecto.struts.util.UtilesVarios;

public class TrabajoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1013031349848405157L;
	private Ordentrabajo trabajo;
	private Solicitud solicitud;
	private int buscSolic;
	private int buscPaq;
	private int busTec;
	private List<Ordentrabajo> trabajos;
	private List<Paquete> paquetes;
	private List<Tecnico> tecnicos;

	private static TrabajoService traServ = new TrabajoService();
	private static SolicitudService solServ = new SolicitudService();
	private static PaqueteService paqServ = new PaqueteService();
	private static TecnicoService tecServ = new TecnicoService();
	private static EstadoService estServ = new EstadoService();

	public String execute() {
		try {
			Map session = ActionContext.getContext().getSession();
			if (trabajo == null)
				trabajo = new Ordentrabajo();
			if (paquetes == null)
				paquetes = new ArrayList<Paquete>();
			if (tecnicos == null)
				tecnicos = new ArrayList<Tecnico>();
			System.out.println("Entro al Action... : " + trabajo.getId());
			if (trabajo.getId() != 0) {
				trabajo = traServ.getTrabajo(trabajo.getId());
				System.out.println("Solicitud : " + trabajo.getSolicitud());
				solicitud = solServ.getSolicitud(trabajo.getSolicitud());
				System.out.println("id: " + trabajo.getId());
				paquetes = obtenerPaquetes(trabajo.getId());
				tecnicos = obtenerTecnicos(trabajo.getId());
				session.put("trabajoTecnicos", tecnicos);
				session.put("trabajoPaquetes", paquetes);
			} else {
				session.remove("trabajoPaquetes");
				session.remove("trabajoTecnicos");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public String ListaTrabajos() {
		try {
			trabajos = traServ.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}

	public String ObtenerSolicitud() {
		try {
			if (solicitud == null)
				solicitud = new Solicitud();

			solicitud = solServ.getSolicitud(buscSolic);
			if (solicitud == null) {
				addActionMessage("La solicitud ingresada, no existe");
			}
			System.out.println("Estado de la solictud: " + solicitud.getEstado().getIdestado());
			if (solicitud.getEstado().getIdestado() != 1) {
				solicitud = null;
				addActionMessage("La solicitud ingresada, ya ah sido atendida");
			} else {
				trabajo.setSolicitud(solicitud.getId());
				Calendar c1 = Calendar.getInstance();
				trabajo.setFecha_inicio(c1.getTime());
				trabajo.setFecha_termino(c1.getTime());
			}
		} catch (Exception e) {
			return "error";
		}
		return "success";
	}

	public String InsertaorActualizaTrabajo() {
		UtilesVarios ut = new UtilesVarios();
		try {
			// int x = solicitud.getId();
			Map session = ActionContext.getContext().getSession();
			if (paquetes == null)
				paquetes = new ArrayList<Paquete>();
			if (tecnicos == null)
				tecnicos = new ArrayList<Tecnico>();
			if (session.get("trabajoPaquetes") != null)
				paquetes.addAll((List) session.get("trabajoPaquetes"));
			if (session.get("trabajoTecnicos") != null)
				tecnicos.addAll((List) session.get("trabajoTecnicos"));
			/*List<Paquetes_has_ordentrabajo> det_paq = new ArrayList<Paquetes_has_ordentrabajo>();
			List<Ordentrabajo_has_tecnicos> det_tec = new ArrayList<Ordentrabajo_has_tecnicos>();*/
			String user;
			user = (String) session.get("login");
			trabajo.setUsuario(user);
			if (trabajo.getFecha_inicio() == null
					|| trabajo.getFecha_termino() == null) {
				addActionMessage("Debe ingresar los campos de fechas");
				return "error";
			}
			if (UtilesVarios.fechasDiferenciaEnDias(trabajo.getFecha_inicio(),
					trabajo.getFecha_termino()) < 1) {
				addActionMessage("La fecha final  debe ser mayor a la de termino..");
				return "error";
			}
			if (trabajo.getSolicitud() == 0) {
				addActionMessage("Debe ingresar una solicitud de Servicio..");
				return "error";
			}
			if (paquetes.size() == 0) {
				addActionMessage("Debe ingresar un paquete de Servicio..");
				return "error";
			}
			if (tecnicos.size() == 0) {
				addActionMessage("Debe ingresar un Tecnico...");
				return "error";
			}

			if (trabajo.getId() == 0) {
				if (traServ.insertar(trabajo, paquetes, tecnicos) == 0) {
					// Actualizamos la solicitud de servicio de dicha orden de trabajo
					Solicitud sol = new Solicitud();
					sol = solServ.getSolicitud(trabajo.getSolicitud());
					sol.setEstado(estServ.getEstado(2));// En proceso
					solServ.edita(sol);
				} else {
					addActionMessage("Error en el Ingreso, Verifique los Datos Ingresados..");
					return "error";
				}
			} else {
				if (traServ.actualizar(trabajo, paquetes, tecnicos) == 0) {

				}
			}
		} catch (Exception e) {
			addActionMessage("Error en ele Ingreso, Verifique sus datos...");
			return "error";
		}
		return "success";
	}
	
	public String eliminarTrabajo() {
		return "success";
	}
	
	// Estos métodos serán llamados mediante AJAX - Ini
	public String ObtenerPaquete() {
		Map session = ActionContext.getContext().getSession();
		try {
			Paquete p = new Paquete();
			p = paqServ.getPaquete(buscPaq);
			// Map session = ActionContext.getContext().getSession();
			// paquetes = paqServ.getPaquetes(buscPaq, paquetes);
			if (p == null) {
				System.out.println("El paquete es nulo");
				/*if (session.get("trabajoPaquetes") != null) {
					paquetes = new ArrayList<Paquete>();
					paquetes.addAll((List) session.get("trabajoPaquetes"));
				}*/
				addActionMessage("El paquete ingresado, no existe");
			} else {
				System.out.println("Se agrega el Paquete a la lista");
				System.out.println(p.getId() + " : " + p.getNombre());
				if (paquetes == null) {
					System.out.println("paquetes es nulo");
					paquetes = new ArrayList<Paquete>();
					if (session.get("trabajoPaquetes") != null) {
						System.out.println("session paquete != nulo");
						paquetes.addAll((List) session.get("trabajoPaquetes"));
					}
				}
				paquetes.add(p);
				
				/*Calendar c1 = Calendar.getInstance();
				c1.setTime(trabajo.getFecha_inicio());
				c1.add(Calendar.DATE, p.getDuracion());
				trabajo.setFecha_termino(c1.getTime());*/
				 
				session.put("trabajoPaquetes", paquetes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String ObtenerTecnico() {
		Map session = ActionContext.getContext().getSession();
		try {
			Tecnico tec = new Tecnico();
			tec = tecServ.getTecnico(busTec);
			if (tec == null) {
				if (session.get("trabajoTecnicos") != null) {
					tecnicos = new ArrayList<Tecnico>();
					tecnicos.addAll((List) session.get("trabajoTecnicos"));

				}
				addActionMessage("El tecnico ingresado no existe");
			} else {
				if (tecnicos == null) {
					tecnicos = new ArrayList<Tecnico>();
					if (session.get("trabajoTecnicos") != null) {
						tecnicos.addAll((List) session.get("trabajoTecnicos"));
					}
				}
				tecnicos.add(tec);
				session.put("trabajoTecnicos", tecnicos);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "success";
	}
	// Estos métodos serán llamados mediante AJAX - Fin

	private List<Paquete> obtenerPaquetes(int idTrabajo) {
		List<Paquete> lst = new ArrayList<Paquete>();
		try {
			Iterator<Paquetes_has_ordentrabajo> it = traServ.getPaquetes(
					idTrabajo).iterator();
			while (it.hasNext()) {
				Paquetes_has_ordentrabajo tr = new Paquetes_has_ordentrabajo();
				tr = it.next();
				Paquete pq = new Paquete();
				pq = paqServ.getPaquete(tr.getPaquetes_paquetes());
				lst.add(pq);
			}
			return lst;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	private List<Tecnico> obtenerTecnicos(int idTrabajo) {
		List<Tecnico> lst = new ArrayList<Tecnico>();
		try {
			Iterator<Ordentrabajo_has_tecnicos> it = traServ.getTecnicos(
					idTrabajo).iterator();
			while (it.hasNext()) {
				Ordentrabajo_has_tecnicos ot = new Ordentrabajo_has_tecnicos();
				ot = it.next();
				Tecnico tec = new Tecnico();
				tec = tecServ.getTecnico(ot.getTecnicos_tecnicos());
				lst.add(tec);
			}
			return lst;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public Ordentrabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Ordentrabajo trabajo) {
		this.trabajo = trabajo;
	}

	public List<Ordentrabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(List<Ordentrabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public int getBuscSolic() {
		return buscSolic;
	}

	public void setBuscSolic(int buscSolic) {
		this.buscSolic = buscSolic;
	}

	public int getBuscPaq() {
		return buscPaq;
	}

	public void setBuscPaq(int buscPaq) {
		this.buscPaq = buscPaq;
	}

	public int getBusTec() {
		return busTec;
	}

	public void setBusTec(int busTec) {
		this.busTec = busTec;
	}

	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

}
