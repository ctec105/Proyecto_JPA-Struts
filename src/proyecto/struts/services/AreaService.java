package proyecto.struts.services;

import java.util.List;

import proyecto.struts.bean.Area;
import proyecto.struts.dao.AreaDAO;
import proyecto.struts.dao.DAOFactory;

public class AreaService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	AreaDAO areadao = fabrica.getAreaDAO();

	public List<Area> getListAreas() throws Exception {
		// TODO Auto-generated method stub
		return areadao.getListAreas();
	}
}
