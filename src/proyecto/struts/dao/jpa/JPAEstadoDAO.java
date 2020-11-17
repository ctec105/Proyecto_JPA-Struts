package proyecto.struts.dao.jpa;

import javax.persistence.EntityManager;

import proyecto.struts.bean.Estado;
import proyecto.struts.dao.EstadoDAO;

public class JPAEstadoDAO extends GenericDAOJpa<Long, Estado> implements EstadoDAO {

	EntityManager em = getEntityManager();

	@Override
	public Estado getEstado(int id) throws Exception {
		try {
			return em.find(Estado.class, id);
		} catch (Exception e) {
			return null;
		}
	}

}
