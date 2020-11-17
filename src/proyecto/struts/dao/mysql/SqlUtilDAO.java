package proyecto.struts.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Area;
import proyecto.struts.bean.ClaseEquipo;
import proyecto.struts.bean.Especialidad;
import proyecto.struts.bean.Estado;
import proyecto.struts.bean.Marca;
import proyecto.struts.bean.Modelo;
import proyecto.struts.bean.Paquetesactividades;
import proyecto.struts.bean.Paquetesherramientas;
import proyecto.struts.bean.Paquetesmateriales;
import proyecto.struts.bean.Solicitud;
import proyecto.struts.bean.Tecnico;
import proyecto.struts.bean.UtilBean;
import proyecto.struts.dao.UtilDAO;
import proyecto.struts.util.MySqlDbConn;

public class SqlUtilDAO implements UtilDAO {

	@Override
	public List lista(String table) throws Exception {
		UtilBean bean = null;
		Connection cn = MySqlDbConn.obtenerConexion();
		Statement stm = cn.createStatement();
		String sql = "Select * From tb_" + table;
		ResultSet rst = stm.executeQuery(sql);
		ArrayList lista = new ArrayList();

		while (rst.next()) {
			bean = new UtilBean();
			bean.setId(rst.getString(1));
			bean.setDesc(rst.getString(2));
			lista.add(bean);
		}
		rst.close();
		stm.close();
		cn.close();

		return lista;
	}

	@Override
	public UtilBean getUtil(String table, String id) throws Exception {
		int rpta = 0;
		UtilBean bean = null;
		Connection cn = MySqlDbConn.obtenerConexion();
		String sql = "Select * From tb_" + table + " Where id_" + table
				+ " = ?";
		PreparedStatement stm = cn.prepareStatement(sql);
		stm.setString(1, id);
		ResultSet rst = stm.executeQuery();

		if (rst.next()) {
			bean = new UtilBean();
			bean.setId(rst.getString(1));
			bean.setDesc(rst.getString(2));

		}

		rst.close();
		stm.close();
		cn.close();

		return bean;
	}

	@Override
	public List<Marca> listMarca() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modelo> listModelo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modelo> listModelo(String marca) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquetesactividades getActividad(int buscAct) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquetesherramientas getHerramienta(int buscHer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquetesmateriales getMaterial(int buscMat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClaseEquipo> getClasesEquipos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> getEstados() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Especialidad> listEspecialidad() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquetesherramientas> popBucarHerramienta(
			Paquetesherramientas herramienta) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquetesactividades> popBuscarActividad(
			Paquetesactividades actividad) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquetesmateriales> popBuscarMaterial(
			Paquetesmateriales material) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Area getArea(int codArea) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}