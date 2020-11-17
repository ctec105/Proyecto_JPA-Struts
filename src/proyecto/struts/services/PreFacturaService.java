package proyecto.struts.services;

import java.util.Collection;
import java.util.List;

import proyecto.struts.bean.Detalleprefactura;
import proyecto.struts.bean.Prefactura;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.PrefacturaDAO;

public class PreFacturaService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	PrefacturaDAO dao = fabrica.getPreFacturaDAO();

	public List<Detalleprefactura> getDetFactPaq(Prefactura prefactura)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDetFactPaq(prefactura);
	}

	public List<Detalleprefactura> getDetFactTec(Prefactura prefactura)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDetFactTec(prefactura);
	}

	public void insertar(Prefactura prefactura, List<Detalleprefactura> detalles)
			throws Exception {
		// TODO Auto-generated method stub
		dao.insertar(prefactura, detalles);
	}

	public List<Prefactura> listarPrefacturas() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPrefacturas();
	}

}
