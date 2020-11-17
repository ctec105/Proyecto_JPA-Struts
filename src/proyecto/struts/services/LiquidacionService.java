package proyecto.struts.services;

import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Cliente;
import proyecto.struts.bean.Ordenliquidacion;
import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.LiquidacionDAO;

public class LiquidacionService {

	ArrayList listar;
	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	LiquidacionDAO liqdao = fabrica.getLiquidacionDAO();

	public List<Ordentrabajo> findByCliente(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return liqdao.findByCliente(cliente);
	}

	public int insertar(Ordenliquidacion liquidacion) throws Exception {
		// TODO Auto-generated method stub
		return liqdao.insertar(liquidacion);
	}

	public Ordenliquidacion findByNoID(Ordenliquidacion liquidacion) throws Exception {
		// TODO Auto-generated method stub
		return liqdao.findByNoID(liquidacion);
	}

	public List<Ordenliquidacion> listLiquidaciones() throws Exception {
		// TODO Auto-generated method stub
		return liqdao.listLiquidaciones();
	}

	public Ordenliquidacion getLiquidacion(int id) throws Exception {
		// TODO Auto-generated method stub
		return liqdao.getLiquidacion(id);
	}

	public void update(Ordenliquidacion liq) throws Exception {
		// TODO Auto-generated method stub
		liqdao.update(liq);
	}

	public List<Ordenliquidacion> popBuscarLiq(Ordenliquidacion liquidacion) throws Exception {
		// TODO Auto-generated method stub
		return liqdao.popBuscarLiq(liquidacion);
	}
}
