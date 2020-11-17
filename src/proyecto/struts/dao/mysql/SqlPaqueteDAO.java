package proyecto.struts.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Equipo;
import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetesactividades;
import proyecto.struts.bean.Paquetesherramientas;
import proyecto.struts.bean.Paquetesmateriales;
import proyecto.struts.dao.PaqueteDAO;
import proyecto.struts.util.MySqlDbConn;

public class SqlPaqueteDAO implements PaqueteDAO {

	@Override
	public List buscarPaquete(String nro) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paquete getPaquete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public Paquete getPaquete(String id) throws Exception { Paquete
	 * bean= null; Connection cn = MySqlDbConn.obtenerConexion();
	 * 
	 * String sql = "select * From tb_paquetes Where id_paquetes=?";
	 * PreparedStatement stm = cn.prepareStatement(sql); stm.setString(1, id);
	 * ResultSet rst = stm.executeQuery();
	 * 
	 * if (rst.next()) { bean = new Paquete(); bean.setId(rst.getString(1));
	 * bean.setNombre(rst.getString(2)); bean.setModelo(rst.getString(3));
	 * bean.setPrecio(rst.getString(4)); bean.setDuracion(rst.getInt(5)); }
	 * 
	 * rst.close(); stm.close(); cn.close();
	 * 
	 * return bean; }
	 * 
	 * @Override public List buscarPaquete(String nro) throws Exception {
	 * Paquete bean = null; Connection cn = MySqlDbConn.obtenerConexion();
	 * Statement stm = cn.createStatement(); String sql =
	 * " SELECT * FROM tb_paquetes "; if(!nro.equals("")) sql = sql +
	 * " WHERE id_paquetes = "+nro; System.out.println(sql); ResultSet rst =
	 * stm.executeQuery(sql); ArrayList lista = new ArrayList();
	 * 
	 * while(rst.next()) { bean = new Paquete(); bean.setId(rst.getString(1));
	 * bean.setNombre(rst.getString(2)); bean.setModelo(rst.getString(3));
	 * bean.setPrecio(rst.getString(4)); bean.setDuracion(rst.getInt(5));
	 * lista.add(bean); } rst.close(); stm.close(); cn.close();
	 * 
	 * return lista; }
	 */

	@Override
	public List<Paquete> getPaquetes(int buscPaq, List<Paquete> paquetes)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquete> getPaquetes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(Paquete paquete, List<Paquetesactividades> lstAct,
			List<Paquetesmateriales> lstMat, List<Paquetesherramientas> lstHer)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificar(Paquete paquete, List<Paquetesactividades> lstAct,
			List<Paquetesmateriales> lstMat, List<Paquetesherramientas> lstHer)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Paquetesactividades> getActividadesxId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquetesherramientas> getHerramientasxId(int id)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paquetesmateriales> getMaterialesxId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminar(Paquete paquete) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Paquete> popBuscarPaquetes(Paquete paquete) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
