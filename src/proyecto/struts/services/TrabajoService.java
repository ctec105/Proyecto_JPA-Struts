package proyecto.struts.services;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.bean.Ordentrabajo_has_tecnicos;
import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetes_has_ordentrabajo;
import proyecto.struts.bean.Tecnico;
import proyecto.struts.bean.Trabajo;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.TrabajoDAO;

public class TrabajoService {
	ArrayList listar;

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	TrabajoDAO trabajodao = fabrica.getTrabajoDAO();

	public int inserta(Trabajo bean, Hashtable<String, Paquete> paquetes,
			Hashtable<String, Tecnico> tecnicos) throws Exception {
		// TODO Auto-generated method stub
		return trabajodao.inserta(bean, paquetes, tecnicos);
	}

	public List buscarTrabajo(String estado) throws Exception {
		// TODO Auto-generated method stub
		return trabajodao.buscarTrabajo(estado);
	}

	public List<Ordentrabajo> listar() throws Exception {
		// TODO Auto-generated method stub
		return trabajodao.listar();
	}

	public int insertar(Ordentrabajo trabajo, List<Paquete> paquetes,
			List<Tecnico> tecnicos) throws Exception {
		// TODO Auto-generated method stub
		return trabajodao.insertar(trabajo, paquetes, tecnicos);
	}

	public Ordentrabajo getTrabajo(int id) throws Exception {
		// TODO Auto-generated method stub
		return trabajodao.getTrabajo(id);
	}

	public List<Paquetes_has_ordentrabajo> getPaquetes(int idTrabajo)
			throws Exception {
		// TODO Auto-generated method stub
		return trabajodao.getPaquetes(idTrabajo);
	}

	public List<Ordentrabajo_has_tecnicos> getTecnicos(int idTrabajo)
			throws Exception {
		// TODO Auto-generated method stub
		return trabajodao.getTenicos(idTrabajo);
	}

	public int actualizar(Ordentrabajo trabajo, List<Paquete> paquetes,
			List<Tecnico> tecnicos) throws Exception {
		// TODO Auto-generated method stub
		return trabajodao.actualizar(trabajo, paquetes, tecnicos);
	}

	public void actualizar(Ordentrabajo ot) throws Exception {
		// TODO Auto-generated method stub
		trabajodao.actualizar(ot);
	}

}
