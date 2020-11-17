package proyecto.struts.services;

import java.util.Date;
import java.util.List;

import proyecto.struts.bean.rpt.Rrt01;
import proyecto.struts.bean.rpt.Rrt02;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.ReporteDAO;

public class ReporteService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	ReporteDAO dao = fabrica.getReporteDAO();

	public List<Rrt01> reporte1(Date fecInicio, Date fecFin) throws Exception {
		// TODO Auto-generated method stub
		return dao.reporte1(fecInicio, fecFin);
	}

	public List<Rrt02> reporte2() throws Exception {
		// TODO Auto-generated method stub
		return dao.reporte2();
	}

}
