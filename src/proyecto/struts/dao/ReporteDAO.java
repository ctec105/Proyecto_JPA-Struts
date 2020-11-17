package proyecto.struts.dao;

import java.util.Date;
import java.util.List;

import proyecto.struts.bean.rpt.Rrt01;
import proyecto.struts.bean.rpt.Rrt02;

public interface ReporteDAO {

	public abstract List<Rrt02> reporte2() throws Exception;

	public abstract List<Rrt01> reporte1(Date fecInicio, Date fecFin)
			throws Exception;

}
