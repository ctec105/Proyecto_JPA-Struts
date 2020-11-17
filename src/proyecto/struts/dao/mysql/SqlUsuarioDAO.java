package proyecto.struts.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import proyecto.struts.util.MySqlDbConn;
import proyecto.struts.bean.AreaMenu;
import proyecto.struts.bean.Menu;
import proyecto.struts.bean.Permisos;
import proyecto.struts.bean.Usuario;
import proyecto.struts.dao.UsuarioDAO;

public class SqlUsuarioDAO implements UsuarioDAO {

	@Override
	public List<Usuario> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario LogueoUsuario(String sCodigo, String sPassword)
			throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int edita(Usuario dao) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int elimina(Usuario bean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario getUsuario(int login) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int inserta(Usuario dao) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List menu(String area) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List permisos(int idArea) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List permisosUpdate(String area, String idS) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AreaMenu> permisosAll(int area) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public Usuario LogueoUsuario(String sCodigo, String sPassword) throws
	 * Exception { System.out.println("llego al DAO");
	 * 
	 * Usuario objEntidad = null;
	 * 
	 * Connection cn = MySqlDbConn.obtenerConexion();
	 * 
	 * String sql =
	 * "SELECT login, nombre, ape_pat, ape_mat, tb_area_id_area, descripcion FROM tb_usuarios t inner join tb_area a on t.tb_area_id_area = a.id_area where login=?  and password = ?"
	 * ; System.out.println(sql); PreparedStatement stm =
	 * cn.prepareStatement(sql); stm.setString(1, sCodigo); stm.setString(2,
	 * sPassword);
	 * 
	 * ResultSet rst = stm.executeQuery();
	 * 
	 * if (rst.next()) { objEntidad = new Usuario();
	 * objEntidad.setLogin(rst.getString(1));
	 * objEntidad.setArea(rst.getString(5));
	 * objEntidad.setNombre(rst.getString(2));
	 * objEntidad.setApePat(rst.getString(3));
	 * objEntidad.setApeMat(rst.getString(4));
	 * 
	 * }
	 * 
	 * rst.close(); stm.close(); cn.close();
	 * 
	 * return objEntidad; }
	 * 
	 * public List Listar() throws Exception {
	 * System.out.println("llego al DAO");
	 * 
	 * Usuario objusuario = null;
	 * 
	 * Connection cn = MySqlDbConn.obtenerConexion(); Statement stm =
	 * cn.createStatement(); String sql =
	 * " SELECT u.id_usuario, u.nombre, u.ape_pat, u.ape_mat, u.fecha_ingreso, login, a.descripcion "
	 * +
	 * " FROM tb_usuarios u INNER JOIN tb_area a ON u.tb_area_id_area = a.id_area "
	 * ; ResultSet rst = stm.executeQuery(sql);
	 * 
	 * ArrayList lista = new ArrayList();
	 * 
	 * while(rst.next()) {
	 * 
	 * objusuario = new Usuario(); objusuario.setId(rst.getString(1));
	 * objusuario.setNombre(rst.getString(2));
	 * objusuario.setApePat(rst.getString(3));
	 * objusuario.setApeMat(rst.getString(4));
	 * objusuario.setFecIngreso(rst.getString(5));
	 * objusuario.setLogin(rst.getString(6));
	 * objusuario.setArea(rst.getString(7)); lista.add(objusuario); }
	 * 
	 * rst.close(); stm.close(); cn.close();
	 * 
	 * return lista; }
	 * 
	 * public int eliminaUsuario(String login) throws Exception { try{
	 * System.out.println("llego al DAO elimina"); int rpta = 0;
	 * 
	 * Connection cn = MySqlDbConn.obtenerConexion();
	 * 
	 * String sql = "Delete from tb_usuarios  WHERE id_usuario = '"+login+"'";
	 * System.out.println(sql); PreparedStatement stm =
	 * cn.prepareStatement(sql); //stm.setString(1, login); rpta =
	 * stm.executeUpdate(sql); stm.close(); cn.close(); return rpta; }catch
	 * (SQLException e){
	 * System.out.println("Ocurrió una excepcion al insertar..."+e); throw new
	 * Exception(e);
	 * 
	 * } }
	 * 
	 * public int insertaUsuario(Usuario dao) throws Exception { int rpta = 0;
	 * 
	 * System.out.println("llego al DAO inserta usuario"); Usuario obj = null;
	 * Connection cn = MySqlDbConn.obtenerConexion(); //String sql =
	 * "insert into tb_usuario(login, pwd, codTipo, nombre, apepat, apemat) values(?,?,?,?,?,?) "
	 * ; String sql = "insert into tb_usuarios values(null,'" + dao.getNombre()
	 * +"','" + dao.getApePat() +"','" + dao.getApeMat() +"','" +
	 * dao.getFecIngreso()+"','" + dao.getLogin()+"','" + dao.getPwd()+"','" +
	 * dao.getArea()+"') "; System.out.println(sql); PreparedStatement stm =
	 * cn.prepareStatement(sql); rpta = stm.executeUpdate(sql); stm.close();
	 * cn.close(); System.out.println("paso dao"); return rpta; }
	 * 
	 * public Usuario cargaUsuario(String login) throws Exception {
	 * System.out.println("llego al DAO");
	 * 
	 * Usuario objEntidad = null;
	 * 
	 * Connection cn = MySqlDbConn.obtenerConexion();
	 * 
	 * String sql = "select * from tb_usuarios where id_usuario =? ";
	 * System.out.println(sql); PreparedStatement stm =
	 * cn.prepareStatement(sql); stm.setString(1, login);
	 * 
	 * ResultSet rst = stm.executeQuery();
	 * 
	 * if (rst.next()) { objEntidad = new Usuario();
	 * objEntidad.setId(rst.getString(1));
	 * objEntidad.setNombre(rst.getString(2));
	 * objEntidad.setApePat(rst.getString(3));
	 * objEntidad.setApeMat(rst.getString(4));
	 * objEntidad.setFecIngreso(rst.getString(5));
	 * objEntidad.setLogin(rst.getString(6));
	 * //objEntidad.setPwd(rst.getString(7));
	 * objEntidad.setArea(rst.getString(8)); }
	 * 
	 * rst.close(); stm.close(); cn.close();
	 * 
	 * return objEntidad; }
	 * 
	 * public int modificaUsuario(Usuario dao) throws Exception {
	 * System.out.println("llego al DAO modifica"); int rpta = 0; Usuario
	 * usuario = null; Connection cn = MySqlDbConn.obtenerConexion(); String sql
	 * = "Update tb_usuarios set " + " nombre = '"+dao.getNombre()+"'," +
	 * " ape_Pat = '"+dao.getApePat()+"'," + " ape_Mat= '"+dao.getApeMat()+"',"
	 * + " fecha_ingreso= '"+dao.getFecIngreso()+"'," +
	 * " tb_area_id_area = '"+dao.getArea()+"'" +
	 * " Where id_usuario= '"+dao.getId()+"'"; System.out.println(sql);
	 * PreparedStatement stm = cn.prepareStatement(sql);
	 * 
	 * //stm.setString(1, dao.getNombre()); //stm.setString(2, dao.getApePat());
	 * //stm.setString(3, dao.getApeMat()); //stm.setString(4,
	 * dao.getCodTipo()); //stm.setString(5, dao.getLogin());
	 * //System.out.println(dao.getLogin()); rpta = stm.executeUpdate(sql);
	 * stm.close(); cn.close(); System.out.println(rpta); return rpta; }
	 * 
	 * @Override public List menu(String area) throws Exception { // TODO
	 * Auto-generated method stub Menu menu = null; Connection cn =
	 * MySqlDbConn.obtenerConexion(); Statement stm = cn.createStatement();
	 * String sql =
	 * "SELECT m.* FROM tb_menu m inner join tb_area_has_tb_menu d "; sql = sql
	 * +
	 * " on m.id_menu = d.tb_menu_id_menu  Where d.ver = 'S' and tb_area_id_area = '"
	 * +area+"' Order by nivel ASC"; System.out.println(sql); ResultSet rst =
	 * stm.executeQuery(sql);
	 * 
	 * ArrayList lista = new ArrayList();
	 * 
	 * while(rst.next()) { menu = new Menu(); menu.setId(rst.getInt(1));
	 * menu.setNivel(rst.getString(2)); menu.setTitulo(rst.getString(3));
	 * menu.setAction(rst.getString(4)); if(rst.getString(2).length()==1)
	 * menu.setGrupo(0); else menu.setGrupo(1); lista.add(menu); } rst.close();
	 * stm.close(); cn.close();
	 * 
	 * return lista; }
	 * 
	 * @Override public List permisos(String idArea) throws Exception {
	 * 
	 * Connection cn = MySqlDbConn.obtenerConexion(); Permisos bean =null;
	 * Statement stm = cn.createStatement(); String sql =
	 * " SELECT tb_area_id_area, id_menu, nivel, titulo, ver FROM tb_area_has_tb_menu "
	 * +
	 * " inner Join tb_menu m on tb_menu_id_menu = id_menu WHERE tb_area_id_area = "
	 * +idArea+ " Order By nivel "; ResultSet rst = stm.executeQuery(sql);
	 * ArrayList lista = new ArrayList(); System.out.println(sql);
	 * 
	 * while(rst.next()) { bean = new Permisos(); bean.setIdArea(rst.getInt(1));
	 * bean.setIdMenu(rst.getInt(2)); bean.setNivel(rst.getString(3));
	 * bean.setTitulo(rst.getString(4)); if(rst.getString(5).equals("S"))
	 * bean.setVer("0"); else bean.setVer("1");
	 * 
	 * if(rst.getString(3).length()==1) bean.setEnc(0); else bean.setEnc(1);
	 * lista.add(bean); }
	 * 
	 * rst.close(); stm.close(); cn.close();
	 * 
	 * return lista; }
	 * 
	 * @Override public List permisosUpdate(String area, String idS) throws
	 * Exception { List lista ; Usuario usuario = null; Connection cn =
	 * MySqlDbConn.obtenerConexion(); String sql =
	 * "Update tb_area_has_tb_menu set ver = 'S' Where tb_menu_id_menu in ("
	 * +idS+") and tb_area_id_area ="+area; String sql2 =
	 * "Update tb_area_has_tb_menu set ver = 'N' Where not tb_menu_id_menu in ("
	 * +idS+") and tb_area_id_area ="+area; PreparedStatement stm =
	 * cn.prepareStatement(sql); PreparedStatement stm2 =
	 * cn.prepareStatement(sql2); try { stm.executeUpdate();
	 * stm2.executeUpdate(); lista = permisos(area); } catch (SQLException e) {
	 * e.printStackTrace(); lista = null; }finally{ try { stm.close();
	 * cn.close();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } return lista; }
	 */
}
