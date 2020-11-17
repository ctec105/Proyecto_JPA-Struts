package proyecto.struts.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import proyecto.struts.bean.AreaMenu;
import proyecto.struts.bean.Usuario;
import proyecto.struts.dao.UsuarioDAO;

public class JPAUsuarioDAO extends GenericDAOJpa<Long, Usuario> implements UsuarioDAO {

	@Override
	public List<Usuario> Listar() throws Exception {
		Query q = getEntityManager().createQuery("select u from Usuario u ");
		List<Usuario> results = q.getResultList();
		System.out.println("Registros encontrados :" + results.size());
		return results;
	}

	@Override
	public Usuario LogueoUsuario(String sCodigo, String sPassword) throws SQLException, Exception {
		Query q = getEntityManager().createQuery("select u from Usuario u WHERE u.login = ?1 AND u.password = ?2");
		q.setParameter(1, sCodigo);
		q.setParameter(2, sPassword);
		List<Usuario> results = q.getResultList();
		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}

	@Override
	public int edita(Usuario dao) throws Exception {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(dao);
			getEntityManager().getTransaction().commit();
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}

	@Override
	public int elimina(Usuario bean) throws Exception {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(bean);
			getEntityManager().getTransaction().commit();
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}

	@Override
	public Usuario getUsuario(int id) throws Exception {
		try {
			return getEntityManager().find(Usuario.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int inserta(Usuario dao) throws Exception {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(dao);
		getEntityManager().getTransaction().commit();
		return 0;
	}

	@Override
	public List menu(String area) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AreaMenu> permisos(int idArea) throws Exception {
		Query q = getEntityManager().createQuery("select u from AreaMenu u WHERE u.idArea = ?1 AND  u.ver = ?2 ORDER BY u.menu.nivel ASC ");
		q.setParameter(1, idArea);
		q.setParameter(2, "S");
		List<AreaMenu> results = q.getResultList();
		for (int i = 0; i < results.size(); i++) {
			AreaMenu l = results.get(i);
			System.out.println(l.getMenu().getTitulo());
		}
		System.out.println("Registros encontrados:" + results.size());
		return results;
	}

	@Override
	public List permisosUpdate(String area, String idS) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AreaMenu> permisosAll(int area) throws Exception {
		// TODO Auto-generated method stub
		Query q = getEntityManager()
				.createQuery(
						"select u from AreaMenu u WHERE u.idArea = ?1  ORDER BY u.menu.nivel ASC ");
		q.setParameter(1, area);
		// q.setParameter(2, "S" );

		List<AreaMenu> results = q.getResultList();

		for (int i = 0; i < results.size(); i++) {
			AreaMenu l = results.get(i);
			System.out.println(l.getMenu().getTitulo());
		}

		System.out.println("Registros encontrados :" + results.size());

		return results;
	}

}
