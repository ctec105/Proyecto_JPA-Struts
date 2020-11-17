package proyecto.struts.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.Ordenliquidacion;
import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.services.LiquidacionService;
import proyecto.struts.services.TrabajoService;

public class LiquidacionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7343579806683884554L;
	// private HashMap<String, Ordentrabajo> ordenesxCli;
	// private HashMap<String, Ordentrabajo> ordenes;
	private List<Ordentrabajo> ordenesxCli = new ArrayList<Ordentrabajo>();
	private List<Ordentrabajo> ordenes = new ArrayList<Ordentrabajo>();
	private List<Ordenliquidacion> liquidaciones = new ArrayList<Ordenliquidacion>();
	private Ordenliquidacion liquidacion;
	private List<String> listado;

	private static LiquidacionService liqServ = new LiquidacionService();
	private static TrabajoService traServ = new TrabajoService();

	public String execute() {
		// TrabajoService sr = new TrabajoService();
		Map session = ActionContext.getContext().getSession();
		try {
			// ordenesxCli = sr.listar();
			// ordenes.add(sr.getTrabajo(1));
			if (liquidacion == null) {
				liquidacion = new Ordenliquidacion();
				Calendar c1 = Calendar.getInstance();
				liquidacion.setUsuario((String) session.get("login"));
				liquidacion.setNombre((String) session.get("nombre"));
				liquidacion.setFecha(c1.getTime());
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String Listaliquidaciones() {
		try {
			liquidaciones = liqServ.listLiquidaciones();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String ObtenerDivOrdenes() {
		System.out.println("entro al action...");
		TrabajoService sr = new TrabajoService();
		try {
			ordenesxCli = liqServ.findByCliente(liquidacion.getCliente());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String agregarOrdenes() {
		System.out.println("Entro al action!!");
		Map session = ActionContext.getContext().getSession();
		String[] codigos = ServletActionContext.getRequest().getParameterValues("agregar");
		TrabajoService sr = new TrabajoService();
		try {
			for (int i = 0; i < codigos.length; i++) {
				System.out.println(codigos[i].toString());
				ordenes.add(sr.getTrabajo(Integer.parseInt(codigos[i])));
			}
			session.put("LiquidacionOrdenes", ordenes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String AddorUpdateLiquidacion() {
		Map session = ActionContext.getContext().getSession();
		try {
			ordenes = (List<Ordentrabajo>) session.get("LiquidacionOrdenes");

			if (ordenes == null)
				ordenes = new ArrayList<Ordentrabajo>();

			if (ordenes.size() != 0) {
				System.out.println("Ordenes : " + ordenes.size());
				liqServ.insertar(liquidacion);;
				if (liqServ.insertar(liquidacion) == 0) {
					// --------------------------------------------------------------------
					liquidacion = liqServ.findByNoID(liquidacion);
					for (Method m : liquidacion.getClass().getMethods()) {
						if (m.getName().startsWith("get"))
							System.out.println(m.getName() + " : " + m.invoke(liquidacion));
					}
					// --------------------------------------------------------------------
					Iterator it = ordenes.iterator();
					while (it.hasNext()) {
						Ordentrabajo ot = new Ordentrabajo();
						ot = (Ordentrabajo) it.next();
						ot.setIdLiquidacion(liquidacion.getId());
						traServ.actualizar(ot);
					}
				}
			} else {
				addActionMessage("Debe Selecionar las ordenes de trabajo a Liquidar");
				return "error";
			}
		} catch (Exception e) {
			addActionMessage("Error en el Ingreso.. Verifique los datos Ingresados");
			return "error";
		}
		return "success";
	}
	
	public String eliminarLiquidacion() {
		return "success";
	}
	
	public String popBuscarLiquidacion() throws Exception {
		if (liquidacion == null)
			liquidacion = new Ordenliquidacion();
		liquidaciones = liqServ.popBuscarLiq(liquidacion);
		return "success";
	}

	public List<Ordentrabajo> getOrdenesxCli() {
		return ordenesxCli;
	}

	public List<String> getListado() {
		return listado;
	}

	public void setListado(List<String> listado) {
		this.listado = listado;
	}

	public void setOrdenesxCli(List<Ordentrabajo> ordenesxCli) {
		this.ordenesxCli = ordenesxCli;
	}

	public List<Ordentrabajo> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Ordentrabajo> ordenes) {
		this.ordenes = ordenes;
	}

	public Ordenliquidacion getLiquidacion() {
		return liquidacion;
	}

	public void setLiquidacion(Ordenliquidacion liquidacion) {
		this.liquidacion = liquidacion;
	}

	public List<Ordenliquidacion> getLiquidaciones() {
		return liquidaciones;
	}

	public void setLiquidaciones(List<Ordenliquidacion> liquidaciones) {
		this.liquidaciones = liquidaciones;
	}

}
