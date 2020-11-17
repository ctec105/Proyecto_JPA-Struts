package proyecto.struts.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.struts.bean.Area;
import proyecto.struts.dao.AreaDAO;

public class JPAAreaDAO extends GenericDAOJpa<Long, Area> implements AreaDAO {
	EntityManager em = getEntityManager();

	@Override
	public List<Area> getListAreas() throws Exception {
		try {
			Query q = em.createQuery("SELECT a FROM Area a");
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
