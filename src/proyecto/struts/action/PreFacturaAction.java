package proyecto.struts.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import proyecto.struts.bean.Detalleprefactura;
import proyecto.struts.bean.Ordenliquidacion;
import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.bean.Prefactura;
import proyecto.struts.services.LiquidacionService;
import proyecto.struts.services.PreFacturaService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PreFacturaAction extends ActionSupport {

	private List<Prefactura> prefacturas = new ArrayList<Prefactura>();
	private Prefactura prefactura;
	private List<Detalleprefactura> detalles = new ArrayList<Detalleprefactura>();
	private static PreFacturaService pfServ = new PreFacturaService();

	public String execute() {
		try {
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}

	public String Listaprefacturas() {
		try {
			this.prefacturas = pfServ.listarPrefacturas();
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public String AddorUpdatePreFactura() {
		Map session = ActionContext.getContext().getSession();
		try {
			if (prefactura == null) {
				prefactura = new Prefactura();
				Calendar c1 = Calendar.getInstance();
				prefactura.setUsuario((String) session.get("login"));
				prefactura.setFecha(c1.getTime());
			} else {

			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public String grabarPrefactura() {
		Map session = ActionContext.getContext().getSession();
		try {
			this.detalles = (List<Detalleprefactura>) session.get("detalles");
			if (this.detalles.size() == 0) {
				addActionMessage("No se agregaron ordenes...");
				return "frm";
			}
			pfServ.insertar(this.prefactura, this.detalles);
			LiquidacionService lqsrv = new LiquidacionService();
			Ordenliquidacion liq = new Ordenliquidacion();
			liq = lqsrv.getLiquidacion(prefactura.getLiquidacion().getId());
			liq.setEstado(1);
			lqsrv.update(liq);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return "frm";
		}

	}

	public String CargaDatosLiq() {
		Map session = ActionContext.getContext().getSession();
		try {
			Ordenliquidacion ol;
			LiquidacionService olServ = new LiquidacionService();
			ol = olServ.getLiquidacion(prefactura.getLiquidacion().getId());
			if (ol != null) {
				prefactura.setRuc(ol.getCliente().getId());
				prefactura.setCliente(ol.getCliente().getRazonSoc());
				prefactura.setDireccion(ol.getCliente().getDireccion());

				detalles.addAll(pfServ.getDetFactPaq(prefactura));
				detalles.addAll(pfServ.getDetFactTec(prefactura));
				session.put("detalles", detalles);
			} else {
				addActionMessage("La Orden Ingresada no esta registrada...");
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public List<Prefactura> getPrefacturas() {
		return prefacturas;
	}

	public void setPrefacturas(List<Prefactura> prefacturas) {
		this.prefacturas = prefacturas;
	}

	public Prefactura getPrefactura() {
		return prefactura;
	}

	public void setPrefactura(Prefactura prefactura) {
		this.prefactura = prefactura;
	}

	public List<Detalleprefactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalleprefactura> detalles) {
		this.detalles = detalles;
	}

}
