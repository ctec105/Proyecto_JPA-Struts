package proyecto.struts.action;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.record.formula.functions.Today;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.Cliente;
import proyecto.struts.bean.Equipo;
import proyecto.struts.bean.Estado;
import proyecto.struts.bean.Solicitud;
import proyecto.struts.bean.Usuario;
import proyecto.struts.services.ClienteService;
import proyecto.struts.services.EquipoService;
import proyecto.struts.services.EstadoService;
import proyecto.struts.services.SolicitudService;
import proyecto.struts.services.UsuarioService;
import proyecto.struts.services.UtilService;
import proyecto.struts.util.UtilesVarios;
import sun.print.resources.serviceui;

public class ClienteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 943686167674528537L;
	private Cliente cliente;
	private List<Cliente> clientes;
	private static ClienteService cliServ = new ClienteService();

	public String execute() {
		try {
			if (cliente == null) {
				cliente = new Cliente();
				cliente.setId("0");
			} else {
				if (cliente.getId().trim().length() > 0) {
					System.out.println("Entrando a Editar");
					cliente = cliServ.getCliente(cliente.getId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String ListaClientes() {
		try {
			clientes = cliServ.listarClientes();
			Map session = ActionContext.getContext().getSession();
			session.put("clientes", clientes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String insertaActualizaCliente() {
		try {
			if (cliente.getId().trim().length() <= 0) {
				System.out.println("Insertando cliente");
				if (cliServ.inserta(cliente) == 1) {
					System.out.println("Error en el Insert");
					;
				}
			} else {
				System.out.println("Actualizando cliente");
				cliServ.edita(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String eliminaCliente() throws Exception {
		try {
			System.out.println("Entro a eliminar");
			cliente = cliServ.getCliente(cliente.getId());
			cliServ.elimina(cliente);
			System.out.println("Cliente eliminado: " + cliente.getId());
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	// --------------------
//	public String ObtenerEquipo() {
		// try {
		// System.out.println(buscTarjeta);
		// equipo = equServ.getEquipo(buscTarjeta);
		// //solicitud.setEquipo(eq);
		// if(equipo!=null){
		// solicitud.setEquipo(equipo);
		// System.out.println("Id Cliente: " +equipo.getCliente());
		// cliente = cliServ.getCliente(equipo.getCliente());
		// System.out.println("Empresa : "+ cliente.getRazonSoc());
		// Calendar c1 = Calendar.getInstance();
		// solicitud.setFecha(c1.getTime());
		// }else{
		// addActionMessage("El equipo no esta registrado..");
		// }
		//
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }
		//
//		return "success";
//	}
	
	public String popBuscarCliente() {
		Map session = ActionContext.getContext().getSession();
		try {
			if (cliente != null) {
				clientes = cliServ.buscarCliente(cliente);
				//solServ.buscarSolicitud(solicitud.getRepresentante(), solicitud.getEstado().getIdestado());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}

//	public String popSolicitud() {
//		return "success";
//	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
