/*
 * Created on 01/10/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package proyecto.struts.dao;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int XML = 5;
	public static final int JPA = 6;

	// Existirá un método por cada DAO que pueda ser creado.
	// Ejemplo:
	// public abstract ArticuloDAO getArticuloDAO();
	public abstract UsuarioDAO getUsuarioDAO();

	public abstract EquipoDAO getEquipoDAO();

	public abstract SolicitudDAO getSolicitudDAO();

	public abstract ClienteDAO getClienteDAO();

	public abstract PaqueteDAO getPaqueteDAO();

	public abstract TecnicoDAO getTecnicoDAO();

	public abstract TrabajoDAO getTrabajoDAO();

	public abstract UtilDAO getUtilDAO();

	public abstract LiquidacionDAO getLiquidacionDAO();

	public abstract EstadoDAO getEstadoDAO();

	public abstract AreaDAO getAreaDAO();

	public abstract PrefacturaDAO getPreFacturaDAO();

	public abstract ReporteDAO getReporteDAO();

	// registramos nuestros daos

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MySqlDAOFactory();
		case JPA:
			return new JPADAOFactory();
			/*
			 * case SQLSERVER: return new SqlDAOFactory(); case ORACLE: return
			 * new OracleDAOFactory(); case DB2: return new Db2DAOFactory();
			 * case SQLSERVER: return new SqlServerDAOFactory(); case XML:
			 * return new XmlDAOFactory();
			 */
		default:
			return null;
		}
	}

}
