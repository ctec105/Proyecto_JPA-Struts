package proyecto.struts.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.Area;
import proyecto.struts.bean.AreaMenu;
import proyecto.struts.bean.Usuario;
import proyecto.struts.services.UsuarioService;
import proyecto.struts.services.UtilService;
import proyecto.struts.util.MD5Util;

public class LogueoAction extends ActionSupport {

	private Usuario usuario;

	UsuarioService srvUser = new UsuarioService();
	UtilService srvUtil = new UtilService();

	public String execute() {
		String rst = "error";

		try {
			System.out.println("Entro al Action");
			usuario = srvUser.logueo(usuario.getLogin(),
					MD5Util.md5Hex(usuario.getPassword()));
			if (usuario != null) {
				if (usuario.getEstado() == 1) {
					addActionMessage("Su cuenta se encuentra bloqueada...");
					rst = "error";
				} else {
					Map session = ActionContext.getContext().getSession();
					String nombre = usuario.getNombre() + " "
							+ usuario.getApe_pat() + " " + usuario.getApe_mat();
					session.put("nombre", nombre);
					session.put("login", usuario.getLogin());
					Area area = srvUtil.getArea(usuario.getCodArea());
					session.put("area", area.getDescripcion());
					List<AreaMenu> listMenu;
					listMenu = srvUser.permisos(usuario.getCodArea());
					System.out.println(listMenu.size());
					session.put("menu", listMenu);

					System.out.println(MD5Util.md5Hex("Ricardo"));
					rst = "success";
				}
			} else {
				addActionMessage("Su login o contraseña son incorrectos...");
				rst = "error";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rst;

	}

	public String CerrarSession() {
		Map session = ActionContext.getContext().getSession();
		session.remove("login");
		session.clear();
		return "success";
	}

	
	public String index() {
		return "success";
	}

	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
