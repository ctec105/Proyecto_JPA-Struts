package proyecto.struts.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.ClaseEquipo;
import proyecto.struts.bean.Equipo;
import proyecto.struts.bean.UtilBean;
import proyecto.struts.services.EquipoService;
import proyecto.struts.services.UtilService;

public class EquipoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9154136127585496338L;
	private Equipo equipo;
	private List<Equipo> equipos;
	private List<ClaseEquipo> clases;
	private static EquipoService equserv = new EquipoService();
	private static UtilService utlServ = new UtilService();

	public String execute() {
		return "success";
	}

	public String popBuscarEquipos() {
		Map session = ActionContext.getContext().getSession();
		try {
			if (equipo != null) {
				equipos = equserv.buscarEquipo(equipo.getNrotarjeta(), equipo.getClaseEquipo());
			} else {
				clases = utlServ.getClasesEquipos();
				session.put("clasesEquipos", clases);
				System.out.println("Clases: " + clases.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	/*private void llenarClases() {
		clases.add(new UtilBean("*", "Todos"));
		clases.add(new UtilBean("1", "Retroexcavadora"));
		clases.add(new UtilBean("2", "Motoniveladora"));
	}*/

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<ClaseEquipo> getClases() {
		return clases;
	}

	public void setClases(List<ClaseEquipo> clases) {
		this.clases = clases;
	}

}
