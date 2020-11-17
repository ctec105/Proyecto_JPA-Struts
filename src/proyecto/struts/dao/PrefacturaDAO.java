package proyecto.struts.dao;

import java.util.List;

import proyecto.struts.bean.Detalleprefactura;
import proyecto.struts.bean.Prefactura;

public interface PrefacturaDAO {

	public abstract List<Detalleprefactura> getDetFactPaq(Prefactura prefactura)
			throws Exception;

	public abstract List<Detalleprefactura> getDetFactTec(Prefactura prefactura)
			throws Exception;

	public abstract void insertar(Prefactura prefactura,
			List<Detalleprefactura> detalles) throws Exception;

	public abstract List<Prefactura> listarPrefacturas() throws Exception;

}
