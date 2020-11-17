package proyecto.struts.dao;

import java.util.List;

import proyecto.struts.bean.Cliente;
import proyecto.struts.bean.Ordenliquidacion;
import proyecto.struts.bean.Ordentrabajo;

public interface LiquidacionDAO {

	public abstract List<Ordentrabajo> findByCliente(Cliente cliente)
			throws Exception;

	public abstract int insertar(Ordenliquidacion liquidacion) throws Exception;

	public abstract Ordenliquidacion findByNoID(Ordenliquidacion liquidacion)
			throws Exception;

	public abstract List<Ordenliquidacion> listLiquidaciones() throws Exception;

	public abstract Ordenliquidacion getLiquidacion(int id) throws Exception;

	public abstract void update(Ordenliquidacion liq) throws Exception;

	public abstract List<Ordenliquidacion> popBuscarLiq(
			Ordenliquidacion liquidacion) throws Exception;

}
