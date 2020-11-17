package proyecto.struts.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.struts.bean.Cliente;
import proyecto.struts.bean.Equipo;
import proyecto.struts.bean.Usuario;
import proyecto.struts.dao.ClienteDAO;
import proyecto.struts.util.MySqlDbConn;

public class SqlClienteDAO implements ClienteDAO {

	public Cliente getCliente(int idCliente) throws Exception {

		Cliente bean = null;
		Connection cn = MySqlDbConn.obtenerConexion();

		String sql = "SELECT * FROM tb_cliente  Where id_cliente=?";
		PreparedStatement stm = cn.prepareStatement(sql);
		stm.setInt(1, idCliente);
		ResultSet rst = stm.executeQuery();
		if (rst.next()) {
			bean = new Cliente();
			bean.setId(rst.getString(1));
			bean.setRazonSoc(rst.getString(2));
			bean.setDireccion(rst.getString(3));
			bean.setTelefono(rst.getString(4));
		}

		rst.close();
		stm.close();
		cn.close();

		return bean;
	}

	public List listarClientes() throws Exception {
		Cliente obj = null;

		Connection cn = MySqlDbConn.obtenerConexion();
		Statement stm = cn.createStatement();
		String sql = "SELECT * FROM tb_cliente ";
		ResultSet rst = stm.executeQuery(sql);

		ArrayList lista = new ArrayList();
		while (rst.next()) {
			obj = new Cliente();
			obj.setId(rst.getString(1));
			obj.setRazonSoc(rst.getString(2));
			obj.setDireccion(rst.getString(3));
			obj.setTelefono(rst.getString(4));
			lista.add(obj);
		}
		return lista;
	}

	@Override
	public int inserta(Cliente bean) throws Exception {
		int rpta = 0;
		Connection cn = MySqlDbConn.obtenerConexion();
		String sql = "INSERT INTO tb_cliente values(?,?,?,?)";
		PreparedStatement stm = cn.prepareStatement(sql);
		try {
			stm.setString(1, bean.getId());
			stm.setString(2, bean.getRazonSoc());
			stm.setString(3, bean.getDireccion());
			stm.setString(4, bean.getTelefono());
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rpta;
	}

	@Override
	public int elimina(Cliente bean) throws Exception {
		// try{
		// System.out.println("llego al DAO elimina");
		// int rpta = 0;
		//
		// Connection cn = MySqlDbConn.obtenerConexion();
		//
		// String sql = "Delete from tb_cliente  WHERE id_cliente = '"+id+"'";
		// System.out.println(sql);
		// PreparedStatement stm = cn.prepareStatement(sql);
		// //stm.setString(1, login);
		// rpta = stm.executeUpdate(sql);
		// stm.close();
		// cn.close();
		// return rpta;
		// }catch (SQLException e){
		// System.out.println("Ocurrió una excepcion al insertar..."+e);
		// throw new Exception(e);
		//
		// }
		return 0;
	}

	@Override
	public int edita(Cliente bean) throws Exception {
		int rpta = 0;
		Connection cn = MySqlDbConn.obtenerConexion();
		String sql = "Update tb_cliente set razonsocial=?, direccion= ?, telefono=? Where id_cliente=?";
		System.out.println(sql);
		System.out.println(bean.getId());
		PreparedStatement stm = cn.prepareStatement(sql);
		try {
			stm.setString(1, bean.getRazonSoc());
			stm.setString(2, bean.getDireccion());
			stm.setString(3, bean.getTelefono());
			stm.setString(4, bean.getId());
			stm.executeUpdate();

			// stm.close();
			// cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			rpta = 1;
		} finally {
			try {
				stm.close();
				cn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rpta;
	}

	@Override
	public Cliente getCliente(String idCliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarCliente(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
