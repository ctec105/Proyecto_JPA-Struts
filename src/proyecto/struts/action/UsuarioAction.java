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
import proyecto.struts.services.AreaService;
import proyecto.struts.services.ClienteService;
import proyecto.struts.services.EquipoService;
import proyecto.struts.services.EstadoService;
import proyecto.struts.services.SolicitudService;
import proyecto.struts.services.UsuarioService;
import proyecto.struts.services.UtilService;
import proyecto.struts.util.MD5Util;
import proyecto.struts.util.UtilesVarios;
import sun.print.resources.serviceui;

public class UsuarioAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1525513819915874823L;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private String confPass;
	private String newPass;
	private static UsuarioService usuServ = new UsuarioService();

	public String execute() {
		try {
			if (usuario == null)
				usuario = new Usuario();
			
			AreaService areaServ = new AreaService();
			List areas;
			areas = areaServ.getListAreas();
			Map session = ActionContext.getContext().getSession();
			session.put("areas", areas);

			if (usuario.getCodUsuario() != 0) {
				System.out.println("Entrando a Editar");
				usuario = usuServ.cargaUsuario(usuario.getCodUsuario());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String ListaUsuarios() {
		try {
			usuarios = usuServ.listarUsuarios();
			Map session = ActionContext.getContext().getSession();
			session.put("usuarios", usuarios);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	
//	public String ObtenerEquipo() {
		// try {
		// System.out.println(buscTarjeta);
		// equipo = equServ.getEquipo(buscTarjeta);
		// //solicitud.setEquipo(eq);
		// if(equipo!=null){
		// solicitud.setEquipo(equipo);
		// System.out.println("Id Cliente: " +equipo.getCliente());
		// cliente = cliServ.getCliente(equipo.getCliente());
		// System.out.println("Empresa :  "+ cliente.getRazonSoc());
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

	public String insertaActualizaUsuario() {
		try {
			if (usuario.getCodArea() == 0) {
				System.out.println("Insertando Solicitud");
				usuario.setPassword(MD5Util.md5Hex(usuario.getPassword()));
				if (usuServ.inserta(usuario) == 1) {
					System.out.println("Error en el Insert");
					;
				}
			} else {
				usuario.setPassword(MD5Util.md5Hex(usuario.getPassword()));
				usuServ.modifica(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String cambiaPwd() throws Exception {
		Map session = ActionContext.getContext().getSession();
		if (usuario == null) {
			usuario = new Usuario();
			String user = session.get("login").toString();
			usuario.setLogin(user);
		} else {
			Usuario user = null;
			user = usuServ.logueo(usuario.getLogin(), MD5Util.md5Hex(usuario.getPassword()));
			System.out.println("New Pwd : " + this.newPass);
			System.out.println("Conf Pwd : " + this.confPass);
			if (user == null) {
				addActionMessage("El password es incorrecto...");
			} else {
				user.setPassword(MD5Util.md5Hex(newPass));
				usuServ.modifica(user);
				addActionMessage("Contraseña Cambiada...");
				usuario.setPassword(null);
				this.confPass = "";
				this.newPass = "";
			}
		}
		return "success";
	}

//	public String popBuscarSolicitud() {
		// Map session = ActionContext.getContext().getSession();
		// try {
		//
		//
		// if(solicitud!=null){
		// solicitudes = solServ.buscarSolicitud(
		// solicitud.getRepresentante(),solicitud.getEstado().getIdestado());
		// }else{
		// List<Estado> estados = utlServ.getEstados();
		// session.put("estados", estados);
		// }
		//
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
//		return "success";
//	}

	public String EliminaUsuario() throws Exception {
		try {
			System.out.println("Entro a eliminar");
			usuario = usuServ.cargaUsuario(usuario.getCodUsuario());
			usuServ.eliminaUsuario(usuario);
			System.out.println("Usuario eliminado: " + usuario.getCodUsuario());
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
	
	public String bloquearUsuario() throws Exception {
		usuario = usuServ.cargaUsuario(usuario.getCodUsuario());
		usuario.setEstado(1);
		usuServ.modifica(usuario);
		addActionMessage("Usuario " + usuario.getLogin() + " Bloqueado... ");
		return "success";
	}

	public String desBloquearUsuario() throws Exception {
		usuario = usuServ.cargaUsuario(usuario.getCodUsuario());
		usuario.setEstado(0);
		usuServ.modifica(usuario);
		addActionMessage("Usuario " + usuario.getLogin() + " Desbloqueado... ");
		return "success";
	}

	
//	public String popSolicitud() {
//		return "success";
//	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getConfPass() {
		return confPass;
	}

	public void setConfPass(String confPass) {
		this.confPass = confPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

}
