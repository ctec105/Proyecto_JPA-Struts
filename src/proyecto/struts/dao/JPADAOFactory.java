package proyecto.struts.dao;

import proyecto.struts.dao.jpa.JPAAreaDAO;
import proyecto.struts.dao.jpa.JPAClienteDAO;
import proyecto.struts.dao.jpa.JPAEquipoDAO;
import proyecto.struts.dao.jpa.JPAEstadoDAO;
import proyecto.struts.dao.jpa.JPALiquidacionDAO;
import proyecto.struts.dao.jpa.JPAPaqueteDAO;
import proyecto.struts.dao.jpa.JPAPrefacturaDAO;
import proyecto.struts.dao.jpa.JPAReporteDAO;
import proyecto.struts.dao.jpa.JPASolicitudDAO;
import proyecto.struts.dao.jpa.JPATecnicoDAO;
import proyecto.struts.dao.jpa.JPATrabajoDAO;
import proyecto.struts.dao.jpa.JPAUsuarioDAO;
import proyecto.struts.dao.jpa.JPAUtilDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new JPAClienteDAO();
	}

	@Override
	public EquipoDAO getEquipoDAO() {
		// TODO Auto-generated method stub
		return new JPAEquipoDAO();
	}

	@Override
	public LiquidacionDAO getLiquidacionDAO() {
		// TODO Auto-generated method stub
		return new JPALiquidacionDAO();
	}

	@Override
	public PaqueteDAO getPaqueteDAO() {
		// TODO Auto-generated method stub
		return new JPAPaqueteDAO();
	}

	@Override
	public SolicitudDAO getSolicitudDAO() {
		// TODO Auto-generated method stub
		return new JPASolicitudDAO();
	}

	@Override
	public TecnicoDAO getTecnicoDAO() {
		// TODO Auto-generated method stub
		return new JPATecnicoDAO();
	}

	@Override
	public TrabajoDAO getTrabajoDAO() {
		// TODO Auto-generated method stub
		return new JPATrabajoDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuarioDAO();
	}

	@Override
	public UtilDAO getUtilDAO() {
		// TODO Auto-generated method stub
		return new JPAUtilDAO();
	}

	@Override
	public EstadoDAO getEstadoDAO() {
		// TODO Auto-generated method stub
		return new JPAEstadoDAO();
	}

	@Override
	public AreaDAO getAreaDAO() {
		// TODO Auto-generated method stub
		return new JPAAreaDAO();
	}

	@Override
	public PrefacturaDAO getPreFacturaDAO() {
		// TODO Auto-generated method stub
		return new JPAPrefacturaDAO();
	}

	@Override
	public ReporteDAO getReporteDAO() {
		// TODO Auto-generated method stub
		return new JPAReporteDAO();
	}

}
