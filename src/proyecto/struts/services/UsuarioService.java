package proyecto.struts.services;

import java.util.List;

import proyecto.struts.bean.AreaMenu;
import proyecto.struts.bean.Usuario;
import proyecto.struts.dao.DAOFactory;
import proyecto.struts.dao.UsuarioDAO;

public class UsuarioService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(6);
	UsuarioDAO usuariodao = fabrica.getUsuarioDAO();

	public Usuario logueo(String login, String pwd) throws Exception {
		return usuariodao.LogueoUsuario(login, pwd);
	}

	public List listarUsuarios() throws Exception {
		return usuariodao.Listar();
	}

	public int eliminaUsuario(Usuario login) throws Exception {
		return usuariodao.elimina(login);
	}

	public int inserta(Usuario dao) throws Exception {
		// TODO Auto-generated method stub
		return usuariodao.inserta(dao);
	}

	public Usuario cargaUsuario(int id) throws Exception {
		// TODO Auto-generated method stub
		return usuariodao.getUsuario(id);
	}

	public int modifica(Usuario dao) throws Exception {
		// TODO Auto-generated method stub
		return usuariodao.edita(dao);
	}

	public List menu(String area) throws Exception {
		// TODO Auto-generated method stub
		return usuariodao.menu(area);
	}

	public List permisos(int i) throws Exception {
		// TODO Auto-generated method stub
		return usuariodao.permisos(i);
	}

	public List permisosUpdate(String area, String idS) throws Exception {
		// TODO Auto-generated method stub
		return usuariodao.permisosUpdate(area, idS);
	}

	public List<AreaMenu> permisosAll(int area) throws Exception {
		// TODO Auto-generated method stub
		return usuariodao.permisosAll(area);
	}

}
