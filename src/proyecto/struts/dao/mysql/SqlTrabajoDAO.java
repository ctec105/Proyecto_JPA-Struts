package proyecto.struts.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.bean.Ordentrabajo_has_tecnicos;
import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetes_has_ordentrabajo;
import proyecto.struts.bean.Tecnico;
import proyecto.struts.bean.Trabajo;
import proyecto.struts.bean.Usuario;
import proyecto.struts.dao.TrabajoDAO;
import proyecto.struts.util.MySqlDbConn;
import proyecto.struts.util.UtilesVarios;

public class SqlTrabajoDAO implements TrabajoDAO {

	public List buscarTrabajo(String estado) throws Exception {
		Trabajo bean = null;

		Connection cn = MySqlDbConn.obtenerConexion();

		String sql = "SELECT * FROM tb_ordentrabajo";
		System.out.println(sql);
		PreparedStatement stm = cn.prepareStatement(sql);
		// stm.setString(1, sCodigo);
		ResultSet rst = stm.executeQuery();
		ArrayList lista = new ArrayList();
		UtilesVarios utl = new UtilesVarios();

		while (rst.next()) {
			bean = new Trabajo();
			bean.setId(rst.getString(1));
			bean.setInicio(utl.enviarFec(rst.getString(2)));
			bean.setFin(utl.enviarFec(rst.getString(3)));
			bean.setComentario(rst.getString(4));
			bean.setSolicitud(rst.getString(5));
			lista.add(bean);
		}

		rst.close();
		stm.close();
		cn.close();

		return lista;
	}

	@Override
	public List<Paquetes_has_ordentrabajo> getPaquetes(int idTrabajo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ordentrabajo_has_tecnicos> getTenicos(int idTrabajo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordentrabajo getTrabajo(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int inserta(Trabajo bean, Hashtable<String, Paquete> paquetes, Hashtable<String, Tecnico> tecnicos)
			throws Exception {
		int rpta = 0;
		System.out.println("llego al DAO inserta Orden de trabajo");
		Connection cn = MySqlDbConn.obtenerConexion();
		String sql = "INSERT INTO tb_ordenTrabajo values(null,?,?,?,?)";
		PreparedStatement stm = cn.prepareStatement(sql);
		try {
			stm.setString(1, bean.getInicio());
			stm.setString(2, bean.getFin());
			stm.setString(3, bean.getComentario());
			stm.setString(4, bean.getSolicitud());
			stm.executeUpdate();

			String id = null;
			sql = "select max(id_otrabajo) from tb_ordentrabajo";
			Statement stm2 = cn.createStatement();
			ResultSet rst = stm2.executeQuery(sql);
			while (rst.next()) {
				id = rst.getString(1);
				System.out.println(id);
			}

			Enumeration keys = paquetes.keys();
			while (keys.hasMoreElements()) {
				String codigo = (String) keys.nextElement();
				insertaDetPaquetes(paquetes.get(codigo), id);
				System.out.println("insertando detalle paketes " + paquetes.get(codigo));

			}
			Enumeration keys2 = tecnicos.keys();
			while (keys2.hasMoreElements()) {
				String codigo = (String) keys2.nextElement();
				insertaDetTecnicos(tecnicos.get(codigo), id);
				System.out.println("insertando detalle tecnicos " + tecnicos.get(codigo));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			rpta = 1;
		} finally {
			try {
				stm.close();
				cn.close();

			} catch (SQLException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rpta;
	}

	@Override
	public int insertar(Ordentrabajo trabajo, List<Paquete> paquetes, List<Tecnico> tecnicos) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ordentrabajo> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int actualizar(Ordentrabajo trabajo, List<Paquete> paquetes, List<Tecnico> tecnicos) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actualizar(Ordentrabajo ot) throws Exception {
		// TODO Auto-generated method stub

	}

	public void insertaDetTecnicos(Tecnico bean, String id) throws Exception {
		Connection cn = MySqlDbConn.obtenerConexion();
		String sqlT = "INSERT INTO tb_ordentrabajo_has_tb_tecnicos values(?,?)";
		PreparedStatement stm = cn.prepareStatement(sqlT);
		System.out.println(sqlT + " " + "insertando detalletecnicos");
		try {

			stm.setString(1, id);
			stm.setInt(2, bean.getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
				cn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void insertaDetPaquetes(Paquete bean, String id) throws Exception {
		Connection cn = MySqlDbConn.obtenerConexion();
		String sqlP = "INSERT INTO tb_paquetes_has_tb_ordentrabajo values(?,?)";
		PreparedStatement stm = cn.prepareStatement(sqlP);
		System.out.println(sqlP + " " + "insertando detallepaketes");
		try {

			// stm.setString(1, bean.getPaquetes() ); stm.setString(2, id);
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
				cn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
