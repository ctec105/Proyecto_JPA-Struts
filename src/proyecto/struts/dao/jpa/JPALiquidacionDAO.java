package proyecto.struts.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.struts.bean.Cliente;
import proyecto.struts.bean.Ordenliquidacion;
import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.dao.LiquidacionDAO;

public class JPALiquidacionDAO extends GenericDAOJpa<Long, Ordenliquidacion> implements LiquidacionDAO {

	EntityManager em = getEntityManager();

	@Override
	public List<Ordentrabajo> findByCliente(Cliente cliente) throws Exception {
		try {
			Query q = em.createNamedQuery("findTrabajosByCliente");
			q.setParameter("cliente", cliente.getId());
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertar(Ordenliquidacion liquidacion) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(liquidacion);
			em.getTransaction().commit();

			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}

	}

	@Override
	public Ordenliquidacion findByNoID(Ordenliquidacion l) throws Exception {
		// TODO Auto-generated method stub
		try {
			Query q = em.createQuery(
					"SELECT l FROM Ordenliquidacion l  WHERE l.fecha=?1 AND l.usuario=?2 AND l.cliente.id=?3 ORDER BY l.id DESC");
			q.setParameter(1, l.getFecha());
			q.setParameter(2, l.getUsuario());
			q.setParameter(3, l.getCliente().getId());

			List<Ordenliquidacion> results = q.getResultList();
			if (results.size() > 0) {
				return results.get(0);
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public List<Ordenliquidacion> listLiquidaciones() throws Exception {
		// TODO Auto-generated method stub
		try {
			Query q = em.createQuery("SELECT o FROM Ordenliquidacion o where  o.id <> -1");

			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Ordenliquidacion getLiquidacion(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			return em.find(Ordenliquidacion.class, id);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void update(Ordenliquidacion liq) throws Exception {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(liq);
		em.getTransaction().commit();
	}

	@Override
	public List<Ordenliquidacion> popBuscarLiq(Ordenliquidacion liquidacion) throws Exception {
		// TODO Auto-generated method stub
		try {
			Query q = em.createQuery(
					"SELECT o FROM Ordenliquidacion o where  o.id <> -1 AND o.estado = 0 AND o.cliente.id like ?1 ");
			q.setParameter(1, "%" + liquidacion.getCliente().getId() + "%");
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
