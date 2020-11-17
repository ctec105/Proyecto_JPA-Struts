package proyecto.struts.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.Especialidad;
import proyecto.struts.bean.Tecnico;
import proyecto.struts.services.TecnicoService;
import proyecto.struts.services.UtilService;

public class TecnicoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 402119891320239555L;
	private Tecnico tecnico;
	private List<Tecnico> tecnicos;

	UtilService utServ = new UtilService();
	TecnicoService tecServ = new TecnicoService();

	public String execute() {
		return "success";
	}

	public String popBuscarTecnico() {
		Map session = ActionContext.getContext().getSession();
		try {
			System.out.println("Entro al Action ");

			if (tecnico != null) {
				tecnicos = tecServ.popBuscarTecn(tecnico);
			} else {
				List<Especialidad> lstespecialidades = utServ.listEspecialidad();
				session.put("lstespecialidades", lstespecialidades);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

}
