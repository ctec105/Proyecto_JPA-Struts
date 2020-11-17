package proyecto.struts.dao;

import java.sql.SQLException;
import java.util.List;

import proyecto.struts.bean.AreaMenu;
import proyecto.struts.bean.Usuario;

public interface UsuarioDAO {

	public abstract Usuario LogueoUsuario(String sCodigo, String sPassword) throws SQLException, Exception;

	public abstract List<Usuario> Listar() throws Exception;
	
	public abstract int inserta(Usuario dao) throws Exception;

	public abstract int edita(Usuario dao) throws Exception;

	public abstract int elimina(Usuario bean) throws Exception;

	public abstract Usuario getUsuario(int login) throws Exception;

	// Metodos del menu

	public abstract List menu(String area) throws Exception;

	public abstract List permisos(int i) throws Exception;

	public abstract List permisosUpdate(String area, String idS) throws Exception;

	public abstract List<AreaMenu> permisosAll(int area) throws Exception;

}
