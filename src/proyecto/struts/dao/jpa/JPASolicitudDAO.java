package proyecto.struts.dao.jpa;

import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.Query;

import proyecto.struts.bean.Solicitud;
import proyecto.struts.bean.Usuario;
import proyecto.struts.dao.SolicitudDAO;
import proyecto.struts.services.EquipoService;

public class JPASolicitudDAO extends GenericDAOJpa<Long, Solicitud> implements
		SolicitudDAO {

	@Override
	public List<Solicitud> buscarSolicitud(int id, String tarj)
			throws Exception {
		Query q;
		System.out.println(id + " : " + tarj);
		if (id == 0) {
			q = getEntityManager()
					.createQuery(
							"select s from Solicitud s WHERE  s.equipo.nrotarjeta like ?1");
			q.setParameter(1, "%" + tarj + "%");
		} else {
			q = getEntityManager()
					.createQuery(
							"select s from Solicitud s WHERE s.id like ?1 AND s.equipo.nroTarjeta like ?2");
			q.setParameter(1, "%" + id + "%");
			q.setParameter(2, "%" + tarj + "%");
		}

		return q.getResultList();
	}

	@Override
	public int edita(Solicitud bean) throws Exception {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(bean);
			getEntityManager().getTransaction().commit();
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}

	@Override
	public int elimina(Solicitud bean) throws Exception {
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
	public Solicitud getSolicitud(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			return getEntityManager().find(Solicitud.class, id);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
		// Query q =
		// getEntityManager().createQuery("select s from Solicitud s WHERE s.id = ?1");

		// q.setParameter(1,id);

		// return (Solicitud) q.getSingleResult();

	}

	@Override
	public int inserta(Solicitud bean) throws Exception {
		// TODO Auto-generated method stub
		try {
			// System.out.println("Dentro del metodo registraCliente");

			// System.out.println( "Equipo : " +
			// bean.getEquipo().getNrotarjeta().toString());
			// EquipoService srvEq = new EquipoService();
			// bean.setEstado("1");
			getEntityManager().getTransaction().begin();
			// bean.setEquipo(srvEq.getEquipo("111111111"));
			getEntityManager().persist(bean);
			getEntityManager().getTransaction().commit();
			return 0;
		} catch (Exception e) {
			return 1;
			// TODO: handle exception
		}
	}

	@Override
	public List<Solicitud> buscarSolicitud(String representante, int idEstado)
			throws Exception {
		try {
			Query q = getEntityManager()
					.createQuery(
							"select s from Solicitud s WHERE s.estado.idestado = ?1 AND s.representante like ?2");
			q.setParameter(1, idEstado);
			q.setParameter(2, "%" + representante + "%");
			return q.getResultList();
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}

	}

}
