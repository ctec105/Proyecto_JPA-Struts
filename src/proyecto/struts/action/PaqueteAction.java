package proyecto.struts.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import proyecto.struts.bean.Marca;
import proyecto.struts.bean.Modelo;
import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetesactividades;
import proyecto.struts.bean.Paquetesherramientas;
import proyecto.struts.bean.Paquetesmateriales;
import proyecto.struts.services.PaqueteService;
import proyecto.struts.services.UtilService;

public class PaqueteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7989578854400851339L;
	private Paquete paquete;
	private List<Paquete> paquetes;
	private int buscHer;
	private int buscAct;
	private int buscMat;

	PaqueteService paqServ = new PaqueteService();
	UtilService utServ = new UtilService();

	public String execute() {
		Map session = ActionContext.getContext().getSession();
		try {
			// Eliminando sessiones Anteriores
			session.remove("paqHerramientas");
			session.remove("paqMateriales");
			session.remove("paqActividades");
			
			// combos
			List<Marca> lstMarca = utServ.listMarca();
			session.put("paqueteMarca", lstMarca);

			if (paquete == null)
				paquete = new Paquete();
			
			if (paquete.getId() != 0) {
				paquete = paqServ.getPaquete(paquete.getId());
				List<Modelo> lstModelo = utServ.listModelo(paquete.getMarca());
				session.put("paqueteModelo", lstModelo);
				session.put("paqHerramientas", paqServ.getHerramientasxId(paquete.getId()));
				session.put("paqMateriales", paqServ.getMaterialesxId(paquete.getId()));
				session.put("paqActividades", paqServ.getActividadesxId(paquete.getId()));
			} else {
				List<Modelo> lstModelo = utServ.listModelo("1");
				session.put("paqueteModelo", lstModelo);
			}

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String ListaPaquetes() {
		try {
			paquetes = paqServ.getListPaquetes();
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public String insertaActualizaPaquete() {
		Map session = ActionContext.getContext().getSession();
		try {
			for (Method m : paquete.getClass().getMethods()) {
				if (m.getName().startsWith("get"))
					System.out.println(m.getName() + " : " + m.invoke(paquete));
			}

			List<Paquetesactividades> lstAct = new ArrayList<Paquetesactividades>();
			List<Paquetesmateriales> lstMat = new ArrayList<Paquetesmateriales>();
			List<Paquetesherramientas> lstHer = new ArrayList<Paquetesherramientas>();

			if (session.get("paqHerramientas") != null)
				lstHer = (List<Paquetesherramientas>) session.get("paqHerramientas");
			else {
				addActionMessage("Debe ingresar Herraminetas");
				return "error";
			}
			if (session.get("paqMateriales") != null)
				lstMat = (List<Paquetesmateriales>) session.get("paqMateriales");
			else {
				addActionMessage("Debe ingresar Materiales");
				return "error";
			}
			if (session.get("paqActividades") != null)
				lstAct = (List<Paquetesactividades>) session.get("paqActividades");
			else {
				addActionMessage("Debe ingresar Actividades");
				return "error";
			}
			if (paquete.getModelo() == null) {
				addActionMessage("Debe selecionar un Modelo");
				return "error";
			}
			if (paquete.getId() == 0) {
				if (paqServ.insertar(paquete, lstAct, lstMat, lstHer) == 1) {
					addActionMessage("Error en el ingreso, Revisar los Datos ingresados");
					return "error";
				}
			} else {
				if (paqServ.modificar(paquete, lstAct, lstMat, lstHer) == 1) {
					addActionMessage("Error en la modificacion, Revisar los Datos ingresados");
					return "error";
				}
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public String eliminarPaquete() {
		try {
			paquete = paqServ.getPaquete(paquete.getId());
			paqServ.eliminar(paquete);
			return "success";
		} catch (Exception e) {
			return "error";
		}

	}

	// Estos métodos serán llamados mediante AJAX - Ini
	public String ObtenerModelos() {
		Map session = ActionContext.getContext().getSession();
		try {
			System.out.println("Entro al Action ObtenerModelos");
			List<Modelo> lstModelo = utServ.listModelo(paquete.getMarca());
			session.put("paqueteModelo", lstModelo);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String ObtenerHerramienta() {
		Map session = ActionContext.getContext().getSession();
		try {
			Paquetesherramientas ph = new Paquetesherramientas();
			ph = utServ.getHerramienta(buscHer);
			if (ph == null) {
				addActionMessage("El codigo ingresado no existe");
			} else {
				List<Paquetesherramientas> lst = new ArrayList<Paquetesherramientas>();
				if (session.get("paqHerramientas") != null) {
					lst = (List<Paquetesherramientas>) session.get("paqHerramientas");
				}
				lst.add(ph);
				session.put("paqHerramientas", lst);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public String ObtenerMaterial() {
		Map session = ActionContext.getContext().getSession();
		try {
			Paquetesmateriales pm = new Paquetesmateriales();
			pm = utServ.getMaterial(buscMat);
			if (pm == null) {
				addActionMessage("El codigo ingresado no existe");
			} else {
				List<Paquetesmateriales> lst = new ArrayList<Paquetesmateriales>();
				if (session.get("paqMateriales") != null) {
					lst = (List<Paquetesmateriales>) session.get("paqMateriales");
				}
				lst.add(pm);
				session.put("paqMateriales", lst);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
	
	public String ObtenerActividad() {
		Map session = ActionContext.getContext().getSession();
		try {
			Paquetesactividades pa = new Paquetesactividades();
			pa = utServ.getActividad(buscAct);
			if (pa == null) {
				addActionMessage("El codigo ingresado no existe");
			} else {
				List<Paquetesactividades> lst = new ArrayList<Paquetesactividades>();
				if (session.get("paqActividades") != null) {
					lst = (List<Paquetesactividades>) session.get("paqActividades");
				}
				lst.add(pa);
				session.put("paqActividades", lst);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public String CalcularPrecio() {
		Map session = ActionContext.getContext().getSession();
		Double monto = 0.00;
		List<Paquetesherramientas> lst1 = new ArrayList<Paquetesherramientas>();
		List<Paquetesmateriales> lst2 = new ArrayList<Paquetesmateriales>();
		List<Paquetesactividades> lst3 = new ArrayList<Paquetesactividades>();
		try {
			System.out.println("Entro a Calcular Precio ::: ");
			
			if (session.get("paqHerramientas") != null)
				lst1 = (List<Paquetesherramientas>) session.get("paqHerramientas");
			if (session.get("paqMateriales") != null)
				lst2 = (List<Paquetesmateriales>) session.get("paqMateriales");
			if (session.get("paqActividades") != null)
				lst3 = (List<Paquetesactividades>) session.get("paqActividades");

			monto = monto + calcula1(lst1);
			monto = monto + calcula2(lst2);
			monto = monto + calcula3(lst3);

			paquete.setPrecio(monto);
			System.out.println("Monto = " + monto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	private Double calcula1(List<Paquetesherramientas> lst) {
		double rst = 0.00;
		Iterator it = lst.iterator();
		while (it.hasNext()) {
			Paquetesherramientas pq = (Paquetesherramientas) it.next();
			rst = rst + pq.getPrecio(); // * paquete.getDuracion());
		}
		return rst;
	}

	private Double calcula2(List<Paquetesmateriales> lst) {
		double rst = 0.00;
		Iterator it = lst.iterator();
		while (it.hasNext()) {
			Paquetesmateriales pq = (Paquetesmateriales) it.next();
			rst = rst + pq.getPrecio(); // * paquete.getDuracion());
		}
		return rst;
	}

	private Double calcula3(List<Paquetesactividades> lst) {
		double rst = 0.00;
		Iterator it = lst.iterator();
		while (it.hasNext()) {
			Paquetesactividades pq = (Paquetesactividades) it.next();
			rst = rst + pq.getPrecio(); // * paquete.getDuracion());
		}
		return rst;
	}
	
	public String popBuscarPaquete() {
		Map session = ActionContext.getContext().getSession();
		try {
			if (paquete != null) {
				paquetes = paqServ.popBuscarPaquetes(paquete);
			} else {
				List<Marca> marcas = utServ.listMarca();
				List<Modelo> paqueteModelo = utServ.listModelo("1");
				session.put("marcas", marcas);
				session.put("paqueteModelo", paqueteModelo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	// Estos métodos serán llamados mediante AJAX - Fin

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public int getBuscHer() {
		return buscHer;
	}

	public void setBuscHer(int buscHer) {
		this.buscHer = buscHer;
	}

	public int getBuscMat() {
		return buscMat;
	}

	public void setBuscMat(int buscMat) {
		this.buscMat = buscMat;
	}

	public int getBuscAct() {
		return buscAct;
	}

	public void setBuscAct(int buscAct) {
		this.buscAct = buscAct;
	}

}
