package proyecto.struts.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.Area;
import proyecto.struts.bean.AreaMenu;
import proyecto.struts.services.AreaService;
import proyecto.struts.services.UsuarioService;

public class PermisosAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4813710847304310389L;
	private List<Area> areas;
	private List<AreaMenu> listMenu;
	private Area area;

	UsuarioService srvUser = new UsuarioService();
	AreaService areaServ = new AreaService();

	public String execute() {
		try {
			areas = areaServ.getListAreas();
			Map session = ActionContext.getContext().getSession();
			session.put("areas", areas);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public String permisosList() {
		try {
			System.out.println("Entro al PermisosList :::: ");
			listMenu = srvUser.permisosAll(area.getArea());
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<AreaMenu> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<AreaMenu> listMenu) {
		this.listMenu = listMenu;
	}

}
