package proyecto.struts.dao.mysql;

import java.util.List;

import proyecto.struts.bean.Cliente;
import proyecto.struts.bean.Ordenliquidacion;
import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.dao.LiquidacionDAO;

public class SqlLiquidacionDAO implements LiquidacionDAO {

	@Override
	public List<Ordentrabajo> findByCliente(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(Ordenliquidacion liquidacion) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ordenliquidacion findByNoID(Ordenliquidacion liquidacion)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ordenliquidacion> listLiquidaciones() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordenliquidacion getLiquidacion(int liquidacion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Ordenliquidacion liq) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ordenliquidacion> popBuscarLiq(Ordenliquidacion liquidacion)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
