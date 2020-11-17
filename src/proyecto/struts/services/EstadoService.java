package proyecto.struts.services;

import proyecto.struts.bean.Estado;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.EstadoDAO;

public class EstadoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	EstadoDAO estadodao = fabrica.getEstadoDAO();

	public Estado getEstado(int id) throws Exception {
		return estadodao.getEstado(id);
	}

}
