package proyecto.struts.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Equipo;
import proyecto.struts.dao.EquipoDAO;
import proyecto.struts.util.MySqlDbConn;

public class SqlEquipoDAO implements EquipoDAO {

	@Override
	public List<Equipo> buscarEquipo(String nroTarjeta, int clase)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int edita() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int elimina() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Equipo getEquipo(String nroTarjeta) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inserta() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * public List buscarEquipo(String nroTarjeta, String clase) throws
	 * Exception { System.out.println("llego al DAO");
	 * 
	 * Equipo bean = null; Connection cn = MySqlDbConn.obtenerConexion();
	 * Statement stm = cn.createStatement(); String sql =
	 * " SELECT * FROM tb_equipo "; if(!nroTarjeta.equals("") ||
	 * !clase.equals("*")) sql = sql + " WHERE "; if(!nroTarjeta.equals("")) sql
	 * = sql + " nrotarjeta like '" + nroTarjeta + "%' ";
	 * if(!nroTarjeta.equals("") && !clase.equals("*")) sql = sql + " and ";
	 * if(!clase.equals("*")) sql = sql + " tb_claseEquipo_id_claseEquipo = '" +
	 * clase + "' "; System.out.println(sql); ResultSet rst =
	 * stm.executeQuery(sql); ArrayList lista = new ArrayList();
	 * 
	 * while(rst.next()) { bean = new Equipo();
	 * bean.setNroTarjeta(rst.getString(1)); bean.setNroSerie(rst.getString(2));
	 * bean.setClase(rst.getString(3)); bean.setIdCliente(rst.getString(4));
	 * bean.setModelo(rst.getString(5)); lista.add(bean); }
	 * 
	 * rst.close(); stm.close(); cn.close();
	 * 
	 * return lista; }
	 * 
	 * public Equipo getEquipo(String nroTarjeta) throws Exception {
	 * 
	 * Equipo bean= null; Connection cn = MySqlDbConn.obtenerConexion();
	 * 
	 * String sql = "select * From tb_equipo Where nroTarjeta=?";
	 * PreparedStatement stm = cn.prepareStatement(sql); stm.setString(1,
	 * nroTarjeta); ResultSet rst = stm.executeQuery();
	 * 
	 * if (rst.next()) { bean = new Equipo();
	 * bean.setNroTarjeta(rst.getString(1)); bean.setNroSerie(rst.getString(2));
	 * bean.setClase(rst.getString(3)); bean.setIdCliente(rst.getString(4));
	 * bean.setModelo(rst.getString(5)); }
	 * 
	 * rst.close(); stm.close(); cn.close();
	 * 
	 * return bean; }
	 * 
	 * @Override public int edita() throws Exception { // TODO Auto-generated
	 * method stub return 0; }
	 * 
	 * @Override public int elimina() throws Exception { // TODO Auto-generated
	 * method stub return 0; }
	 * 
	 * @Override public int inserta() throws Exception { // TODO Auto-generated
	 * method stub return 0; }
	 */
}
