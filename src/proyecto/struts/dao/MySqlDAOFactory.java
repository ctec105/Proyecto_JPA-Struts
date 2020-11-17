/*
 * Created on 01/10/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package proyecto.struts.dao;

import proyecto.struts.dao.mysql.SqlClienteDAO;
import proyecto.struts.dao.mysql.SqlEquipoDAO;
import proyecto.struts.dao.mysql.SqlLiquidacionDAO;
import proyecto.struts.dao.mysql.SqlPaqueteDAO;
import proyecto.struts.dao.mysql.SqlSolicitudDAO;
import proyecto.struts.dao.mysql.SqlTecnicoDAO;
import proyecto.struts.dao.mysql.SqlTrabajoDAO;
import proyecto.struts.dao.mysql.SqlUsuarioDAO;
import proyecto.struts.dao.mysql.SqlUtilDAO;

public class MySqlDAOFactory extends DAOFactory {

	public UsuarioDAO getUsuarioDAO() {
		return new SqlUsuarioDAO();
	}

	public EquipoDAO getEquipoDAO() {
		return new SqlEquipoDAO();
	}

	public SolicitudDAO getSolicitudDAO() {
		return new SqlSolicitudDAO();
	}

	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new SqlClienteDAO();
	}

	public PaqueteDAO getPaqueteDAO() {
		// TODO Auto-generated method stub
		return new SqlPaqueteDAO();
	}

	@Override
	public TecnicoDAO getTecnicoDAO() {
		// TODO Auto-generated method stub
		return new SqlTecnicoDAO();
	}

	@Override
	public TrabajoDAO getTrabajoDAO() {
		// TODO Auto-generated method stub
		return new SqlTrabajoDAO();
	}

	@Override
	public UtilDAO getUtilDAO() {
		// TODO Auto-generated method stub
		return new SqlUtilDAO();
	}

	@Override
	public LiquidacionDAO getLiquidacionDAO() {
		// TODO Auto-generated method stub
		return new SqlLiquidacionDAO();
	}

	@Override
	public EstadoDAO getEstadoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AreaDAO getAreaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrefacturaDAO getPreFacturaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReporteDAO getReporteDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
