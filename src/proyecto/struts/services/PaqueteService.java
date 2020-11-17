package proyecto.struts.services;

import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetesactividades;
import proyecto.struts.bean.Paquetesherramientas;
import proyecto.struts.bean.Paquetesmateriales;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.PaqueteDAO;

public class PaqueteService {
	ArrayList listar;
	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	PaqueteDAO paquetedao = fabrica.getPaqueteDAO();

	public Paquete getPaquete(int id) throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.getPaquete(id);
	}

	public List<Paquete> buscarPaquete(String nro) throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.buscarPaquete(nro);
	}

	public List<Paquete> getPaquetes(int buscPaq, List<Paquete> paquetes) throws Exception {
		return paquetedao.getPaquetes(buscPaq, paquetes);

	}

	public List<Paquete> getListPaquetes() throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.getPaquetes();
	}

	public int insertar(Paquete paquete, List<Paquetesactividades> lstAct,
			List<Paquetesmateriales> lstMat, List<Paquetesherramientas> lstHer)
			throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.insertar(paquete, lstAct, lstMat, lstHer);
	}

	public int modificar(Paquete paquete, List<Paquetesactividades> lstAct,
			List<Paquetesmateriales> lstMat, List<Paquetesherramientas> lstHer)
			throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.modificar(paquete, lstAct, lstMat, lstHer);
	}

	public List<Paquetesherramientas> getHerramientasxId(int id)
			throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.getHerramientasxId(id);
	}

	public List<Paquetesmateriales> getMaterialesxId(int id) throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.getMaterialesxId(id);
	}

	public List<Paquetesactividades> getActividadesxId(int id) throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.getActividadesxId(id);
	}

	public int eliminar(Paquete paquete) throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.eliminar(paquete);
	}

	public List<Paquete> popBuscarPaquetes(Paquete paquete) throws Exception {
		// TODO Auto-generated method stub
		return paquetedao.popBuscarPaquetes(paquete);
	}

}
