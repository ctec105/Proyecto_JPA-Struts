package proyecto.struts.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.rpt.Rrt01;
import proyecto.struts.bean.rpt.Rrt02;
import proyecto.struts.services.ReporteService;
import proyecto.struts.services.UtilService;
import proyecto.struts.util.UtilesVarios;

public class ReporteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7898156509202161087L;
	private List<Rrt01> reporte = new ArrayList<Rrt01>();
	private List<Rrt02> reporte2 = new ArrayList<Rrt02>();

	private Date fecInicio;
	private Date fecFin;

	private static ReporteService rptServ = new ReporteService();

	public String execute() {
		UtilService utServ = new UtilService();
		Map session = ActionContext.getContext().getSession();
		try {
			// List<ClaseEquipo> clases = utServ.getClasesEquipos();
			// session.put("clasesEquipos", clases);
			Calendar c1 = Calendar.getInstance();
			this.fecInicio = c1.getTime();
			this.fecFin = c1.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String reporte1() throws Exception {
		if (UtilesVarios.fechasDiferenciaEnDias(fecInicio, fecFin) < 0) {
			addActionMessage("La fecha inicial debe ser menor a la de fin");
			return "frm";
		} else {
			Map session = ActionContext.getContext().getSession();
			reporte = rptServ.reporte1(fecInicio, fecFin);
			if (reporte.size() == 0) {
				addActionMessage("No se encontraron resultados para su consulta");
				return "frm";
			}
			System.out.println("cantidad: " + reporte.size());
		}
		return "success";
	}

	public String reporte2() throws Exception {
		reporte2 = rptServ.reporte2();
		return "success";

	}

	public Date getFecInicio() {
		return fecInicio;
	}

	public List<Rrt01> getReporte() {
		return reporte;
	}

	public void setReporte(List<Rrt01> reporte) {
		this.reporte = reporte;
	}

	public List<Rrt02> getReporte2() {
		return reporte2;
	}

	public void setReporte2(List<Rrt02> reporte2) {
		this.reporte2 = reporte2;
	}

	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	public Date getFecFin() {
		return fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}

}
