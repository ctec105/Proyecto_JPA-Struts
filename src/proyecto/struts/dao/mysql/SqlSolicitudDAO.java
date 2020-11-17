package proyecto.struts.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Equipo;
import proyecto.struts.bean.Estado;
import proyecto.struts.bean.Solicitud;
import proyecto.struts.dao.SolicitudDAO;
import proyecto.struts.util.MySqlDbConn;

public class SqlSolicitudDAO implements SolicitudDAO {

	@Override
	public List<Solicitud> buscarSolicitud(int id, String tarj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int edita(Solicitud bean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int elimina(Solicitud bean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Solicitud getSolicitud(int id) throws Exception {
		Solicitud bean = null;
		Connection cn = MySqlDbConn.obtenerConexion();
		String sql = "SELECT * FROM tb_solicitud Where id_solicitud = ?";
		PreparedStatement stm = cn.prepareStatement(sql);
		stm.setInt(1, id);
		ResultSet rst = stm.executeQuery();

		if (rst.next()) {
			bean = new Solicitud();
			bean.setId(rst.getInt(1));
			bean.setDesc(rst.getString(2));
			bean.setRepresentante(rst.getString(3));

			java.sql.Date dbSqlDate = rst.getDate(4);
			java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());

			bean.setFecha(dbSqlDateConverted);
			bean.setHorometro(rst.getInt(5));

			Estado estado = new Estado();
			estado.setIdestado(rst.getInt(6));
			bean.setEstado(estado);

			Equipo equipo = new Equipo();
			equipo.setNrotarjeta(rst.getString(7));
			bean.setEquipo(equipo);
		}

		rst.close();
		stm.close();
		cn.close();

		return bean;
	}

	public int inserta(Solicitud bean) throws Exception {
		int rpta = 0;
		System.out.println("llego al DAO inserta solicitud");
		Connection cn = MySqlDbConn.obtenerConexion();
		String sql = "INSERT INTO tb_solicitud values(null,?,?,?,?,?,?)";
		PreparedStatement stm = cn.prepareStatement(sql);
		try {

			stm.setString(1, bean.getDesc());
			stm.setString(2, bean.getRepresentante());

			java.util.Date dbSqlDate1 = bean.getFecha();
			java.sql.Date dbSqlDate = new java.sql.Date(dbSqlDate1.getTime());

			stm.setDate(3, dbSqlDate);
			stm.setInt(4, bean.getHorometro());
			stm.setString(5, "V");
			stm.setString(6, bean.getEquipo().getNrotarjeta());
			stm.executeUpdate();

			stm.close();
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			rpta = 1;
		} finally {
			try {
				stm.close();
				cn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rpta;
	}

	public List<Solicitud> buscarSolicitud(String idrepresentante, int tarj) throws Exception {

		Solicitud bean = null;
		Connection cn = MySqlDbConn.obtenerConexion();
		Statement stm = cn.createStatement();
		String sql = " SELECT * FROM tb_solicitud Where ";
		if (!idrepresentante.equals(""))
			sql = sql + " id_solicitud like '" + idrepresentante + "' AND ";
		sql = sql + " tb_equipo_nrotarjeta like '%" + tarj + "%' ";
		System.out.println(sql);
		ResultSet rst = stm.executeQuery(sql);
		ArrayList lista = new ArrayList();

		while (rst.next()) {
			bean = new Solicitud();
			bean.setId(rst.getInt(1));
			bean.setDesc(rst.getString(2));
			bean.setRepresentante(rst.getString(3));

			java.sql.Date bdSqlDate = rst.getDate(4);
			java.util.Date bdSqlDateConverted = new java.util.Date(bdSqlDate.getTime());

			bean.setFecha(bdSqlDateConverted);
			bean.setHorometro(rst.getInt(5));

			Estado estado = new Estado();
			estado.setIdestado(rst.getInt(6));

			bean.setEstado(estado);

			Equipo equipo = new Equipo();
			equipo.setNrotarjeta(rst.getString(7));

			bean.setEquipo(equipo);
			lista.add(bean);
		}

		rst.close();
		stm.close();
		cn.close();

		return lista;
	}

}
