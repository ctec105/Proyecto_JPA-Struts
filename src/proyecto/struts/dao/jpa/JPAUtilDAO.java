package proyecto.struts.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import proyecto.struts.bean.Area;
import proyecto.struts.bean.ClaseEquipo;
import proyecto.struts.bean.Especialidad;
import proyecto.struts.bean.Estado;
import proyecto.struts.bean.Marca;
import proyecto.struts.bean.Modelo;
import proyecto.struts.bean.Paquetesactividades;
import proyecto.struts.bean.Paquetesherramientas;
import proyecto.struts.bean.Paquetesmateriales;
import proyecto.struts.bean.UtilBean;
import proyecto.struts.dao.UtilDAO;

public class JPAUtilDAO extends GenericDAOJpa<Long, UtilBean> implements UtilDAO {

	// EntityManager em = getEntityManager();
	@Override
	public UtilBean getUtil(String table, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marca> listMarca() throws Exception {
		try {
			Query q = getEntityManager().createQuery("SELECT m FROM Marca m");
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public List lista(String table) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modelo> listModelo() throws Exception {
		try {
			Query q = getEntityManager().createQuery("SELECT m FROM Modelo m");
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Modelo> listModelo(String marca) throws Exception {
		try {
			System.out.println("idMarca: " + marca);
			Query q = getEntityManager().createQuery(
					"SELECT m FROM Modelo m WHERE m.idMarca =?1");
			q.setParameter(1, Integer.parseInt(marca));
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Paquetesactividades getActividad(int buscAct) throws Exception {
		// TODO Auto-generated method stub
		try {
			return getEntityManager().find(Paquetesactividades.class, buscAct);

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Paquetesherramientas getHerramienta(int buscHer) throws Exception {
		try {
			return getEntityManager().find(Paquetesherramientas.class, buscHer);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Paquetesmateriales getMaterial(int buscMat) throws Exception {
		try {
			return getEntityManager().find(Paquetesmateriales.class, buscMat);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<ClaseEquipo> getClasesEquipos() throws Exception {
		// TODO Auto-generated method stub
		try {
			System.out.println("Ingreso a listado de equipos");
			Query q = getEntityManager().createQuery(
					"SELECT m FROM ClaseEquipo m");
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Estado> getEstados() throws Exception {
		try {
			Query q = getEntityManager().createQuery("SELECT m FROM Estado m");
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Especialidad> listEspecialidad() throws Exception {
		try {
			Query q = getEntityManager().createQuery(
					"SELECT m FROM Especialidad m");
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Paquetesherramientas> popBucarHerramienta(Paquetesherramientas h) throws Exception {
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT m FROM Paquetesherramientas m WHERE m.descripcion like ?1");
			q.setParameter(1, "%" + h.getDescripcion() + "%");
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Paquetesactividades> popBuscarActividad(Paquetesactividades a) throws Exception {
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT m FROM Paquetesactividades m WHERE m.descripcion like ?1");
			q.setParameter(1, "%" + a.getDescripcion() + "%");
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Paquetesmateriales> popBuscarMaterial(Paquetesmateriales m) throws Exception {
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT m FROM Paquetesmateriales m WHERE m.descripcion like ?1");
			q.setParameter(1, "%" + m.getDescripcion() + "%");
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Area getArea(int codArea) throws Exception {
		// TODO Auto-generated method stub
		try {
			return getEntityManager().find(Area.class, codArea);

		} catch (Exception e) {
			return null;
		}
	}

}
