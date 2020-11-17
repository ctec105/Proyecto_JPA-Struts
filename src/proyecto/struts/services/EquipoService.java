package proyecto.struts.services;

import java.util.List;

import proyecto.struts.bean.Equipo;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.EquipoDAO;

public class EquipoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	EquipoDAO equipodao = fabrica.getEquipoDAO();

	public List<Equipo> buscarEquipo(String nroTarjeta, int clase) throws Exception {
		return equipodao.buscarEquipo(nroTarjeta, clase);
	}

	public Equipo getEquipo(String nroTarjeta) throws Exception {
		return equipodao.getEquipo(nroTarjeta);
	}

}
