package proyecto.struts.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import proyecto.struts.bean.Paquetesactividades;
import proyecto.struts.bean.Paquetesherramientas;
import proyecto.struts.bean.Paquetesmateriales;
import proyecto.struts.services.UtilService;

public class PaqueteDetAction {

	private Paquetesherramientas herramienta;
	private Paquetesmateriales material;
	private Paquetesactividades actividad;
	private List<Paquetesherramientas> herramientas;
	private List<Paquetesmateriales> materiales;
	private List<Paquetesactividades> actividades;
	UtilService utlServ = new UtilService();

	public String execute() {
		return "success";
	}

	public String popBuscarHerramienta() {
		Map session = ActionContext.getContext().getSession();
		try {
			if (herramienta != null) {
				herramientas = utlServ.popBucarHerramienta(herramienta);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String popBuscarActividad() {
		Map session = ActionContext.getContext().getSession();
		try {
			if (actividad != null) {
				actividades = utlServ.popBuscarActividad(actividad);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String popBuscarMaterial() {
		Map session = ActionContext.getContext().getSession();
		try {
			if (material != null) {
				materiales = utlServ.popBuscarMaterial(material);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public Paquetesactividades getActividad() {
		return actividad;
	}

	public void setActividad(Paquetesactividades actividad) {
		this.actividad = actividad;
	}

	public Paquetesherramientas getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Paquetesherramientas herramienta) {
		this.herramienta = herramienta;
	}

	public Paquetesmateriales getMaterial() {
		return material;
	}

	public void setMaterial(Paquetesmateriales material) {
		this.material = material;
	}

	public List<Paquetesactividades> getActividades() {
		return actividades;
	}

	public void setActividades(List<Paquetesactividades> actividades) {
		this.actividades = actividades;
	}

	public List<Paquetesherramientas> getHerramientas() {
		return herramientas;
	}

	public void setHerramientas(List<Paquetesherramientas> herramientas) {
		this.herramientas = herramientas;
	}

	public List<Paquetesmateriales> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Paquetesmateriales> materiales) {
		this.materiales = materiales;
	}

}
