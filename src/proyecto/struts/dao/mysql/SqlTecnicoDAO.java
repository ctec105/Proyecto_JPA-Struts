package proyecto.struts.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Tecnico;
import proyecto.struts.dao.TecnicoDAO;
import proyecto.struts.util.MySqlDbConn;

public class SqlTecnicoDAO implements TecnicoDAO {

	@Override
	public List buscarTecnico(String nombre) throws Exception {
		Tecnico bean = null;
		Connection cn = MySqlDbConn.obtenerConexion();
		Statement stm = cn.createStatement();
		String sql = " SELECT id_tecnicos, nombre, ape_pat, ape_mat, fecha_ingreso, disponible, e.descripcion, supervisor "
				+ "FROM tb_tecnicos t Inner Join tb_especialidades e on t.tb_especialidades_id_especialidad = e.id_especialidad ";
		if (!nombre.equals(""))
			sql = sql + " WHERE nombre like '%" + nombre + "%'";
		System.out.println(sql);
		ResultSet rst = stm.executeQuery(sql);
		ArrayList lista = new ArrayList();

		while (rst.next()) {
			bean = new Tecnico();
			bean.setId(rst.getInt(1));
			bean.setNombre(rst.getString(2));
			bean.setApe_pat(rst.getString(3));
			bean.setApe_mat(rst.getString(4));
			java.sql.Date dbSqlDate = rst.getDate(5);
			java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());
			bean.setFecha_ingreso(dbSqlDateConverted);
			bean.setDisponible(rst.getString(6));
			bean.setIdEspecialidad(rst.getInt(7));
			bean.setSupervisor(rst.getInt(8));
			lista.add(bean);
		}
		rst.close();
		stm.close();
		cn.close();

		return lista;
	}

	@Override
	public Tecnico getTecnico(int id) throws Exception {
		Tecnico bean = null;
		Connection cn = MySqlDbConn.obtenerConexion();

		String sql = " SELECT id_tecnicos, nombre, ape_pat, ape_mat, fecha_ingreso, disponible, e.descripcion, supervisor "
				+ "FROM tb_tecnicos t Inner Join tb_especialidades e on t.tb_especialidades_id_especialidad = e.id_especialidad "
				+ "Where id_tecnicos=?";
		PreparedStatement stm = cn.prepareStatement(sql);
		stm.setInt(1, id);
		ResultSet rst = stm.executeQuery();

		if (rst.next()) {
			bean = new Tecnico();
			bean.setId(rst.getInt(1));
			bean.setNombre(rst.getString(2));
			bean.setApe_pat(rst.getString(3));
			bean.setApe_mat(rst.getString(4));
			java.sql.Date dbSqlDate = rst.getDate(5);
			java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());
			bean.setFecha_ingreso(dbSqlDateConverted);
			bean.setDisponible(rst.getString(6));
			bean.setIdEspecialidad(rst.getInt(7));
			bean.setSupervisor(rst.getInt(8));
		}
		rst.close();
		stm.close();
		cn.close();

		return bean;
	}

	@Override
	public List<Tecnico> popBuscarTecn(Tecnico tecnico) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
