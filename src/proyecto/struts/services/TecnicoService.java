package proyecto.struts.services;

import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Tecnico;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.TecnicoDAO;

public class TecnicoService {
	ArrayList listar;

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	TecnicoDAO tecnicodao = fabrica.getTecnicoDAO();

	public List buscarTecnico(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return tecnicodao.buscarTecnico(nombre);
	}

	public Tecnico getTecnico(int id) throws Exception {
		// TODO Auto-generated method stub
		return tecnicodao.getTecnico(id);
	}

	public List<Tecnico> popBuscarTecn(Tecnico tecnico) throws Exception {
		// TODO Auto-generated method stub
		return tecnicodao.popBuscarTecn(tecnico);
	}

}
