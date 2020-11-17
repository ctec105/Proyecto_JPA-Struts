package proyecto.struts.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import proyecto.struts.bean.Paquete;
import proyecto.struts.bean.Tecnico;
import proyecto.struts.dao.TecnicoDAO;

public class JPATecnicoDAO extends GenericDAOJpa<Long, Tecnico> implements
		TecnicoDAO {

	@Override
	public List buscarTecnico(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tecnico getTecnico(int id) throws Exception {
		try {
			return getEntityManager().find(Tecnico.class, id);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Tecnico> popBuscarTecn(Tecnico t) throws Exception {
		try {
			// Query q =
			// getEntityManager().createQuery("SELECT m FROM Tecnico m WHERE m.nombre like ?1 AND m.idEspecialidad =?2");
			Query q = getEntityManager()
					.createQuery(
							"SELECT m FROM Tecnico m WHERE m.nombre like ?1 AND m.idEspecialidad =?2");
			q.setParameter(1, "%" + t.getNombre() + "%");
			q.setParameter(2, t.getIdEspecialidad());
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
