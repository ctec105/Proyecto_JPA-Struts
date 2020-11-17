package proyecto.struts.dao.jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import proyecto.struts.bean.Equipo;
import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Paquetes_has_paquetesactividades;
import proyecto.struts.bean.Paquetes_has_paquetesherramientas;
import proyecto.struts.bean.Paquetes_has_paquetesmateriales;
import proyecto.struts.bean.Paquetesactividades;
import proyecto.struts.bean.Paquetesherramientas;
import proyecto.struts.bean.Paquetesmateriales;
import proyecto.struts.bean.Usuario;
import proyecto.struts.dao.PaqueteDAO;
import proyecto.struts.services.UtilService;

public class JPAPaqueteDAO extends GenericDAOJpa<Long, Paquete> implements PaqueteDAO {

	@Override
	public List<Paquete> buscarPaquete(String nro) throws Exception {
		// TODO Auto-generated method stub
		Query q = getEntityManager().createQuery("select u from Paquete u ");

		List<Paquete> results = q.getResultList();

		System.out.println("Registros encontrados :" + results.size());

		return results;
	}

	@Override
	public Paquete getPaquete(int id) throws Exception {
		try {
			return getEntityManager().find(Paquete.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Paquete> getPaquetes(int buscPaq, List<Paquete> paquetes)
			throws Exception {
		Query q = getEntityManager().createQuery(
				"select u from Paquete u WHERE u.id = ?1 ");
		q.setParameter(1, buscPaq);

		List<Paquete> rst = q.getResultList();
		paquetes.addAll(rst);
		// TODO Auto-generated method stub
		return paquetes;
	}

	@Override
	public List<Paquete> getPaquetes() throws Exception {
		try {
			Query q = getEntityManager()
					.createQuery("select u from Paquete u ");

			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public int insertar(Paquete paquete, List<Paquetesactividades> lstAct,
			List<Paquetesmateriales> lstMat, List<Paquetesherramientas> lstHer)
			throws Exception {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(paquete);
			getEntityManager().getTransaction().commit();
			paquete = buscarPaquetexNoID(paquete);
			InsertarDetalles(paquete, lstAct, lstMat, lstHer);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

	private Paquete buscarPaquetexNoID(Paquete p) {
		Query q = getEntityManager().createQuery("select u from Paquete u WHERE u.nombre = ?1 AND u.duracion=?2 AND u.marca=?3 AND u.modelo=?4 AND u.precio=?5 ORDER BY u.id DESC");
		q.setParameter(1, p.getNombre());
		q.setParameter(2, p.getDuracion());
		q.setParameter(3, p.getMarca());
		q.setParameter(4, p.getModelo());
		q.setParameter(5, p.getPrecio());
		List<Paquete> rst = q.getResultList();
		if (rst.size() > 0) {
			return rst.get(0);
		}
		return null;
	}
	
	private void InsertarDetalles(Paquete paquete,
			List<Paquetesactividades> lstAct, List<Paquetesmateriales> lstMat,
			List<Paquetesherramientas> lstHer) {
		getEntityManager().getTransaction().begin();
		
		Iterator itHer = lstHer.iterator();
		while (itHer.hasNext()) {
			Paquetesherramientas her = (Paquetesherramientas) itHer.next();
			Paquetes_has_paquetesherramientas detHer = new Paquetes_has_paquetesherramientas();
			detHer.setPaquetes_paquetes(paquete.getId());
			detHer.setPaquetesHerramientas_herramientas(her.getId());
			detHer.setPrecio(her.getPrecio());
			getEntityManager().persist(detHer);
		}
		
		Iterator itAct = lstAct.iterator();
		while (itAct.hasNext()) {
			Paquetesactividades act = (Paquetesactividades) itAct.next();
			Paquetes_has_paquetesactividades detAct = new Paquetes_has_paquetesactividades();
			detAct.setPaquetes_paquetes(paquete.getId());
			detAct.setPaquetesActividades_actividades(act.getId());
			detAct.setPrecio(act.getPrecio());
			getEntityManager().persist(detAct);
		}
		
		Iterator itMat = lstMat.iterator();
		while (itMat.hasNext()) {
			Paquetesmateriales mat = (Paquetesmateriales) itMat.next();
			Paquetes_has_paquetesmateriales detMat = new Paquetes_has_paquetesmateriales();
			detMat.setPaquetes_paquetes(paquete.getId());
			detMat.setPaquetesMateriales_materiales(mat.getId());
			detMat.setPrecio(mat.getPrecio());
			getEntityManager().persist(detMat);
		}
		
		getEntityManager().getTransaction().commit();

	}

	@Override
	public int modificar(Paquete paquete, List<Paquetesactividades> lstAct,
			List<Paquetesmateriales> lstMat, List<Paquetesherramientas> lstHer)
			throws Exception {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().merge(paquete);
			getEntityManager().getTransaction().commit();
			paquete = buscarPaquetexNoID(paquete);
			eliminarDetalles(paquete);
			InsertarDetalles(paquete, lstAct, lstMat, lstHer);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

	private void eliminarDetalles(Paquete paquete) {
		Query q = getEntityManager().createQuery("SELECT p FROM Paquetes_has_paquetesherramientas p WHERE p.paquetes_paquetes =?1");
		q.setParameter(1, paquete.getId());
		Iterator it = q.getResultList().iterator();

		Query q1 = getEntityManager().createQuery("SELECT p FROM Paquetes_has_paquetesactividades p WHERE p.paquetes_paquetes =?1");
		q1.setParameter(1, paquete.getId());
		Iterator it1 = q1.getResultList().iterator();

		Query q2 = getEntityManager().createQuery("SELECT p FROM Paquetes_has_paquetesmateriales p WHERE p.paquetes_paquetes =?1");
		q2.setParameter(1, paquete.getId());
		Iterator it2 = q2.getResultList().iterator();

		getEntityManager().getTransaction().begin();
		while (it.hasNext()) {
			Paquetes_has_paquetesherramientas h = (Paquetes_has_paquetesherramientas) it.next();
			getEntityManager().remove(h);
		}
		while (it1.hasNext()) {
			Paquetes_has_paquetesactividades a = (Paquetes_has_paquetesactividades) it1.next();
			getEntityManager().remove(a);
		}
		while (it2.hasNext()) {
			Paquetes_has_paquetesmateriales m = (Paquetes_has_paquetesmateriales) it2.next();
			getEntityManager().remove(m);
		}
		getEntityManager().getTransaction().commit();
	}

	@Override
	public int eliminar(Paquete paquete) throws Exception {
		eliminarDetalles(paquete);
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(paquete);
		getEntityManager().getTransaction().commit();
		return 0;
	}

	@Override
	public List<Paquete> popBuscarPaquetes(Paquete p) throws Exception {
		try {
			Query q = getEntityManager()
					.createQuery(
							"select u from Paquete u WHERE u.nombre like ?1  AND u.marca=?2 AND u.modelo=?3 ");
			q.setParameter(1, "%" + p.getNombre() + "%");
			q.setParameter(2, p.getMarca());
			q.setParameter(3, p.getModelo());
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Paquetesactividades> getActividadesxId(int id) throws Exception {
		// TODO Auto-generated method stub
		UtilService utlServ = new UtilService();
		Query q = getEntityManager()
				.createQuery(
						"SELECT p FROM Paquetes_has_paquetesactividades p WHERE p.paquetes_paquetes =?1");
		q.setParameter(1, id);
		List<Paquetesactividades> rst = new ArrayList<Paquetesactividades>();
		Iterator it = q.getResultList().iterator();
		while (it.hasNext()) {
			Paquetes_has_paquetesactividades a;
			a = (Paquetes_has_paquetesactividades) it.next();
			Paquetesactividades act = new Paquetesactividades();
			act = utlServ.getActividad(a.getPaquetesActividades_actividades());
			rst.add(act);
		}
		return rst;
	}

	@Override
	public List<Paquetesherramientas> getHerramientasxId(int id)
			throws Exception {
		// TODO Auto-generated method stub
		UtilService utlServ = new UtilService();
		Query q = getEntityManager()
				.createQuery(
						"SELECT p FROM Paquetes_has_paquetesherramientas p WHERE p.paquetes_paquetes =?1");
		q.setParameter(1, id);
		List<Paquetesherramientas> rst = new ArrayList<Paquetesherramientas>();
		Iterator it = q.getResultList().iterator();
		while (it.hasNext()) {
			Paquetes_has_paquetesherramientas p;
			p = (Paquetes_has_paquetesherramientas) it.next();
			Paquetesherramientas pqt = new Paquetesherramientas();
			pqt = utlServ.getHerramienta(p
					.getPaquetesHerramientas_herramientas());
			rst.add(pqt);
		}
		return rst;
	}

	@Override
	public List<Paquetesmateriales> getMaterialesxId(int id) throws Exception {
		// TODO Auto-generated method stub
		UtilService utlServ = new UtilService();
		Query q = getEntityManager()
				.createQuery(
						"SELECT p FROM Paquetes_has_paquetesmateriales p WHERE p.paquetes_paquetes =?1");
		q.setParameter(1, id);
		List<Paquetesmateriales> rst = new ArrayList<Paquetesmateriales>();
		Iterator it = q.getResultList().iterator();
		while (it.hasNext()) {
			Paquetes_has_paquetesmateriales p;
			p = (Paquetes_has_paquetesmateriales) it.next();
			Paquetesmateriales pqt = new Paquetesmateriales();
			pqt = utlServ.getMaterial(p.getPaquetesMateriales_materiales());
			rst.add(pqt);
		}
		return rst;
	}

}
