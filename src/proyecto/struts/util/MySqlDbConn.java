package proyecto.struts.util;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class MySqlDbConn {

	// Registramos el driver de conexion a la b.d. (MySql)
	static {
		// un bloque estatico solo se ejecuta la primera
		// vez que se invoca a la clase

		try {

			// Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection obtenerConexion() throws NamingException {
		Connection conexion = null;

		try {
			// Creamos un contexto jndi inicial
			// Este context no tiene nada que ver con
			// la etiqueta contexto donde esta el pool

			// Este context hace referenceiaa un servicio de nombres
			// naming service
			Context ctx = new InitialContext();
			System.out.println("Se ingreso a la conexion");
			// DataSource ds = (DataSource) ctx.lookup("jdbc/sisepuede");
			// los nombre jndi se crean debajo de un nombre raiz el cual es
			// estandar : java:comp/evn
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/maskiner");

			conexion = ds.getConnection();
			System.out.println("conexion exitosa usando el pool");

			/*
			 * conexion=DriverManager.getConnection(
			 * "jdbc:mysql://localhost:3306/jeedb", "root", "mysql");
			 */

		} catch (SQLException e) {
			System.out.println("Se perdio la conexion");
			e.printStackTrace();
		}
		return conexion;
	}

}
