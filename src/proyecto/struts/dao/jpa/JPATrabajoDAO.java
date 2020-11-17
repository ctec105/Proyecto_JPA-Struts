package proyecto.struts.dao.jpa;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.struts.bean.Ordentrabajo;
import proyecto.struts.bean.Ordentrabajo_has_tecnicos;
import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetes_has_ordentrabajo;
import proyecto.struts.bean.Solicitud;
import proyecto.struts.bean.Tecnico;
import proyecto.struts.bean.Trabajo;
import proyecto.struts.bean.Usuario;
import proyecto.struts.dao.TrabajoDAO;
import proyecto.struts.util.UtilesVarios;

public class JPATrabajoDAO extends GenericDAOJpa<Long, Ordentrabajo> implements
		TrabajoDAO {
	EntityManager em = getEntityManager();
	UtilesVarios ut = new UtilesVarios();

	@Override
	public List buscarTrabajo(String estado) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Ordentrabajo buscarTrabajoxNoID(Ordentrabajo tra) throws Exception {
		try {
			Query q = em
					.createQuery("SELECT u FROM Ordentrabajo u WHERE u.solicitud = ?1 AND u.fecha_inicio =?2 AND u.usuario =?3");
			q.setParameter(1, tra.getSolicitud());
			q.setParameter(2, tra.getFecha_inicio());
			q.setParameter(3, tra.getUsuario());

			return (Ordentrabajo) q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en el buscarxNoID");
			return null;
		}

	}

	@Override
	public int inserta(Trabajo bean, Hashtable<String, Paquete> paquetes,
			Hashtable<String, Tecnico> tecnicos) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ordentrabajo> listar() throws Exception {
		// TODO Auto-generated method stub
		Query q = em
				.createQuery("SELECT u FROM Ordentrabajo u where u.idLiquidacion = -1");
		List<Ordentrabajo> results = q.getResultList();
		System.out.println("Registros encontrados :" + results.size());

		return results;
	}

	@Override
	public int insertar(Ordentrabajo trabajo, List<Paquete> paquetes,
			List<Tecnico> tecnicos) throws Exception {
		// TODO Auto-generated method stub
		try {
			for (Method m : trabajo.getClass().getMethods()) {
				if (m.getName().startsWith("get"))
					System.out.println(m.getName() + " : " + m.invoke(trabajo));
			}
			// Insertando la Orden de Trabajo
			System.out.println("Metodo InsertaTrabajo...");
			trabajo.setIdLiquidacion(-1);
			em.getTransaction().begin();
			em.persist(trabajo);
			em.getTransaction().commit();
			// obtener el bean trabajo con todos sus datos( ID )

			trabajo = buscarTrabajoxNoID(trabajo);
			System.out.println("Nuevo codigo de trabajo:" + trabajo.getId());
			em.getTransaction().begin();
			Iterator paq = paquetes.iterator();
			while (paq.hasNext()) {
				Paquete p = new Paquete();
				p = (Paquete) paq.next();
				Paquetes_has_ordentrabajo po = new Paquetes_has_ordentrabajo();
				po.setOrdenTrabajo_otrabajo(trabajo.getId());
				po.setPaquetes_paquetes(p.getId());
				po.setPrecio(p.getPrecio());
				em.persist(po);
			}
			Iterator tec = tecnicos.iterator();
			while (tec.hasNext()) {
				Tecnico t = new Tecnico();
				t = (Tecnico) tec.next();
				Ordentrabajo_has_tecnicos ot = new Ordentrabajo_has_tecnicos();
				ot.setOrdenTrabajo_otrabajo(trabajo.getId());
				ot.setTecnicos_tecnicos(t.getId());
				int dias;
				dias = ut.fechasDiferenciaEnDias(trabajo.getFecha_inicio(),
						trabajo.getFecha_termino());
				ot.setDias(dias);
				em.persist(ot);
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}

		return 0;
	}

	@Override
	public Ordentrabajo getTrabajo(int id) throws Exception {
		// TODO Auto-generated method stub
		try {
			// return em.find(Ordentrabajo.class, id);
			Query q = em
					.createQuery("SELECT u FROM Ordentrabajo u WHERE u.id =?1");
			q.setParameter(1, id);
			return (Ordentrabajo) q.getSingleResult();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public List<Paquetes_has_ordentrabajo> getPaquetes(int idTrabajo)
			throws Exception {
		try {
			Query q = em
					.createQuery("SELECT u FROM Paquetes_has_ordentrabajo u WHERE u.ordenTrabajo_otrabajo =?1");
			q.setParameter(1, idTrabajo);
			return q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en el getPaquetes");
			return null;
		}

	}

	@Override
	public List<Ordentrabajo_has_tecnicos> getTenicos(int idTrabajo)
			throws Exception {
		try {
			Query q = em
					.createQuery("SELECT u FROM Ordentrabajo_has_tecnicos u WHERE u.ordenTrabajo_otrabajo =?1");
			q.setParameter(1, idTrabajo);
			return q.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en el getTecnicos");
			return null;
		}
	}

	@Override
	public int actualizar(Ordentrabajo trabajo, List<Paquete> paquetes,
			List<Tecnico> tecnicos) throws Exception {
		try {
			em.getTransaction().begin();
			em.merge(trabajo);
			em.getTransaction().commit();
			deleteDetPaquetes(trabajo.getId());
			deleteDetTecnicos(trabajo.getId());
			// Actualizando los detalles
			em.getTransaction().begin();
			Iterator paq = paquetes.iterator();
			while (paq.hasNext()) {
				Paquete p = new Paquete();
				p = (Paquete) paq.next();
				Paquetes_has_ordentrabajo po = new Paquetes_has_ordentrabajo();
				po.setOrdenTrabajo_otrabajo(trabajo.getId());
				po.setPaquetes_paquetes(p.getId());
				po.setPrecio(p.getPrecio());
				em.persist(po);
			}
			Iterator tec = tecnicos.iterator();
			while (tec.hasNext()) {
				Tecnico t = new Tecnico();
				t = (Tecnico) tec.next();
				Ordentrabajo_has_tecnicos ot = new Ordentrabajo_has_tecnicos();
				ot.setOrdenTrabajo_otrabajo(trabajo.getId());
				ot.setTecnicos_tecnicos(t.getId());
				int dias;
				dias = ut.fechasDiferenciaEnDias(trabajo.getFecha_inicio(),
						trabajo.getFecha_termino());
				ot.setDias(dias);
				em.persist(ot);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
		return 0;
	}

	private void deleteDetTecnicos(int id) {
		// TODO Auto-generated method stub
		Query q = em
				.createQuery("SELECT u FROM Ordentrabajo_has_tecnicos u WHERE u.ordenTrabajo_otrabajo =?1");
		q.setParameter(1, id);
		List<Ordentrabajo_has_tecnicos> rst = q.getResultList();
		Iterator it = rst.iterator();
		em.getTransaction().begin();
		while (it.hasNext()) {
			Ordentrabajo_has_tecnicos t = new Ordentrabajo_has_tecnicos();
			t = (Ordentrabajo_has_tecnicos) it.next();
			em.remove(t);
		}
		em.getTransaction().commit();
	}

	private void deleteDetPaquetes(int id) {
		// TODO Auto-generated method stub
		Query q = em
				.createQuery("SELECT u FROM Paquetes_has_ordentrabajo u WHERE u.ordenTrabajo_otrabajo =?1");
		q.setParameter(1, id);
		List<Paquetes_has_ordentrabajo> rst = q.getResultList();
		Iterator it = rst.iterator();
		em.getTransaction().begin();
		while (it.hasNext()) {
			Paquetes_has_ordentrabajo t = new Paquetes_has_ordentrabajo();
			t = (Paquetes_has_ordentrabajo) it.next();
			em.remove(t);
		}
		em.getTransaction().commit();
	}

	@Override
	public void actualizar(Ordentrabajo ot) throws Exception {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.merge(ot);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}